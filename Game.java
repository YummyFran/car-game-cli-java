import java.io.IOException;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    private static String[][] gameMap;
    private static int gameScore;

    private static Road road;
    private static Car car;
    private static Obstacle obstacle;

    private Player player;
    private LeaderBoard leaderBoard;
    private String playerName;

    public Game(String playerName, LeaderBoard leaderBoard) {
        this.playerName = playerName;
        this.leaderBoard = leaderBoard;
        this.player = new Player(playerName);
    }

    public void initializeGame() throws IOException {
        road = new Road(30);
        car = new Car((road.getWidth() + road.getLength()) / 2 + 5);
        obstacle = new Obstacle(1);
        gameScore = 0;

        drawFrame();
    }

    private void drawFrame() throws IOException {
        while (true) {
            //Draw the Elements with its data
            gameMap = road.initializeRoad();
            gameMap = obstacle.drawObstacle(gameMap, road);
            gameMap = car.drawCar(gameMap, road.getLength() - 10, car.getXPosition());
            
            //Then i-render
            render();

            //Check nato if nabangga ba, if yes -> gameOver()
            int obstacleFrame = (int) Math.min(Math.floor((double) obstacle.getObstacleY() / (road.getLength() / obstacle.getObstacle().length)), obstacle.getObstacle().length - 1);
            if (checkCollision(
                gameMap, 
                car.getCar(), 
                road.getLength() - 10, car.getXPosition(), 
                obstacle.getObstacle(), 
                obstacle.getObstacleY(), 
                obstacle.getObstacleX(), 
                obstacle.getObstacle()[obstacleFrame].length,
                obstacle.getObstacle()[obstacleFrame][0].length() )
            ) {
                gameOverScreen();
                break;
            }

            //If no -> Coninue Game
            System.out.println("Player: " + this.playerName);
            System.out.println("Score: " + gameScore);

            //Update Element datas
            obstacle.updateObstaclePosition(road);
            car.updateCarPosition(road);
        }
    }

    private void render() {
        // Clear the console to redraw the road
        System.out.print("\033[H\033[2J");
        System.out.flush();

        gameScore++;

        for (int i = 0; i < road.getLength(); i++) {
            int currentRoadWidth = road.getWidth() + i;
            int sidePadding = (currentRoadWidth + road.getWidth() - i * 2);

            // Space sa left
            for (int j = 0; j < sidePadding; j++) {
                System.out.print(" ");
            }

            // Draw left part sa road
            System.out.print(road.getLeftRoad());

            // Draw tanang elements sa road
            for (int j = 0; j < (currentRoadWidth - 2) * 2; j++) {
                System.out.print(gameMap[i][j]);
            }

            // Draw right part sa road
            System.out.println(road.getRightRoad());
        }
    }

    public static boolean checkCollision(String[][] map, String[] carObj, int carY, int carX, String[][] obstacleObj, int obstacleY, int obstacleX, int obstacleHeight, int obstacleWidth) {
        for (int i = 0; i < carObj.length; i++) {
            for (int j = 0; j < carObj[i].length(); j++) {
                int mapY = carY + i;
                int mapX = carX + j;
    
                if (mapY >= obstacleY && mapY < obstacleY + obstacleHeight &&
                    mapX >= obstacleX && mapX < obstacleX + obstacleWidth &&
                    !map[mapY][mapX].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void gameOverScreen() throws IOException {
        String gameTitle = 
                "  ___    __    __  __  ____    _____  _  _  ____  ____ \n" +
                " / __)  /__\\  (  \\/  )( ___)  (  _  )( \\/ )( ___)(  _ \\\n" +
                "( (_-. /(__)\\  )    (  )__)    )(_)(  \\  /  )__)  )   /\n" +
                " \\___/(__)(__)(_/\\/\\_)(____)  (_____)  \\/  (____)(_)\\_)\n";

        System.out.println(gameTitle);
        System.out.printf("%s Crashed\n", playerName);
        System.out.printf("Your score: %d\n\n", gameScore);
        player.setScore(gameScore);
        leaderBoard.addPLayer(player);

        try {
            Thread.sleep(1500);
            System.out.printf("Nice Driving %s! But be better next time!\n", playerName);
            Thread.sleep(500);
            displayOptions();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void displayOptions() throws IOException {
        System.out.println("What would you like to do now?");
        System.out.println("\t1. Play Again");
        System.out.println("\t2. Play with different Player");
        System.out.println("\t3. Open Leaderboards");
        System.out.println("\t4. Quit Game");
        System.out.print("> ");

        char option = sc.next().toUpperCase().charAt(0);;    

        switch (option) {
            case '1':
                initializeGame();
                break;
            case '2':
                App.NewGame();
                break;
            case '3':
                leaderBoard.displayLeaderboard();
                displayOptions();
                break;
            case '4':
                System.out.println("Thank you for playing!");
                App.printAnimatedTitle();
                return;
            default:
                System.out.print("\033[H\033[2J");
                displayOptions();
                break;
        }
    }
}