package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new  BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(bufferedReader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
            for (String l:result)
             System.out.println(l);
        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {

            if(i==0&&list.get(i)!=list.get(i+1))list.add(i+1,list.get(i));
            if(i==list.size()-1&&list.get(i)!=list.get(i-1))list.add(list.get(i));
             if((i!=0&&i<list.size()-1)&&list.get(i)!=list.get(i-1)&&list.get(i)!=list.get(i+1))
               list.add(i+1,list.get(i));
        }

        return list;
    }
}
