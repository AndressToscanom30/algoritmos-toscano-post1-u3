package com.u3.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests JUnit 5 para las tres variantes de Fibonacci.
 *
 * NOTA: fibRecursivo solo se prueba para n <= 30 porque su complejidad O(2^n)
 * hace inviable su ejecución para valores mayores dentro de un tiempo razonable.
 * Para n=40 tarda varios segundos; para n=50 puede tardar minutos.
 */
public class FibonacciTest {

    // Valores de referencia conocidos
    private static final long[] EXPECTED = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Test
    void testFibN0() {
        assertEquals(0L, Fibonacci.fibRecursivo(0));
        assertEquals(0L, Fibonacci.fibMemo(0));
        assertEquals(0L, Fibonacci.fibTabla(0));
    }

    @Test
    void testFibN1() {
        assertEquals(1L, Fibonacci.fibRecursivo(1));
        assertEquals(1L, Fibonacci.fibMemo(1));
        assertEquals(1L, Fibonacci.fibTabla(1));
    }

    @Test
    void testFibN2() {
        assertEquals(1L, Fibonacci.fibRecursivo(2));
        assertEquals(1L, Fibonacci.fibMemo(2));
        assertEquals(1L, Fibonacci.fibTabla(2));
    }

    @Test
    void testFibN5() {
        assertEquals(5L, Fibonacci.fibRecursivo(5));
        assertEquals(5L, Fibonacci.fibMemo(5));
        assertEquals(5L, Fibonacci.fibTabla(5));
    }

    @Test
    void testFibN10() {
        assertEquals(55L, Fibonacci.fibRecursivo(10));
        assertEquals(55L, Fibonacci.fibMemo(10));
        assertEquals(55L, Fibonacci.fibTabla(10));
    }

    @Test
    void testFibN20() {
        assertEquals(6765L, Fibonacci.fibRecursivo(20));
        assertEquals(6765L, Fibonacci.fibMemo(20));
        assertEquals(6765L, Fibonacci.fibTabla(20));
    }

    @Test
    void testFibN30() {
        // n=30 es el límite práctico para fibRecursivo en pruebas
        assertEquals(832040L, Fibonacci.fibRecursivo(30));
        assertEquals(832040L, Fibonacci.fibMemo(30));
        assertEquals(832040L, Fibonacci.fibTabla(30));
    }

    @Test
    void testFibTabla92SinDesbordamiento() {
        // Solo fibTabla y fibMemo se prueban para n=92
        assertEquals(7540113804746346429L, Fibonacci.fibTabla(92));
        assertEquals(7540113804746346429L, Fibonacci.fibMemo(92));
    }
}