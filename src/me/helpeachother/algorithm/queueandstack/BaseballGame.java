package me.helpeachother.algorithm.queueandstack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {

        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(callPoints(strs));

    }

    public static int callPoints(String[] ops) {
        if(ops==null || ops.length==0 || ops[0]=="C" || ops[0]=="D" || ops[0]=="+") return 0;

        Stack<String> stack = new Stack<>();
        int sum = 0;

        for(String op : ops) {
            if(op.equals("C")) {
                int val1 = Integer.valueOf(stack.pop());
                sum = sum - val1;
            } else if(op.equals("D")) {
                int val = Integer.valueOf(stack.peek());
                stack.push(String.valueOf(2*val));
                sum = sum + 2*val;
            } else if(op.equals("+")) {
                int val1 = Integer.valueOf(stack.pop());
                int val2 = Integer.valueOf(stack.pop());
                int val3 = val1+val2;
                sum = sum + val3;

                stack.push(String.valueOf(val2));
                stack.push(String.valueOf(val1));
                stack.push(String.valueOf(val3));

            } else {
                stack.push(op);
                sum = sum+Integer.valueOf(op);
            }
        }

        return sum;

    }


}
