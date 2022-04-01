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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button button;
    EditText inputlat1;
    EditText inputlat2;
    EditText inputlong1;
    EditText inputlong2;
    TextView distance;
    TextView refuel;
    TextView travel;
    Spinner spinner;
    static double answ, time, speed, refueltime,range;

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
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calDistance();
                calRefuel();
                calTime();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
        switch(position){
            case 0:
                break;
            case 1:
                speed = ;
                range = ;
                break;
            case 2:
                speed = ;
                range = ;
                break;
            case 3:
                speed = ;
                range = ;
                break;
            case 4:
                speed = ;
                range = ;
                break;
            case 5:
                speed = ;
                range = ;
                break;
            case 6:
                speed = ;
                range = ;
                break;
            case 7:
                speed = ;
                range = ;
                break;
            case 8:
                speed = ;
                range = ;
                break;
            case 9:
                speed = ;
                range = ;
                break;
            case 10:
                speed = ;
                range = ;
                break;
            case 11:
                speed = ;
                range = ;
                break;
            case 12:
                speed = ;
                range = ;
                break;
            case 13:
                speed = ;
                range = ;
                break;
            case 14:
                speed = ;
                range = ;
                break;
            case 15:
                speed = ;
                range = ;
                break;
            case 16:
                speed = ;
                range = ;
                break;
            case 17:
                speed = ;
                range = ;
                break;
            case 18:
                speed = ;
                range = ;
                break;
            case 19:
                speed = ;
                range = ;
                break;
            case 20:
                speed = ;
                range = ;
                break;
            case 21:
                speed = ;
                range = ;
                break;
            case 22:
                speed = ;
                range = ;
                break;
            case 23:
                speed = ;
                range = ;
                break;
            case 24:
                speed = ;
                range = ;
                break;
            case 25:
                speed = ;
                range = ;
                break;
            case 26:
                speed = ;
                range = ;
                break;
            case 27:
                speed = ;
                range = ;
                break;
            case 28:
                speed = ;
                range = ;
                break;
            case 29:
                speed = ;
                range = ;
                break;
            case 30:
                speed = ;
                range = ;
                break;
            case 31:
                speed = ;
                range = ;
                break;
            case 32:
                speed = ;
                range = ;
                break;
            case 33:
                speed = ;
                range = ;
                break;
            case 34:
                speed = ;
                range = ;
                break;
            case 35:
                speed = ;
                range = ;
                break;
            case 36:
                speed = ;
                range = ;
                break;
            case 37:
                speed = ;
                range = ;
                break;
            case 38:
                speed = ;
                range = ;
                break;
            case 39:
                speed = ;
                range = ;
                break;
            case 40:
                speed = ;
                range = ;
                break;
            case 41:
                speed = ;
                range = ;
                break;
            case 42:
                speed = ;
                range = ;
                break;
            case 43:
                speed = ;
                range = ;
                break;
            case 44:
                speed = ;
                range = ;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
         answ = c * r;
        distance.setText("You are "+ Double.toString(answ) + " kilometers away from your specified destination");

    }
    private void calTime(){
        time = answ / speed;
        travel.setText("It will take " + Double.toString(time) + " hours to reach your specified destination at maximum speed");
    }
    private void calRefuel(){
        refueltime = answ / range;
        refuel.setText("You will need to refuel: " + Double.toString(refueltime) + " times at maximum speed");
    }

}