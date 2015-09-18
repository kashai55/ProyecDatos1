package com.proyectdatos1.pandoraunderattack;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.provider.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.widget.Toast;

import java.text.StringCharacterIterator;

import paqueteCliente.*;

import static android.content.Context.LOCATION_SERVICE;

/**
 * @author Gustavo A.
 *
 */
public class MenuMainActivity extends AppCompatActivity implements LocationListener {
    Jugador jugador;

    //Maps GPS
    GPSMapsActivity gpsMapsActivity;
    GoogleMap mMap;
    GPSTraker gps;

    public String myText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
    }


    //general event Button BacktoMenu
    public void onClickBackMenu(View view){
        setContentView(R.layout.activity_menu_main);
    }

    //event Button SignIn
    public void onClickSignIn(View view){
        setContentView(R.layout.activity_sign_in);
        NetworkOnMainThreadException str = new NetworkOnMainThreadException();
        str.printStackTrace();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Emisor emisor01 = new Emisor();
        //emisor01.enviar();

    }

    //event Button LogIn
    public void onClickLogIn(View view){
        setContentView(R.layout.activity_log_in);
    }

    //event Button Create New Account
    public void onClickCreateNewAccount(View view){
        //Text in Frame
        EditText textNewName = (EditText)findViewById(R.id.editTextNewUserName);
        EditText textPass = (EditText)findViewById(R.id.editTextPass);
        EditText texCPass = (EditText)findViewById(R.id.editTextCPass);

        String stringPass = textPass.getText().toString();
        String stringCPass = texCPass.getText().toString();
        String stringNewName = textNewName.getText().toString();

        //prints
        System.out.println(stringNewName);
        System.out.println(stringPass);
        System.out.println(stringCPass);


        //main
        setContentView(R.layout.activity_welcome_new_user);

        TextView viewTextName = (TextView) findViewById(R.id.textViewNameUser);
        String stringViewNewName = viewTextName.getText().toString();
        viewTextName.setText("Welcome to Pandora Under Attack " + stringNewName);


        jugador = new Jugador(stringNewName, stringPass);

    }


    //event Button Create New Clan
    public void onClickCreateNewClan(View view){
        setContentView(R.layout.activity_gpsmaps);

        jugador.crearClan("nuevco clan");

    }

    //event GPS Position Button
    public void onClickMyPosition(View view){
        gps = new GPSTraker(MenuMainActivity.this);

        if(gps.isGPSEnable == true){

            double latitud = gps.getLatitude();
            double longitud = gps.getLongitude();

            LatLng locationCR = new LatLng(latitud, longitud);

            //prueba impire
            System.out.println(latitud);
            System.out.println(longitud);

            if(latitud != 0.0 && longitud != 0.0) {
                Button buttonNext = (Button) findViewById(R.id.buttonNext);
                TextView textInPanel = (TextView) findViewById(R.id.textGPS);

                //habilitar el boton Next
                buttonNext.setEnabled(true);
                textInPanel.setText(" This is yout location" + "\n" + latitud + "\n " + longitud);

                //movimiento del camara hacia la ubicacion
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(locationCR, 17);
                mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

                mMap.animateCamera(update);
                mMap.animateCamera(update, 3000, null);
                mMap.addMarker(new MarkerOptions().position(locationCR).title("You create your clan here"));
            }

        }else{
        gps.showSettingsAlert();}

    }

    public  void onClickNext(View view){
        AlertDialog.Builder dialogUser = new AlertDialog.Builder(this);
        dialogUser.setTitle("Creando Clan").setMessage("Nombre y Emblema de su clan");


        //final EditText nameClan = (EditText)findViewById(R.id.textNameClan);

        final EditText nameClan = new EditText(this);

        //view layout, input name and image
        //dialogUser.setView(R.layout.dialog_create_clan);
        dialogUser.setView(nameClan);

        dialogUser.setIcon(R.drawable.powered_by_google_light);



        nameClan.setInputType(InputType.TYPE_CLASS_TEXT);

        dialogUser.setPositiveButton("Created", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //String nameClan01 = nameClan.getText().toString();

                //System.out.println(nameClan01);
                myText = nameClan.getText().toString();
                System.out.println(myText);
            }
        });
        dialogUser.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        dialogUser.create();
        dialogUser.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
}
