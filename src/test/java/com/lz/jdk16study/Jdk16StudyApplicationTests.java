package com.lz.jdk16study;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import com.lz.jdk16study.service.impl.PrivateLnterfaceImpl;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Jdk16StudyApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * var 类型推断 | since jdk10
     * var 是 Java10 版本中新出的特性，
     * 用它来定义局部变量。var 不是关键字，
     * 相当于一种动态类型，编译器根据变量所赋的值来推断类型。
     * 所以必须在定义变量的时候赋初始值。
     */
    @Test
    void testJDK10VarLocalVariable() {
        var num1 = 1000;
        var num2 = 1.001;
        var str = "hello var";
        var list = new ArrayList<>();
        var map = new HashMap<>();
    }

    //---------------------------------------------------------------

    /**
     * 文本块 | since jdk13
     * 在我们日常的工作中，有时候需要用到一大段的字符串，这
     * 些字符串需要换行，需要排版，需要转义。在一个文本编辑器中，这当然是非常容易的事情。
     * 但是在 java 代码中，就是一个噩梦了。而新的文本块使用"""这个符号，进行拼接。
     *
     * 简化表达多行字符串，不需要转义；
     * 增强可读性；
     */
    @Test
    public void testNormalString(){
        String text = "{" + "\n"
                +"    \"username\": \"lengleng\",\n"
                +"    \"password\": \"123456\" \n"
                +"}";
        System.out.println(text);
    }


    @Test
    public void testNewJdk13TextBlock(){

        var text = """
                  {
                "username": "lengleng",
                 "password": "123456"
                  }""";

        System.out.println(text);

    }

    //------------------------------------------------

    /**
     * switch 表达式 | since jdk12
     * jdk12 可以通过的 switch 表达式简化逻辑
     */
    @Test
    public void testNewJdk12MultiSwitch(){
        var day = 2;

        switch (day){
            case 1,2,3,4,5 -> System.out.println("workday");
            case 6,7 -> System.out.println("weekend");
            default -> System.out.println("invalid");
        }
    }


    //----------------------------

    /**
     * 集合工厂 | since jdk9
     * 通常希望在代码中创建一个集合（例如，List 或 Set ），并直接用一些元素填充它。实例化集合，
     * 几个 “add” 调用，使得代码重复。
     * 现在可以通过 of 方法来快速构建集合类型
     *
     */
    @Test
    public void testNewJdk9(){

        var fruits = List.of("apple", "banana", "orange");
        var numbers = Map.of(1, "one", 2, "two", 3, "three");

        System.out.println(JSONUtil.toJsonPrettyStr(fruits));
        System.out.println(JSONUtil.toJsonPrettyStr(numbers));


    }

    //----------------------------------------------

    /**
     * record 记录 | since jdk14
     * Records 的目标是扩展 Java 语言语法，Records 为声明类提供了一种紧凑的语法，
     * 用于创建一种类中是“字段，只是字段，除了字段什么都没有”的类。
     * 通过对类做这样的声明，编译器可以通过自动创建所有方法并让所有字段参与 hashCode()等方法。
     * 干掉 lombok 只需要通过 record 声明即可完成实体字段的 get 和构造器方法。
     */
    public record Demo(String name,String password){

    }

    @Test
    public void testJdk15Record(){

        var lz = new Demo("lz", "123");
        System.out.println(lz.name);
        System.out.println(lz.getClass());
        System.out.println(lz.password());
    }

    public interface PrivateInterface {

        private void printF(){
            System.out.println("lengleng");
        }

        default void getPassword(){
            printF();
            System.out.println("123456");
        }
    }

    //------------------------------


    /**
     * 接口私有方法 | since jdk9
     * Java8 带来了许多改变，其中之一就是 default 修饰的接口方法。
     * 这些方法改变了我们已知的接口，现在我们能够在接口中定义默认实现方法。
     * 如果你大量使用 default 方法在你的应用接口中，现在可以通过 JDK9 的接口私有方法来重构。
     */
    @Test
    public void testGetPassword(){
        var privateInterface = new PrivateLnterfaceImpl();

        privateInterface.getPassword();
    }

    //-------------------------------------




}



