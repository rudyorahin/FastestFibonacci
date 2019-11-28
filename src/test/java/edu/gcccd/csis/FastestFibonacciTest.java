package edu.gcccd.csis;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.net.URL;

import static org.junit.Assert.*;
public class FastestFibonacciTest {
    private static BigInteger fibIterative(int n) {
        BigInteger secondPrevious , previous = BigInteger.ONE , nth = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            secondPrevious = previous;
            previous = nth;
            nth = secondPrevious.add(previous);
        }
        return nth;
    }

    private static String url(int x) {
        try {
            URL file = new URL("https://oeis.org/A000045/b000045.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(file.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (Integer.parseInt(inputLine.substring(0, inputLine.indexOf(' '))) == x)
                {
                    break;
                }
            }
            in.close();
            return inputLine;
        } catch (IOException e) {
            System.out.println("Message: " + e);
        }
        return "0 0";
    }

    private static String format(int x) {
            return x + " " + FastestFibonacci.fib(BigInteger.ONE, BigInteger.ZERO, x);
    }

    @Test
    public void main() {
//        System.out.println(fibIterative(2000));
//        System.out.println(FastestFibonacci.fib(2000));
//        assertEquals(fibIterative(2000), FastestFibonacci.fib(BigInteger.ONE, BigInteger.ZERO, 2000));

        for (int testVal = 0; testVal <= 2000; testVal++) {
            assertEquals(format(testVal), url(testVal));
            assertEquals(fibIterative(testVal), FastestFibonacci.fib(BigInteger.ONE, BigInteger.ZERO, testVal));
//            System.out.println(testVal + " " + fibIterative( testVal));
//            System.out.println(testVal + " " + FastestFibonacci.fib(BigInteger.ONE, BigInteger.ZERO, testVal));
        }
    }
}