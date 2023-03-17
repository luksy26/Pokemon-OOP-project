package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        File directory = new File("input");
        File[] files = directory.listFiles();
        PrintStream out;
        if(args[0].equals("null"))
            out = new PrintStream(System.out);
        else
            out = new PrintStream(args[0]);

        int i = 0;
        if(files != null)
        for (File file : files)
        {
            ArrayList<Trainer> trainers = Administration.extractData(file);
            out.println("------------------ROUND " + (i+1) + " OF DUELS------------------\n");
            out.println(trainers.get(0).getName() + ", age " + trainers.get(0).getAge() + " vs "
                    + trainers.get(1).getName() + ", age " + trainers.get(1).getAge() + "\n");
            Administration.duels(trainers, out);
            ++i;
        }
    }
}

