package benchmark;

import main.Simple;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 2)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class TestMB {

    @State(Scope.Benchmark)
    public static class Data {
        public static int d_countA;
        public static int d_countB;
        public static ArrayList<Integer> d_a;
        public static ArrayList<Integer> d_b;

        @Param({"1000000", "10000000"})
        public static int d_count;

        @Setup(Level.Trial)
        public void setupData() {
            d_countA = d_count;
            d_countB = d_count;

            long st = System.nanoTime();
            d_a = GeneratorData.sortNumber(d_countA, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d_b = GeneratorData.sortNumber(d_countB, Integer.MIN_VALUE, Integer.MAX_VALUE);
            float sec = (System.nanoTime() - st) / 1_000_000;

            System.out.print(Float.toString(sec) + " micro sec - time was spent on data creation; ");
        }
    }

    @State(Scope.Thread)
    public static class ExecutionPlan {
        public static ArrayList<Integer> p_a;
        public static ArrayList<Integer> p_b;
        public static int p_countA;
        public static int p_countB;

        @Setup(Level.Invocation)
        public void setupPlan(Data data) {
            p_countA = data.d_countA;
            p_countB = data.d_countB;
            p_a = (ArrayList<Integer>) data.d_a.clone();
            p_b = (ArrayList<Integer>) data.d_b.clone();
        }
    }

    @Benchmark
    public void merge(ExecutionPlan plan) throws Exception {
        Simple.merge(plan.p_a, plan.p_b);

//        for debugging purposes !!!
//        System.out.println("p_b size = " + plan.p_b.size() + " ; plan.p_countB = " + plan.p_countB);
//        if (plan.p_a.size() != plan.p_countA || plan.p_b.size() != plan.p_countB)
//            throw new Exception();
//        if ((plan.p_a.size() != plan.p_countA + plan.p_countB) || plan.p_b.size() != plan.p_countB)
//            throw new Exception();
    }

   /* @Benchmark
    public void merge2(ExecutionPlan plan) throws Exception {
        Simple.merge2(plan.p_a, plan.p_b);
    }*/

    @Benchmark
    public void merge3(ExecutionPlan plan) throws Exception {
        Simple.merge3(plan.p_a, plan.p_b);
    }

    @Benchmark
    public void merge4(ExecutionPlan plan) throws Exception {
        Simple.merge4(plan.p_a, plan.p_b);
    }
}
