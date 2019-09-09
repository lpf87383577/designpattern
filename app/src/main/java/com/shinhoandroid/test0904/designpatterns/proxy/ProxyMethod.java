package com.shinhoandroid.test0904.designpatterns.proxy;

/**
 * @author Liupengfei
 * @describe 代理模式
 * 由于某些原因需要给某对象提供一个代理以控制对该对象的访问。
 * 这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
 * @date on 2019/9/6 9:59
 */
//静态代理
public class ProxyMethod {

   public  void test(){
       Proxy proxy=new Proxy();
       proxy.Request();
   }

    //抽象主题
    interface Subject {
        void Request();
    }

    //真实主题
    class RealSubject implements Subject {

        @Override
        public void Request() {
            System.out.println("访问真实主题方法...");
        }
    }

    //代理
    class Proxy implements Subject {
        private RealSubject realSubject;
        @Override
        public void Request() {
            if (realSubject==null){
                realSubject=new RealSubject();
            }
            preRequest();
            realSubject.Request();
            postRequest();
        }
        public void preRequest() {
            System.out.println("访问真实主题之前的预处理。");
        }
        public void postRequest() {
            System.out.println("访问真实主题之后的后续处理。");
        }
    }
}
