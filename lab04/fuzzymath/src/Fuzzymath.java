public class Fuzzymath {

  static int FUZZ_FACTOR = 1;

  public static int sum(int a, int b) {

    return a + b + FUZZ_FACTOR;
  }

  public static int dif(int a, int b) {

    int dif = a - b;
    dif = dif - FUZZ_FACTOR;

    return dif;
  }


  public static void main( String[] args ) {

  }

}