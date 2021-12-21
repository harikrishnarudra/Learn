package com.practice.learn;

import com.practice.model.Fruit;

abstract class superAbstract{
     protected abstract void doSomething(Fruit fruit);
    }

public class AbstractMethodTest extends superAbstract {
    @Override
    protected void doSomething(final Fruit fruit) {

    }
}
