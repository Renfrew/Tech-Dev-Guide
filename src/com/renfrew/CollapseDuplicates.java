package com.renfrew;

public class CollapseDuplicates {
    public static void main(final String[] args) {
        System.out.println(collapseDuplicates("a"));
        System.out.println(collapseDuplicates("aa"));
        System.out.println(collapseDuplicates("abc"));
    }

    public static String collapseDuplicates(String a) {
        int i = 0;
        String result = "";
        while (i < a.length()) {
          char ch = a.charAt(i);
          result += ch;
          i++;

          while (i < a.length() && a.charAt(i) == ch) {
            i++;
          }
        }
        
        return result; 
    }
    
}