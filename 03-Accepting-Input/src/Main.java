import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {


   /**—————————————————————————————————————————————————————— 
   * colors 
  ** ——————————————————————————————————————————————————————**/
   public static class ANSI {
   
      public static final String RESET = "\u001B[0m";
      public static final String RED = "\u001B[31m";
      public static final String GREEN = "\u001B[32m";
      public static final String YELLOW = "\u001B[33m";
      public static final String BLUE = "\u001B[34m";
      public static final String PURPLE = "\u001B[35m";
      public static final String CYAN = "\u001B[36m";

      public static final String DEFAULT_COLOR = ANSI.PURPLE;
      
   }

   /**—————————————————————————————————————————————————————— 
   * date and time 
  ** ——————————————————————————————————————————————————————**/
   public static class Clock {
      public static void currentDT () {
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

         System.out.println("Current date and time : " + now.format(formatter));
      }
   }

   /**—————————————————————————————————————————————————————— 
   * spinner 
  ** ——————————————————————————————————————————————————————**/
     public static class Spinner {
      public static void spin(int durationMs, String message) throws InterruptedException {

         char[] frames = {'|', '/', '-', '\\'};
         int i = 0;
         long end = System.currentTimeMillis() + durationMs;

         while (System.currentTimeMillis() < end) {
               System.out.print(ANSI.YELLOW + "\r" + message + frames[i++ % frames.length]);
               Thread.sleep(100);
         }

      }
   }

   /**—————————————————————————————————————————————————————— 
   * header and sub headers 
  ** ——————————————————————————————————————————————————————**/
   public static class UI{
      public static void header (String title) {
         System.out.print("===========================================\n");
         System.out.println("  " + title.toUpperCase());
         System.out.println("===========================================\n");
      }

      public static void subHeading (String title) {
         System.out.println("==== " + title + " ====");
      }
   }


  /**—————————————————————————————————————————————————————— 
   * program exe begins  
  ** ——————————————————————————————————————————————————————**/
   @SuppressWarnings ("deprecation")
   public static void main(String[] args) {

      try {

         Runtime.getRuntime().exec("cmd /c color 03");
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
         
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.print(ANSI.DEFAULT_COLOR);
      Clock.currentDT();
      UI.header("accepting user input");

      //scanner
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter your name : ");
      String name = scanner.nextLine(); //string

      System.out.print("Enter your age  : ");
      int age = scanner.nextInt(); //integer
      
      System.out.print("What is your gpa : ");
      double gpa = scanner.nextDouble(); //double

      System.out.print("Are you a student? (True/False) : ");
      boolean isStudent = scanner.nextBoolean(); //boolean

      try {

         System.out.println();
         Spinner.spin(3000, "saving data");
         System.out.println( ANSI.GREEN + "\n\r saving data completed");

         System.out.println();
         UI.subHeading(ANSI.CYAN + "Results");

         System.out.println(ANSI.PURPLE + "[1] Hello " + name + "!");
         System.out.println("[2] You are "+ age + " years old");
         System.out.println("[3] Your gpa is "+ gpa + "points");
         System.out.println((isStudent) == true ? 
                             "[4] Congrats! You are a student!\n\n" : 
                             "[4] Sorry! You are not enrolled\n\n");


      } catch (Exception e) {
         e.printStackTrace();
      }


      scanner.close();

      
      
   }

}
