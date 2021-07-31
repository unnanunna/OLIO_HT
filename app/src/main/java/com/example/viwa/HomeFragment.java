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

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    checkDay checking = checkDay.getInstance();
    Log log = new Log();

    public HomeFragment() {
        // Required empty public constructor
    }

    public boolean checkDay(int water, int vitamin){
        //checking the day

        strDay = currentDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        if (checking.getCheck().equals("")) {
            return true;
        } else if (strDay.equals(checking.getCheck())) {
            return true;
        } else {
            checking.setCheck(strDay);
            try {
                log.saveData(currentDay, water, vitamin, getActivity());
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        clicked = checking.getClicked();
        ImageButton button = root.findViewById(R.id.vitamins);

        //making sure the vitamin button stays correct color
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
                //user has taken vitamin

                vita.vitaminAdd();
                checking.setClicked(true);
                button.setBackgroundResource(R.color.dark_turqoise);

                try {
                    log.saveData(currentDay, waterTracker.getWater(), vita.getVitamin(), getActivity());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });



        Button smallWater = root.findViewById(R.id.smallGlass);
        smallWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //add 100ml water to meter

                waterTracker.waterAdd(100);
                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());

                try {
                    log.saveData(currentDay, waterTracker.getWater(), vita.getVitamin(), getActivity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button mediumWater = root.findViewById(R.id.mediumGlass);
        mediumWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //add 200ml water to meter

                waterTracker.waterAdd(200);
                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());

                try {
                    log.saveData(currentDay, waterTracker.getWater(), vita.getVitamin(), getActivity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button bigWater = root.findViewById(R.id.largeGlass);
        bigWater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //add 500ml water to meter

                waterTracker.waterAdd(500);

                progress = Integer.toString(waterTracker.getWater());
                TextView textView2 = (TextView) root.findViewById(R.id.progressWater);
                textView2.setText(progress);

                ProgressBar simpleProgressBar=(ProgressBar) root.findViewById(R.id.progress);
                simpleProgressBar.setProgress(waterTracker.getWater());

                try {
                    log.saveData(currentDay, waterTracker.getWater(), vita.getVitamin(), getActivity());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        waterNeeded = waterTracker.waterAmount();
        maxWater = Integer.toString(waterNeeded);
        progress = Integer.toString(waterTracker.getWater());

        //progressbar
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