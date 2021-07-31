package com.example.viwa;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.FileInfo;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static android.content.Context.MODE_PRIVATE;

public class Log {
    private String waterAmount = "";
    private String vitaminAmount = "";
    private static final String FILE_NAME = "Log.txt";


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveData(LocalDate date, int iwater, int vitamins, Context ctx) throws IOException {
        //save data to internal file

        waterAmount = String.valueOf(iwater);

        if (vitamins == 0) {
            vitaminAmount = "not taken";
        } else if (vitamins > 0) {
            vitaminAmount = "taken";
        }

        String formatedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        //https://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/create-xml-file-in-java-using-dom-parser-example/

        FileOutputStream fos = null;
        String line = formatedDay + ';' + waterAmount + ';' + vitaminAmount + '\n';

        try {
            fos = ctx.openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(line.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readData(TextView history, Context ctx) {
        //show saved data in history page
        FileInputStream fis = null;

        try {
            fis = ctx.openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                String[] parts = text.split(";", 3);
                int length = text.length();
                if (length > 0) {
                    String input = parts[0] + " you had " + parts[1] + " ml water and had " + parts[2] + " your vitamins.";
                    sb.append(input).append("\n");
                }
            }
            history.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

