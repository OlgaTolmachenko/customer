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

    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mGoogleMap;
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

        parentLayout = (CoordinatorLayout) findViewById(R.id.parentLayout);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addConnectionCallbacks(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .build();
        }
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onConnectionSuspended(int i) {
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
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
        mapView.onStop();
        super.onStop();
    }

    @Override
    protected void onResume() {
        mGoogleApiClient.connect();
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
                Intent intent = new Intent();
                intent.putExtra(Constants.LOCATION, chosenLocation);
                intent.putExtra(Constants.ADDRESS, fullAddress);
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

        mGoogleMap = googleMap;
        mGoogleMap.setOnMapClickListener(this);
        mGoogleMap.setOnMyLocationButtonClickListener(this);
        setUpMapUiSettings(mGoogleMap);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        chosenLocation = latLng;
        showMarkerWithAnimation(chosenLocation);
        showAddress(chosenLocation);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
            return;
        }

        mGoogleMap.setMyLocationEnabled(true);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient,
                createLocationRequest(),
                this);

        if (getIntent().getParcelableExtra(Constants.LOCATION) != null) {
            chosenLocation = getIntent().getParcelableExtra(Constants.LOCATION);
        } else {
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                chosenLocation = new LatLng(TaskApp.getInstance().getCurrentCustomer().getLocation().getLatitude(),
                                            TaskApp.getInstance().getCurrentCustomer().getLocation().getLongitude());
            } else {
                chosenLocation = getLastLocation();
            }
        }

        showMarker(chosenLocation);
        showAddress(chosenLocation);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        LatLng deviceLocation = getLastLocation();
        showMarkerWithAnimation(deviceLocation);
        showAddress(deviceLocation);
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
                    showAddress(chosenLocation);
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

    private LatLng getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        }
        return new LatLng(
                LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient).getLatitude(),
                LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient).getLongitude()
        );
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                },
                Constants.RequestCodes.REQUEST_LOCATION_PERMISSION);
    }

    private void showAddress(LatLng currentLocation) {
        List<Address> addresses = null;
        Geocoder geocoder = new Geocoder(BaseMapActivity.this);
        int maxResults = 1;

        try {
            addresses = geocoder.getFromLocation(
                    currentLocation.latitude,
                    currentLocation.longitude,
                    maxResults);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        if (addresses != null && !addresses.isEmpty()) {
            Address address = addresses.get(0);

            ArrayList<String> addressFragments = new ArrayList<>();
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                addressFragments.add(address.getAddressLine(i));
            }
            fullAddress = TextUtils.join(", ", addressFragments);

            showSnackbar(fullAddress);
            setMenuItemVisibility(true);
        } else {
            dismissSnackBar();
            setMenuItemVisibility(false);
        }
    }

    private void dismissSnackBar() {
        Toast.makeText(this, R.string.text_select_location, Toast.LENGTH_LONG).show();
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    private void setMenuItemVisibility(boolean enabled) {
        if (saveMenuItem != null) {
            saveMenuItem.setEnabled(enabled);
        }
    }

    public void showSnackbar(String address) {
        snackbar = Snackbar.make(parentLayout, getString(R.string.text_location, address), Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    private void showMarkerWithAnimation(LatLng chosenLocation) {
        mGoogleMap.clear();
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        mGoogleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
    }

    private void showMarker(LatLng chosenLocation) {
        mGoogleMap.clear();
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        mGoogleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
    }

    protected LocationRequest createLocationRequest() {
        int interval = 120000;
        int fastestInterval = 30000;
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(interval);
        mLocationRequest.setFastestInterval(fastestInterval);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }
}