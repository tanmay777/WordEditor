package com.example.tanmay.editorinnervoice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button yellowButton, whiteButton, nextButton;
    EditText editTextData;
    boolean yellow = false, white = true;
    boolean flag = false;
    int counter=1;
    int x,y;
    SpannableStringBuilder sb;
    final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(158, 158, 158));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yellowButton = (Button) findViewById(R.id.button_yellow);
        whiteButton = (Button) findViewById(R.id.button_white);
        nextButton = (Button) findViewById(R.id.button_next);
        editTextData = (EditText) findViewById(R.id.edit_text_data);
        yellowButton.setOnClickListener(this);
        whiteButton.setOnClickListener(this);

        TextView TV = (TextView) findViewById(R.id.abc);
        Spannable wordtoSpan = new SpannableString("Iknow");
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TV.setText(wordtoSpan);
        editTextData.setText("");

        editTextData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getApplicationContext(), "Before Text changed", Toast.LENGTH_SHORT).show();
                Log.v("Char sequence",s.toString());
                Log.v("Start",start+"");
                Log.v("count",count+"");
                Log.v("after",after+"");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getApplicationContext(), "On Text changed", Toast.LENGTH_SHORT).show();

                sb = new SpannableStringBuilder(s.toString());
                /* Spannable wordtoSpan;
                if (yellow) {
                    wordtoSpan = new SpannableString(editTextData.getText().toString());
                    if (!flag) {
                        Log.v("Yellow start", wordtoSpan.length() + "");
                        Log.v("Yellow end", wordtoSpan.length() + 1 + "");
                        wordtoSpan.setSpan(new ForegroundColorSpan(Color.YELLOW), 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        flag = true;
                        counter=counter+1;
                        Log.v("Check", "if of yellow");

                    } else {
                        if(counter==1) {
                            editTextData.setText(wordtoSpan);
                            flag = false;
                            Log.v("Check", "else of yellow");
                            counter=0;
                        }
                        else {
                            return;
                        }
                    }
                }*/
            }
            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(), "After Text changed", Toast.LENGTH_SHORT).show();
                Log.v("Editable s",s.toString());
                y=s.length();
                if(y==x+counter)
                {
                    counter++;
                    if(yellow)
                    {

                        sb.setSpan(fcs,x,y,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        editTextData.append(sb.subSequence(y-1,y));
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_white:
                white = true;
                yellow = false;
                break;
            case R.id.button_yellow:
                yellow = true;
                String a=editTextData.getText().toString();
                x=a.length();
                white = false;
                break;
            case R.id.button_next:
                break;
        }
    }
}
