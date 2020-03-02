package com.blue.fish.se.basis.inner.clazz;

/**
 * 成员内部类的继承语法格式要求继承引用方式为 Outter.Inner 形式且继承类的构造器中必须有指向外部类对象的引用，
 * 并通过这个引用调用 super()，其实这个要求就是因为成员内部类默认持有外部类的引用，外部类不先实例化则无法实例化自己
 *
 * @author bluefish 2019-07-09
 * @version 1.0.0
 */
public class VariableInnerClassExtends extends VariableInnerClass.InnerClass {

    public VariableInnerClassExtends(VariableInnerClass variableInnerClass) {
        variableInnerClass.super();
    }

}
