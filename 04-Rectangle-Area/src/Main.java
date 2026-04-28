import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

   public static class ANSI {

      public static final String RESET = "\u001B[0m";
      public static final String RED = "\u001B[31m";
      public static final String GREEN = "\u001B[32m";
      public static final String YELLOW = "\u001B[33m";
      public static final String BLUE = "\u001B[34m";
      public static final String PURPLE = "\u001B[35m";
      public static final String CYAN = "\u001B[36m";

      public static final String DEFAULT_CLR = ANSI.CYAN;
   }

   public static class Clock {
      public static void currentDT () {
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

         System.out.println("Current date and time : " + now.format(formatter));
      }
      
   }

   public static class Spinner {
      public static void spin (int durationMs, String message) throws InterruptedException {

         int i = 0;
         char frames[] = {'|', '/', '-', '\\'};
         long end = System.currentTimeMillis() + durationMs;

         while (System.currentTimeMillis() < end) {
            System.out.println(ANSI.YELLOW + "\r" + message + frames[ i++ % frames.length]);
            Thread.sleep(100);
         }
      }
      
   }

   public static class UI {

      public static void header(String heading) {
         System.out.println("===========================================");
         System.out.println(" " + heading.toUpperCase());
         System.out.println("===========================================\n");
      }

      public static void subHeading (String sub) {
         System.out.println("==== " + sub + " ====");
      }
   }

   @SuppressWarnings ("deprecation")
   public static void main(String[] args) {
      
      try {

         Runtime.getRuntime().exec("cmd /c color 03");
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
         
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println(ANSI.DEFAULT_CLR);
      Clock.currentDT();
      UI.header("the area of a rectangle");
   }
}
