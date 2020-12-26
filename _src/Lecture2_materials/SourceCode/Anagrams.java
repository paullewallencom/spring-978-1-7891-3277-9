package com.loonycorn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananiravi on 11/18/15.
 */
public class Anagrams {

    public static void main(String[] args) {
        printAnagrams(findAnagrams("ROA"));
    }

    public static void printAnagrams(List<String> anagramList) {
        for (String anagram : anagramList) {
            System.out.println(anagram);
        }
    }

    public static List<String> findAnagrams(String word) {
        if (word.length() == 1) {
            List<String> potentialAnagrams = new ArrayList<>();
            potentialAnagrams.add(word);

            return potentialAnagrams;
        }

        List<String> anagramList = new ArrayList<>();
        char currentChar = word.charAt(0);
        String subset = word.substring(1, word.length());

        List<String> potentialAnagramList = findAnagrams(subset);
        insertCharacterAtEveryIndex(potentialAnagramList, currentChar, anagramList);

        return anagramList;
    }

    private static void insertCharacterAtEveryIndex(List<String> potentialAnagramList,
                                                    char currentChar,
                                                    List<String> anagramList) {
        for (String potentialAnagram : potentialAnagramList) {
            // Inserts the current character at every position.
            for (int insertIndex = 0; insertIndex <= potentialAnagram.length(); insertIndex++) {
                StringBuilder sb = new StringBuilder(potentialAnagram);
                if (insertIndex < potentialAnagram.length()) {
                    sb.insert(insertIndex, currentChar);
                } else {
                    sb.append(currentChar);
                }

                anagramList.add(sb.toString());
            }
        }
    }


}
