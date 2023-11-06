package com.codegym;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    static TreeMap<Integer, String> map = new TreeMap<>();
    static ArrayList listCountWord = new ArrayList<>();
    public static void main(String[] args) {

        String str = "My; parents gave me my name, my father to be exact. Zhi means knowledge, " +
                "and Lei means accumulation. So I guess my parents wanted to tell me that being " +
                "knowledgeable depends on accumulation. You see, they put a lot of pressure on my " +
                "shoulders with this name. I quite like my name, and I won't change it for the world," +
                " because it is unique. I don't think that anyone else in China has the same name. " +
                "It's part of my identity, and it is meaningful to me. People in my country pay great" +
                " attention to their names because they believe that suitable names will bring them good " +
                "fortune. Sometimes they even change their names for their business and family purpose. " +
                "In China, I believe that fathers are in the position of naming their children. Sometimes " +
                "they will look through some Chinese classical literatures to seek the meaningful words for" +
                " their children. Oh, there are some nick names that are very popular in China. For example, " +
                "Lili means that their parents hope their daughters would be beautiful; and Kuan kuan, indicates" +
                " that their sons would be magnanimous when they are grown up.";

        str = str.toLowerCase();

        treeMap(str);
        getListCountWord(str);

        System.out.println("The word in the String is: " + map.size());
        for (int i = 0; i < listCountWord.size(); i++){
            System.out.println("Word " + (i + 1) + ": " + map.get(i) + " => count = " + listCountWord.get(i));
        }
    }
    public static boolean isDuplicate(String word){
        for (int i = 0; i < map.size(); i++){
            if(map.get(i).equals(word)){
                return true;
            }
        }
        return false;
    }

    public static int count(String word, String str){
        String wordTemp = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if((int)c != 32 && (int)c != 44 && (int)c != 46 && (int)c != 59){
                wordTemp += c;
            } else if(wordTemp.equals(word)){
                count++;
            } else {
                wordTemp = "";
            }
        }
        return count;
    }

    public static TreeMap<Integer, String> treeMap (String str){
        Integer key = 0;
        String wordTemp = "";
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if((int)c != 32 && (int)c != 44 && (int)c != 46 && (int)c != 59){
                wordTemp += c;
            } else if(!isDuplicate(wordTemp) && wordTemp != ""){
                map.put(key++, wordTemp);
                wordTemp = "";
            } else {
                wordTemp = "";
            }
        }
        return map;
    }

    public static ArrayList getListCountWord(String str){
        for (int i = 0; i < map.size(); i++){
            listCountWord.add(count((String) map.get(i), str));
        }
        return listCountWord;
    }
}