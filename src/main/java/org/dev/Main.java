package org.dev;

import org.dev.wc.WC;

public class Main {
    public static void main(String[] args) {
        WC commandLineWC = new WC(args);
        long result = commandLineWC.callType();
        System.out.println("Result: "+result);
    }
}