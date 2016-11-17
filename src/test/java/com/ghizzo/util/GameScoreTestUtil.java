package com.ghizzo.util;

import com.ghizzo.model.GameScore;
import com.ghizzo.model.PlayerScore;

import static org.junit.Assert.assertEquals;

public class GameScoreTestUtil {

    public static GameScore createCustomGameScore(int p1Set, int p1Game, int p1Point, int p2Set, int p2Game, int p2Point, boolean tieBreak) {
        GameScore gameScore = new GameScore();
        gameScore.setTieBreak(tieBreak);

        PlayerScore p1 = gameScore.getPlayer1();
        p1.setSet(p1Set);
        p1.setGame(p1Game);
        p1.setPoint(p1Point);

        PlayerScore p2 = gameScore.getPlayer2();
        p2.setSet(p2Set);
        p2.setGame(p2Game);
        p2.setPoint(p2Point);

        return gameScore;
    }

    public static void GameScoreComparison(PlayerScore player, int expectedSet, int expectedGame, int expectedPoint) {
        assertEquals(player.getSet(), expectedSet);
        assertEquals(player.getGame(), expectedGame);
        assertEquals(player.getPoint(), expectedPoint);
    }

}
