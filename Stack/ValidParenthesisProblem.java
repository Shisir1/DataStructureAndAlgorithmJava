package org.example.Stack;

import java.util.Stack;

public class ValidParenthesisProblem {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    char top = stack.peek();
                    if(top == '(' && c == ')' ||
                       top == '{' && c == '}' ||
                       top == '[' && c == ']'){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = new String("[{()}]]");
        if(isValid(s)){
            System.out.println("Valid String, Opening and closing brackets matched!");
        } else {
            System.out.println("Invalid String, Opening and closing brackets DOESN'T match!!!");
        }

    }
}
