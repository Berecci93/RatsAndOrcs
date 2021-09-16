package com.berecci;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public class Action {
    private final String name;
    private final Runnable action;
    private final BooleanSupplier predicate;

//    public Action(String name, Runnable action, BooleanSupplier predicate) {
//        this.name = name;
//        this.action = action;
//        this.BooleanSupplier = predicate;
//    }
}
