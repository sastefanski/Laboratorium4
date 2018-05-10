package com.example.seba.laboratorium4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> target;
    private ArrayAdapter adapter;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] values = new String[] { "Pies",
                "Kot", "Koń", "Gołąb", "Kruk", "Dzik", "Karp",
                "Osioł", "Chomik", "Mysz", "Jeż", "Kraluch" };
        this.target = new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));
        this.adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,this.target);
        ListView listview = (ListView) findViewById(
                R.id.listView);
        listview.setAdapter(this.adapter);
                // Example of a call to a native method
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void wyslij (View view)
    {
        EditText kontrolka =
                (EditText)findViewById(R.id.editText);
        String pole =
                kontrolka.getText().toString();
        Intent intencja = new Intent();
        intencja.putExtra("wpis", pole);
        setResult(RESULT_OK, intencja);
        finish();
    }




    public void nowyWpis(MenuItem mi)
    {
        Intent intencja = new Intent(this,
                DodajWpis.class);
        startActivityForResult(intencja, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            String nowy = (String)extras.get("wpis");
            target.add(nowy);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
