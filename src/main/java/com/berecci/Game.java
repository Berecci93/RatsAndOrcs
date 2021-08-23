package com.berecci;

import lombok.Getter;

import javax.swing.*;
import java.util.List;

public class Game {
    private List<String> options = List.of("Go right", "Go left");
    private List<String> places = List.of("You are in a Dark Forest", "You are in the Field", "You are in the Desert");
    private int currentLocation = 0;
    @Getter
    private String actionResult = "";

    void action(int chosen) {
        actionResult = "";
        if (chosen == 0) {
            if (currentLocation + 1 > places.size() - 1) {
                actionResult = "You can't get there";
            } else {
                currentLocation++;
            }
        } else {
            if (currentLocation - 1 < 0) {
                actionResult = "You can't get there";
            } else {
                currentLocation--;
            }
        }
    }

    List<String> getMoves() {
        return options;
    }

    String getInfo() {
        return actionResult + "\n" + places.get(currentLocation);
    }

}
