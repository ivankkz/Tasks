package benchmark;

import main.Simple;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;

public class TestMB {

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({"1000", "100000", "1000000"})
        public int countA;

        @Param({"1000", "100000", "1000000"})
        public int countB;

        public static ArrayList<Integer> aOld;
        public static ArrayList<Integer> aNew;
        public static ArrayList<Integer> b;

        @Setup(Level.Invocation)
        public void setUp() {
            aOld = GeneratorData.sortNumber(countA, Integer.MIN_VALUE, Integer.MAX_VALUE);
            aNew = (ArrayList<Integer>) aOld.clone();
            b = GeneratorData.sortNumber(countB, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void merge(ExecutionPlan plan) {
        Simple.merge(plan.aNew, plan.b);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public void merge2(ExecutionPlan plan) {
        Simple.merge2(plan.aOld, plan.b);
    }
}
