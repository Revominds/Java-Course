import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  
  /**—————————————————————————————————————————————————————— 
   * ANSI colors 🎨
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
   * datetime ⌚
  ** ——————————————————————————————————————————————————————**/
   public static class DateTime {
      public static void showDateTime() {
         LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 

         System.out.println("Current date and time : " + now.format(formatter));
      }
   }

   
  /**—————————————————————————————————————————————————————— 
   * spinner ()
  ** ——————————————————————————————————————————————————————**/
   public static class Spinner {
      public static void spin(int durationMs) throws InterruptedException {

         char[] frames = {'|', '/', '-', '\\'};
         int i = 0;
         long end = System.currentTimeMillis() + durationMs;

         while (System.currentTimeMillis() < end) {
               System.out.print(ANSI.YELLOW + "\rLoading " + frames[i++ % frames.length]);
               Thread.sleep(100);
         }

         System.out.print( ANSI.GREEN + "\rCompleted Successfully     \n\n");
      }
   }
  /**—————————————————————————————————————————————————————— 
   * header () 
  ** ——————————————————————————————————————————————————————**/
   public static class UI {
      public static void printHeader(String title) {
         System.out.println("============================================");
         System.out.println("  " + title.toUpperCase());
         System.out.println("============================================\n");

      }
   }

   public static class SUB{
      public static void subTitles(String subTitle) {
         System.out.println(ANSI.CYAN + "==== "+subTitle +" ====" + ANSI.RESET);
      }
   }

  /**—————————————————————————————————————————————————————— 
   * main function begins here
  ** ——————————————————————————————————————————————————————**/

 @SuppressWarnings("deprecation")
public static void main(String[] args) {
    
    try {
      
      Runtime.getRuntime().exec("cmd /c color 03");
      new ProcessBuilder("cmd", "/c", "cls")
         .inheritIO().start().waitFor();

   } catch (Exception e) {
     e.printStackTrace();
   }

   System.out.println(ANSI.DEFAULT_COLOR);
   DateTime.showDateTime();
   UI.printHeader("variables in java");
   
   showIntegers();
   showDoubles();
   showChars();
   showBooleans();
   showStrings();

   
   try {
         Spinner.spin(3000);
   } catch (Exception e) {
      e.printStackTrace();
   }
  
  }

  //integer function
  private static void showIntegers() {
   int age = 26;
   int year = 2026;
   int quantity = 10;
   
   SUB.subTitles("Integers");
   System.out.println(ANSI.DEFAULT_COLOR);
   System.out.print("[1] You are " + age + " years old\n");
   System.out.print("[2] The year is " + year +" \n");
   System.out.print("[3] The total quantity is " + quantity +" \n\n");
  }

  //double function
  private static void showDoubles() {

   double price = 19.99;
   double gpa = 3.99;
   double temperature = -30.19;

   SUB.subTitles("Double");
   System.out.println(ANSI.PURPLE);
   System.out.print("[1] The price is $"+ price + "\n");
   System.out.print("[2] Your gpa is "+ gpa + "\n");
   System.out.print("[3] Today's temperature is "+ temperature + "\n\n");

  }

  //char function
  private static void showChars(){
  
   char currency = '$';
   char grade = 'A';
   char symbol = '!';

   SUB.subTitles("Char");
   System.out.println(ANSI.PURPLE);
   System.out.print("[1] The currency is"+ currency + "\n");
   System.out.print("[2] Your grade is " + grade + "\n");
   System.out.print("[3] Come back here"+ symbol + "\n\n");
  
  }

  //boolean function
  private static void showBooleans(){
  
   boolean isStudent = true;
   boolean isForSale = false;
   boolean isOnline = true;
   
   SUB.subTitles("Boolean");
   System.out.println(ANSI.PURPLE);
   System.out.print((isStudent) ? "[1] John is a student\n" : 
                                  "[1] Ama is a student\n");
   System.out.print((isForSale) ? "[2] The iPhone 11 Pro is for sale\n" : 
                                  "[2] The iPhone 11 Pro is not for sale\n");
   System.out.print((isOnline) ? "[3] Jacquelyn is online\n\n" :
                                 "[3] Jacquelyn is offline" + "\n\n");
  }

  //String function
  private static void showStrings(){

   String name = "James Dukes";
   String country = "The Republic of Congo";
   String email = "jdukes@gmail.com";
   
   SUB.subTitles("Strings");
   System.out.println(ANSI.PURPLE);
   System.out.print("[1] Your name is "+ name + "\n");
   System.out.print("[2] "+ name + " comes from " + country + "\n");
   System.out.print("[3] His email address is " + email + "\n\n");
   
  }


}
