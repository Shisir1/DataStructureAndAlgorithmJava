package org.example.SinglyLinkedList;

public class PalindromeString {

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length()-1;

        while(start < end){
            if(charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "that";
        PalindromeString ps = new PalindromeString();
        if(ps.isPalindrome(word)){
            System.out.println("word " + '"' +word + '"' +" is Palindrome");
        } else {
            System.out.println("word " + '"' +word + '"' +" is not Palindrome");
        }
    }

}
