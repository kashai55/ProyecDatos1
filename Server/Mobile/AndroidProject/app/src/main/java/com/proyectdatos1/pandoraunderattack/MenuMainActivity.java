package com.proyectdatos1.pandoraunderattack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
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


    //general event Button BacktoMenu
    public void onClickBackMenu(View view){
        setContentView(R.layout.activity_menu_main);
    }

    //event Button SignIn
    public void onClickSignIn(View view){
        setContentView(R.layout.activity_sign_in);
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
    }

    //event Button Create New Clan
    public void onClikCreateNewClan(View view){
        setContentView(R.layout.activity_gpsmaps);
    }
}
