package com.example.tanmay.editorinnervoice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import windyzboy.github.io.customeeditor.CustomEditText;

public class EditorActivity extends AppCompatActivity{
    private LinearLayout lnl;
    private CustomEditText customEditor;
    private ImageView imgChangeYellowColor;
    private ImageView imgChangeWhiteColor;
    TextView nextTextView;
    Boolean flag=true;
    int counter=0;

    private int selectionStart;
    private int selectionEnd;

    private CustomEditText.EventBack eventBack = new CustomEditText.EventBack() {

        @Override
        public void close() {
            lnl.setVisibility(View.VISIBLE);
        }

        @Override
        public void show() {
            lnl.setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (customEditor.isFocused()) {
                lnl.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        imgChangeYellowColor = (ImageView) findViewById(R.id.btnChangeYellowTextColor);
        imgChangeWhiteColor=(ImageView)findViewById(R.id.btnChangeWhiteTextColor);

        lnl = (LinearLayout) findViewById(R.id.lnlAction);
        lnl.setVisibility(View.VISIBLE);

        nextTextView=(TextView)findViewById(R.id.textView_next);
        nextTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TestActivity.class);
                intent.putExtra("data",customEditor.getTextHTML().toString());
                startActivity(intent);
            }
        });

        customEditor = (CustomEditText) findViewById(R.id.CustomEditor);
        customEditor.setHint(getResources().getString(R.string.hint));
        customEditor.setSingleLine(false);
        customEditor.setMinLines(10);
        customEditor.setColor(Color.WHITE,customEditor.getSelectionStart(), customEditor.getSelectionEnd());
        customEditor.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    lnl.setVisibility(View.VISIBLE);
                }
                else
                {
                    lnl.setVisibility(View.GONE);
                }
            }
        });

        customEditor.setEventBack(eventBack);
        customEditor.setOnClickListener(clickListener);
        
        imgChangeYellowColor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectionStart = customEditor.getSelectionStart();
                selectionEnd = customEditor.getSelectionEnd();
                customEditor.setColor(Color.YELLOW, selectionStart, selectionEnd);
            }
        });

        imgChangeWhiteColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionStart = customEditor.getSelectionStart();
                selectionEnd = customEditor.getSelectionEnd();
                customEditor.setColor(Color.WHITE, selectionStart, selectionEnd);
            }
        });

    }

}
