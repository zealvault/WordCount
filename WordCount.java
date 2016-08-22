package com.ee.frequency;

/**
 * Created by Vishal on 21-08-2016.
 * AIM:The following java code takes a .txt file and displays word frequency.
 */

import java.util.*;
import java.io.*;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the name of your file .... ");
        String fileName = reader.nextLine();
        Scanner inputstream = new Scanner(new File(fileName));

        // count occurrences
        Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
        while (inputstream.hasNext()) {
            String word = (inputstream.next().toLowerCase()).replace('.',' ').replace(',','\u0000').trim();
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }

        // get cutoff
        System.out.print("Enter Frequency Cut off :");
        int cutoff = reader.nextInt();
        System.out.println("WORD \t COUNT");
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            if (count >= cutoff)
                System.out.println(word + "\t\t" + count);
        }
    }
}
