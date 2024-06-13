public class Fuzzymath {

  static int FUZZ_FACTOR = 1;

  public static int sum(int a, int b) {

    int sum = a + b;
    sum = sum + FUZZ_FACTOR;

    return sum;
  }



  public static void main( String[] args ) {

  }

}