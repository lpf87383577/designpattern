package com.shinhoandroid.test0904.designpatterns.bridge;

/**
 * @author Liupengfei
 * @describe 桥接模式
 * 将抽象与实现分离，使它们可以独立变化。
 * 它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 * 桥接模式通常适用于以下场景。
 * 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 * 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 * 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。
 * @date on 2019/9/6 16:02
 */
public class BridgeMethod {

    public void test(){

        Implementor imple=new ConcreteImplementorA();
        Abstraction abs=new RefinedAbstraction(imple);
        abs.Operation();

    }


    //实现化角色
    interface Implementor {
        public void OperationImpl();
    }

    //具体实现化角色
    class ConcreteImplementorA implements Implementor {
        @Override
        public void OperationImpl() {
            System.out.println("具体实现化(Concrete Implementor)角色被访问" );
        }
    }

    //抽象化角色
    abstract class Abstraction {
        protected Implementor imple;
        protected Abstraction(Implementor imple) {
            this.imple=imple;
        }
        public abstract void Operation();
    }

    //扩展抽象化角色
    class RefinedAbstraction extends Abstraction {
        protected RefinedAbstraction(Implementor imple) {
            super(imple);
        }
        @Override
        public void Operation() {
            System.out.println("扩展抽象化(Refined Abstraction)角色被访问" );
            imple.OperationImpl();
        }
    }
}
