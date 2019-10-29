package com.blue.fish.se.basis.serializ;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * <p>
 * <p>
 * transient使用小结
 * 1.一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2.transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3.被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 *
 * @author bluefish 2019-10-29
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends BaseSerialize {

    private static final long serialVersionUID = 1L;
    private int employeeId;
    private String employeeName;
    /**
     * 使用transient关键字，表示该字段不序列化
     */
    private transient String department;

    private Long id;


}