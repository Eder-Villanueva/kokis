package com.example.kokis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class rebanadas extends Activity implements OnClickListener {

    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero;
    EditText cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebanadas);


        cont = (EditText) findViewById(R.id.conte);

        uno = (Button) findViewById(R.id.uno);
        uno.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.uno) {
        }


    }


}