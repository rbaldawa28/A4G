/**
 * Searches and displays nearby pet resources (based on current location) for the 2nd recommended pet using Google Maps.
 * Interactive map that allows users to move around.
 * @author rbaldawa28, amchong, ibateman
 */

package com.example.petpicker;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Map2 extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    GoogleApiClient client;
    LatLng current;
    MaterialButton search;
    double lat, lng;
    Context context = this;

    /**
     * Google Map (road, street, and highway map) displayed when opened
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.smf);
        mapFragment.getMapAsync(this);

        search = (MaterialButton) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {

            /**
             * Calls findPets method (searches for local animal resources) when search button is pressed
             * @param v
             */
            @Override
            public void onClick(View v) {
                findPets(v);
            }
        });

    }

    /**
     * Searches for pet resources (shelters & pet resource stores) within a user specified radius (default radius is 50,000 m) of the current location
     * @param v
     */
    public void findPets(View v)
    {
        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);
        Pets options = new Pets(sp);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(Map2.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {

                /**
                 * Utilizes user specified radius and current location to search for the 2nd recommended pet locations
                 * @param task
                 */
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location location = task.getResult();
                    if(location != null)
                    {
                        Geocoder geocoder = new Geocoder(Map2.this, Locale.getDefault());
                        try {
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            lat = addresses.get(0).getLatitude();
                            lng = addresses.get(0).getLongitude();

                            double radius = 50000; //max search radius of google maps ~31 miles
                            EditText radiusT = findViewById(R.id.radius);
                            if(!radiusT.getText().toString().equals(""))
                            {
                                radius = Integer.parseInt(radiusT.getText().toString());
                                radius *= 1609;
                            }
                            StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=");
                            stringBuilder.append(lat+"%2C"+lng);
                            stringBuilder.append("&radius="+radius);
                            stringBuilder.append("&type=store");
                            stringBuilder.append("&keyword=pet"+options.getSecond());
                            stringBuilder.append("&key="+getResources().getString(R.string.google_places_key));
                            String url = stringBuilder.toString();
                            Log.i("TAG", url);

                            Object dataTransfer[] = new Object[3];
                            dataTransfer[0] = mMap;
                            dataTransfer[1] = url;
                            dataTransfer[2] = radius;

                            GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces(context);
                            getNearbyPlaces.execute(dataTransfer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * Updates current location when moved
     * @param location
     */
    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(location == null){
            Toast.makeText(getApplicationContext(),"Location Not Found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            LatLng current = new LatLng(location.getLatitude(), location.getLatitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(current,15);
            //mMap.moveCamera(update);

            MarkerOptions options = new MarkerOptions();
            options.position(current);
            options.title("Current Location");
            //mMap.addMarker(options);
        }
    }

    /**
     * Connects to Google API
     * @param googleMap
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        client = new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();

        client.connect();
    }

    /**
     * Asks for user permission to use location
     * @param bundle
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        LocationRequest request = new LocationRequest().create();
        request.setInterval(1000);
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this::onLocationChanged);

    }

    /**
     * When app gets disconnected
     * @param i
     */
    @Override
    public void onConnectionSuspended(int i) {

    }

    /**
     * When app fails to connect
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
