package com.berecci;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orc extends Enemy {

//    static class Factory implements Enemy.Factory{
//        public Enemy getEnemy() {
//            return new Orc();
//        }
//    }

    String name="Orc";
    int hp = 200;
    int dmg = 200;
}
