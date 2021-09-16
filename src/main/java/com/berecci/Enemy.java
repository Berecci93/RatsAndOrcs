package com.berecci;

public abstract class Enemy {

//    interface Factory {
//        Enemy getEnemy();
//    }

    public abstract String getName();

    public abstract int getHp();

    public abstract void setHp(int hp);

    public abstract int getDmg();
}
