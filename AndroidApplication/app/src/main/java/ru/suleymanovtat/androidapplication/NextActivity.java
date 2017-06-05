package ru.suleymanovtat.androidapplication;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        findViewById(R.id.btnMainActivty).setOnClickListener(v ->
                NavUtils.navigateUpFromSameTask(this));
    }
}
