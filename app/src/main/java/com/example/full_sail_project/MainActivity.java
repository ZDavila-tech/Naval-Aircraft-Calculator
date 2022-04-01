package com.example.full_sail_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {

    Button button;
    EditText inputlat1;
    EditText inputlat2;
    EditText inputlong1;
    EditText inputlong2;
    TextView distance;
    TextView refuel;
    TextView travel;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        inputlat1 = findViewById(R.id.lat1);
        inputlat2 = findViewById(R.id.lat2);
        inputlong1 = findViewById(R.id.long1);
        inputlong2 = findViewById(R.id.long2);
        distance = findViewById(R.id.distance);
        refuel = findViewById(R.id.refuel);
        travel = findViewById(R.id.travel);
        spinner = findViewById(R.id.spinner_aircraft);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.aircraft, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calDistance();
                calRefuel();
                calTime();
            }
        });

    }

    private void calDistance(){
        double conlat1 = Double.parseDouble(inputlat1.getText().toString());
        double conlat2 = Double.parseDouble(inputlat2.getText().toString());
        double conlong1 = Double.parseDouble(inputlong1.getText().toString());
        double conlong2 = Double.parseDouble(inputlong2.getText().toString());

        double lat1 = Math.toRadians(conlat1);
        double lat2 = Math.toRadians(conlat2);
        double long1 = Math.toRadians(conlong1);
        double long2 = Math.toRadians(conlong2);

        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        double answ = c * r;

        distance.setText("You are "+ Double.toString(answ) + " kilometers away from your specified destination");

    }
    private void calTime(){
        double time = 0.0;

        travel.setText("It will take " + Double.toString(time) + " hours to reach your specified destination");


    }
    private void calRefuel(){
        int refueltime = 0 ;
        refuel.setText("You will need to refuel: " + Integer.toString(refueltime) + " times");
    }
}