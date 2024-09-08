package org.example;

import java.util.HashMap;
import java.util.Map;



public class WordCounter {
    public static Map<String,Integer> calculateWord (String text) {

        Map<String,Integer> wordCountMap = new HashMap<>();

        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
              wordCountMap.put(word,wordCountMap.get(word)+1);
            } else {
                wordCountMap.put(word,1);
            }
        }
        return wordCountMap;
    }
}
