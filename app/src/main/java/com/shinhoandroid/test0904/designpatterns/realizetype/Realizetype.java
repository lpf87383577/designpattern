package com.shinhoandroid.test0904.designpatterns.realizetype;

/**
 * @author Liupengfei
 * @describe 原型模式
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆
 * @date on 2019/9/4 16:44
 */
public class Realizetype implements Cloneable{

    public void print(){

        System.out.print("我是模型类");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Realizetype)super.clone();
    }

    //     测试
//    Realizetype obj1=new Realizetype();
//    Realizetype obj2=(Realizetype)obj1.clone();
//    System.out.println("obj1==obj2?"+(obj1==obj2));

}
