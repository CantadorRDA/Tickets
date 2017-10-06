package co.tink.gticket.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

import co.tink.gticket.R;
import co.tink.gticket.helpers.Animations;

/**
 * Created by Cantador on 27.01.17.
 */

public class FragmentTicketSearchInputs extends android.support.v4.app.Fragment implements View.OnClickListener {

    //    Spinner persons, level;
    AppCompatButton persons, level;
    LinearLayout dialog_persons, dialog_levels;
    AppCompatButton close_levels, close_persons;

    public FragmentTicketSearchInputs() {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ticket_search_inputs, container, false);
        init_views(rootView);

//        populate_spinner(persons, R.array.persons);
//        populate_spinner(level, R.array.levels);

        persons.setOnClickListener(this);
        level.setOnClickListener(this);
        close_levels.setOnClickListener(this);
        close_persons.setOnClickListener(this);

        return rootView;
    }

    public void init_views(View rootView) {
//        persons = (Spinner) rootView.findViewById(R.id.persons);
//        level = (Spinner) rootView.findViewById(R.id.level);
        persons = (AppCompatButton) rootView.findViewById(R.id.persons);
        level = (AppCompatButton) rootView.findViewById(R.id.level);

        dialog_persons = (LinearLayout) rootView.findViewById(R.id.dialog_persons);
        dialog_levels = (LinearLayout) rootView.findViewById(R.id.dialog_levels);

        close_levels = (AppCompatButton) rootView.findViewById(R.id.close_levels);
        close_persons = (AppCompatButton) rootView.findViewById(R.id.close_persons);
    }

    private void populate_spinner(Spinner spinner, int array) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.persons:
                Animations.visible(dialog_persons, true);
                break;

            case R.id.level:
                Animations.visible(dialog_levels, true);
                break;

            case R.id.close_levels:
                Animations.visible(dialog_levels, false);
                break;

            case R.id.close_persons:
            Animations.visible(dialog_persons, false);
            break;
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
