package com.example.tanmay.editorinnervoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        text=(TextView)findViewById(R.id.test);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        text.setText(Html.fromHtml(getIntent().getStringExtra("data"))) ;


    }
}
