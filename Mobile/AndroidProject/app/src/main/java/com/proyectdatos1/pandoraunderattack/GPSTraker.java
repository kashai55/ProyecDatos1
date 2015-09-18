package com.proyectdatos1.pandoraunderattack;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by gusfc_000 on 16/09/2015.
 */
public class GPSTraker extends Service implements LocationListener {

    public Context myContext;

    //estados
    boolean isGPSEnable = false;
    boolean isNetworkEnable;
    boolean cancelGetLocation = false;

    LocationManager locationManager;

    Location locationGPS;
    double latitude;
    double longitude;

    public GPSTraker(Context context) {
        this.myContext = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) myContext.getSystemService(LOCATION_SERVICE);

            isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnable && !isNetworkEnable) {
                //ningun proveedor de red esta habilitada
            } else {
                this.cancelGetLocation = true;

                //habilitando GPS servicio
                if (isGPSEnable) {
                    if (locationGPS == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 10, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (locationGPS != null) {
                                latitude = locationGPS.getLatitude();
                                longitude = locationGPS.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locationGPS;
    }

    //function to get latitude
    public double getLatitude() {
        if (locationGPS != null) {
            latitude = locationGPS.getLatitude();
        }
        return latitude;
    }

    //function to get longitude
    public double getLongitude() {
        if (locationGPS != null) {
            longitude = locationGPS.getLongitude();
        }
        return longitude;
    }

    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(myContext);

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                myContext.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
