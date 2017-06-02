package ru.suleymanovtat.androidapplication.framgent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import ru.suleymanovtat.androidapplication.R;
import ru.suleymanovtat.androidapplication.adapter.TransactionAdapter;
import ru.suleymanovtat.androidapplication.model.Transactions;

public class TransactionFragment extends Fragment implements TransactionAdapter.ClickListener, DetailsFragment.SentdData {

    private ArrayList<Transactions> listAddresses;
    public static final String TAB_TRANSACTION_FRAG = "TransactionFragment";
    private TextView textName;
    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        textName = (TextView) view.findViewById(R.id.textName);
        RecyclerView listTransactionView = (RecyclerView) view.findViewById(R.id.listTransaction);
        listTransactionView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAddresses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listAddresses.add(new Transactions("Name " + i, 1000 * i, new Date()));
        }
        TransactionAdapter transactionAdapter = new TransactionAdapter(getActivity(), listAddresses);
        listTransactionView.setAdapter(transactionAdapter);
        transactionAdapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(int position, View v) {
        Toast.makeText(getActivity(), listAddresses.get(position).toString(), Toast.LENGTH_LONG).show();
        DetailsFragment fragment = new DetailsFragment();
        fragment.setName(this);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, DetailsFragment.TAB_TRANSACTION_FRAG).addToBackStack("").commit();
    }

    @Override
    public void sentdData(String text) {
        this.text = text;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (text != null) {
            textName.setText(text);
        }
    }
}
