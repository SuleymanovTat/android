package ru.suleymanovtat.androidapplication.framgent;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ru.suleymanovtat.androidapplication.R;
import ru.suleymanovtat.androidapplication.adapter.CategoriesAdapter;
import ru.suleymanovtat.androidapplication.model.Categories;

public class CategoriesFragment extends BaseFragment implements CategoriesAdapter.ClickListener {

    public static final String TAB_CATEGORIES_FRAG = "CategoriesFragment";
    private ArrayList<Categories> listCategories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        toolbar(view, R.string.categories, R.drawable.ic_menu);

        RecyclerView listCategoriesView = (RecyclerView) view.findViewById(R.id.listCategories);
        listCategoriesView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //формируем список Categories
        listCategories = new ArrayList<>();
        listCategories.add(new Categories("categories0", "Еда"));
        listCategories.add(new Categories("categories1", "Одежда"));
        listCategories.add(new Categories("categories2", "Учеба"));
        listCategories.add(new Categories("categories3", "Работа"));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getActivity(), listCategories);
        listCategoriesView.setAdapter(categoriesAdapter);
        categoriesAdapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(int position, View view) {
        Toast.makeText(getActivity(), "" + listCategories.get(position).toString(), Toast.LENGTH_LONG).show();
    }
}
