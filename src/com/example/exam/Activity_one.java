package com.example.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;

/**
 * Created by brian on 22/10/2015.
 */
public class Activity_one extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        int min = 0, max = 0, sum = 0;
        int[] array = new int[5];
        Intent intent = getIntent();
        Bundle receivedData = intent.getExtras();
        array[0] = receivedData.getInt("num1");
        array[1] = receivedData.getInt("num2");
        array[2] = receivedData.getInt("num3");
        array[3] = receivedData.getInt("num4");
        array[4] = receivedData.getInt("num5");

        for(int i = 0; i < array.length; i ++){
            sum = sum + array[i];
        }
        Arrays.sort(array);
        min = array[0];
        max = array[4];
        final EditText num1Text = (EditText)findViewById(R.id.num1Text);
        final EditText num2Text = (EditText)findViewById(R.id.num2Text);
        final EditText num3Text = (EditText)findViewById(R.id.num3Text);
       // num1Text.setText("min = " + min);
        //num2Text.setText("max = " + max);
        //num3Text.setText("sum = " + sum);
        //possibly send this back in a bundle to main activity and update it there.
        Bundle answer = new Bundle();
        answer.putInt("sum", sum);
        answer.putInt("min",min);
        answer.putInt("max",max);

        intent.putExtras(answer);
        setResult(Activity.RESULT_OK,intent);
        finish();

    }
}