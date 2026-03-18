package com.u3.lab1;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark JMH para comparar empíricamente las tres variantes de Fibonacci.
 *
 * <p>Se mide el tiempo promedio de ejecución en microsegundos para
 * n = {10, 20, 30, 35}. fibRecursivo se excluye para n > 35 porque
 * su complejidad O(2^n) haría que el benchmark tardara horas.</p>
 *
 * <p>Ejecutar con: mvn clean package &amp;&amp; java -jar target/benchmarks.jar</p>
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class BenchmarkFibonacci {

    @Param({"10", "20", "30", "35"})
    public int n;

    /**
     * Mide fibRecursivo — O(2^n).
     * Solo viable hasta n=35 en tiempo de benchmark razonable.
     */
    @Benchmark
    public long recursivo() {
        return Fibonacci.fibRecursivo(n);
    }

    /**
     * Mide fibMemo — O(n) tiempo, O(n) espacio.
     */
    @Benchmark
    public long memoizacion() {
        return Fibonacci.fibMemo(n);
    }

    /**
     * Mide fibTabla — O(n) tiempo, O(1) espacio.
     */
    @Benchmark
    public long tabulacion() {
        return Fibonacci.fibTabla(n);
    }
}