package com.lintaostudy.demo.java.decorator;

/**
 * 版本：1.0
 * 创建日期：2021/5/12 19
 * 描述：装饰器组件
 */
public abstract class Food implements Animal {

    private Animal animal;

    public Food(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eat() {
        animal.eat();
    }
}
