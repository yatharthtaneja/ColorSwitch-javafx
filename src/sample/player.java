package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class player implements Serializable {
    private static final long serialVersionUID= 1l;
    private int score;
    private double ballX;
    private double ballY;
    private ArrayList<Integer> ObstacleType= new ArrayList<>();
    private ArrayList<Double> ObsatcleXcord = new ArrayList<>();
    private ArrayList<Double> ObsatcleYcord = new ArrayList<>();

    public double getBallX() {
        return ballX;
    }

    public double getBallY() {
        return ballY;
    }

    public int getcurrScore() {
        return score;
    }

    public void setBallX(double ballX) {
        this.ballX = ballX;
    }

    public void setBallY(double ballY) {
        this.ballY = ballY;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addType(int type){
        this.ObstacleType.add(type);
    }
    public void addXcord(double type){
        this.ObsatcleXcord.add(type);
    }
    public void addYcord(double type){
        this.ObsatcleYcord.add(type);
    }
    public int getObsType(int i){
        return ObstacleType.get(i);
    }
    public double getObsX(int i){
        return ObsatcleXcord.get(i);
    }
    public double getObsY(int i){
        return ObsatcleYcord.get(i);
    }
    public int getSize(){
        return ObsatcleXcord.size();
    }
}
