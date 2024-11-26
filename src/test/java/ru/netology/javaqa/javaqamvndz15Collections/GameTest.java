package ru.netology.javaqa.javaqamvndz15Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(15, "Alex", 100);
    Player player2 = new Player(51, "Olga", 150);
    Player player3 = new Player(45, "Gleb", 100);

    @Test
    public void shouldWinFirstStrongPlayer() {
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Alex", "Olga"));
    }

    @Test
    public void shouldWinSecondStrongPlayer() {
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(1, game.round("Olga", "Gleb"));
    }

    @Test
    public void shouldNotWinIfEqual() {
        game.register(player1);
        game.register(player3);

        Assertions.assertEquals(0, game.round("Alex", "Gleb"));
    }

    @Test
    public void shouldNotFindUnregisteredPlayerName1() {

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Gleb", "Olga");
        });
    }

    @Test
    public void shouldNotFindUnregisteredPlayerName2() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Igor");
        });
    }

}
