package com.shinhoandroid.test0904.designpatterns.singlecase;

/**
 * @author Liupengfei
 * @describe 恶汉式
 * @date on 2019/9/4 16:28
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
