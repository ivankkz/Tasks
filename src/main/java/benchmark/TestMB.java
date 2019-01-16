package benchmark;

import main.Simple;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;

public class TestMB {
    private static final int countA = 100_000;
    private static final int countB = 100_000;

    private static ArrayList<Integer> a1 = GeneratorData.sortNumber(countA, -10000, 10000);
    private static ArrayList<Integer> a2 = (ArrayList<Integer>) a1.clone(); // одинаковые рандомные выборки
    private static ArrayList<Integer> b = GeneratorData.sortNumber(countB, -10000, 10000);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void merge() {
        Simple.merge(a1, b);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void merge2() {
        Simple.merge2(a2, b);
    }

}
