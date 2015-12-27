package com.example.nick.numbers;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView Show;
    EditText Edit;
    Button Btn;

    int Value;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Show = (TextView)findViewById(R.id.textView);
        Edit = (EditText)findViewById(R.id.editText);
        Btn = (Button)findViewById(R.id.button);

        Value = (int)(Math.random()*100);
        gameFinished = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onClick(View v){
        if (!gameFinished){
            int number=Integer.parseInt(Edit.getText().toString());

            if (number > Value)
                Show.setText(getResources().getString(R.string.ahead));
            if (number< Value)
                Show.setText(getResources().getString(R.string.behind));
            if (number == Value)
            {
                Show.setText(getResources().getString(R.string.hit));
                Btn.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
            if (number>100)
                Show.setText(getResources().getString(R.string.error_big));
            if (number<0)
                Show.setText(getResources().getString(R.string.error_minus));

        }
        else
        {
            Value = (int) (Math.random() * 100);
            Btn.setText(getResources().getString(R.string.input_value));
            Show.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        Edit.setText("");
    }
}