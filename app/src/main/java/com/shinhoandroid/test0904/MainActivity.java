package com.shinhoandroid.test0904;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mdit.library.proxy.Enhancer;
import com.mdit.library.proxy.MethodInterceptor;
import com.mdit.library.proxy.MethodProxy;
import com.shinhoandroid.test0904.designpatterns.HelloWorldMaker;
import com.shinhoandroid.test0904.designpatterns.L;
import com.shinhoandroid.test0904.designpatterns.proxy.CglibProxyMethod;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void click1(View v){

       //new CglibProxyMethod().test(MainActivity.this);

        T1 cgTest = (T1)cgTest(MainActivity.this, new T1());
        cgTest.test1();
    }

    public void click2(View v){

        //dexMaker简单使用
//        try {
//            HelloWorldMaker.hello(MainActivity.this);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //new CglibProxyMethod().test2(MainActivity.this);
        L.e("---000--"+System.currentTimeMillis()+"---");
        T2 cgTest = (T2)cgTest(MainActivity.this, new T2());
        cgTest.test2();
        L.e("---111--"+System.currentTimeMillis()+"---");
        new T2().test2();
        L.e("---333--"+System.currentTimeMillis()+"---");
    }

    public Object cgTest(Context context,Object t){

        //因为需要Context,所以放在Activity中测试
        Enhancer enhancer = new Enhancer(context);
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                L.e("买房前准备");
                Object obj = methodProxy.invokeSuper(object, args);
                L.e("买房后装修");
                return obj;
            }
        });

        return enhancer.create();

    }

    public class T1{

        public void test1() {
            L.e("我要买房1");
        }
    }

    public class T2{

        public void test2() {
            L.e("我要买房2");
        }
    }
}
