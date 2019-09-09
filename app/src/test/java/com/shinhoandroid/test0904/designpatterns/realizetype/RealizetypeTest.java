package com.shinhoandroid.test0904.designpatterns.realizetype;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/9/4 16:49
 */
public class RealizetypeTest {

    @Test
    public void print() throws CloneNotSupportedException{

            Realizetype obj1=new Realizetype();
            Realizetype obj2=(Realizetype)obj1.clone();
            System.out.println("obj1==obj2?"+(obj1==obj2));
            obj2.print();

    }
}