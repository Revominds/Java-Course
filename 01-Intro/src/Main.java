import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static class ANSI {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }

    public static class DateTimeExample {
        public static void showDateTime() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println("Current Time: " + now.format(formatter));
        }
    }

    public static class UI {
        public static void printHeader(String title) {
            System.out.println("=================================");
            System.out.println(title.toUpperCase());
            System.out.println("=================================");
        }
    }

    public static class Spinner {
        public static void spin(int durationMs) throws InterruptedException {

            char[] frames = {'|', '/', '-', '\\'};
            int i = 0;
            long end = System.currentTimeMillis() + durationMs;

            while (System.currentTimeMillis() < end) {
                System.out.print("\rLoading " + frames[i++ % frames.length]);
                Thread.sleep(100);
            }

            System.out.print(ANSI. YELLOW + "\rDone!      \n");
        }
    }

    /* MAIN MUST BE HERE */
    public static void main(String[] args) {

        try {
            Runtime.getRuntime().exec("cmd /c color 03");
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(ANSI.YELLOW);
        DateTimeExample.showDateTime();
        UI.printHeader(" Introduction to Java");

        System.out.print(ANSI.CYAN);
        System.out.println("[1] I like rice");
        System.out.println("[2] Rice is really good");
        System.out.println("[3] Buy some rice for me");
        System.out.print(ANSI.RESET);

        try {
            Spinner.spin(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}