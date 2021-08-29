package com.berecci;

import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Getter
public class Place {

    private final Random r = new Random();
    private final List<Supplier<Enemy>> enemyFactories = List.of(() -> new Skeleton(), () -> new Orc());

    private String name;
    private Enemy currentEnemy;

    public Place(String name) {
        this.name = name;
    }

    void enter() {
        if (currentEnemy == null && r.nextDouble() > 0.5) {
            int randomEnemyIndex = r.nextInt(enemyFactories.size());
            Supplier<Enemy> enemySupplier = enemyFactories.get(randomEnemyIndex);
            currentEnemy = enemySupplier.get();
        }
    }

//    int counter = 0;
//    Enemy randomEnemy(int randomInt){
//        if(randomInt == ++counter) return new Skeleton();
//        if(randomInt == ++counter) return new Orc();
//    }

//    void wypisywacz(int liczba) {
//        System.out.println(liczba);
//        if(liczba > 5) return;
//        wypisywacz(liczba + 1);
//    }

//    @Override
//    public String toString() {
//        return name;
//    }
}