package com.shinhoandroid.test0904.designpatterns.factorymethod;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/9/4 17:48
 */
public class FactoryMethod {

    //抽象产品
    interface Product {
        public void show();
    }
    //具体产品1：实现抽象产品中的抽象方法
    class ConcreteProduct1 implements Product {
        @Override
        public void show()
        {
            System.out.println("具体产品1显示...");
        }
    }
    //具体产品2：实现抽象产品中的抽象方法
    class ConcreteProduct2 implements Product {
        @Override
        public void show()
        {
            System.out.println("具体产品2显示...");
        }
    }

    //抽象工厂：提供了厂品的生成方法
    interface AbstractFactory {

         Product newProduct();
    }

    //具体工厂1：实现了厂品的生成方法
    class ConcreteFactory1 implements AbstractFactory {
        @Override
        public Product newProduct() {
            System.out.println("具体工厂1生成-->具体产品1...");
            return new ConcreteProduct1();
        }
    }
    //具体工厂2：实现了厂品的生成方法
    class ConcreteFactory2 implements AbstractFactory {
        @Override
        public Product newProduct() {
            System.out.println("具体工厂2生成-->具体产品2...");
            return new ConcreteProduct2();
        }
    }


}
