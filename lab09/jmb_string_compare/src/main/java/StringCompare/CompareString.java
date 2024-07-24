package StringCompare;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CompareString {
    // Create large equal strings so it has to be traversed
    private final String str1 = new String(new char[1000000]).replace('\0', 'x');
    private final String str2 = new String(new char[1000000]).replace('\0', 'x');
    // Interations
    private final int counter = 1000000;

    @Benchmark
    public boolean compareUsingEqualSign(){
        boolean result = true;
        for (int i=0; i<counter; i++){
            result = (str1 == str2);
        }
        return result;
    }

    @Benchmark
    public boolean compareUsingEquals(){
        boolean result = true;
        for (int i=0; i<counter;i++){
            str1.equals(str2);
        }
        return result;
    }

    @Benchmark
    public  boolean compareUsingContentEquals(){
        boolean result = true;
        for (int i=0; i<counter;i++){
            str1.contentEquals(str2);
        }
        return result;
    }

    @Benchmark
    public int compareUsingCompareTo(){
        int result = 0;
        for (int i=0; i<counter;i++){
            result = str1.compareTo(str2);
        }
        return result;
    }

    @Benchmark
    public int compareUsingcompareToIgnoreCase(){
        int result = 0;
        for (int i=0; i<counter;i++){
            result = str1.compareToIgnoreCase(str2);
        }
        return result;
    }
}
