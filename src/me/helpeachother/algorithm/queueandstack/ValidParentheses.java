package me.helpeachother.algorithm.queueandstack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

//        String input = "{[]}";
//        String input = "([)]";
        String input = "()(){[]()}{}[]]";


        ValidParentheses a = new ValidParentheses();
        System.out.println(a.isValid_practice(input));


    }

    public boolean isValid(String s) {

        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                default:
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(!stack.empty() && stack.peek()=='(') stack.pop();
                case '}':
                    if(!stack.empty() && stack.peek()=='{') stack.pop();
                case ']':
                    if(!stack.empty() && stack.peek()=='[') stack.pop();
            }
        }


        return false;
    }

    public boolean isValid_practice(String s) {
        if(s==null || s.equals(null)) return false;

        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    System.out.println("open: " + ch);
                    stack.push(ch);
                    break;
                case ']':
                    System.out.println("close: " + ch);
                    if(stack.pop()!='[') return false;
                    break;
                case '}':
                    System.out.println("close: " + ch);
                    if(stack.pop()!='{') return false;
                    break;
                case ')':
                    System.out.println("close: " + ch);
                    if(stack.pop()!='(') return false;
                    break;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
