
package com.madsum.shopcite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BrowseByStoreCat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_by_store_cat);
    }

    public void onClickElecStore(View view){
        Intent intent=new Intent(this, BbsElec.class);
        startActivity(intent);
    }
    public void onClickPcStore(View view){
        Intent intent= new Intent(this, BbsPc.class);
        startActivity(intent);
    }

    public void onClickSpStore(View view){
        Intent i= new Intent(this, BbsSp.class);
        startActivity(i);
    }

    public void onClickApStore(View v){
        Intent i= new Intent(this, BbsApparels.class);
        startActivity(i);
    }
}
