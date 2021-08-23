package com.berecci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void checkIfBlockedIfWentLeftOnce() {
        Game game = new Game();
        game.action(1);
        assertEquals("You can't get there", game.getActionResult());
    }

    @Test
    void checkIfOkIfWentRightTwice() {
        Game game = new Game();
        game.action(0);
        game.getInfo();
        game.action(0);
        game.getInfo();
        assertEquals("", game.getActionResult());
    }

    @Test
    void checkIfBlockedIfWentRightThrice() {
        Game game = new Game();
        game.action(0);
        game.getInfo();
        game.action(0);
        game.getInfo();
        game.action(0);
        game.getInfo();
        assertEquals("You can't get there", game.getActionResult());
    }
}