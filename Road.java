public class Road {
    private String leftRoad = "//";
    private String rightRoad = "\\\\";

    private int roadLength;
    private int roadWidth;

    public int leftBound = 1;
    public int rightBound = 56;

    public Road(int roadLength) {
        this.roadLength = roadLength;
        this.roadWidth = roadLength / 2;
    }

    public String[][] initializeRoad() {
        String[][] road = new String[roadLength][];

        for (int i = 0; i < roadLength; i++) {
            int rowSize =(roadWidth + i - 2) * 2;
            String[] row = new String[rowSize];

            for (int j = 0; j < rowSize; j++) {
                row[j] = i % 3 != 0 && (j == rowSize / 3 || j == 2 * rowSize / 3) ? ":" : " ";
            }
            road[i] = row;
        }

        return road;
    }

    public int getWidth() {
        return this.roadWidth;
    }

    public int getLength() {
        return this.roadLength;
    }

    public String getLeftRoad() {
        return this.leftRoad;
    }

    public String getRightRoad() {
        return this.rightRoad;
    }
}
