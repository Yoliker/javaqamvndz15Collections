package ru.netology.javaqa.javaqamvndz15Collections;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player" + playerName1 + "is not registered!"
            );
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player" + playerName2 + "is not registered!");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName2).getStrength() > findByName(playerName1).getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }


}
