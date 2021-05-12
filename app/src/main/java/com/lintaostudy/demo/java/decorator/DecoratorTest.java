package com.lintaostudy.demo.java.decorator;

/**
 * 版本：1.0
 * 创建日期：2021/5/12 20
 * 描述：
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Panda panda = new Panda();
        BambooFood bambooFood = new BambooFood(panda);
        CarrotFood carrotFood = new CarrotFood(bambooFood);
        carrotFood.eat();
    }
}
