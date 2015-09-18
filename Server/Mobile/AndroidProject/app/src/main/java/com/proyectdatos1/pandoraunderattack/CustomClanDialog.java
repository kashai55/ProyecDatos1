package com.proyectdatos1.pandoraunderattack;

import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by gusfc_000 on 17/09/2015.
 */
public class CustomClanDialog extends DialogFragment {
    public EditText nameClan;
    public CustomClanDialog(){

    }

    public static CustomClanDialog newInstance(String title){
        CustomClanDialog frag = new CustomClanDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
}
