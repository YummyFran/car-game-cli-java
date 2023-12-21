public class Obstacle {
    private int obstacleXPosition;
    private int obstacleYPosition;
    private int obstacleXPercentage;
    private int obstacleSize;
    private int obstacleSpeed;
    private String [][] obstacleFrames;
    private int obstacleLevel;

    public Obstacle(int speed) {
        this.obstacleXPosition = (int) Math.floor(Math.random() * 86);
        this.obstacleYPosition = 0;
        this.obstacleSpeed = speed;
        this.obstacleLevel = 0;
    }

    public String[][] drawObstacle(String[][] map, Road road) {
        String[][] obstacles = {
            {
                "/\\",
                " \\/"
            },
            {
                "__",
                "/  \\",
                "|    |",
                "  \\__/"
            },{
                "___",
                "/   \\",
                "|     |",
                "  \\___/"
            },
            {
                "_____", 
                "/     \\",
                "/       \\",
                "|         |",
                "  \\       /",
                "    \\_____/"
            },
            {
                "_______", 
                "/       \\",
                "/         \\",
                "|           |",
                "  \\         /",
                "    \\_______/"
            },
            {
                "________", 
                "/        \\",
                "/          \\",
                "|            |",
                " |            |",
                "   \\          /",
                "     \\________/"
            },
            {
                "_________", 
                "/         \\",
                "/           \\",
                "|             |",
                " |             |",
                "   \\           /",
                "     \\_________/"
            },
            {
                "_________", 
                "/         \\",
                "/           \\",
                "/             \\",
                "|               |",
                "  \\             /",
                "    \\           /",
                "      \\_________/"
            }
        };

        obstacleFrames = obstacles;
        

        obstacleSize = (int) Math.min(Math.floor((double) obstacleYPosition / (road.getLength() / obstacles.length)), obstacles.length - 1);
        int rowSize =(road.getWidth() + obstacleYPosition - 2) * 2;
        obstacleXPercentage =(int) (rowSize * obstacleXPosition) / 100;

        for (int i = 0; i < obstacles[obstacleSize].length; i++) {
            for (int j = 0; j < obstacles[obstacleSize][i].length(); j++) {
                if(obstacleYPosition + i < road.getLength() - 1) {
                    map[obstacleYPosition + i][obstacleXPercentage + j] = String.valueOf(obstacles[obstacleSize][i].charAt(j));
                }
            }
        }

        return map;
    }

    public void updateObstaclePosition(Road road) {
        if(obstacleLevel == 5) {
            obstacleSpeed++;
        }

        if(obstacleYPosition < road.getLength() - 1) {
            obstacleYPosition += obstacleSpeed;
        } else {
            obstacleXPosition = (int) Math.floor(Math.random() * 86);
            obstacleYPosition = 0;
            obstacleLevel += 1;
        }
    }

    public String[][] getObstacle() {
        return obstacleFrames;
    }

    public int getObstacleY() {
        return obstacleYPosition;
    }

    public int getObstacleX() {
        return obstacleXPercentage;
    }
}
