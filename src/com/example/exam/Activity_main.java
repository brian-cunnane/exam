package com.example.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_main extends Activity {
    /**
     * Called when the activity is first created.
     */



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button1;
        Button button2;
        Button button3;

        button1 = (Button)findViewById(R.id.actOneButton);
        button2 = (Button)findViewById(R.id.actTwoButton);
        button3 = (Button)findViewById(R.id.actThreeButton);

        final EditText num1Text = (EditText)findViewById(R.id.num1Text);
        final EditText num2Text = (EditText)findViewById(R.id.num2Text);
        final EditText num3Text = (EditText)findViewById(R.id.num3Text);
        final EditText num4Text = (EditText)findViewById(R.id.num4Text);
        final EditText num5Text = (EditText)findViewById(R.id.num5Text);

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
                startActivityForResult(intent, 1010);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] data = new String[5];

                //cater for blank strings

                //get input from text areas
                data[0] = num1Text.getText().toString();
                data[1] = num2Text.getText().toString();
                data[2] = num3Text.getText().toString();
                data[3] = num4Text.getText().toString();
                data[4] = num5Text.getText().toString();
                for(int i = 0; i < data.length; i ++){
                    if (data[i].compareTo("")==0) {
                        data[i] = "0";
                    }
                }
                Bundle dataBundle = new Bundle();
                dataBundle.putStringArray("data",data);
                Intent intent = new Intent(Activity_main.this, Activity_two.class);

                intent.putExtras(dataBundle);
                startActivityForResult(intent, 2020);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        final EditText num1Text = (EditText)findViewById(R.id.num1Text);
        final EditText num2Text = (EditText)findViewById(R.id.num2Text);
        final EditText num3Text = (EditText)findViewById(R.id.num3Text);
        final EditText num4Text = (EditText)findViewById(R.id.num4Text);
        final EditText num5Text = (EditText)findViewById(R.id.num5Text);
        try{
            if(requestCode == 2020 || requestCode == 1010){

                num1Text.setText("");
                num2Text.setText("");
                num3Text.setText("");
                num4Text.setText("");
                num5Text.setText("");

                Bundle receivedData = data.getExtras();
                num1Text.setText("min = " + receivedData.getInt("min"));
                num2Text.setText("max = " + receivedData.getInt("max"));
                num3Text.setText("sum = " + receivedData.getInt("sum"));

            }
            else num5Text.setText("ERROR");
        }catch(Exception ee){ee.printStackTrace();}
    }
}
