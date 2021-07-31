package com.example.viwa;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment {

    EditText userName;
    EditText userWeight;
    EditText userExercise;
    private String name = "";
    private String weight = "";
    private String hours = "";

    EntryManager manager = new EntryManager();

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //taking user input and saving the entry
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_user, container, false);

        userName = (EditText) root.findViewById(R.id.inputName);

        userWeight = (EditText) root.findViewById(R.id.inputWeight);

        userExercise = (EditText) root.findViewById(R.id.inputExercise);

        Button done = root.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                name = userName.getText().toString();
                weight = userWeight.getText().toString();
                hours = userExercise.getText().toString();
                manager.saveEntry(name, weight, hours);
                hideKeyboardFrom(getActivity(), root);
            }
        });

        return root;
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
