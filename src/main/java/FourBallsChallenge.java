import processing.core.PApplet;

import java.util.ArrayList;

public class FourBallsChallenge extends PApplet{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int DIAMETER = 20;
    private static final int TOTAL_NUMBER_OF_BALLS = 4;
    ArrayList<Integer> listOfBalls = new ArrayList<>();
    ArrayList<Float> heightsOfBalls = new ArrayList<>();
    public static void main(String[] args) {
        PApplet.main("FourBallsChallenge", args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        for (int ballNumber = 1; ballNumber <= TOTAL_NUMBER_OF_BALLS; ballNumber++) {
            listOfBalls.add(ballNumber - 1);
            heightsOfBalls.add((HEIGHT * ballNumber) / 5.0f);
        }
    }

    @Override
    public void draw() {
        for (int ballNumber = 1; ballNumber <= TOTAL_NUMBER_OF_BALLS; ballNumber++) {
            drawAndMoveBall(ballNumber);
        }
    }

    private void drawAndMoveBall(int ballNumber) {
        int width = getPreviousWidthOf(ballNumber);
        float height = getHeightOf(ballNumber);
        ellipse(width, height, DIAMETER, DIAMETER);
        changeWidthForNextMoveOf(ballNumber, width);
    }

    private void changeWidthForNextMoveOf(int ballNumber, int width) {
        listOfBalls.set(ballNumber - 1, width + ballNumber);
    }

    private float getHeightOf(int ballIndex) {
        return heightsOfBalls.get(ballIndex -1);
    }

    private int getPreviousWidthOf(int ballNumber) {
        return listOfBalls.get(ballNumber - 1);
    }
}
