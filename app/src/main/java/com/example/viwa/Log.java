package com.example.viwa;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Log {
    private String waterAmount = "";
    private String vitaminAmount = "";
    private String formatedDay = "";
    private String input = "";
    private String filename = "com/example/viwa/FileInfo.txt";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveData(LocalDate date, int iwater, int vitamins) {
        waterAmount = String.valueOf(iwater);

        if (vitamins == 0) {
            vitaminAmount = "not taken";
        } else if (vitamins > 0) {
            vitaminAmount = "taken";
        }

        formatedDay = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        formatedDay = date.toString();

        //https://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/create-xml-file-in-java-using-dom-parser-example/


        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(formatedDay + ';' + waterAmount + ';' + vitaminAmount + '\n');

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void readData(TextView history) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            System.out.println();
            String output = "";
            int length;

            //String[] parts = new String[3];
            if ((output = br.readLine()) != null) {
                String[] parts = output.split(";", 3);
                length = output.length();
                if (length > 0) {
                    input = parts[0] + " you had " + parts[1] + " ml water and had " + parts[2] + " your vitamins.";
                    history.setText(input);
                }
            } else {

            }
            br.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }

}

