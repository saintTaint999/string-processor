package ru.sainttaint999;

import ru.sainttaint999.utility.StringProcessor;

public class Main {
    public static void main(String[] args) {
        String string = "3[xy2[3[x]y]z]4[xy]z10[yz]";
        if (StringProcessor.isValid(string)) {
            System.out.println(StringProcessor.process(string));
        } else {
            System.out.println("String validation failed.");
        }
    }
}
