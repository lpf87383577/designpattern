package com.shinhoandroid.test0904.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liupengfei
 * @describe 观察者（Observer）模式
 * 指多个对象间存在一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * 这种模式有时又称作发布-订阅模式、模型-视图模式，它是对象行为型模式。
 * @date on 2019/9/6 16:59
 */
public class ObserverMethod {

    public void test(){

        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();

    }


    //抽象目标
    abstract class Subject {
        protected List<Observer> observers=new ArrayList<Observer>();
        //增加观察者方法
        public void add(Observer observer) {
            observers.add(observer);
        }
        //删除观察者方法
        public void remove(Observer observer) {
            observers.remove(observer);
        }
        public abstract void notifyObserver(); //通知观察者方法
    }
    //具体目标
    class ConcreteSubject extends Subject {
        @Override
        public void notifyObserver() {
            System.out.println("具体目标发生改变...");
            System.out.println("--------------");

            for(Object obs:observers) {
                ((Observer)obs).response();
            }
        }
    }
    //抽象观察者
    interface Observer {
        void response(); //反应
    }
    //具体观察者1
    class ConcreteObserver1 implements Observer {
        @Override
        public void response() {
            System.out.println("具体观察者1作出反应！");
        }
    }
    //具体观察者1
    class ConcreteObserver2 implements Observer {
        @Override
        public void response() {
            System.out.println("具体观察者2作出反应！");
        }
    }
}
