package com.shinhoandroid.test0904.designpatterns.proxy;



import android.content.Context;
import android.util.Log;

import com.mdit.library.proxy.CallbackFilter;
import com.mdit.library.proxy.Enhancer;
import com.mdit.library.proxy.MethodInterceptor;
import com.mdit.library.proxy.MethodProxy;
import com.mdit.library.proxy.NoOp;
import com.shinhoandroid.test0904.designpatterns.L;

import java.lang.reflect.Method;


/**
 * @author Liupengfei
 * @describe JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需要CGLib了。
 * CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截
 * 所有父类方法的调用，顺势织入横切逻辑。但因为采用的是继承，所以不能对final修饰的类进行代理。
 * JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
 */
public class CglibProxyMethod {

    public void test(Context context){

        //因为需要Context,所以放在Activity中测试
        Enhancer enhancer = new Enhancer(context);
        enhancer.setSuperclass(BuyHouseImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                L.e("买房前准备");
                Object obj = methodProxy.invokeSuper(object, args);
                L.e("买房后装修");
                return obj;
            }
        });

        BuyHouseImpl buyHouse = (BuyHouseImpl) enhancer.create();

        buyHouse.buyHosue();

    }
    public void test2(Context context){



        //因为需要Context,所以放在Activity中测试
        Enhancer enhancer = new Enhancer(context);
        enhancer.setSuperclass(BuyHouseImpl.class);
        //给enhancer设置两个拦截器，一个不处理拦截，一个处理拦截
        enhancer.setCallbacks(new MethodInterceptor[]{NoOp.INSTANCE,new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {

                //object继承被代理类，不同于动态代理，动态代理继承Proxy，实现被代理的接口,
                L.e("买房前准备");
                Object obj = methodProxy.invokeSuper(object, args);
                L.e("买房后装修");
                return obj;
            }
        }
        });

        //设置拦截条件
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                L.e(method.getName());

                //返回的值为数字，代表了Callbacks数组中的索引位置，决定使用哪个Callback
                if (method.getName().equals("buyHosue2")){
                    return 0;
                }
                return 1;
            }
        });
        BuyHouseImpl buyHouse = (BuyHouseImpl) enhancer.create();

        buyHouse.buyHosue();

    }

    //需要代理的类一定要设置的public ,不然会报错
    public class BuyHouseImpl {

        public void buyHosue() {
            L.e("我要买房1");
        }

        public void buyHosue2() {
            L.e("我要买房2");
        }
    }


}
