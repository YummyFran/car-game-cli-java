import java.util.Scanner;

public class Car {
    Scanner scanner = new Scanner(System.in);
    private int carXPosition;
    private int carSpeed = 2;
    private String[] car = {
                " /_/\\_\\ ",
                "[--------] ",
                "|__________| ",
                "|____________| ",
                " \\ \\        / / ",
                "   \\    ||    / ",
                "     |   ||   | ",
                "    / /   ||   \\ \\ ",
                "  / / /          \\ \\ \\ ",
                "  /_/_/____________\\_\\_\\ "
        };;

    public Car(int xCoord) {
        this.carXPosition = xCoord;
    }

    public String[][] drawCar(String[][] map, int y, int x) {
        //place my car at the bottom of the road
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length(); j++) {
                map[y + i][x + j] = String.valueOf(car[i].charAt(j));
            }
        }

        return map;
    }

    public void updateCarPosition(Road road) {
        // Get user input for car movement
        System.out.print("Press 'A' to move left, 'D' to move right, or 'S' to stay on position: ");
        char userInput = scanner.next().toUpperCase().charAt(0);

        if (userInput == 'A' && carXPosition > road.leftBound) {
            carXPosition -= carSpeed;
        } else if (userInput == 'D' && carXPosition < road.rightBound) {
            carXPosition += carSpeed;
        }
        return;
    }


    public int getXPosition() {
        return this.carXPosition;
    }

    public String[] getCar() {
        return this.car;
    }

}