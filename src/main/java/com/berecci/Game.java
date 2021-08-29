package com.berecci;

import lombok.Getter;

import java.util.List;

public class Game {
    private List<String> options = List.of("Go right", "Go left", "Attack");
    private List<Place> places = List.of(new Place("the City"), new Place("the Forest"), new Place("the Field"), new Place("the Desert"), new Place("Caves"));

    private int currentLocation = 0;

    @Getter
    private String actionResult = "";

    void startTurn() {
        places.get(currentLocation).enter();
    }

    void action(int chosen) {
        actionResult = "";
        startTurn();
        if (chosen == 0) {
            if (currentLocation + 1 > places.size() - 1) {
                actionResult = "You can't get there";
            } else {
                currentLocation++;
            }

        } else if (chosen == 1) {
            if (currentLocation - 1 < 0) {
                actionResult = "You can't get there";
            } else {
                currentLocation--;
            }
        } else if (chosen == 2) {
            actionResult = "You attacked an enemy";

        }
    }

    List<String> getMoves() {
        return options;
    }

    String getInfo() {
        return actionResult + "\n" + "You are in " + places.get(currentLocation).getName() + "\n" + getEnemyInfo();
    }

    private String getEnemyInfo() {
        Enemy currentEnemy = getCurrentEnemy();
        if(currentEnemy ==null){
            return "";
        }
        return currentEnemy.getName() +
                " appears with hp: " + currentEnemy.getHp() + " and dmg: " + currentEnemy.getDmg();
    }

    private Enemy getCurrentEnemy() {
        return places.get(currentLocation).getCurrentEnemy();
    }


}
