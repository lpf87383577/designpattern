package com.shinhoandroid.test0904.designpatterns.build;

/**
 * @author Liupengfei
 * @describe 建造者模式
 * 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * 它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。
 * 它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 * @date on 2019/9/6 9:35
 */
public class BuilderMethod {

    class Product {
        private String partA;
        private String partB;
        private String partC;
        public void setPartA(String partA) {
            this.partA=partA;
        }
        public void setPartB(String partB) {
            this.partB=partB;
        }
        public void setPartC(String partC) {
            this.partC=partC;
        }
        public void show() {
            //显示产品的特性
            System.out.println("partA="+partA+"\npartB="+partB+"\npartC="+partC);
        }
    }

    abstract class Builder {
        //创建产品对象
        protected Product product=new Product();
        public abstract void buildPartA();
        public abstract void buildPartB();
        public abstract void buildPartC();
        //返回产品对象
        public Product getResult() {
            return product;
        }
    }


    public class ConcreteBuilder extends Builder {
        @Override
        public void buildPartA() {
            product.setPartA("建造 PartA");
        }
        @Override
        public void buildPartB() {
            product.setPartB("建造 PartB");
        }
        @Override
        public void buildPartC() {
            product.setPartC("建造 PartC");
        }
    }

    //指挥者
    class Director {
        private Builder builder;
        public Director(Builder builder) {
            this.builder=builder;
        }
        //产品构建与组装方法
        public Product construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }

    public Client mClient = new Client();

    public  class Client {

        public  void test() {
            Builder builder=new ConcreteBuilder();
            Director director=new Director(builder);
            Product product=director.construct();
            product.show();
        }
    }


}
