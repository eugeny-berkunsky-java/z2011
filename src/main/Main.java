package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    public String var9(String s, int len) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (string.length() != 0 &&
                    (string.length() != len ||
                            !isConsonant(string.charAt(0)))
            ) {
                sb.append(string).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        double start = in.nextDouble();
        double finish = in.nextDouble();
        double step = in.nextDouble();

        int nSteps = nSteps(start, finish, step);
    }

    public int nSteps(double start, double finish, double step) {
        return (int) (Math.round((finish-start)/step)+1);
    }

    boolean isConsonant(char c) {
//        var set = Set.of('a','e','i','o','u','y');
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u','y')
        );
        return ! vowels.contains(c);
    }

    public double[] fillX(double start, double finish, double step) {
        double[] x = new double[nSteps(start,finish,step)];
        for (int i = 0; i < x.length; i++) {
            x[i] = start + i * step;
        }
        return x;
    }

    public double[] fillY(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = f(x[i]);
        }
        return y;
    }

    public double f(double x) {
        return Math.sin(x);
    }

    public int numMax(double[] x) {
        int res = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i]>x[res]) res = i;
        }
        return res;
    }

    public int numMin(double[] x) {
        int res = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i]<x[res]) res = i;
        }
        return res;
    }

    public double sum(double[] x) {
        double s = 0;
        for (double v : x) {
            s += v;
        }
        return s;
    }

    public double average(double[] x) {
        return x.length==0
                ? 0.0
                : Arrays.stream(x).average().getAsDouble();
    }
}




