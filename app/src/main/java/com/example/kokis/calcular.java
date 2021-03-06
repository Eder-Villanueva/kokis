package com.example.kokis;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class calcular extends Activity implements OnClickListener {

    Button refresco, reyeno, ingrediente, ind, chica, mediana, grande, familiar, limpiar, cuadrada, eliminar, cal, reb;
    private Dialog dialog;
    TextView resultado;
    EditText  cont, contenedor;

    ArrayList<Integer> lista = new ArrayList();
    ArrayList<String> nombre = new ArrayList();

    int cambiar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        limpiar = (Button) findViewById(R.id.limpiar);
        limpiar.setOnClickListener(this);

        refresco = (Button) findViewById(R.id.refresco);
        refresco.setOnClickListener(this);

        reyeno = (Button) findViewById(R.id.reyena);
        reyeno.setOnClickListener(this);

        ingrediente = (Button) findViewById(R.id.ingrediente);
        ingrediente.setOnClickListener(this);

        ind = (Button) findViewById(R.id.individual);
        ind.setOnClickListener(this);

        chica = (Button) findViewById(R.id.chica);
        chica.setOnClickListener(this);

        mediana = (Button) findViewById(R.id.mediana);
        mediana.setOnClickListener(this);

        grande = (Button) findViewById(R.id.grande);
        grande.setOnClickListener(this);

        familiar = (Button) findViewById(R.id.familiar);
        familiar.setOnClickListener(this);

        cuadrada = (Button) findViewById(R.id.cuadrada);
        cuadrada.setOnClickListener(this);

        eliminar = (Button) findViewById(R.id.eliminar);
        eliminar.setOnClickListener(this);

        cal = (Button) findViewById(R.id.cal);
        cal.setOnClickListener(this);

        reb = (Button) findViewById(R.id.reb);
        reb.setOnClickListener(this);

        cont = (EditText) findViewById(R.id.conte);

        resultado = (TextView) findViewById(R.id.resultado);

        contenedor = (EditText) findViewById(R.id.contenedor);
        contenedor.setOnClickListener(this);

        contenedor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Listo para modificar", Toast.LENGTH_SHORT).show();
                modificar();
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ingrediente) {
            array(7,"Extra");
        }
        if (v.getId() == R.id.refresco) {

            array(10, "Refresco");
        }
        if (v.getId() == R.id.reyena) {

            int numerolista = lista.size() - 1;
            if (numerolista >= 0) {
                String pizza = nombre.get(numerolista);
                relleno(pizza, numerolista);
            }
        }
        if (v.getId() == R.id.individual) {
            array(40,"Individual");

        }
        if (v.getId() == R.id.chica) {
            array(70, "Chica");


        }
        if (v.getId() == R.id.mediana) {
            array(100,"Mediana");

        }
        if (v.getId() == R.id.grande) {
            array(130,"Grande");

        }
        if (v.getId() == R.id.familiar) {
            array(160,"Familiar");

        }
        if (v.getId() == R.id.cuadrada) {
            array(230, "Cuadrada");
        }
        if (v.getId() == R.id.cal) {
            calculadora();
        }
        if (v.getId() == R.id.reb) {
            rebanadas();
        }
        if (v.getId() == R.id.eliminar) {
            int dato = lista.size() - 1;
            if (dato >= 0) {
                lista.remove(dato);
                nombre.remove(dato);
            }
            suma();
            contenedor.setSelection(contenedor.getText().length());
        }
        if (v.getId() == R.id.limpiar) {

            resultado.setText("");
            contenedor.setText("");
            lista.clear();
            nombre.clear();
        }
        if (v.getId() == R.id.contenedor) {
            if(cambiar==1){
                cambiar=0;
                contenedor.setText("" + lista);
            }else{
                cambiar=1;
                contenedor.setText("" + nombre);
            }
            contenedor.setSelection(contenedor.getText().length());
        }
    }



    public void array(int a, String b) {
        nombre.add(b);
        lista.add(a);
        suma();
        contenedor.setSelection(contenedor.getText().length());
    }

    public void suma() {
        if(cambiar==0){
        contenedor.setText("" + lista);
        }
        else{
            contenedor.setText("" + nombre);
        }

        int suma = 0;
        for (Integer i : lista) {
            suma = suma + i;
        }

        resultado.setText("" + suma);

    }

    public void relleno(String b, int c) {
        if (b.equals("Individual")) {
            lista.set(c, 50);
            nombre.set(c, "Individual R");
        }

        if (b.equals("Chica")) {
            lista.set(c, 85);
            nombre.set(c, "Chica R");
        }

        if (b == "Mediana") {
            lista.set(c, 120);
            nombre.set(c, "Mediana R");
        }

        if (b == "Grande") {
            lista.set(c, 155);
            nombre.set(c, "Grande R");
        }

        if (b == "Familiar") {
            lista.set(c, 195);
            nombre.set(c, "Familiar R");
        }

        if (b == "Cuadrada") {
            lista.set(c, 280);
            nombre.set(c, "Cuadrada R");
        }
        suma();
        contenedor.setSelection(contenedor.getText().length());
    }

    private void rebanadas() {

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_rebanadas);

        final EditText caja = (EditText) dialog.findViewById(R.id.conte);
        dialog.findViewById(R.id.btCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caja.getText().toString().isEmpty() ){ }
                else {
                    if (caja.getText().length() > 9){
                        Toast.makeText(getApplicationContext(), "Datos no soportados", Toast.LENGTH_SHORT).show();
                    }
                      else {
                        String reb = caja.getText().toString();
                        int reba = Integer.parseInt(reb) * 20;
                        if (reba != 0) {
                            String rebanadas = reb + " Reb";
                            array(reba, rebanadas);
                        }
                    }
                }
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
        dialog.findViewById(R.id.uno).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "1");

            }
        });


        dialog.findViewById(R.id.dos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "2");

            }
        });
        dialog.findViewById(R.id.tres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "3");

            }
        });
        dialog.findViewById(R.id.cuatro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "4");

            }
        });
        dialog.findViewById(R.id.cinco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "5");

            }
        });
        dialog.findViewById(R.id.seis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "6");

            }
        });
        dialog.findViewById(R.id.siete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "7");

            }
        });
        dialog.findViewById(R.id.ocho).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "8");

            }
        });
        dialog.findViewById(R.id.nueve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "9");

            }
        });
        dialog.findViewById(R.id.cero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "0");

            }
        });


        dialog.findViewById(R.id.clean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText("");

            }
        });
        dialog.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (caja.getText().toString().isEmpty() == false){
                    String reb = caja.getText().toString();
                    reb = reb.substring(0, reb.length() - 1);
                    caja.setText("" + reb);
                }

            }
        });



    }

    private void calculadora() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_calculadora);
        final EditText caja = (EditText) dialog.findViewById(R.id.contcalc);
        //double cuenta

        dialog.findViewById(R.id.btCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
        dialog.findViewById(R.id.uno).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "1");

            }
        });


        dialog.findViewById(R.id.dos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "2");

            }
        });
        dialog.findViewById(R.id.tres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "3");

            }
        });
        dialog.findViewById(R.id.cuatro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "4");

            }
        });
        dialog.findViewById(R.id.cinco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "5");

            }
        });
        dialog.findViewById(R.id.seis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "6");

            }
        });
        dialog.findViewById(R.id.siete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "7");

            }
        });
        dialog.findViewById(R.id.ocho).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "8");

            }
        });
        dialog.findViewById(R.id.nueve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "9");

            }
        });
        dialog.findViewById(R.id.cero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText(caja.getText() + "0");

            }
        });


        dialog.findViewById(R.id.clean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caja.setText("");

            }
        });

    }

    public void modificar(){

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.modificar);



       // final ListView modifica = (ListView) dialog.findViewById(R.id.modificar);
        //ArrayAdapter adapta= new ArrayAdapter(this,android.R.layout.simple_list_item_1,nombre);
        //modifica.setAdapter(adapta);







        dialog.findViewById(R.id.btCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.promo) {
            Intent intent = new Intent(this, calcular.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}



