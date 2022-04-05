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
                speed = 132;
                range = 1259;
                break;
            case 2:
                speed = 145;
                range = 1269;
                break;
            case 3:
                speed = 278;
                range = 2917;
                break;
            case 4:
                speed = 289;
                range = 6186;
                break;
            case 5:
                speed = 270;
                range = 4530;
                break;
            case 6:
                speed = 280;
                range = 2428;
                break;
            case 7:
                speed = 275;
                range = 6667;
                break;
            case 8:
                speed = 275;
                range = 3013;
                break;
            case 9:
                speed = 106;
                range = 889;
                break;
            case 10:
                speed = 114;
                range = 765;
                break;
            case 11:
                speed = 1034;
                range = 3704;
                break;
            case 12:
                speed = 560;
                range = 2385;
                break;
            case 13:
                speed = 478;
                range = 12816;
                break;
            case 14:
                speed = 473;
                range = 7749;
                break;
            case 15:
                speed = 524;
                range = 22409;
                break;
            case 16:
                speed = 1026;
                range = 4345;
                break;
            case 17:
                speed = 1032;
                range = 2028;
                break;
            case 18:
                speed = 426;
                range = 4115;
                break;
            case 19:
                speed = 138;
                range = 1356;
                break;
            case 20:
                speed = 139;
                range = 2815;
                break;
            case 21:
                speed = 248;
                range = 4815;
                break;
            case 22:
                speed = 288;
                range = 4445;
                break;
            case 23:
                speed = 505;
                range = 12742;
                break;
            case 24:
                speed = 508;
                range = 23150;
                break;
            case 25:
                speed = 108;
                range = 343;
                break;
            case 26:
                speed = 154;
                range = 1769;
                break;
            case 27:
                speed = 152;
                range = 1565;
                break;
            case 28:
                speed = 324;
                range = 6667;
                break;
            case 29:
                speed = 1145;
                range = 7815;
                break;
            case 30:
                speed = 1042;
                range = 4111;
                break;
            case 31:
                speed = 405;
                range = 16668;
                break;
            case 32:
                speed = 936;
                range = 4599;
                break;
            case 33:
                speed = 140;
                range = 1111;
                break;
            case 34:
                speed = 326;
                range = 4784;
                break;
            case 35:
                speed = 351;
                range = 5019;
                break;
            case 36:
                speed = 310;
                range = 28123;
                break;
            case 37:
                speed = 115;
                range = 2778;
                break;
            case 38:
                speed = 745;
                range = 3398;
                break;
            case 39:
                speed = 170;
                range = 3843;
                break;
            case 40:
                speed = 180;
                range = 2408;
                break;
            case 41:
                speed = 180;
                range = 4111;
                break;
            case 42:
                speed = 178;
                range = 1304;
                break;
            case 43:
                speed = 159;
                range = 1082;
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