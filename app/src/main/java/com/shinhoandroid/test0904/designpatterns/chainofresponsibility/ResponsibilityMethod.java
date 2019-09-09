package com.shinhoandroid.test0904.designpatterns.chainofresponsibility;

/**
 * @author Liupengfei
 * @describe 责任链（Chain of Responsibility）模式的定义：为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 * @date on 2019/9/6 17:17
 */
public class ResponsibilityMethod {

    public void test(){

        //组装责任链
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }

    //抽象处理者角色
    abstract class Handler {
        private Handler next;
        public void setNext(Handler next) {
            this.next=next;
        }
        public Handler getNext() {
            return next;
        }
        //处理请求的方法
        public abstract void handleRequest(String request);
    }

    //具体处理者角色1
    class ConcreteHandler1 extends Handler {

        @Override
        public void handleRequest(String request) {
            if(request.equals("one")) {
                System.out.println("具体处理者1负责处理该请求！");
            }
            else {
                if(getNext()!=null) {
                    getNext().handleRequest(request);
                } else {
                    System.out.println("没有人处理该请求！");
                }
            }
        }
    }

    //具体处理者角色2
    class ConcreteHandler2 extends Handler {

        @Override
        public void handleRequest(String request) {
            if(request.equals("two")) {
                System.out.println("具体处理者2负责处理该请求！");
            }
            else {
                if(getNext()!=null) {
                    getNext().handleRequest(request);
                } else {
                    System.out.println("没有人处理该请求！");
                }
            }
        }
    }

}
