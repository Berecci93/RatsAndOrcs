package com.berecci;

import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

public class Game {
    private int currentLocation = 0;
    //    private List<String> options = List.of("Go right", "Go left", "Attack");
    private List<Place> places = List.of(new Place("the City"), new Place("the Forest"), new Place("the Field"), new Place("the Desert"), new Place("Caves"));

    private List<Action> actions = List.of(
            new Action("go right", () -> currentLocation++, () -> currentLocation + 1 < places.size()),
            new Action("go left", () -> currentLocation--, () -> currentLocation - 1 >= 0),
            new Action("attack", this::attackAction, () -> getCurrentEnemy() != null)
    );

    @Getter
    private String actionResult = "";

    void startTurn() {
        places.get(currentLocation).enter();
    }

    void attackAction() {
        Enemy currentEnemy = getCurrentEnemy();
        currentEnemy.setHp(currentEnemy.getHp() - 30);
        if(currentEnemy.getHp()<=0){
            places.get(currentLocation).setCurrentEnemy(null);
            actionResult=currentEnemy.getName()+" has been killed";
        }

    }

    List<Action> getFilteredActions() {
        return actions.stream()
                .filter((action) -> action.getPredicate().getAsBoolean())
                .toList();
    }

    void executeAction(int chosen) {
    }

//    void action(int chosen) {
//        actionResult = "";
//        startTurn();
//        if (chosen == 0) {
//            if (currentLocation + 1 > places.size() - 1) {
//                actionResult = "You can't get there";
//            } else {
//                currentLocation++;
//            }
//
//        } else if (chosen == 1) {
//            if (currentLocation - 1 < 0) {
//                actionResult = "You can't get there";
//            } else {
//                currentLocation--;
//            }
//        } else if (chosen == 2) {
//            actionResult = "You attacked an enemy";
//
//        }
//    }
//    private Predicate<?> checkIfEnemyIsDead(){
//        Enemy currentEnemy=getCurrentEnemy();
//        if(currentEnemy.getHp()<=0){
//            return currentEnemy=null;
//
//        }
//    }

    String getInfo() {
        String finalInfo=actionResult + "\n" + "You are in " + places.get(currentLocation).getName() + "\n" + getEnemyInfo();
        actionResult="";
        return finalInfo;
    }

    private String getEnemyInfo() {
        Enemy currentEnemy = getCurrentEnemy();
        if (currentEnemy == null) {
            return "";
        }
        return currentEnemy.getName() +
                " appears with hp: " + currentEnemy.getHp() + " and dmg: " + currentEnemy.getDmg();
    }

    private Enemy getCurrentEnemy() {
        return places.get(currentLocation).getCurrentEnemy();
    }


}
