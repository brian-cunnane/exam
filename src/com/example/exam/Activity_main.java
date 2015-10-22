package com.example.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_main extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button1;
        button1 = (Button)findViewById(R.id.actOneButton);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int num1 = 100;
                int num2 = 400;
                int num3 = 300;
                int num4 = 50;
                int num5 = 102;

                Intent intent = new Intent(Activity_main.this, Activity_one.class);

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("num1", num1);
                dataBundle.putInt("num2", num2);
                dataBundle.putInt("num3", num3);
                dataBundle.putInt("num4", num4);
                dataBundle.putInt("num5", num5);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }
}
