package com.proyectdatos1.pandoraunderattack;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import paqueteCliente.Cliente;


/**
 * Clase que ejecuta todos los métodos, tales como eventos de los botones,
 * Instancia los diferentes los atributos necesario para la localización, así como el
 * Mapa, instancia un cliente para que el usuario pueda conectarse con el Servidor,
 * En el método inicial que carga la actividad principal se incorpora los iconos para los
 * Recursos, se instancia una excepción de red para que el cliente se conecte con el Servidor.
 *
 * @author Gustavo A. Fallas Carrea
 *
 */
public class MenuMainActivity extends Activity implements LocationListener {

    //Maps GPS
    public GPSMapsActivity map = new GPSMapsActivity();
    public GoogleMap mMap = map.Map;
    public GPSTracker gps;
    public double latitud;
    public double longitud;
    public LatLng locationClient;

    //resource
    public LatLng locationResourceIron;
    public LatLng locationResourceWood;
    public LatLng locationResourceStone;

    //client
    public Cliente cliente;

    //position user of clan new
    public MarkerOptions markerClient;

    //bitmap for Emblem Clan
    public Bitmap bitmapClan;

    //boolean
    public boolean entradaDesdeSignIn = false;
    public boolean entradaDesdeLogIn = false;

    //icon for marker, resources and client in clan view
    public int userClientMarker;
    public int ironMarker;
    public int woodMarker;
    public int stoneMarker;


    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        //set icon to marker's
        userClientMarker = R.drawable.client;
        ironMarker       = R.drawable.hierro;
        woodMarker       = R.drawable.madera;
        stoneMarker      = R.drawable.piedra;

        //conexion para el cliente
        NetworkOnMainThreadException str = new NetworkOnMainThreadException();
        str.printStackTrace();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//       cliente = new Cliente();
    }


    /**
     * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when
     * the activity had been stopped, but is now again being displayed to the
     * user.  It will be followed by {@link #onResume}.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onCreate
     * @see #onStop
     * @see #onResume
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Android", "onStart event");
    }

    /**
     * Called after {@link #onStop} when the current activity is being
     * re-displayed to the user (the user has navigated back to it).  It will
     * be followed by {@link #onStart} and then {@link #onResume}.
     * <p/>
     * <p>For activities that are using raw {@link @Cursor} objects (instead of
     * creating them through
     * {@link #managedQuery(Uri, String[], String, String[], String)},
     * this is usually the place
     * where the cursor should be requeried (because you had deactivated it in
     * {@link #onStop}.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onStop
     * @see #onStart
     * @see #onResume
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Android", "onRestart event");
    }

    /**
     * Called after {@link #onRestoreInstanceState}, {@link #onRestart}, or
     * {@link #onPause}, for your activity to start interacting with the user.
     * This is a good place to begin animations, open exclusive-access devices
     * (such as the camera), etc.
     * <p/>
     * <p>Keep in mind that onResume is not the best indicator that your activity
     * is visible to the user; a system window such as the keyguard may be in
     * front.  Use {@link #onWindowFocusChanged} to know for certain that your
     * activity is visible to the user (for example, to resume a game).
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onRestoreInstanceState
     * @see #onRestart
     * @see #onPostResume
     * @see #onPause
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Android", "onResume event");
    }

    /**
     * Called as part of the activity lifecycle when an activity is going into
     * the background, but has not (yet) been killed.  The counterpart to
     * {@link #onResume}.
     * <p/>
     * <p>When activity B is launched in front of activity A, this callback will
     * be invoked on A.  B will not be created until A's {@link #onPause} returns,
     * so be sure to not do anything lengthy here.
     * <p/>
     * <p>This callback is mostly used for saving any persistent state the
     * activity is editing, to present a "edit in place" model to the user and
     * making sure nothing is lost if there are not enough resources to start
     * the new activity without first killing this one.  This is also a good
     * place to do things like stop animations and other things that consume a
     * noticeable amount of CPU in order to make the switch to the next activity
     * as fast as possible, or to close resources that are exclusive access
     * such as the camera.
     * <p/>
     * <p>In situations where the system needs more memory it may kill paused
     * processes to reclaim resources.  Because of this, you should be sure
     * that all of your state is saved by the time you return from
     * this function.  In general {@link #onSaveInstanceState} is used to save
     * per-instance state in the activity and this method is used to store
     * global persistent data (in content providers, files, etc.)
     * <p/>
     * <p>After receiving this call you will usually receive a following call
     * to {@link #onStop} (after the next activity has been resumed and
     * displayed), however in some cases there will be a direct call back to
     * {@link #onResume} without going through the stopped state.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onResume
     * @see #onSaveInstanceState
     * @see #onStop
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Android", "onPause event");
    }

    /**
     * Called when you are no longer visible to the user.  You will next
     * receive either {@link #onRestart}, {@link #onDestroy}, or nothing,
     * depending on later user activity.
     * <p/>
     * <p>Note that this method may never be called, in low memory situations
     * where the system does not have enough memory to keep your activity's
     * process running after its {@link #onPause} method is called.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onRestart
     * @see #onResume
     * @see #onSaveInstanceState
     * @see #onDestroy
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Android", "onStop event");
    }

    /**
     * Perform any final cleanup before an activity is destroyed.  This can
     * happen either because the activity is finishing (someone called
     * {@link #finish} on it, or because the system is temporarily destroying
     * this instance of the activity to save space.  You can distinguish
     * between these two scenarios with the {@link #isFinishing} method.
     * <p/>
     * <p><em>Note: do not count on this method being called as a place for
     * saving data! For example, if an activity is editing data in a content
     * provider, those edits should be committed in either {@link #onPause} or
     * {@link #onSaveInstanceState}, not here.</em> This method is usually implemented to
     * free resources like threads that are associated with an activity, so
     * that a destroyed activity does not leave such things around while the
     * rest of its application is still running.  There are situations where
     * the system will simply kill the activity's hosting process without
     * calling this method (or any others) in it, so it should not be used to
     * do things that are intended to remain around after the process goes
     * away.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onPause
     * @see #onStop
     * @see #finish
     * @see #isFinishing
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Android", "onDestroy event");
    }

    /**
     * Called by the system when the device configuration changes while your
     * activity is running.  Note that this will <em>only</em> be called if
     * you have selected configurations you would like to handle with the
     * {@link android.R.attr#configChanges} attribute in your manifest.  If
     * any configuration change occurs that is not selected to be reported
     * by that attribute, then instead of reporting it the system will stop
     * and restart the activity (to have it launched with the new
     * configuration).
     * <p/>
     * <p>At the time that this function has been called, your Resources
     * object will have been updated to return resource values matching the
     * new configuration.
     *
     * @param newConfig The new device configuration.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"landscape", Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"portrait", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Método que muestra la actividad activity_menu_main,
     * Es llamado cuando presiona retroceder, desde SIGN IN o LOG IN
     * Vuelve entradaDesdeLogIn y entradaDesdeSignIn con valor FALSE.
     *
     * @param view actividad  que sera vista
     */
    public void onClickBackMenu(View view){
        setContentView(R.layout.activity_menu_main);
        entradaDesdeLogIn = false;
        entradaDesdeSignIn = false;
    }


    /**
     * Método que muestra la actividad <<activity_sign_in>>,
     * Es llamado cuando presiona SIGN IN
     * Cambia la variable entradaDesdeSignIn = TRUE.
     *
     * @param view actividad  que sera vista
     */
    public void onClickSignIn(View view){
        setContentView(R.layout.activity_sign_in);
        entradaDesdeSignIn = true;
    }


    /**
     * Método que muestra la actividad <<activity_log_in>>,
     * Es llamado cuando presiona LOG IN
     * Cambia la variable entradaDesdeLogIn= TRUE.
     *
     * @param view  actividad  que sera vista
     */
    public void onClickLogIn(View view) {
        setContentView(R.layout.activity_log_in);
        entradaDesdeLogIn = true;
    }


    /**
     * Método que realiza la creación de la cuenta y entrar en cuenta.
     * -Si entra desde SIGN IN: Obtiene el nombre del nuevo usuario y la contraseña.
     * Si digita un nombre valido, y  contraseñas validas, se comunica con el cliente,
     * Enviando los datos al servidor, espera que le responda que se creó la cuenta.
     * Si no es así muestra mensajes de error al usuario.
     * -Si entra desde LOG IN: Obtiene el nombre de la cuenta ya existente.
     * Se comunica con el servidor mediante el cliente, solicitando ingresar.
     * Si la cuenta se encuentra en el Servidor, habilita la actividad <<activity_welcome_new_user>>.
     *
     * @param view actividad  que sera vista
     * @throws InterruptedException
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onClickCreateNewAccount(View view) throws InterruptedException {
        if(entradaDesdeSignIn) {
            //Text Input User
            EditText textNewName = (EditText) findViewById(R.id.editTextNewUserName);
            EditText textPass = (EditText) findViewById(R.id.editTextPass);
            EditText texCPass = (EditText) findViewById(R.id.editTextCPass);

            //get string text input
            String stringPass = textPass.getText().toString();
            String stringCPass = texCPass.getText().toString();
            String stringNewName = textNewName.getText().toString();

            //test prints
            System.out.println(stringNewName);
            System.out.println(stringPass);
            System.out.println(stringCPass);

            //verify that the name is longer than one character
            if (stringNewName.length() <= 3) {
                //alert dialog in frame
                AlertDialog.Builder nameFail = new AlertDialog.Builder(this);
                nameFail.setMessage("Ingrese un nombre valido \n mayor o igual a 4 caracteres");
                nameFail.setTitle("Error Text");
                nameFail.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                nameFail.show();
                nameFail.create();
            } else {
                //If both passwords are equal
                if ((stringPass.equals(stringCPass)) && stringPass.length() >= 4) {
//                    cliente.comunicarse("SI/" + stringNewName + "/" + stringPass);

//                    if (cliente.respuestaSeparada.Sub(0).toString().equals("BN")) {
                        setContentView(R.layout.activity_welcome_new_user);
                        //set text in frame
                        TextView viewTextName = (TextView) findViewById(R.id.textViewNameUser);
                        viewTextName.setText("Welcome to Pandora Under Attack \n" + "\n" + stringNewName);

//                    } else {
//                        System.out.println("Error en el servido");
//                   }


                } else {
                    //!=passwords
                    AlertDialog.Builder passFail = new AlertDialog.Builder(this);
                    passFail.setMessage("Contraseña no valida");
                    passFail.setTitle("Error Pass");
                    passFail.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    passFail.show();
                    passFail.create();
                }
            }
        }
        if (entradaDesdeLogIn){
            EditText textNameUser = (EditText)findViewById(R.id.editTextNameUser);
            EditText textNamePass = (EditText)findViewById(R.id.editTextPassUser);


//            cliente.comunicarse("LI/" + textNameUser.getText().toString() + "/" + textNamePass.getText().toString());

//            if (cliente.respuestaSeparada.Sub(0).toString().equals("BN")) {
//                setContentView(R.layout.activity_welcome_new_user);

                //set text in frame
                TextView viewTextName = (TextView) findViewById(R.id.textViewNameUser);
                viewTextName.setVisibility(View.VISIBLE);
                viewTextName.setText("Welcome back " + textNameUser + "\n to Pandora Under Attack");
            }
            else {
                //!=passwords
                AlertDialog.Builder userFail = new AlertDialog.Builder(this);
                userFail.setMessage("Cliente no existe");
                userFail.setTitle("Error Account");
                userFail.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                userFail.show();
                userFail.create();

            }



//       }

    }


    /**
     * Método que realiza y carga la actividad <<activity_gpsmaps>>.
     * Obtiene el botón para localizar y el espacio para mostrar las coordenadas para habilitarlos en pantalla.
     * Este evento es llamado desde el botón CREATE NEW CLAN.
     *
     * @param view actividad  que sera vista
     */
    public void onClickCreateNewClan(View view) {
        setContentView(R.layout.activity_gpsmaps);
        TextView textViewGPS = (TextView)findViewById(R.id.textGPS);
        ImageButton buttonGPSLocation = (ImageButton)findViewById(R.id.imageButtonPosition);

        //enabled button and textView
        textViewGPS.setVisibility(View.VISIBLE);
        buttonGPSLocation.setVisibility(View.VISIBLE);
    }


    /**
     * Método que Inicializa el método para localizar la posición, obtiene la latitud y longitud
     * Para el cliente, Si el encuentra algún proveedor habilitado y coordenadas diferentes a 0.0,
     * Procede a dibujar la marca donde se encuentra el jugador
     *
     * @param view actividad  que sera vista
     */
    public void onClickMyPosition(View view){
        //location
        gps = new GPSTracker(MenuMainActivity.this);
        latitud = gps.getLatitude();
        longitud = gps.getLongitude();
        locationClient = new LatLng(latitud, longitud);

        //test prints
        System.out.println(latitud);
        System.out.println(longitud);

        System.out.println(gps.isGPSEnable);
        System.out.println(gps.isNetworkEnable);

        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        //GPS Mobile Enabled
        if(gps.isGPSEnable || gps.isNetworkEnable){
            //cuando encuentre una posicion
            if(latitud != 0.0 && longitud != 0.0) {
                //maps
                Button buttonNext = (Button) findViewById(R.id.buttonNext);
                TextView textInPanel = (TextView) findViewById(R.id.textGPS);
                //habilitar
                buttonNext.setVisibility(View.VISIBLE);
                //textInPanel.setVisibility(View.VISIBLE);

                //setText in panel
                textInPanel.setText(" This is yout location" + "\n" + latitud + "\n " + longitud);
                textInPanel.setTextColor(Color.BLUE);

                //move camera in position
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(locationClient, 17);
                mMap.animateCamera(update, 3000, null);

                //add marker  postion User
                MarkerOptions markerPositionUser = new MarkerOptions().title("You create your clan here");
                markerPositionUser.position(locationClient);
                mMap.addMarker(markerPositionUser);

            }
        }else{
        gps.showSettingsAlert();}

    }


    /**
     * Metodo que obtiene los elementos del Maps,
     * los habilita para ser mostrados.
     *
     * @param view actividad  que sera vista
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public  void onClickNext(View view){

        //get frame, widgets
        FrameLayout frame = (FrameLayout)findViewById(R.id.generatedClan);
        Button createClan = (Button) findViewById(R.id.buttonCreateClan);
        Button upEmblem = (Button)findViewById(R.id.buttonUpEmblem);
        EditText nameClan = (EditText)findViewById(R.id.editTextNameClan);

        //visible frame and widgets
        frame.setVisibility(View.VISIBLE);
        createClan.setVisibility(View.VISIBLE);
        upEmblem.setVisibility(View.VISIBLE);
        nameClan.setVisibility(View.VISIBLE);
    }


    /**
     * Metodo que obtiene los elementos mostrados en el mapa los deshabilita
     * Toma la imagen selecciona para ser emblema y cambia a menor tamaño
     * Si el jugador ingresa un nombre para clan y un emblema prosigue a limpiar el mapa
     * Se conecta con el Servidor, enviando le el nombre del clan, y las posiciones en el mapa.
     * Dibuja una marca Con las posiciones del cliente al ingresar
     * Añade un radio al clan de 50 metros.
     * Añade una marca que pertenece al miembro del clan.
     * Añade los recursos al mapa (Hierro, Madera, Piedra).
     * Si no es asi muestra un mensaje de error.
     *
     * @param view actividad  que sera vista
     * @throws InterruptedException
     */
    public void onClickCreateClanConfirm(final View view) throws InterruptedException {
        //get widgets to disabled
        TextView textViewGPS = (TextView)findViewById(R.id.textGPS);
        ImageButton buttonGPSLocation = (ImageButton)findViewById(R.id.imageButtonPosition);
        FrameLayout frame = (FrameLayout)findViewById(R.id.generatedClan);
        Button createClan = (Button)findViewById(R.id.buttonCreateClan);
        Button upEmblem = (Button)findViewById(R.id.buttonUpEmblem);
        final Button buttonNext = (Button)findViewById(R.id.buttonNext);

        //get widgets in frame
        EditText nameClan = (EditText)findViewById(R.id.editTextNameClan);
        String stringNameClan = nameClan.getText().toString();

        //disabled widgets
        buttonNext.setVisibility(View.INVISIBLE);
        nameClan.setVisibility(View.INVISIBLE);
        frame.setVisibility(View.INVISIBLE);
        createClan.setVisibility(View.INVISIBLE);
        upEmblem.setVisibility(View.INVISIBLE);
        textViewGPS.setVisibility(View.INVISIBLE);
        buttonGPSLocation.setVisibility(View.INVISIBLE);

        //prueba
        System.out.println(stringNameClan);

        //position clan
        double latClan = locationClient.latitude;
        double longClan = locationClient.longitude;
        final LatLng locationClan = new LatLng(latClan, longClan);

        //emblem for clan
        Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmapClan, 120, 120);


        //si cantidad de nombre es menor o 1, mostrara error
        if(stringNameClan.length() <= 3 || thumbnail == null){
            //alert dialog in frame
            AlertDialog.Builder errorCreateClan = new AlertDialog.Builder(this);
            errorCreateClan.setMessage("Ingrese un nombre para el clan" + "\n" + " y un emblema, por favor");
            errorCreateClan.setTitle("Error Create Clan");
            errorCreateClan.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //si hay un error en crear clan, sin nombre o sin emblema
                    buttonNext.setVisibility(View.VISIBLE);
                }
            });
            errorCreateClan.show();
            errorCreateClan.create();

        }else {
//            cliente.comunicarse("CC/" + stringNameClan + "/" + latClan + "/" + longClan);

//            if(cliente.respuestaSeparada.Sub(0).toString().equals("CLCR")) {

                //maps
                mMap.clear();

                //maps
                mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

                //add emblem to clan
                mMap.addMarker(new MarkerOptions().position(locationClan).title(stringNameClan).icon(BitmapDescriptorFactory.fromBitmap(thumbnail)));

                //radius to clan /radius specified in meters
                mMap.addCircle(new CircleOptions().center(locationClan).radius(50).visible(true).fillColor(Color.argb(50, 0, 255, 0)));

                //update camera
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(locationClan, 18);
                mMap.animateCamera(update, 1000, null);

                //location client
                final double latClientClan = locationClient.latitude;
                double longClientClan = locationClient.longitude;
                final LatLng locationClientInClan = new LatLng(latClientClan, longClientClan);



                //marca
                markerClient = new MarkerOptions().title("Esta aqui").position(locationClientInClan);
                markerClient.draggable(true);
                markerClient.icon(BitmapDescriptorFactory.fromResource(userClientMarker));
                mMap.addMarker(markerClient);



                //resoruces in maps

                //iron
                locationResourceIron = new LatLng(9.903968, -84.076918);
                MarkerOptions markerIron = new MarkerOptions().position(locationResourceIron).title("Iron").icon(BitmapDescriptorFactory.fromResource(ironMarker));
                markerIron.snippet("100 of Iron " + " Toque para recolectar");
                final Marker addIron = mMap.addMarker(markerIron);


                //wood
                locationResourceWood = new LatLng(9.8961, -83.95261);
                MarkerOptions markerWood = new MarkerOptions().position(locationResourceWood).title("Wood").icon(BitmapDescriptorFactory.fromResource(woodMarker));
                markerWood.snippet("100 of Wood " + " Toque para recolectar");
                final Marker addWood = mMap.addMarker(markerWood);

                //stone
                locationResourceStone = new LatLng(9.8161, -83.90261);
                MarkerOptions markerStone = new MarkerOptions().position(locationResourceStone).title("Stone").icon(BitmapDescriptorFactory.fromResource(stoneMarker));
                markerStone.snippet("100 of Stone " + " Toque para recolectar");
                final Marker addStone = mMap.addMarker(markerStone);
//            }else {
//                System.out.println("Error en el servido");
//            }


            //event
            //when you touch the marker displays information once
            // the second time it collects

        }//final else

    }//final if


    public void updateLocation(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(5000);
                        gps.getLocation();
                        gps.onLocationChanged(gps.locationGPS);
                        latitud = gps.getLatitude();
                        longitud = gps.getLongitude();
                        locationClient = new LatLng(latitud, longitud);
                        System.out.println("actualizando cordenadas del jugador" + latitud + "," + longitud);

                        //markerClient.position(locationClient);


                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * Metodo que obtiene e inicializa el Intent para poder
     * acceder a la galeria del sistema.
     * Muestra la imagen en un vista previa.
     *
     * @param view actividad que sera vista
     */
    public void onClickUpEmblem(View view){
        //get space for image selected
        ImageView emblemClan = (ImageView)findViewById(R.id.emblemViewClan);
        emblemClan.setVisibility(View.VISIBLE);

        //instance intent to access the image
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        int code = 2;
        //start intent
        startActivityForResult(intent, code);
    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * <p/>
     * <p>This method is never invoked if your activity sets
     *
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param imageReturned        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturned) {
        Uri selectedImageClan = imageReturned.getData();
        InputStream is;
        try {
            is = getContentResolver().openInputStream(selectedImageClan);
            BufferedInputStream bit = new BufferedInputStream(is);
            bitmapClan = BitmapFactory.decodeStream(bit);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmapClan.compress(Bitmap.CompressFormat.PNG, 70, out);
            ImageView emblemClan = (ImageView)findViewById(R.id.emblemViewClan);
            emblemClan.setImageBitmap(bitmapClan);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p/>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p/>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p/>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p/>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_main, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p/>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
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

    /**
     * Called when the provider status changes. This method is called when
     * a provider is unable to fetch a location or if the provider has recently
     * become available after a period of unavailability.
     *
     * @param provider the name of the location provider associated with this
     *                 update.
     * @param status   {@link LocationProvider#OUT_OF_SERVICE} if the
     *                 provider is out of service, and this is not expected to change in the
     *                 near future; {@link LocationProvider#TEMPORARILY_UNAVAILABLE} if
     *                 the provider is temporarily unavailable but is expected to be available
     *                 shortly; and {@link LocationProvider#AVAILABLE} if the
     *                 provider is currently available.
     * @param extras   an optional Bundle which will contain provider specific
     *                 status variables.
     *                 <p/>
     *                 <p> A number of common key/value pairs for the extras Bundle are listed
     *                 below. Providers that use any of the keys on this list must
     *                 provide the corresponding value as described below.
     *                 <p/>
     *                 <ul>
     *                 <li> satellites - the number of satellites used to derive the fix
     */
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    /**
     * Called when the location has changed.
     * <p/>
     * <p> There are no restrictions on the use of the supplied Location object.
     *
     * @param location The new location, as a Location object.
     */
    @Override
    public void onLocationChanged(Location location) {
    }

    /**
     * Called when the provider is enabled by the user.
     *
     * @param provider the name of the location provider associated with this
     *                 update.
     */
    @Override
    public void onProviderEnabled(String provider) {
    }

    /**
     * Called when the provider is disabled by the user. If requestLocationUpdates
     * is called on an already disabled provider, this method is called
     * immediately.
     *
     * @param provider the name of the location provider associated with this
     *                 update.
     */
    @Override
    public void onProviderDisabled(String provider) {
    }


}//final class MenuMainActivity
