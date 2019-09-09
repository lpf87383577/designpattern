package com.shinhoandroid.test0904.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Liupengfei
 * @describe 动态代理
 * 在动态代理中我们不再需要再手动的创建代理类，
 * 我们只需要编写一个动态处理器就可以了。真正的代理对象由JDK再运行时为我们动态的来创建
 * @date on 2019/9/6 10:05
 */
public class DynamicProxyMethod {

    public void test(){
        BuyHouseImpl buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                         Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));

        proxyBuyHouse.buyHosue();

    }


    public class DynamicProxyHandler implements InvocationHandler {

      private Object object;

      public DynamicProxyHandler(final Object object) {
            this.object = object;
      }

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              System.out.println("买房前准备");
              Object result = method.invoke(object, args);
              System.out.println("买房后装修");
              return result;
          }
    }

    interface BuyHouse{
        void buyHosue();
    }

    class BuyHouseImpl implements  BuyHouse{
        @Override
        public void buyHosue() {
               System.out.println("我要买房");
        }
    }
}
