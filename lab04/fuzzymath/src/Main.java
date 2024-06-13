public class Main {

  public static void main( String[] args ) {

    printToScreen("Fuzzymath add / subtract / divide / multiply ");

  }

  private static void printToScreen(String message) {
    printToScreen(message, true);
  }

  private static void printToScreen(String message, boolean newline) {
    if (message != null) {
      System.out.print(message);
      if (newline) {
        System.out.println("");
      }
    }
  }

}