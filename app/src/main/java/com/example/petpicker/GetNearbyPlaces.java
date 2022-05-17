/**
 * Determines the location (latitude and longitude) of pet resources within a certain (specified) radius
 * @author rbaldawa28, amchong, ibateman
 */

package com.example.petpicker;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNearbyPlaces extends AsyncTask<Object,String,String>
{
    GoogleMap mMap;
    String url;
    double radius;
    InputStream is;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    String data;
    Context context;

    /**
     * Constructs a Context object
     * @param context
     */
    public GetNearbyPlaces(Context context) {

        this.context = context;
    }

    /**
     * Searches for pet resource locations based on user specified parameters (radius) and the recommended pet
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Object... params) {
        mMap = (GoogleMap) params[0];
        url = (String) params[1];
        radius = (Double) params[2];

        try {
            URL myUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) myUrl.openConnection();
            httpURLConnection.connect();
            is = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line = "";
            stringBuilder = new StringBuilder();

            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            data = stringBuilder.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Gets latitude and longitude of nearby resources and displays the resource name and location with marker
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject parentObject = new JSONObject(s);
            JSONArray resultsArray = parentObject.getJSONArray("results");
            mMap.clear();
            for(int i = 0; i < resultsArray.length(); i++)
            {
                JSONObject jsonObject = resultsArray.getJSONObject(i);
                JSONObject locationObj = jsonObject.getJSONObject("geometry").getJSONObject("location");
                String latitude = locationObj.getString("lat");
                String longitude = locationObj.getString("lng");

                JSONObject nameObject = resultsArray.getJSONObject((i));
                String name_pet = nameObject.getString("name");
                Log.i("LOC",name_pet);

                LatLng latlng = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
                if(i == 0)
                {
                    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latlng, (float) (-0.00002125*radius+11.5));
                    mMap.moveCamera(update);
                }

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title(name_pet + ": " + nameObject.getString("vicinity"));
                markerOptions.position(latlng);
                mMap.addMarker(markerOptions);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
