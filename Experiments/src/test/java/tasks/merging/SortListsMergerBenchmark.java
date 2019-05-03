package tasks.merging;

import benchmark.DataGenerator;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 4)
public class SortListsMergerBenchmark {

    @State(Scope.Benchmark)
    public static class Data {
        public static int d_countA;
        public static int d_countB;
        public static ArrayList<Integer> d_a;
        public static ArrayList<Integer> d_b;

        @Param({"1000000"})
        public static int d_count;

        @Setup(Level.Trial)
        public void Data() {
            d_countA = d_count;
            d_countB = d_count;

            long st = System.nanoTime();
            d_a = DataGenerator.sortNumber(d_countA, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d_b = DataGenerator.sortNumber(d_countB, Integer.MIN_VALUE, Integer.MAX_VALUE);
            float sec = (System.nanoTime() - st) / 1_000_000;

            System.out.println(Float.toString(sec) + " micro sec - time was spent on data creation; ");
        }
    }

    @State(Scope.Thread)
    public static class ExecutionPlan {
        public static ArrayList<Integer> p_a;
        public static ArrayList<Integer> p_b;
        public static int p_countA;
        public static int p_countB;

        @Setup(Level.Iteration)
        public void setupPlan(Data data) {
            p_countA = data.d_countA;
            p_countB = data.d_countB;
            p_a = (ArrayList<Integer>) data.d_a.clone();
            p_b = (ArrayList<Integer>) data.d_b.clone();
        }
    }

    @Benchmark
    public void merge(ExecutionPlan plan) throws Exception {
        SortListsMerger.merge(plan.p_a, plan.p_b);
    }

   /* @Benchmark
    public void merge2(ExecutionPlan plan) throws Exception {
        Simple.merge2(plan.p_a, plan.p_b);
    }*/

    @Benchmark
    public void merge3(ExecutionPlan plan) throws Exception {
        SortListsMerger.merge3(plan.p_a, plan.p_b);
    }

    @Benchmark
    public void merge4(ExecutionPlan plan) throws Exception {
        SortListsMerger.merge4(plan.p_a, plan.p_b);
    }
}
