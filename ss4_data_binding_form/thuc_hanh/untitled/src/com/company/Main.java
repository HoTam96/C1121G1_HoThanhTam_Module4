package com.company;

public class Main {
    long c;
    long solution(long a, long b) {
        for (long i=a; i <= b; i++){
            String s = i+"";
            if(s.charAt(0) == s.charAt(s.length()-1))
                c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Main main =new Main();
        long a = main.solution(1, 100000000);
        System.out.println(a);
    }
}
