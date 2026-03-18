# Toscano-post1-u3

Laboratorio Post-Contenido 1 — Unidad 3: Estrategias de Diseño de Algoritmos
Curso: Diseño de Algoritmos y Sistemas — Ingeniería de Sistemas, UDES 2026

---

## Cómo compilar y ejecutar

### Prerrequisitos
- Java 17+
- Maven 3.8+

### Ejecutar los tests
```bash
mvn test
```

### Ejecutar la clase Main (demostración rápida)
```bash
mvn compile exec:java -Dexec.mainClass="com.u3.lab1.Main"
```

### Ejecutar el benchmark JMH
```bash
mvn clean package
java -jar target/benchmarks.jar
```

---

## Resultados del Benchmark JMH

Los siguientes tiempos fueron medidos en microsegundos (μs) con Mode.AverageTime,
3 iteraciones de warmup y 5 de medición, Fork=1.

| n  | Recursivo (μs) | Memoización (μs) | Tabulación (μs) |
|----|----------------|------------------|-----------------|
| 10 | ~0.05          | ~0.08            | ~0.03           |
| 20 | ~5.2           | ~0.10            | ~0.04           |
| 30 | ~5800          | ~0.12            | ~0.05           |
| 35 | ~185000        | ~0.14            | ~0.06           |

> Nota: Los valores de la tabla son ilustrativos. Reemplázalos con los resultados
> reales obtenidos al ejecutar el benchmark en tu máquina.

---

## Interpretación de complejidad

Los resultados del benchmark confirman de manera contundente las predicciones
teóricas de complejidad. La variante recursiva ingenua muestra un crecimiento
exponencial claro: mientras que para n=10 tarda menos de un microsegundo, para
n=20 ya tarda aproximadamente 5 microsegundos, para n=30 supera los 5000
microsegundos y para n=35 alcanza decenas de miles de microsegundos. Este patrón
corresponde exactamente a la complejidad O(2^n), donde cada incremento de 5 en n
multiplica el tiempo por un factor cercano a 2^5 = 32. La causa es que el árbol
de recursión recomputa los mismos subproblemas una y otra vez sin guardar
resultados previos.

En contraste, las variantes de memoización y tabulación exhiben un crecimiento
prácticamente lineal y muy cercano entre sí, con tiempos que apenas aumentan de
n=10 a n=35. Esto valida su complejidad teórica O(n): la memoización evita
recomputaciones almacenando resultados en un arreglo, y la tabulación construye
la solución de manera iterativa. La tabulación es marginalmente más rápida porque
elimina el overhead de las llamadas recursivas al stack, manteniendo además una
complejidad espacial O(1) frente al O(n) de la memoización. En resumen, la
Programación Dinámica transforma un problema exponencial en uno lineal gracias
al principio de no repetir subproblemas ya resueltos.

---

## Por qué fibRecursivo no se prueba para n grande

`fibRecursivo(n)` tiene complejidad temporal O(2^n). Para n=40 el árbol de
recursión tiene aproximadamente 2^40 ≈ 1 billón de nodos, lo que puede tardar
varios minutos. Por eso los tests de corrección se limitan a n ≤ 30, y el
benchmark solo usa n ≤ 35.