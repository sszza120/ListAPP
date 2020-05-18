package com.sszza120.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView ls;
    private String[] favorite;
    private TextView txvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls = findViewById(R.id.ls);
        txvshow = findViewById(R.id.txvshow);

        favorite = getResources().getStringArray(R.array.favorite);
        //ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, favorite);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,favorite);
        ls.setAdapter(ad);
        //ls.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ls.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }

    public void btnOK(View view) {

        String str = "";
        for(int i = 0; i<favorite.length; i++){
            if (ls.isItemChecked(i))
                str += favorite[i] + "\n";
        }

        txvshow.setText(str);
    }
}
