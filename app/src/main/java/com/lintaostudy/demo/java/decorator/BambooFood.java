package com.lintaostudy.demo.java.decorator;

/**
 * 版本：1.0
 * 创建日期：2021/5/12 20
 * 描述： 具体装饰
 */
public class BambooFood extends Food {

    public BambooFood(Animal animal) {
        super(animal);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("可以吃竹子");
    }
}
