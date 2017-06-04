package ru.suleymanovtat.androidapplication.framgent;

import android.os.Bundle;
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

public class TransactionFragment extends BaseFragment implements TransactionAdapter.ClickListener, DetailsFragment.SentdData {

    private ArrayList<Transactions> listTransactions;
    public static final String TAB_TRANSACTION_FRAG = "TransactionFragment";
    private TextView textName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        toolbar(view, R.string.waste, R.drawable.ic_menu);
        textName = (TextView) view.findViewById(R.id.textName);
        RecyclerView listTransactionView = (RecyclerView) view.findViewById(R.id.listTransaction);
        listTransactionView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //формируем список Transaction
        listTransactions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listTransactions.add(new Transactions("Name " + i, 1000 * i, new Date()));
        }
        TransactionAdapter transactionAdapter = new TransactionAdapter(getActivity(), listTransactions);
        listTransactionView.setAdapter(transactionAdapter);
        transactionAdapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(int position, View v) {
        Toast.makeText(getActivity(), listTransactions.get(position).toString(), Toast.LENGTH_LONG).show();
        DetailsFragment fragment = new DetailsFragment();
        fragment.setName(this);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, DetailsFragment.TAB_TRANSACTION_FRAG).addToBackStack("").commit();
    }

    @Override
    public void sentdData(String text) {
        if (text != null) {
            textName.setText(text);
        }
    }
}
