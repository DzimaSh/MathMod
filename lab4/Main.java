package lab4;

import java.util.Random;

public class Main {
    private static final int NUM_ITERATIONS = 10000;

    public static void print(String prompt, double actualAnswer, double approximateAnswer) {
        System.out.println(prompt + " = " + actualAnswer + ", approximate = " + approximateAnswer);
    }

    public static void integral1() {
        double actualAnswer = -0.485736;
        double pi = Math.PI;
        Random gen = new Random();
        double sum = 0;
        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            double x = gen.nextDouble() * 5 * pi / 7.0;
            sum += 5 * pi / 7.0 * Math.cos(x + Math.sin(x));
        }
        double approximateAnswer = sum / NUM_ITERATIONS;
        print("cox(x + sin(x))dx from 0 to 5pi/7", actualAnswer, approximateAnswer);
    }

    public static void integral2() {
        double pi = Math.PI;
        double actualAnswer = 3.21825;
        Random gen = new Random();
        double sum = 0;
        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            double phi = gen.nextDouble() * 2 * pi;
            double r = 1 + gen.nextDouble() * (Math.sqrt(3.0) - 1);
            double x = r * Math.cos(phi);
            double y = r * Math.sin(phi);
            sum += 2 * (Math.sqrt(3) - 1) * pi * r / (x * x + Math.pow(y, 4));
        }
        double approximateAnswer = sum / NUM_ITERATIONS;
        print("dxdy / (x^2 + y^4) where 1 <= x^2 + y^2 <= 3", actualAnswer, approximateAnswer);
    }

    public static void main(String[] args) {
        integral1();
        integral2();
    }
}

