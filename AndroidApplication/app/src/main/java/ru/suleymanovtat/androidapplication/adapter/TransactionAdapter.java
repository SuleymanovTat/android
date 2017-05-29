package ru.suleymanovtat.androidapplication.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import ru.suleymanovtat.androidapplication.R;
import ru.suleymanovtat.androidapplication.model.Transactions;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Transactions> listTransitions;
    private ClickListener clickListener;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.getDefault());

    public TransactionAdapter(Context context, ArrayList<Transactions> listTransitions) {
        this.context = context;
        this.listTransitions = listTransitions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_transaction, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        Transactions transactions = listTransitions.get(position);
        viewHolder.textName.setText(transactions.getName());
        viewHolder.textDate.setText(dateFormat.format(transactions.getDate()));
        viewHolder.textSum.setText(String.valueOf(transactions.getSum()));
        if (position % 2 == 0) {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        } else {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        }
    }

    @Override
    public int getItemCount() {
        if (listTransitions == null) {
            return 0;
        }
        return listTransitions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textName;
        private TextView textDate;
        private TextView textSum;

        ViewHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textSum = (TextView) itemView.findViewById(R.id.textSum);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(getAdapterPosition(), v);
            }
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View view);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
