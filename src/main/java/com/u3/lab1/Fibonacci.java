package com.u3.lab1;

import java.util.Arrays;

/**
 * Tres implementaciones del n-ésimo número de Fibonacci para comparación empírica.
 *
 * <p>Todas retornan {@code long} para soportar valores hasta n=92 sin desbordamiento.
 * El valor máximo representable es fib(92) = 7540113804746346429L.</p>
 */
public class Fibonacci {

    /**
     * Calcula fib(n) usando recursión ingenua sin memoización.
     *
     * <p>Complejidad temporal: O(2^n) — árbol de recursión con subproblemas repetidos.</p>
     * <p>Complejidad espacial: O(n) — profundidad máxima del stack de llamadas.</p>
     *
     * <p><b>ADVERTENCIA:</b> No usar para n > 40. El tiempo crece exponencialmente
     * y puede tardar minutos para n >= 50.</p>
     *
     * @param n posición en la secuencia (n >= 0)
     * @pre  n >= 0
     * @post retorna el n-ésimo número de Fibonacci
     * @return fib(n)
     */
    public static long fibRecursivo(int n) {
        if (n <= 1) return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    /**
     * Calcula fib(n) usando memoización top-down (Programación Dinámica).
     *
     * <p>Complejidad temporal: O(n) — cada subproblema se calcula exactamente una vez.</p>
     * <p>Complejidad espacial: O(n) — arreglo memo de tamaño n+2 más el stack de llamadas.</p>
     *
     * @param n posición en la secuencia (n >= 0)
     * @pre  n >= 0
     * @post retorna el n-ésimo número de Fibonacci
     * @return fib(n)
     */
    public static long fibMemo(int n) {
        long[] memo = new long[n + 2];
        Arrays.fill(memo, -1L);
        return fibMemoHelper(n, memo);
    }

    /**
     * Función auxiliar recursiva con tabla de memoización compartida.
     *
     * @param n    subproblema actual
     * @param memo tabla de resultados ya calculados (-1 indica no calculado)
     * @return fib(n)
     */
    private static long fibMemoHelper(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];              // resultado en caché
        memo[n] = fibMemoHelper(n - 1, memo)
                + fibMemoHelper(n - 2, memo);
        return memo[n];
    }

    /**
     * Calcula fib(n) usando tabulación bottom-up (Programación Dinámica iterativa).
     *
     * <p>Complejidad temporal: O(n) — un único bucle de n iteraciones.</p>
     * <p>Complejidad espacial: O(1) — solo dos variables de estado (prev1, prev2).</p>
     *
     * @param n posición en la secuencia (n >= 0)
     * @pre  n >= 0
     * @post retorna el n-ésimo número de Fibonacci
     * @return fib(n)
     */
    public static long fibTabla(int n) {
        if (n <= 1) return n;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}