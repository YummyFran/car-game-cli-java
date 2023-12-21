import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {
    static Scanner sc = new Scanner(System.in);
    static LeaderBoard leaderBoard = new LeaderBoard();
    public static void main(String[] args) throws IOException {

        printAnimatedTitle();

        try {
            System.out.println("Welcome to the Command-Line-based Car game - CLI RASH!\n");
            Thread.sleep(1000);

            System.out.print("You're a new rider huh? May I know your name?\n> ");
            String name = sc.next();
            Thread.sleep(500);

            System.out.println("\nHi " + name +"!! Are you ready to go on a ride?\nPress any key to continue.");
            sc.next();
            Thread.sleep(500);

            System.out.println("\nAlright, Let's go!");
            Thread.sleep(500);
            startGame(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startGame(String name) throws IOException {
        Game newGame = new Game(name, leaderBoard);

        newGame.initializeGame();
    }

    static void NewGame() throws IOException {
        try {
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome to the Command-Line-based Car game - CLI RASH!\n");
            Thread.sleep(1000);

            System.out.print("Another rider huh? May I know your name?\n> ");
            String name = sc.next();
            Thread.sleep(500);

            System.out.println("\nHi " + name +"!! Are you ready to go on a ride?\nPress any key to continue.");
            sc.next();
            Thread.sleep(500);

            System.out.println("\nAlright, Let's go!");
            Thread.sleep(500);
            startGame(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
































    static void printAnimatedTitle() throws IOException {
            String epohs[] = {
                "\n\n" +
                "  /$$$$$$  /$$       /$$$$$$       /$$$$$$$   /$$$$$$   /$$$$$$  /$$   /$$\n" +
                " /$$__  $$| $$      |_  $$_/      | $$__  $$ /$$__  $$ /$$__  $$| $$  | $$\n" +
                "| $$  \\__/| $$        | $$        | $$  \\ $$| $$  \\ $$| $$  \\__/| $$  | $$\n" +
                "| $$      | $$        | $$ /$$$$$$| $$$$$$$/| $$$$$$$$|  $$$$$$ | $$$$$$$$\n" +
                "| $$      | $$        | $$|______/| $$__  $$| $$__  $$ \\____  $$| $$__  $$\n" +
                "| $$    $$| $$        | $$        | $$  \\ $$| $$  | $$ /$$  \\ $$| $$  | $$\n" +
                "|  $$$$$$/| $$$$$$$$ /$$$$$$      | $$  | $$| $$  | $$|  $$$$$$/| $$  | $$\n" +
                " \\______/ |________/|______/      |__/  |__/|__/  |__/ \\______/ |__/  |__/\n"
                ,
                "\n\n" +
                "   $$$$$$\\  $$\\       $$$$$$\\       $$$$$$$\\   $$$$$$\\   $$$$$$\\  $$\\   $$\\\n" +
                "  $$  __$$\\ $$ |      \\_$$  _|      $$  __$$\\ $$  __$$\\ $$  __$$\\ $$ |  $$ |\n" +
                "  $$ /  \\__|$$ |        $$ |        $$ |  $$ |$$ /  $$ |$$ /  \\__|$$ |  $$ |\n" +
                "  $$ |      $$ |        $$ |$$$$$$\\ $$$$$$$  |$$$$$$$$ |\\$$$$$$\\  $$$$$$$$ |\n" +
                "  $$ |      $$ |        $$ |\\______|$$  __$$< $$  __$$ | \\____$$\\ $$  __$$ |\n" +
                "  $$ |  $$\\ $$ |        $$ |        $$ |  $$ |$$ |  $$ |$$\\   $$ |$$ |  $$ |\n" +
                "  \\$$$$$$  |$$$$$$$$\\ $$$$$$\\       $$ |  $$ |$$ |  $$ |\\$$$$$$  |$$ |  $$ |\n" +
                "   \\______/ \\________|\\______|      \\__|  \\__|\\__|  \\__| \\______/ \\__|  \\__|\n"
                ,
                "    ______   __        ______        _______    ______    ______   __    __ \n" +
                "   /      \\ /  |      /      |      /       \\  /      \\  /      \\ /  |  /  |\n" +
                "  /$$$$$$  |$$ |      $$$$$$/       $$$$$$$  |/$$$$$$  |/$$$$$$  |$$ |  $$ |\n" +
                "  $$ |  $$/$$ |        $$ | ______ $$ |__$$ |$$ |__$$ |$$ \\__$$/ $$ |__$$ |\n" +
                "  $$ |      $$ |        $$ |/      |$$    $$< $$    $$ |$$    $$/ $$    $$ |\n" +
                "  $$ |   __ $$ |        $$ |$$$$$$/ $$$$$$$  |$$$$$$$$ | $$$$$$  |$$$$$$$$ |\n" +
                "  $$ \\__/  |$$ |_____  _$$ |_       $$ |  $$ |$$ |  $$ |/  \\__$$ |$$ |  $$ |\n" +
                "  $$    $$/ $$       |/ $$   |      $$ |  $$ |$$ |  $$ |$$    $$/ $$ |  $$ |\n" +
                "   $$$$$$/  $$$$$$$$/ $$$$$$/       $$/   $$/ $$/   $$/  $$$$$$/  $$/   $$/\n"
                ,
                "  ______   __        ______        _______    ______    ______   __    __ \n" +
                " /      \\ |  \\      |      \\      |       \\  /      \\  /      \\ |  \\  |  \\\n" +
                "|  $$$$$$\\| $$       \\$$$$$$      | $$$$$$$\\|  $$$$$$\\|  $$$$$$\\| $$  | $$\n" +
                "| $$   \\$$| $$        | $$ ______ | $$__| $$| $$__| $$| $$___\\$$| $$__| $$\n" +
                "| $$      | $$        | $$|      \\| $$    $$| $$    $$ \\$$    \\ | $$    $$\n" +
                "| $$   __ | $$        | $$ \\$$$$$$| $$$$$$$\\| $$$$$$$$ _\\$$$$$$\\| $$$$$$$$\n" +
                "| $$__/  \\| $$_____  _| $$_       | $$  | $$| $$  | $$|  \\__| $$| $$  | $$\n" +
                " \\$$    $$| $$     \\|   $$ \\      | $$  | $$| $$  | $$ \\$$    $$| $$  | $$\n" +
                "  \\$$$$$$  \\$$$$$$$$ \\$$$$$$       \\$$   \\$$ \\$$   \\$$  \\$$$$$$  \\$$   \\$$\n"
            };
            
            AtomicBoolean keyPressed = new AtomicBoolean(false);
        Thread onKeyPress = new Thread(() -> {
            try {
                System.in.read();
                // Set the stop flag when input is available
                keyPressed.set(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        onKeyPress.start();

        int frame = 0;
        while (!keyPressed.get()) {
            System.out.println("\033[H\033[2J");
            System.out.println(epohs[frame]);
            System.out.println("\nPress Enter to continue");
            
            if(frame==3) frame = 0;
            else frame++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\033[H\033[2J");
        return;
    }
}
