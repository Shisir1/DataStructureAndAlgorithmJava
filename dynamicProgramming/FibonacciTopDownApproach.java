package org.example.dynamicProgramming;

public class FibonacciTopDownApproach {

    public int fib(int[] memo, int n){
        if(memo[n] == 0){   // value at memo[n] = 0 means it has to be calculated
            if (n < 2){
                memo[n] = n;    // n is 0 or 1
            } else {
                int left = fib(memo, n - 1);
                int right = fib(memo, n - 2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }
    public static void main(String[] args) {
        FibonacciTopDownApproach td = new FibonacciTopDownApproach();
        System.out.println("The 7th fibonacci number is : " + td.fib(new int[7 + 1],7));

    }
}
