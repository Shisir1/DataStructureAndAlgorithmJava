package org.example.dynamicProgramming;

public class FibonacciNumberBottomUpApproach {
    public int fib(int n){
        int[] table = new int[n + 1]; //0 -> n
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++){
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }
    public static void main(String[] args) {
        FibonacciNumberBottomUpApproach fn = new FibonacciNumberBottomUpApproach();
        System.out.println("The 6th fibonacci number is : " + fn.fib(6));

    }
}
