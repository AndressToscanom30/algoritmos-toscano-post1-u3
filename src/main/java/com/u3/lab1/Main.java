package com.u3.lab1;

import java.util.Arrays;

/**
 * Clase principal que demuestra el funcionamiento de MergeSort y Fibonacci.
 * Útil para verificar rápidamente la implementación sin ejecutar el benchmark JMH.
 */
public class Main {

    public static void main(String[] args) {
        // --- Demostración de MergeSort ---
        System.out.println("=== MergeSort ===");
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Antes: " + Arrays.toString(arr));
        MergeSort.sort(arr);
        System.out.println("Después: " + Arrays.toString(arr));

        // --- Demostración de Fibonacci ---
        System.out.println("\n=== Fibonacci (n = 10) ===");
        int n = 10;
        System.out.println("Recursivo: " + Fibonacci.fibRecursivo(n));
        System.out.println("Memoización: " + Fibonacci.fibMemo(n));
        System.out.println("Tabulación: " + Fibonacci.fibTabla(n));

        System.out.println("\n=== Fibonacci grande (n = 92, solo memo y tabla) ===");
        System.out.println("Memoización: " + Fibonacci.fibMemo(92));
        System.out.println("Tabulación:  " + Fibonacci.fibTabla(92));
    }
}