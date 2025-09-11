package marathon.sixtyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class WhatCodeIsThat {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : target.toCharArray()) {
            dq.add(c);
        }

        if (dq.size() > 2 && dq.pollFirst() == '\"' && dq.pollLast() == '\"') {
            for (Character c : dq) {
                System.out.print(dq.pollFirst());
            }
        } else {
            System.out.print("CE");
        }
    }

}
