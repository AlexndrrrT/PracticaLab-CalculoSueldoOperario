package com.example.calculosueldooperario;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {


    private TextView txtvw1;
    private TextView txtvw2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle datos = getIntent().getExtras();

        txtvw1 = (TextView)findViewById(R.id.txtvw_tiempo);
        txtvw2 = (TextView)findViewById(R.id.txtvw_salario);

        txtvw1.setText(datos.getString("Tiempo"));
        txtvw2.setText(datos.getString("SalarioTotal"));
    }
}