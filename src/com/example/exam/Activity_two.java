package com.example.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;

/**
 * Created by brian on 22/10/2015.
 */
public class Activity_two extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        int sum = 0, min = 0, max = 0;

        Intent intent = getIntent();
        Bundle receivedData = intent.getExtras();
        String[] data = receivedData.getStringArray("data");
        int[] array = new int[data.length];

        for(int i = 0; i < data.length; i++ ){
            
            array[i] = Integer.parseInt(data[i]);
            sum = sum + array[i];
        }
        Arrays.sort(array);
        min = array[0];
        max = array[4];
        Bundle answer = new Bundle();
        answer.putInt("sum", sum);
        answer.putInt("min",min);
        answer.putInt("max",max);
        intent.putExtras(answer);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}