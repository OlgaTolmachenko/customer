package com.mobidev.taskcompany.activity;

import android.Manifest;
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
=======
import android.content.Context;
=======
>>>>>>> 7465fed... Catch and show address
import android.content.Intent;
import android.content.pm.PackageManager;
<<<<<<< HEAD
>>>>>>> e54c81c... refactoring
=======
import android.location.Address;
import android.location.Geocoder;
>>>>>>> 7465fed... Catch and show address
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
<<<<<<< HEAD
import android.util.Log;
<<<<<<< HEAD
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
=======
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
>>>>>>> e54c81c... refactoring
=======
=======
import android.support.design.widget.CoordinatorLayout;
>>>>>>> 080411d... Capture photo from camera
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
=======
>>>>>>> 7465fed... Catch and show address
=======
>>>>>>> d95c681... Refactoring activities
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.View;
import android.widget.LinearLayout;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
>>>>>>> 3497b4d... refactoring
=======
import android.widget.Toast;
>>>>>>> aee538b... bugfix

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobidev.taskcompany.R;
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.TaskApp;
<<<<<<< HEAD
import com.mobidev.taskcompany.model.Task;
=======
>>>>>>> 9500ee1... Refactor sending address to EditProfileActivity
=======
import com.mobidev.taskcompany.TaskApp;
<<<<<<< HEAD
>>>>>>> aee538b... bugfix
=======
import com.mobidev.taskcompany.model.Task;
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
import com.mobidev.taskcompany.model.TaskLatLng;
=======
import com.mobidev.taskcompany.util.Constants;
>>>>>>> d95c681... Refactoring activities

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

<<<<<<< HEAD
import static com.mobidev.taskcompany.util.Constants.ADDRESS;
<<<<<<< HEAD
<<<<<<< HEAD
import static com.mobidev.taskcompany.util.Constants.LOCATION;
=======
>>>>>>> a04eacf... Fix profile saving to DB
=======
import static com.mobidev.taskcompany.util.Constants.LOCATION;
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
import static com.mobidev.taskcompany.util.Constants.MAX_ZOOM;
import static com.mobidev.taskcompany.util.Constants.MY_MARKER_TITLE;

public class BaseMapActivity extends BaseActivity implements OnMapReadyCallback,
=======
=======
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
=======
>>>>>>> 7465fed... Catch and show address
import com.google.android.gms.location.places.Places;
>>>>>>> 3497b4d... refactoring
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobidev.taskcompany.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mobidev.taskcompany.util.Constants.MAX_ZOOM;
import static com.mobidev.taskcompany.util.Constants.MY_MARKER_TITLE;

<<<<<<< HEAD
public class BaseMapActivity extends AppCompatActivity implements OnMapReadyCallback,
>>>>>>> e54c81c... refactoring
=======
=======
>>>>>>> d95c681... Refactoring activities
public class BaseMapActivity extends BaseActivity implements OnMapReadyCallback,
>>>>>>> 64f37b7... Add progressBars
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMyLocationButtonClickListener,
        LocationListener {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private final int LOC_REQUEST_CODE = 1;

=======
>>>>>>> 3bc2a92... Extract REQUEST_CODES into static class
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mGoogleMap;
    private LatLng chosenLocation;
    private MapView mapView;
    private String fullAddress;
    private CoordinatorLayout parentLayout;
    private Snackbar snackbar;
    private MenuItem saveMenuItem = null;

=======
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mGoogleMap;
    private LatLng currentLocation;
    private final int LOC_REQUEST_CODE = 1;

    public LatLng getCurrentLocation() {
        return currentLocation;
    }
>>>>>>> e54c81c... refactoring
=======
    private final int LOC_REQUEST_CODE = 1;

    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mGoogleMap;
    private LatLng chosenLocation;
    private MapView mapView;
<<<<<<< HEAD
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
    private boolean isLocationPermissionGranted = false;
<<<<<<< HEAD
>>>>>>> 3497b4d... refactoring
=======
    private String fullAddress;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9500ee1... Refactor sending address to EditProfileActivity
=======
    CoordinatorLayout parentLayout;
>>>>>>> cbfc11e... Final map setup
=======
    private CoordinatorLayout parentLayout;
    private Snackbar snackbar;
<<<<<<< HEAD
>>>>>>> aee538b... bugfix
=======
    private Menu menu;
    private MenuItem saveMenuItem = null;

>>>>>>> 35d04a3... Fix Camera. Fix Location

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        setContentView(R.layout.activity_map);
        invalidateOptionsMenu();

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
=======
=======
        setContentView(R.layout.acrivity_map);
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======

        Log.d("LOG", "onCreate: ");

=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
        setContentView(R.layout.activity_map);
        invalidateOptionsMenu();

        parentLayout = (CoordinatorLayout) findViewById(R.id.parentLayout);
>>>>>>> cbfc11e... Final map setup

        if (mGoogleApiClient == null) {

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addConnectionCallbacks(this)
                    .addApi(LocationServices.API)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .build();
        }
<<<<<<< HEAD
        mGoogleApiClient.connect();
<<<<<<< HEAD
>>>>>>> e54c81c... refactoring
=======
=======
>>>>>>> cbfc11e... Final map setup

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
<<<<<<< HEAD
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Log.d("LOG", "onMapReady: ");

        if (googleMap == null) {
            return;
        }

        mGoogleMap = googleMap;
        mGoogleMap.setOnMapClickListener(this);
        mGoogleMap.setOnMyLocationButtonClickListener(this);
        setUpMapUiSettings(mGoogleMap);
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
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                }, LOC_REQUEST_CODE);
    }

    @Override
    public void onMapClick(LatLng latLng) {
<<<<<<< HEAD
        currentLocation = latLng;
        showMarker(CameraUpdateFactory.newLatLng(latLng), new MarkerOptions().position(latLng).title(MY_MARKER_TITLE));
<<<<<<< HEAD
//        showSnackbar(currentLocation);
        showAddress();
>>>>>>> 3497b4d... refactoring
=======
        showAddress(currentLocation);
>>>>>>> 7465fed... Catch and show address
=======
        chosenLocation = latLng;
        Log.d("MY_LOG_TAG", "onMapClick: " + latLng);
        showMarkerPlusAnimation(CameraUpdateFactory.newLatLng(latLng), new MarkerOptions().position(latLng).title(MY_MARKER_TITLE));
        showAddress(chosenLocation);
>>>>>>> cbfc11e... Final map setup
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        Log.d("LOG", "onConnected: ");

<<<<<<< HEAD
=======
>>>>>>> e54c81c... refactoring
=======

>>>>>>> 3497b4d... refactoring
=======
>>>>>>> cbfc11e... Final map setup
=======
>>>>>>> d95c681... Refactoring activities
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
            return;
        }

        mGoogleMap.setMyLocationEnabled(true);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient,
<<<<<<< HEAD
<<<<<<< HEAD
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

<<<<<<< HEAD
            showMarker(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM), new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
            showAddress(chosenLocation);
=======
                    LocationRequest.create(),
=======
                    createLocationRequest(),
>>>>>>> 74fd957... Fix Role. Fix Task
                    this
            );


<<<<<<< HEAD
            if (chosenLocation == null) {
                return;
            }
<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
            showMarker(CameraUpdateFactory.newLatLngZoom(currentLocation, MAX_ZOOM), new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
>>>>>>> e54c81c... refactoring
=======
=======
            if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getLocation() != null) {
=======
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
>>>>>>> 4f5e128... Fix documents permission
                chosenLocation = new LatLng(TaskApp.getInstance().getCurrentCustomer().getLocation().getLatitude(),
                        TaskApp.getInstance().getCurrentCustomer().getLocation().getLongitude());
            }
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
=======

            if (getIntent() != null && getIntent().getParcelableExtra(LOCATION) != null) {
//                if (TaskApp.getInstance().getCurrentCustomer() != null && getIntent().getParcelableExtra(LOCATION) != TaskApp.getInstance().getCurrentCustomer().getLocation()) {
                chosenLocation = getIntent().getParcelableExtra(LOCATION);
//                }
            } else {
                if (TaskApp.getInstance().getCurrentCustomer() != null) {
                    chosenLocation = new LatLng(TaskApp.getInstance().getCurrentCustomer().getLocation().getLatitude(),
                            TaskApp.getInstance().getCurrentCustomer().getLocation().getLongitude());
                } else {
                    chosenLocation = getLastLocation();

                }
            }


>>>>>>> 2a78416... temp
            showMarker(CameraUpdateFactory.newLatLngZoom(chosenLocation, MAX_ZOOM), new MarkerOptions().position(chosenLocation).title(MY_MARKER_TITLE));
            showAddress(chosenLocation);
>>>>>>> cbfc11e... Final map setup
=======
    private LatLng getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
>>>>>>> 05c33ac... Refactor BaseMapApi
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

<<<<<<< HEAD
    @Override
    public void onConnectionSuspended(int i) {
<<<<<<< HEAD
<<<<<<< HEAD
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onStart() {
        mapView.onStart();
        super.onStart();
=======

=======
>>>>>>> 7465fed... Catch and show address
    }

    @Override
<<<<<<< HEAD
    protected void onResume() {
        mGoogleApiClient.connect();
        super.onResume();
>>>>>>> e54c81c... refactoring
=======
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    protected void onStart() {
        mapView.onStart();
        super.onStart();
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
    }

    @Override
    protected void onStop() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
        super.onStop();
>>>>>>> e54c81c... refactoring
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
        mapView.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        mGoogleApiClient.connect();
        mapView.onResume();
        super.onResume();
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
    public boolean onPrepareOptionsMenu(Menu menu) {
        saveMenuItem = menu.findItem(R.id.action_save);
        saveMenuItem.setEnabled(false);
        return true;
    }

    @Override
<<<<<<< HEAD
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_map, menu);
        this.menu = menu;
=======
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_map, menu);
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_map, menu);
<<<<<<< HEAD
        this.menu = menu;
>>>>>>> 35d04a3... Fix Camera. Fix Location
=======
>>>>>>> d95c681... Refactoring activities
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location

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

=======
>>>>>>> dfc22ba... Refactor BaseMApActivity
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

<<<<<<< HEAD
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
        saveMenuItem.setEnabled(enabled);
    }

    public void showSnackbar(String address) {
        snackbar = Snackbar.make(parentLayout, getString(R.string.text_location, address), Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
=======
=======
                startActivity(new Intent(this, EditProfileActivity.class).putExtra("loc", currentLocation));
=======
                startActivity(new Intent(this, EditProfileActivity.class).putExtra("loc", new TaskLatLng(currentLocation.latitude, currentLocation.longitude)).putExtra("address", fullAddress));
>>>>>>> 9500ee1... Refactor sending address to EditProfileActivity
=======
=======
                TaskApp.getInstance().setCustomerAddress(fullAddress);
                TaskApp.getInstance().setLocation(new TaskLatLng(chosenLocation.latitude, chosenLocation.longitude));
>>>>>>> aee538b... bugfix
                    Intent intent = new Intent(this, EditProfileActivity.class);
                    intent.putExtra(LOCATION, new TaskLatLng(chosenLocation.latitude, chosenLocation.longitude));
                    intent.putExtra(ADDRESS, fullAddress);
                    startActivity(intent);
>>>>>>> cbfc11e... Final map setup
=======
                Intent intent = new Intent();
                intent.putExtra(LOCATION, chosenLocation);
                intent.putExtra(ADDRESS, fullAddress);
                setResult(RESULT_OK, intent);
                finish();
>>>>>>> 4f5e128... Fix documents permission
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
    }

    private void showAddress(LatLng currentLocation) {

        List<Address> addresses = null;
        Geocoder geocoder = new Geocoder(BaseMapActivity.this);

        try {
            addresses = geocoder.getFromLocation(
                    currentLocation.latitude,
                    currentLocation.longitude,
                    1);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void onMapClick(LatLng latLng) {
        currentLocation = latLng;
        showMarker(CameraUpdateFactory.newLatLng(latLng), new MarkerOptions().position(latLng).title(MY_MARKER_TITLE));
<<<<<<< HEAD
>>>>>>> e54c81c... refactoring
=======
        showSnackbar(currentLocation);
    }
=======
//    private void getDeviceLocation() {
//        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            isLocationPermissionGranted = true;
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, LOC_REQUEST_CODE);
//        }
//        // A step later in the tutorial adds the code to get the device
//        // location.
//    }
//

>>>>>>> 3497b4d... refactoring
=======
        if (addresses != null && !addresses.isEmpty()) {
            Address address = addresses.get(0);
            ArrayList<String> addressFragments = new ArrayList<>();

            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                addressFragments.add(address.getAddressLine(i));
            }
            fullAddress = TextUtils.join(", ",
                    addressFragments);
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
            showSnackbar(fullAddress);
            saveMenuItem.setEnabled(true);
        } else {
            Toast.makeText(this, "Please select proper location", Toast.LENGTH_LONG).show();
            if (snackbar != null) {
                snackbar.dismiss();
            }
            saveMenuItem.setEnabled(false);
        }
    }
>>>>>>> 7465fed... Catch and show address

    public void showSnackbar(String address) {
<<<<<<< HEAD
<<<<<<< HEAD
        CoordinatorLayout parentLayout = (CoordinatorLayout) findViewById(R.id.parentLayout);
<<<<<<< HEAD
        Snackbar.make(parentLayout, "Location: " + currentLocation, Snackbar.LENGTH_INDEFINITE).show();
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
=======
>>>>>>> cbfc11e... Final map setup
        Snackbar.make(parentLayout, "Location: " + address, Snackbar.LENGTH_INDEFINITE).show();
>>>>>>> 3497b4d... refactoring
=======
        snackbar = Snackbar.make(parentLayout, "Location: " + address, Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
>>>>>>> aee538b... bugfix
    }

<<<<<<< HEAD

    @Override
    public boolean onMyLocationButtonClick() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> cbfc11e... Final map setup
        LatLng deviceLocation = getLastLocation();
        showMarkerPlusAnimation(CameraUpdateFactory.newLatLng(deviceLocation),
                new MarkerOptions().position(deviceLocation).title(Constants.MY_MARKER_TITLE));
        showAddress(deviceLocation);
<<<<<<< HEAD
        return true;
    }

    private void showMarkerPlusAnimation(CameraUpdate cameraUpdate, MarkerOptions me) {
=======
    private void showMarkerWithAnimation(LatLng chosenLocation) {
>>>>>>> 05c33ac... Refactor BaseMapApi
        mGoogleMap.clear();
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        mGoogleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
    }

    private void showMarker(LatLng chosenLocation) {
        mGoogleMap.clear();
<<<<<<< HEAD
        mGoogleMap.moveCamera(cameraUpdate);
=======
        showMarker(CameraUpdateFactory.newLatLng(currentLocation),
                new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
=======
>>>>>>> cbfc11e... Final map setup
        return true;
    }

    private void showMarkerPlusAnimation(CameraUpdate cameraUpdate, MarkerOptions me) {
        mGoogleMap.clear();
        mGoogleMap.animateCamera(cameraUpdate);
>>>>>>> e54c81c... refactoring
        mGoogleMap.addMarker(me);
    }

    private void showMarker(CameraUpdate cameraUpdate, MarkerOptions me) {
        mGoogleMap.clear();
        mGoogleMap.moveCamera(cameraUpdate);
        mGoogleMap.addMarker(me);
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
<<<<<<< HEAD
<<<<<<< HEAD
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions();
                    }
                    chosenLocation = getLastLocation();
                    showMarkerPlusAnimation(CameraUpdateFactory.newLatLngZoom(chosenLocation, MAX_ZOOM), new MarkerOptions().position(chosenLocation).title(MY_MARKER_TITLE));
                    showAddress(chosenLocation);
=======
                        && Objects.equals(permissions[2], Manifest.permission.READ_EXTERNAL_STORAGE)
=======
>>>>>>> 4f5e128... Fix documents permission
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
<<<<<<< HEAD

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions();
                    }
<<<<<<< HEAD
                    currentLocation = getLastLocation();
                    showMarker(CameraUpdateFactory.newLatLngZoom(currentLocation, MAX_ZOOM), new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
>>>>>>> e54c81c... refactoring
=======
=======
>>>>>>> dfc22ba... Refactor BaseMApActivity
                    chosenLocation = getLastLocation();
                    showMarkerPlusAnimation(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM), new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
                    showAddress(chosenLocation);
>>>>>>> cbfc11e... Final map setup
                }
            }
        }
=======
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chosenLocation, Constants.MAX_ZOOM));
        mGoogleMap.addMarker(new MarkerOptions().position(chosenLocation).title(Constants.MY_MARKER_TITLE));
>>>>>>> 05c33ac... Refactor BaseMapApi
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 74fd957... Fix Role. Fix Task

    protected LocationRequest createLocationRequest() {
        int interval = 120000;
        int fastestInterval = 30000;
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(interval);
        mLocationRequest.setFastestInterval(fastestInterval);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }
<<<<<<< HEAD
=======
>>>>>>> e54c81c... refactoring
=======
>>>>>>> 74fd957... Fix Role. Fix Task
}
