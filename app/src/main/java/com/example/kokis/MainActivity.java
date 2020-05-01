package com.example.kokis;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
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

public class MainActivity extends Activity implements OnClickListener {

    Button refresco, reyeno, ingrediente, ind, chica, mediana, grande, familiar, limpiar, cuadrada, eliminar, cal, reb;
    private Dialog dialog;
    TextView resultado;
    EditText contenedor, cont;

    ArrayList<Integer> lista = new ArrayList();

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

        contenedor = (EditText) findViewById(R.id.contenedor);

        cont = (EditText) findViewById(R.id.conte);

        resultado = (TextView) findViewById(R.id.resultado);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ingrediente) {
            array(7);
        }
        if (v.getId() == R.id.refresco) {
            array(10);
        }
        if (v.getId() == R.id.reyena) {
            int relleno = lista.size() - 1;
            if (relleno >= 0) {
                int pizza = lista.get(relleno);
                relleno(pizza, relleno);
            }
        }
        if (v.getId() == R.id.individual) {
            array(40);
        }
        if (v.getId() == R.id.chica) {
            array(70);
        }
        if (v.getId() == R.id.mediana) {
            array(100);
        }
        if (v.getId() == R.id.grande) {
            array(130);
        }
        if (v.getId() == R.id.familiar) {
            array(155);
        }
        if (v.getId() == R.id.cuadrada) {
            array(220);
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
            }
            suma();
        }
        if (v.getId() == R.id.limpiar) {
            resultado.setText("");
            contenedor.setText("");
            lista.clear();
        }
    }

    public void array(int a) {
        lista.add(a);
        suma();
    }

    public void suma() {
        contenedor.setText("" + lista);
        int suma = 0;
        for (Integer i : lista) {
            suma = suma + i;
        }
        resultado.setText("" + suma);
    }

    public void relleno(int b, int c) {
        if (b == 40)
            lista.set(c, 50);

        if (b == 70)
            lista.set(c, 85);

        if (b == 100)
            lista.set(c, 120);

        if (b == 130)
            lista.set(c, 155);

        if (b == 155)
            lista.set(c, 185);

        if (b == 220)
            lista.set(c, 255);


        suma();
    }

    private void rebanadas() {

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_rebanadas);

        final EditText caja = (EditText) dialog.findViewById(R.id.conte);
        dialog.findViewById(R.id.btCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caja.getText().toString().isEmpty()) { }
                else {
                    String reb = caja.getText().toString();
                    int reba = Integer.parseInt(reb) * 20;
                    array(reba);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.modificar) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}



