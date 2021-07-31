package com.example.viwa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GraphFragment extends Fragment {

    Log log = new Log();


    public GraphFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_graph, container, false);

        TextView history =  (TextView) root.findViewById(R.id.Intake);
        log.readData(history, getActivity());


        return root;
    }
}