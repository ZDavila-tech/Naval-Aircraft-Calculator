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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
//variables used in project
    Button button;
    EditText inputlat1;
    EditText inputlat2;
    EditText inputlong1;
    EditText inputlong2;
    TextView distance;
    TextView refuel;
    TextView travel;
    Spinner spinner;
    double answ;
    double time;
    double speed;
    double refueltime;
    double range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        inputlat1 = (EditText) findViewById(R.id.lat1);
        inputlat2 = (EditText) findViewById(R.id.lat2);
        inputlong1 = (EditText) findViewById(R.id.long1);
        inputlong2 = (EditText) findViewById(R.id.long2);
        distance = (TextView) findViewById(R.id.distance);
        refuel = (TextView) findViewById(R.id.refuel);
        travel = (TextView) findViewById(R.id.travel);
        spinner = (Spinner) findViewById(R.id.spinner_aircraft);
        //set Spinner to Appear like a drop-down menu
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.aircraft, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
//when you click the button: the distance, travel time, and number of refuels will appear
        button.setOnClickListener(v -> {
            calDistance();
            calTime();
            calRefuel();

        });

    }
//depending on which aircraft is chosen will determine the values for the speed and range
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
        switch(position){
            case 0:

                break;
            case 1:
                speed = 132.0;
                range = 1259.0;
                break;
            case 2:
                speed = 145.0;
                range = 1269.0;
                break;
            case 3:
                speed = 278.0;
                range = 2917.0;
                break;
            case 4:
                speed = 289.0;
                range = 6186.0;
                break;
            case 5:
                speed = 270.0;
                range = 4530.0;
                break;
            case 6:
                speed = 280.0;
                range = 2428.0;
                break;
            case 7:
                speed = 275.0;
                range = 6667.0;
                break;
            case 8:
                speed = 275.0;
                range = 3013.0;
                break;
            case 9:
                speed = 106.0;
                range = 889.0;
                break;
            case 10:
                speed = 114.0;
                range = 765.0;
                break;
            case 11:
                speed = 1034.0;
                range = 3704.0;
                break;
            case 12:
                speed = 560.0;
                range = 2385.0;
                break;
            case 13:
                speed = 478.0;
                range = 12816.0;
                break;
            case 14:
                speed = 473.0;
                range = 7749.0;
                break;
            case 15:
                speed = 524.0;
                range = 22409.0;
                break;
            case 16:
                speed = 1026.0;
                range = 4345.0;
                break;
            case 17:
                speed = 1032.0;
                range = 2028.0;
                break;
            case 18:
                speed = 426.0;
                range = 4115.0;
                break;
            case 19:
                speed = 138.0;
                range = 1356.0;
                break;
            case 20:
                speed = 139.0;
                range = 2815.0;
                break;
            case 21:
                speed = 248.0;
                range = 4815.0;
                break;
            case 22:
                speed = 288.0;
                range = 4445.0;
                break;
            case 23:
                speed = 505.0;
                range = 12742.0;
                break;
            case 24:
                speed = 508.0;
                range = 23150.0;
                break;
            case 25:
                speed = 108.0;
                range = 343.0;
                break;
            case 26:
                speed = 154.0;
                range = 1769.0;
                break;
            case 27:
                speed = 152.0;
                range = 1565.0;
                break;
            case 28:
                speed = 324.0;
                range = 6667.0;
                break;
            case 29:
                speed = 1145.0;
                range = 7815.0;
                break;
            case 30:
                speed = 1042.0;
                range = 4111.0;
                break;
            case 31:
                speed = 405.0;
                range = 16668.0;
                break;
            case 32:
                speed = 936.0;
                range = 4599.0;
                break;
            case 33:
                speed = 140.0;
                range = 1111.0;
                break;
            case 34:
                speed = 326.0;
                range = 4784.0;
                break;
            case 35:
                speed = 351.0;
                range = 5019.0;
                break;
            case 36:
                speed = 310.0;
                range = 28123.0;
                break;
            case 37:
                speed = 115.0;
                range = 2778.0;
                break;
            case 38:
                speed = 745.0;
                range = 3398.0;
                break;
            case 39:
                speed = 170.0;
                range = 3843.0;
                break;
            case 40:
                speed = 180.0;
                range = 2408.0;
                break;
            case 41:
                speed = 180.0;
                range = 4111.0;
                break;
            case 42:
                speed = 178.0;
                range = 1304.0;
                break;
            case 43:
                speed = 159.0;
                range = 1082.0;
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
         answ = c * r / 1.852;
         String result = "You are "+ String.format("%.2f", answ) + " nautical miles away from your specified destination";
        distance.setText(result);

    }
    private void calTime(){
        time = answ / speed;
        String first = "It will take " + String.format("%.2f", time) + " hours at maximum speed";
        travel.setText(first);
    }
    private void calRefuel(){
        refueltime = answ / range;
        String result = "You will need to refuel " + String.format("%.2f", refueltime) + " times at maximum speed";
        refuel.setText(result);
    }

}