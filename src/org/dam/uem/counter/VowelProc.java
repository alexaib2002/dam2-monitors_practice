package org.dam.uem.counter;

import java.util.function.Consumer;

public class VowelProc extends Thread {
    private int count = 0;
    private char vowel;
    private String word;
    private Consumer<Integer> updateRequest;

    public VowelProc(char vowel, String word, Consumer<Integer> updateRequest) {
        this.vowel = vowel;
        this.word = word;
        this.updateRequest = updateRequest;
    }

    @Override
    public void run() {
        for (char c : word.toCharArray()) {
            if (c == vowel)
                count++;
        }
        sendCountToParent();
    }

    private synchronized void sendCountToParent() {
        updateRequest.accept(count);
    }
}
