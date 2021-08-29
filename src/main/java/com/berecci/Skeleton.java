package com.berecci;

import lombok.Getter;

@Getter
public class Skeleton extends Enemy {

//    static class Factory implements Enemy.Factory{
//        public Enemy getEnemy() {
//            return new Skeleton();
//        }
//    }


    String name="Skeleton";

    int hp = 100;
    int dmg = 150;

}
