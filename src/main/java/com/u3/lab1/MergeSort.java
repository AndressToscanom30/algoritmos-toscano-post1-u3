package com.u3.lab1;

/**
 * Implementación de MergeSort — estrategia Divide y Vencerás.
 *
 * <p>Complejidad temporal: Θ(n log n) en todos los casos (mejor, promedio y peor).
 * Esto se deriva del Teorema Maestro aplicado a T(n) = 2T(n/2) + O(n),
 * donde a=2, b=2, f(n)=O(n), resultando en Θ(n log n).</p>
 *
 * <p>Complejidad espacial: O(n) espacio auxiliar para el arreglo temporal
 * en cada llamada a merge().</p>
 */
public class MergeSort {

    /**
     * Ordena el arreglo in-place usando el algoritmo MergeSort.
     *
     * <p>Complejidad temporal: Θ(n log n). Complejidad espacial: O(n).</p>
     *
     * @param arr arreglo de enteros a ordenar (no nulo)
     * @pre  arr != null
     * @post arr queda ordenado en forma no decreciente
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Método recursivo interno que divide y ordena el subarreglo arr[lo..hi].
     *
     * @param arr arreglo sobre el que se trabaja
     * @param lo  índice izquierdo del subarreglo (inclusivo)
     * @param hi  índice derecho del subarreglo (inclusivo)
     * @pre  0 <= lo <= hi < arr.length
     * @post arr[lo..hi] queda ordenado en forma no decreciente
     */
    private static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;                    // caso base: un solo elemento
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);                 // T(n/2) — mitad izquierda
        mergeSort(arr, mid + 1, hi);             // T(n/2) — mitad derecha
        merge(arr, lo, mid, hi);                 // O(n)   — combinar
    }

    /**
     * Combina dos subarreglos ordenados arr[lo..mid] y arr[mid+1..hi]
     * en un único subarreglo ordenado.
     *
     * @param arr arreglo de trabajo
     * @param lo  inicio del subarreglo izquierdo
     * @param mid fin del subarreglo izquierdo / inicio del derecho - 1
     * @param hi  fin del subarreglo derecho
     */
    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;

        while (i <= mid && j <= hi) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi)  temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, lo, temp.length);
    }
}