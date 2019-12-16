package com.shinhoandroid.test0904.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Liupengfei
 * @describe 动态代理
 * 在动态代理中我们不再需要再手动的创建代理类，
 * 我们只需要编写一个动态处理器就可以了。真正的代理类和代理对象由JDK再运行时为我们动态的来创建
 * @date on 2019/9/6 10:05
 */
public class DynamicProxyMethod {

    public void test(){
        //创建要代理的对象
        BuyHouseImpl buyHouse = new BuyHouseImpl();
        //将对象和接口传给动态代理类，在运行时生成新的类，这个类extend Proxy，implements BuyHouse,并且返回这个类的实例，所以动态代理只能代理接口，（已经继承了Proxy类）
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                         Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        //实例在执行buyHosue方法时，会调用DynamicProxyHandler.invoke方法
        proxyBuyHouse.buyHosue();

    }


    public class DynamicProxyHandler implements InvocationHandler {

      private Object object;

      public DynamicProxyHandler(final Object object) {
            this.object = object;
      }

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //这个proxy就是新生成的类的对象，打印看一下父类和实现的接口
          System.out.println(proxy.getClass().getSuperclass().toString());
          Class<?>[] interfaces = proxy.getClass().getInterfaces();
          System.out.println(interfaces[0].toString());

              System.out.println("买房前准备");
              //执行被代理对象的方法
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
