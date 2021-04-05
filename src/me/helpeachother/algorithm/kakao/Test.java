package me.helpeachother.algorithm.kakao;

import java.util.List;

public class Test {

    public static void main(String[] args) {
//        String ip = "2001:0db8:0000:0000:0000:ff00:0042:8329";
//
//        System.out.println(ip.matches("([0-9a-f]+)\\:\\s([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)"));

        String a = "(A,B) (E,F) (B,C)";
        a=a.replace(" ","").replace(",","");

        System.out.println(a);

        String[] b = a.split("\\(|\\)");

        for(int i=0; i<b.length; i++) {
            if(!b[i].equals("")) {
                char[] info = b[i].toCharArray();
                System.out.println(info[0]);
                System.out.println(info[1]);


            }
        }




    }

    class Node {
        String val;
        Node child;
        Node(String x) { this.val = x;}
    }

}
