package com.madsum.shopcite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class BbsSp extends AppCompatActivity {


    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;
    ArrayList<ShopDetails> arraylist = new ArrayList<ShopDetails>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        rank = new String[] { "$9", "$12", "$19", "$14", "$25", "$16", "$7", "$8", "$9", "$10" };

        country = new String[] { "Firozabad", "Mathura", "Tundla",
                "Mathura", "Firozabad", "Chaumuah", "Agra", "",
                "Farah", "Mathura" };

        population = new String[] { "4/5", "4.5/5",
                "4.5/5", "4/5", "5/5", "4/5",
                "5/5", "5/5", "3/5", "5/5" };

        flag = new int[] { R.drawable.elec_item, R.drawable.light,
                R.drawable.tata_sky, R.drawable.elec_item2,
                R.drawable.elec_item4, R.drawable.elec_item3, R.drawable.pbank,
                R.drawable.light, R.drawable.elec_item4, R.drawable.elec_item3 };

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < rank.length; i++)
        {
            ShopDetails wp = new ShopDetails(rank[i], country[i],
                    population[i], flag[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
}
