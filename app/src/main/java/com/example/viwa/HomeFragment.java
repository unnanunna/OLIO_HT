package com.example.viwa;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.time.LocalDate;

@RequiresApi(api = Build.VERSION_CODES.O)
public class HomeFragment extends Fragment {

    boolean check;
    boolean clicked = false;
    int waterNeeded;
    int totalWater = 0;
    private String maxWater = "";
    private String progress = "";
    private LocalDate currentDay = LocalDate.now();
    private String strDay = "";

    WaterTracker waterTracker = WaterTracker.getInstance();
    VitaminRecommend vita = VitaminRecommend.getInstance();
    checkDay checkDay = checkDay.getInstance();
    Log log = new Log();

    public HomeFragment() {
        // Required empty public constructor
    }

    public boolean checkDay(int water, int vitamin){
        strDay = currentDay.toString();

        if (checkDay.getCheck().equals("")) {
            return true;
        } else if (strDay.equals(checkDay.getCheck())) {
            return true;
        } else {
            checkDay.setCheck(strDay);
            log.saveData(currentDay, water, vitamin);
            return false;
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        check = checkDay(waterTracker.getWater(), vita.getVitamin());
        clicked = checkDay.getClicked();
        ImageButton button = root.findViewById(R.id.vitamins);

        if (check && clicked) {
            button.setBackgroundResource(R.color.dark_turqoise);
        } else if (!check) {
            button.setBackgroundResource(R.color.light_blue);

            ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
            simpleProgressBar.setProgress(0);

            TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
            textView2.setText(0);

        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                vita.vitaminAdd();
                checkDay.setClicked(true);
                button.setBackgroundResource(R.color.dark_turqoise);
            }

        });



        Button smallWater = root.findViewById(R.id.smallGlass);
        smallWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                waterTracker.waterAdd(100);
                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());
            }
        });

        Button mediumWater = root.findViewById(R.id.mediumGlass);
        mediumWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                waterTracker.waterAdd(200);
                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());
            }
        });

        Button bigWater = root.findViewById(R.id.largeGlass);
        bigWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                waterTracker.waterAdd(500);

                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());

            }
        });

        waterNeeded = waterTracker.waterAmount();
        maxWater = Integer.toString(waterNeeded);
        progress = Integer.toString(waterTracker.getWater());


        ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
        simpleProgressBar.setMax(waterNeeded);
        simpleProgressBar.setProgress(waterTracker.getWater());
        TextView textView = (TextView) root.findViewById(R.id.maxWater);
        textView.setText(maxWater);


        TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
        textView2.setText(progress);


        return root;
    }




}