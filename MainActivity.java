package com.example.extstudent.assignmnt4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonPress = null;
    private LinearLayout linearLayout = null;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonPress = (Button) findViewById(R.id.buttonPress);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        this.buttonPress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                generateNewButton();
                buttonPress.setEnabled(false);
            }
        });

    }

    private void generateNewButton() {
        // Generates a new Button widget dynamically.
        // 1. Set the layout params
        // 2. Create the button and define the look (i.e. text, text
        // color, etc.)
        // 3. Create a callback that will generate another widget.
        // 4. Disable the last button.
        final Button b = new Button(MainActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        b.setLayoutParams(params);
        b.setTextColor(getRandomColor());
        String counterStr = Integer.toString(++counter);
        b.setText("Press Me: " + counterStr);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewButton();
                b.setEnabled(false);
            }
        });
        this.linearLayout.addView(b);
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
