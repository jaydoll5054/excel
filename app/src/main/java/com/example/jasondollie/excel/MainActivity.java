package com.example.jasondollie.excel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    readExcelData();
}

private List<personalData> personalDatas = new ArrayList<>();

    public MainActivity(List<com.example.jasondollie.excel.personalData> personalData) {
       // this.personalData = personalData;
    }

    private void readExcelData() {
    InputStream is = getResources().openRawResource(R.raw.data);
    BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))

    );

    String line = "";
    try {

        reader.readLine();

        while ((line = reader.readLine()) != null) {
                //split by ','

            Log.d("MyActivity", "Line: " + line);


            String[] tokens = line.split(",");

            // read the data

            personalData sample = new personalData();
                    sample.setAddress(tokens[0]);
                    sample.setFirstName(tokens[0]);
                    sample.setLastName(tokens[0]);
                    personalDatas.add(sample);

            Log.d("MyActivity", "Just created: " + sample);
        }
    } catch (IOException e) {
        Log.wtf("MyActivity", "Error reading data file on Line" + line, e);
        e.printStackTrace();
    }

    }
}