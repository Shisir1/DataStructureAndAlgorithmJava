package org.example.Queue;

import java.util.*;
import java.util.Queue;

public class GenerateBinary {

    public String[] generateBinaryNumbers(int n){
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i= 0; i < n; i++){
           result[i] = q.poll();
           String n1 = result[i] + "0";
           String n2 = result[i] + "1";
           q.offer(n1);
           q.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateBinary gb = new GenerateBinary();
        //gb.generateBinaryNumbers(6);
//        for(String string : gb.generateBinaryNumbers(6)){
//            System.out.print(string + ",");
//        }
        System.out.println(Arrays.toString(gb.generateBinaryNumbers(6)));
    }
}
