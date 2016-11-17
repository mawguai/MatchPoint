package com.ghizzo.controller;

import com.ghizzo.model.GameScore;
import org.junit.Test;

import static com.ghizzo.util.GameScoreTestUtil.GameScoreComparison;
import static com.ghizzo.util.GameScoreTestUtil.createCustomGameScore;
import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    @Test
    public void test_initialization() {
        GameScore gameScore = new GameScore();
        GameScoreComparison(gameScore.getPlayer1(), 0, 0, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_classic_point() {
        GameScore gameScore = createCustomGameScore(1, 1, 2, 0, 3, 1, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 1, 3);
        GameScoreComparison(gameScore.getPlayer2(), 0, 3, 1);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_classic_tie_break_point() {
        GameScore gameScore = createCustomGameScore(1, 6, 4, 0, 6, 3, true);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 6, 5);
        GameScoreComparison(gameScore.getPlayer2(), 0, 6, 3);
        assertEquals(gameScore.isTieBreak(), true);
    }

    @Test
    public void test_tie_break_point_at_all_height() {
        GameScore gameScore = createCustomGameScore(1, 6, 8, 0, 6, 8, true);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 6, 9);
        GameScoreComparison(gameScore.getPlayer2(), 0, 6, 8);
        assertEquals(gameScore.isTieBreak(), true);
    }

    @Test
    public void test_classic_game_point() {
        GameScore gameScore = createCustomGameScore(0, 4, 3, 0, 2, 1, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 0, 5, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 2, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_deuce_point() {
        GameScore gameScore = createCustomGameScore(0, 2, 3, 0, 0, 3, false);
        gameScore.addPlayerPoint(2);
        GameScoreComparison(gameScore.getPlayer1(), 0, 2, 3);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 4);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_advantage_point() {
        GameScore gameScore = createCustomGameScore(1, 0, 4, 0, 0, 3, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 1, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_advantage_point_2() {
        GameScore gameScore = createCustomGameScore(1, 4, 3, 0, 1, 4, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 4, 3);
        GameScoreComparison(gameScore.getPlayer2(), 0, 1, 3);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_game_point_at_five_games() {
        GameScore gameScore = createCustomGameScore(1, 5, 4, 0, 5, 3, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 6, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 5, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_classic_set_point() {
        GameScore gameScore = createCustomGameScore(0, 5, 4, 0, 4, 3, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 0, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_set_point_at_six_games_1() {
        GameScore gameScore = createCustomGameScore(0, 6, 3, 0, 5, 2, false);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 0, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_set_point_at_six_games_2() {
        GameScore gameScore = createCustomGameScore(0, 6, 0, 0, 5, 3, false);
        gameScore.addPlayerPoint(2);
        GameScoreComparison(gameScore.getPlayer1(), 0, 6, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 6, 0);
        assertEquals(gameScore.isTieBreak(), true);
    }

    @Test
    public void test_set_point_during_tie_break_1() {
        GameScore gameScore = createCustomGameScore(0, 6, 6, 0, 6, 3, true);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 1, 0, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }

    @Test
    public void test_set_point_during_tie_break_2() {
        GameScore gameScore = createCustomGameScore(1, 6, 10, 0, 6, 9, true);
        gameScore.addPlayerPoint(1);
        GameScoreComparison(gameScore.getPlayer1(), 2, 0, 0);
        GameScoreComparison(gameScore.getPlayer2(), 0, 0, 0);
        assertEquals(gameScore.isTieBreak(), false);
    }
}
