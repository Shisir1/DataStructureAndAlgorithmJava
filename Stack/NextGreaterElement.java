package org.example.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static String nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length -1; i >=0; i--){
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        int[] array = {3,4,6,12,7,2,5,11,9,10};
        System.out.println("Input Array :" + Arrays.toString(array));
        System.out.println("Output Array : " + nextGreaterElement(array));

    }
}
