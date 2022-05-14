package com.example.petpicker;

import android.Manifest;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;

public class Map4 extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    GoogleApiClient client;
    LatLng current;
    MaterialButton search;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.smf);
        mapFragment.getMapAsync(this);

        search = (MaterialButton) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPets(v);
            }
        });

    }

    public void findPets(View v)
    {
        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);
        Pets options = new Pets(sp);
        Location location = new Location("");
        LatLng current = new LatLng(location.getLatitude(), location.getLatitude());

        StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        stringBuilder.append("location="+current.latitude+","+current.longitude);
        stringBuilder.append("&radius="+50000);
        stringBuilder.append("&keyword="+options.getFourth());
        stringBuilder.append("&key"+getResources().getString(R.string.google_places_key));
        String url = stringBuilder.toString();

        Object dataTransfer[] = new Object[2];
        dataTransfer[0] = mMap;
        dataTransfer[1] = url;

        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces(this);
        getNearbyPlaces.execute(dataTransfer);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if(location == null){
            Toast.makeText(getApplicationContext(),"Location Not Found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            LatLng current = new LatLng(location.getLatitude(), location.getLatitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(current,15);
            mMap.moveCamera(update);

            MarkerOptions options = new MarkerOptions();
            options.position(current);
            options.title("Current Location");
            mMap.addMarker(options);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        client = new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();

        client.connect();
    }

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

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
