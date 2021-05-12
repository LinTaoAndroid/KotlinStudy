package com.lintaostudy.demo.java.decorator;

/**
 * 版本：1.0
 * 创建日期：2021/5/12 20
 * 描述： 具体装饰
 */
public class CarrotFood extends Food {

    public CarrotFood(Animal animal) {
        super(animal);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("可以吃胡罗卜");
    }
}
