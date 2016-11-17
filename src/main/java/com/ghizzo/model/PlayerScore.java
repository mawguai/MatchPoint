package com.ghizzo.model;

public class PlayerScore {

    private int set;
    private int game;
    private int point;

    public PlayerScore() {
        this.game = 0;
        this.set = 0;
        this.point = 0;
    }

    public int getGame() {
        return game;
    }

    public int getSet() {
        return set;
    }

    public int getPoint() {
        return point;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void resetSet() {
        this.set = 0;
        this.game = 0;
        this.point = 0;
    }

    public void resetGame() {
        this.game = 0;
        this.point = 0;
    }

    public void resetPoint() {
        this.point = 0;
    }

    public void winGame() {
        this.game = this.game + 1;
        resetPoint();
    }

    public void winSet() {
        this.set = this.set + 1;
        resetGame();
    }

    public void addPoint() {
        this.point = this.point + 1;
    }

    public void removePoint() {
        if (this.point != 4) throw new IllegalStateException("Can't remove point from a non advantage situation");
        this.point = this.point - 1;
    }
}
