package com.ghizzo.model;

public class GameScore {

    private PlayerScore player1, player2;
    private boolean tieBreak;

    public GameScore() {
        player1 = new PlayerScore();
        player2 = new PlayerScore();
        tieBreak = false;
    }

    public PlayerScore getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerScore player1) {
        this.player1 = player1;
    }

    public PlayerScore getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerScore player2) {
        this.player2 = player2;
    }

    public boolean isTieBreak() {
        return tieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        this.tieBreak = tieBreak;
    }

    public void reset() {
        getPlayer1().resetSet();
        getPlayer2().resetSet();
        tieBreak = false;
    }

    public void addPlayerPoint(int winnerId) {
        PlayerScore pointWinner;
        PlayerScore pointLooser;

        if (winnerId == 1) {
            pointWinner = player1;
            pointLooser = player2;
        } else {
            pointWinner = player2;
            pointLooser = player1;
        }

        if (!isTieBreak()) {
            if (pointWinner.getPoint() < 3) {
                pointWinner.addPoint();
                return;
            }
            if (pointWinner.getPoint() == 3) {
                computeThirdPointWin(pointWinner, pointLooser);
                return;
            }
            if (pointWinner.getPoint() == 4) {
                addGameWinningPoint(pointWinner, pointLooser);
                return;
            }
        } else {
            computeTieBreakPointWinner(pointWinner, pointLooser);
        }
    }

    private void computeTieBreakPointWinner(PlayerScore pointWinner, PlayerScore pointLooser) {
        if (pointWinner.getPoint() - pointLooser.getPoint() <= 0) {
            pointWinner.addPoint();
        } else {
            if (pointWinner.getPoint() < 6) {
                pointWinner.addPoint();
            } else {
                addSet(pointWinner, pointLooser);
            }
        }
    }

    private void computeThirdPointWin(PlayerScore pointWinner, PlayerScore pointLooser) {
        if (pointLooser.getPoint() == 3) {
            pointWinner.addPoint();
            return;
        }
        if (pointLooser.getPoint() > 3) {
            pointLooser.removePoint();
            return;
        }
        if (pointLooser.getPoint() < 3) {
            addGameWinningPoint(pointWinner, pointLooser);
            return;
        }
    }

    private void addGameWinningPoint(PlayerScore gameWinner, PlayerScore gameLooser) {
        if (gameWinner.getGame() < 5) {
            addGame(gameWinner, gameLooser);
            return;
        }
        if (gameWinner.getGame() == 5) {
            if (gameLooser.getGame() < 5) {
                addSet(gameWinner, gameLooser);
                return;
            }
            if (gameLooser.getGame() == 5) {
                addGame(gameWinner, gameLooser);
                return;
            }
            if (gameLooser.getGame() == 6) {
                addGame(gameWinner, gameLooser);
                setTieBreak(true);
                return;
            }
        }
        if (gameWinner.getGame() == 6) {
            addSet(gameWinner, gameLooser);
        }
    }

    private void addGame(PlayerScore winner, PlayerScore looser) {
        winner.winGame();
        looser.resetPoint();
    }

    private void addSet(PlayerScore winner, PlayerScore looser) {
        winner.winSet();
        looser.resetGame();
        looser.resetPoint();
        this.setTieBreak(false);
    }
}
