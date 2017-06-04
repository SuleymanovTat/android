package ru.suleymanovtat.androidapplication.framgent;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.suleymanovtat.androidapplication.R;

public class DetailsFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAB_TRANSACTION_FRAG = "DetailsFragment";
    private EditText editName;
    private SentdData sentdDataListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_details);
        toolbar.setTitle(R.string.details);
        toolbar.setNavigationIcon(R.drawable.ic_black);
        toolbar.setNavigationOnClickListener(v -> {
            hideKeyboard();
            getActivity().onBackPressed();
        });
        editName = (EditText) view.findViewById(R.id.editName);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        hideKeyboard();
        String message = editName.getText().toString().trim();
        if (message.isEmpty()) {
            Toast.makeText(getActivity(), R.string.empty_name, Toast.LENGTH_SHORT).show();
        } else {
            sentdDataListener.sentdData(message);
            getFragmentManager().popBackStack();
        }
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    interface SentdData {
        void sentdData(String text);
    }

    public void setName(SentdData sentdDataListener) {
        this.sentdDataListener = sentdDataListener;
    }
}