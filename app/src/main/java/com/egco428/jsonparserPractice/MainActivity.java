package com.egco428.jsonparserPractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String Url = "http://www.w3schools.com/js/myTutorials.txt";
    TextView nameTextView, urlTextView;
    private JsonParser obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        urlTextView = (TextView) findViewById(R.id.urlTextView);

        obj = new JsonParser(Url);
        obj.fetchJSON();
        while (obj.parsingComplete) ;

        String name = "";
        String url = "";
        for (int i = 0; i < obj.getName().size(); i++) {
            name = name + "\n" + obj.getName().get(i).toString();
            url = url + "\n" + obj.getUrl().get(i).toString();
        }

        nameTextView.setText(name);
        urlTextView.setText(url);
    }
}
