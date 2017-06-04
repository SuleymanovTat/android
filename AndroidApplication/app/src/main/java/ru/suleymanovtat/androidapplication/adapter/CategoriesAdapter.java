package ru.suleymanovtat.androidapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.suleymanovtat.androidapplication.R;
import ru.suleymanovtat.androidapplication.model.Categories;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private ArrayList<Categories> listTransitions;
    private CategoriesAdapter.ClickListener clickListener;

    public CategoriesAdapter(Context context, ArrayList<Categories> listTransitions) {
        this.listTransitions = listTransitions;
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_categories, viewGroup, false);
        return new CategoriesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CategoriesAdapter.ViewHolder viewHolder, int position) {
        Categories categories = listTransitions.get(position);
        viewHolder.texNameCategories.setText(categories.getName());
    }

    @Override
    public int getItemCount() {
        if (listTransitions == null) {
            return 0;
        }
        return listTransitions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView texNameCategories;

        ViewHolder(View itemView) {
            super(itemView);
            texNameCategories = (TextView) itemView.findViewById(R.id.texNameCategories);
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

    public void setOnItemClickListener(CategoriesAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
