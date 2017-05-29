package ru.suleymanovtat.androidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import ru.suleymanovtat.androidapplication.adapter.TransactionAdapter;
import ru.suleymanovtat.androidapplication.model.Transactions;

public class MainActivity extends AppCompatActivity implements TransactionAdapter.ClickListener {

    private ArrayList<Transactions> listAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView listTransactionView = (RecyclerView) findViewById(R.id.listTransaction);
        listTransactionView.setLayoutManager(new LinearLayoutManager(this));
        listAddresses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listAddresses.add(new Transactions("Name " + i, 1000 * i, new Date()));
        }
        TransactionAdapter transactionAdapter = new TransactionAdapter(this, listAddresses);
        listTransactionView.setAdapter(transactionAdapter);
        transactionAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position, View v) {
        Toast.makeText(MainActivity.this, listAddresses.get(position).toString(), Toast.LENGTH_LONG).show();
    }
}
