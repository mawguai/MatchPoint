package com.ghizzo.controller;

import com.ghizzo.model.GameScore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    private GameScore gameScore = new GameScore();

    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public GameScore getScore() {
        return gameScore;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public void initGame() {
        gameScore.reset();
    }

    @RequestMapping(value = "/winner/{winner}", method = RequestMethod.GET)
    public GameScore changeScore(
            @PathVariable int winner
    ) {
        gameScore.addPlayerPoint(winner);
        return gameScore;
    }
}
