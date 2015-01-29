package com.powwau.drwatson;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    TextView mTextView;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quote, container, false);
        mTextView = (TextView)rootView.findViewById(R.id.text_view_quote);
        displayRandomQuote();
        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_quote, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Boolean handled = false;

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_refresh_quote:
                displayRandomQuote();
                handled = true;
        }
        if (!handled) {
            handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    private void displayRandomQuote() {
        String[] quotes = getResources().getStringArray(R.array.quotes);
        Random random = new Random();
        mTextView.setText(quotes[random.nextInt(quotes.length)]);
    }

}
