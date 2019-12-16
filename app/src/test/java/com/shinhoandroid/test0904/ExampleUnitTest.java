package com.shinhoandroid.test0904;

import com.mdit.library.dx.BinaryOp;
import com.mdit.library.dx.Code;
import com.mdit.library.dx.DexMaker;
import com.mdit.library.dx.FieldId;
import com.mdit.library.dx.Local;
import com.mdit.library.dx.MethodId;
import com.mdit.library.dx.TypeId;
import com.shinhoandroid.test0904.designpatterns.Adapter.AdapterMethod;
import com.shinhoandroid.test0904.designpatterns.build.BuilderMethod;
import com.shinhoandroid.test0904.designpatterns.chainofresponsibility.ResponsibilityMethod;
import com.shinhoandroid.test0904.designpatterns.decorator.DecoratorMethod;
import com.shinhoandroid.test0904.designpatterns.observer.ObserverMethod;
import com.shinhoandroid.test0904.designpatterns.proxy.CglibProxyMethod;
import com.shinhoandroid.test0904.designpatterns.proxy.DynamicProxyMethod;
import com.shinhoandroid.test0904.designpatterns.proxy.ProxyMethod;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

//        BuilderMethod builderMethod = new BuilderMethod();
//        builderMethod.mClient.test();
       new DynamicProxyMethod().test();

//        new ResponsibilityMethod().test();

    }




}