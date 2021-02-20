package com.example.calculosueldooperario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText txt1;
    private EditText txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = (EditText) findViewById (R.id.txtbox2);
        txt2 = (EditText) findViewById (R.id.txtbox2);
    }

    public void Calculo(View view)
    {
        String string_txt1=txt1.getText().toString();
        String string_txt2=txt2.getText().toString();

        int tiempo = Integer.parseInt(string_txt1);
        double salario = Double.parseDouble(string_txt2);

        if(tiempo <=0 || salario <=0)
        {
            Toast.makeText(this,"Por favor, ingrese una cantidad de tiempo mayor a 0",Toast.LENGTH_LONG).show();
        }
        else
        {
            if(salario < 100)
            {
                Toast.makeText(this,"Por favor, ingrese un monto mayor a 100$ USD",Toast.LENGTH_LONG).show();
            }
            else
            {
                EnvDat(tiempo,salario);
            }
        }
    }

    private void EnvDat (int tiempo, double salario)
    {
        double salarioneto = 0;
        if ( salario < 500 && tiempo < 10 )
        {
            salarioneto = (salario * 0.05) + salario;
        }
        else if ( salario < 500 && tiempo >= 10 )
        {
            salarioneto = (salario * 0.2) + salario;
        }

        else if ( salario >= 500 )

        {
            salarioneto = salario;
        }

        Intent i = new Intent(this, Activity2.class);

        i.putExtra("SalarioTotal", String.valueOf (salarioneto));
        i.putExtra("Tiempo", String.valueOf(tiempo));

        startActivity(i);


    }
}