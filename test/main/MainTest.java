package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    double eps = 1e-9;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void nSteps() {
        assertEquals(11, main.nSteps(0, 1, 0.1));
        assertEquals(26, main.nSteps(5, 10, 0.2));
    }

    @Test
    void fillX() {
        double[] x = main.fillX(0.1, 0.9, 0.2);
        double[] expected = {0.1, 0.3, 0.5, 0.7, 0.9};

        assertArrayEquals(expected, x, eps);
        x = main.fillX(0, 1000, 0.001);
        assertEquals(1_000_001, x.length);
        assertArrayEquals(
                new double[]{0.002, 0.100},
                new double[]{x[2], x[100]}, eps
        );
    }

    @Test
    void fillY() {
        double[] x = {0, Math.PI/6, Math.PI/3, Math.PI/2};
        double[] expected = {0, 0.5, 0.866025403, 1};
        assertArrayEquals(expected, main.fillY(x), eps);
    }

    @Test
    void numMax() {
        double[] x = {0.1, -0.41, 0.56, 2.1, 0.5, -2.8};
        int expected = 3;
        assertEquals(expected, main.numMax(x));
    }

    @Test
    void numMin() {
        double[] x = {0.1, -0.41, 0.56, 2.1, 0.5, -2.8};
        int expected = 5;
        assertEquals(expected, main.numMin(x));
    }


    @Test
    void f2() {
        double x = 0;
        double y = main.f2(x);
        assertEquals(Double.NEGATIVE_INFINITY, y);
    }

    @Test
    void sum() {
        double[] x = {0.1, -0.41, 0.56, 2.1, -0.5, -2.8};
        double expected = -0.95;
        assertEquals(expected, main.sum(x), eps);
    }

    @Test
    void average() {
        double[] x = {0.1, -0.41, 0.56, 2.1, -0.5, -2.8};
        double expected = -0.158333333;
        assertEquals(expected, main.average(x), eps);
    }

    @Test
    void var9() {
        String s = "dgdfg gdg drg f gdr grdgr ads";
        String expected = "dgdfg f grdgr ads";
        assertEquals(expected, main.var9(s, 3));
    }

    @Test
    void isConsonant() {
        char t = 'a';
        assertFalse(main.isConsonant(t));
        assertTrue(main.isConsonant('t'));
    }
}