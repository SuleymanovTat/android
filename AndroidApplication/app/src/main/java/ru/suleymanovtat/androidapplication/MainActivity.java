package ru.suleymanovtat.androidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.suleymanovtat.androidapplication.framgent.TransactionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new TransactionFragment(), TransactionFragment.TAB_TRANSACTION_FRAG).commit();
    }
}
