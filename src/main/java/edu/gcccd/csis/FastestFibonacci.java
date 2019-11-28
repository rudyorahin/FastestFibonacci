package edu.gcccd.csis;

import java.math.BigInteger;

public class FastestFibonacci {
        public static BigInteger fib(BigInteger secondPrevious, BigInteger previous, int nth) {
            if (nth == 0) {
                return BigInteger.ZERO;
            } else if (nth == 1) {
                return previous.add(secondPrevious);
            } else {
                return fib(previous, previous.add(secondPrevious), nth - 1);
            }
        }

        public static void main(String[] args) {
            long t0 = System.currentTimeMillis();
            for (int x = 0; x <= 2000; x++) {
                int fibMethodCall =0;
                fibMethodCall += x;
                System.out.println("The " + x + "-th Fibonacci number is " + fib(BigInteger.ONE, BigInteger.ZERO, x) + " and was calculated in " + (System.currentTimeMillis() - t0) + " ms");
                System.out.println("The fibonacci() method got called " + (fibMethodCall + 1) + " times");
            }
        }
}
