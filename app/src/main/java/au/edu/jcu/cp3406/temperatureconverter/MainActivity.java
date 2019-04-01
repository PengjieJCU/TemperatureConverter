package au.edu.jcu.cp3406.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Spinner spinner2;
    ArrayAdapter <String> adapter;
    private List<String> list;
    Integer Celsius;
    Integer Fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setPrompt("Please choose a unit");
        initDatas();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"The unit you choose is:"+list.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2=(Spinner)findViewById(R.id.spinner2);
        spinner2.setPrompt("Please choose a unit");
        initDatas();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"The unit you choose is:"+list.get(position),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void initDatas(){
        list=new ArrayList<String>();
        list.add("Celsius");
        list.add("Fahreheit");
    }

    public void buttonClicked(View view){
        Button button = (Button) view;
        int Fahrenheit = Integer.parseInt(button.getText().toString());

        Celsius = (Fahrenheit-32)*5/9;
        TextView textView = findViewById(R.id.Fahrenheit);
        textView.setText(Fahrenheit);



    }




}
