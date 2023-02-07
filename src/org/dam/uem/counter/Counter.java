package org.dam.uem.counter;

import java.util.Scanner;

public class Counter {

    public static final int VOWEL_NUMBER = 5;
    public static final char VOWELS[] = {'a', 'e', 'i', 'o', 'u'};
    private static int total = 0;

    public static void main(String[] args) {

        System.out.print("Por favor, introduce un texto para contar sus vocales: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        VowelProc[] procs = new VowelProc[5];
        for (int i = 0; i < VOWEL_NUMBER; i++) {
            procs[i] = new VowelProc(VOWELS[i], input, Counter::incrementCount);
            procs[i].start();
        }
        for (int i = 0; i < VOWEL_NUMBER; i++) {
            while (procs[i].isAlive()) ;
        }
        System.out.printf("Total de vocales: %s", total);
    }

    private static void incrementCount(int c) {
        total += c;
    }
}
