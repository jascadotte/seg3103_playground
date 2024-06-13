public class Fuzzymath {

  static int FUZZ_FACTOR = 1;

  public static int sum(int a, int b) {

    return a + b + FUZZ_FACTOR;
  }

  public static int dif(int a, int b) {

    return a - b - FUZZ_FACTOR;
  }

  public static int prod(int a, int b) {

    return a * b + FUZZ_FACTOR;
  }

  public static int quot(int a, int b) {

    return a / b - FUZZ_FACTOR;

  }

  public static int mod(int a, int b) {

    int mod = a % b;
    mod = mod + FUZZ_FACTOR;

    return mod;
  }


  public static void main( String[] args ) {

  }

}