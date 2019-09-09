package com.shinhoandroid.test0904.designpatterns.Adapter;

/**
 * @author Liupengfei
 * @describe Adapter模式 将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 * 适配器模式分为类结构型模式和对象结构型模式两种，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 * @date on 2019/9/6 15:48
 */
public class AdapterMethod {

    public void test(){
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }


    interface Target {

        public void request();
    }
    //适配者接口
    class Adapter {
        public void specificRequest() {
            System.out.println("适配者中的业务代码被调用！");
        }
    }
    //类适配器类
    class ClassAdapter extends Adapter implements Target {
        @Override
        public void request() {
            specificRequest();
        }
    }

}
