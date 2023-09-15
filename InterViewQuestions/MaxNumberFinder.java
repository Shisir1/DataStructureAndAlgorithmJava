package org.example.InterViewQuestions;

import java.util.List;

public class MaxNumberFinder {

    public static String findMax(List<Integer> numbers){

        if(numbers.isEmpty()){
            return "none";
        }

        int max = Integer.MIN_VALUE;
        for(int number : numbers){
            if(number > max){
                max = number;
            }
        }
        return Integer.toString(max);
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,5,3,9,2);
        List<Integer> list2 = List.of();

        String result1 = findMax(list1);
        String result2 = findMax(list2);

        System.out.println("Max in list1: " + result1);
        System.out.println("max in list2: " + result2);
    }
}
