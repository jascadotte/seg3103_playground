// This calculator was inspired by the idea of fuzzy math, where the answer to 
// a calculation is not what it should be, therefore, "fuzzy".

// I used lab 1 as a template for this calculator.

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

    return a % b + FUZZ_FACTOR;
  }

  public static void main( String[] args ) {

  }

}