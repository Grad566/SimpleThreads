package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NumberPrinterTest {
    @Test
    public void testNumberPrinting() throws InterruptedException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.start();

        Thread.sleep(2000);

        System.setOut(originalOut);

        String output = outputStream.toString().trim();

        StringBuilder expectedOutput = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            expectedOutput.append(i).append("\n");
        }
        String expected = expectedOutput.toString().trim();

        assertEquals(expected, output);
    }

    @Test
    public void testNumberPrintingWithWrongAnswer() throws InterruptedException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.start();

        Thread.sleep(2000);

        System.setOut(originalOut);

        String output = outputStream.toString().trim();

        StringBuilder expectedOutput = new StringBuilder();
        for (int i = 0; i < 99; i++) {
            expectedOutput.append(i).append("\n");
        }
        String expected = expectedOutput.toString().trim();

        assertNotEquals(expected, output);
    }
}