import StringCompare.CompareString;
// import StringCompare.SplitBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
   static CompareString demo2 = new CompareString();
        public static void main(String[] args) throws Exception {

            Options opt = new OptionsBuilder()
                    .include(".*" + CompareString.class.getSimpleName() + ".*")
                    .warmupIterations(2)
                    .measurementIterations(2)
                    .forks(1)
                    .build();

            new Runner(opt).run();

        }
}
