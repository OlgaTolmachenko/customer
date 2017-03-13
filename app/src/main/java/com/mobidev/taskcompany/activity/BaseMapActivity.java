package com.mobidev.taskcompany.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseMapActivity extends BaseActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMyLocationButtonClickListener,
        LocationListener {

    private GoogleApiClient googleApiClient;
    private GoogleMap googleMap;
    private LatLng chosenLocation;
    private MapView mapView;
    private String fullAddress;
    private CoordinatorLayout parentLayout;
    private Snackbar snackbar;
    private MenuItem saveMenuItem = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initViews();
        initGoogleApiClient();

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    private boolean isGoogleApiClientExists() {
        return googleApiClient != null;
    }

    private void initGoogleApiClient() {
        if (!isGoogleApiClientExists()) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addConnectionCallbacks(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .build();
        }
    }

    private void initViews() {
        parentLayout = (CoordinatorLayout) findViewById(R.id.parentLayout);
        mapView = (MapView) findViewById(R.id.map);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(Constants.TAG, "onConnectionSuspended: " + i);
    }

    @Override
    protected void onStart() {
        mapView.onStart();
        super.onStart();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        disconnectFromGoogleApiClient();
        mapView.onStop();
        super.onStop();
    }

    private void disconnectFromGoogleApiClient() {
        if (isGoogleApiClientExists() && googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    @Override
    protected void onResume() {
        googleApiClient.connect();
        mapView.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        saveMenuItem = menu.findItem(R.id.action_save);
        saveMenuItem.setEnabled(false);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                Intent intent = new Intent()
                        .putExtra(Constants.LOCATION, chosenLocation)
                        .putExtra(Constants.ADDRESS, fullAddress);
                setResult(RESULT_OK, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap == null) {
            return;
        }
        this.googleMap = googleMap;
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMyLocationButtonClickListener(this);
        setUpMapUiSettings(this.googleMap);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        chosenLocation = latLng;
        showMarkerWithAnimation(chosenLocation);
        extractAndShowAddress(chosenLocation);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermissions();
            return;
        }

        googleMap.setMyLocationEnabled(true);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                googleApiClient,
                createLocationRequest(),
                this);

        if (getIntent().getParcelableExtra(Constants.LOCATION) != null) {
            chosenLocation = getIntent().getParcelableExtra(Constants.LOCATION);
        } else if (TaskApp.getInstance().getCurrentCustomer() != null) {
            chosenLocation = new LatLng(TaskApp.getInstance().getCurrentCustomer().getLocation().getLatitude(),
                    TaskApp.getInstance().getCurrentCustomer().getLocation().getLongitude());
        } else {
            chosenLocation = getLastLocation();
        }

        showMarker(chosenLocation);
        extractAndShowAddress(chosenLocation);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        LatLng deviceLocation = getLastLocation();
        showMarkerWithAnimation(deviceLocation);
        extractAndShowAddress(deviceLocation);
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.RequestCodes.REQUEST_LOCATION_PERMISSION: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], Manifest.permission.ACCESS_FINE_LOCATION)
                        && Objects.equals(permissions[1], Manifest.permission.ACCESS_COARSE_LOCATION)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    chosenLocation = getLastLocation();
                    showMarkerWithAnimation(chosenLocation);
                    extractAndShowAddress(chosenLocation);
                }
            }
        }
    }

    private void setUpMapUiSettings(GoogleMap googleMap) {
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }


    //TODO handle Security exception
    private LatLng getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermissions();
        }
        return new LatLng(
                LocationServices.FusedLocationApi.getLastLocation(googleApiClient).getLatitude(),
                LocationServices.FusedLocationApi.getLastLocation(googleApiClient).getLongitude()
        );
    }

    private void requestLocationPermissions() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        ActivityCompat.requestPermissions(this, permissions, Constants.RequestCodes.REQUEST_LOCATION_PERMISSION);
    }

    private void extractAndShowAddress(LatLng currentLocation) {
        List<Address> addresses = null;
        Geocoder geocoder = new Geocoder(BaseMapActivity.this);
        int maxResults = 1;

        try {
            addresses = geocoder.getFromLocation(currentLocation.latitude, currentLocation.longitude, maxResults);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        if (addresses == null || addresses.isEmpty()) {
            dismissSnackBar();
            setMenuItemVisibility(false);
            return;
        }

        Address address = addresses.get(0);
        ArrayList<String> addressFragments = new ArrayList<>();
        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
            addressFragments.add(address.getAddressLine(i));
        }

        fullAddress = TextUtils.join(", ", addressFragments);
        showSnackbar(fullAddress);
        setMenuItemVisibility(true);
    }

    private void dismissSnackBar() {
        Toast.makeText(this, R.string.text_select_location, Toast.LENGTH_LONG).show();
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    private void setMenuItemVisibility(boolean enabled) {
        if (saveMenuItem == null) {
            return;
        }
        saveMenuItem.setEnabled(enabled);
    }

    public void showSnackbar(String address) {
        snackbar = Snackbar.make(parentLayout, getString(R.string.text_location, address), Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    private void showMarkerWithAnimation(LatLng chosenLocation) {
        googleMap.clear();
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        googleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
    }

    private void showMarker(LatLng chosenLocation) {
        googleMap.clear();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        googleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
    }

    protected LocationRequest createLocationRequest() {
        int standartInterval = 120000;
        int fastInterval = 30000;
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(standartInterval);
        mLocationRequest.setFastestInterval(fastInterval);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }
}