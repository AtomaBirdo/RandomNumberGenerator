package com.example.createtext;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BasicActivity extends AppCompatActivity {

    public void clickMe(View view){
        Intent intent = getIntent(); //Get the data of this intent
        String text = intent.getStringExtra(Intent.EXTRA_TEXT); //Get the data from the intent
        //String[] str = new String[3];
        //str[0] = intent.getStringExtra("MIN");
        //str[1] = intent.getStringExtra("MAX");
        //str[2] = intent.getStringExtra("COUNT");
        String[] str = text.split(" "); //Split the data into min, max, and count
        int min = Integer.parseInt(str[0]);
        int max = Integer.parseInt(str[1]);
        int count = Integer.parseInt(str[2]);

        final LinearLayout vl = findViewById(R.id.ll);
        final TextView[] tv = new TextView[count];

        int width = vl.getWidth(); //Get the width of the vertical layout
        int height = vl.getHeight();

        for (int i=0; i<count; i++)
        {
            tv[i] = new TextView(this); //Select the corresponding TextView
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            //params.leftMargin = (int)(Math.random() * width - 48);
            params.leftMargin = width / 2 - 30; //Set the String list at the center of the screen
            params.topMargin = 1;
            //params.topMargin  = (int)(Math.random() * height / count);
            tv[i].setText((int)(Math.random() * max - min) + ""); //Generate a random number
            //tv[i].setPadding(20, 20, 20, 20);
            tv[i].setTextSize(24);

            /*switch ((int)(Math.random() * 3)){
                case 0:
                    tv[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    break;
                case 1:
                    tv[i].setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    break;
                case 2:
                    tv[i].setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                    break;
            }*/

            tv[i].setLayoutParams(params);
            vl.addView(tv[i]); //Add the TextView into the vertical layout in order to show it on the screen
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
