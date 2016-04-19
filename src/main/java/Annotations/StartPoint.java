package Annotations;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.annotation.*;
import java.util.Arrays;

/*
 *http://tutorials.jenkov.com/java-reflection/annotations.html
 */

@Data
@AllArgsConstructor
@MyAnn(name = "brix", val = "11")
class A {
    int a,b;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnn {
    public String name();
    public String val();
}



public class StartPoint {
    public static void main(String[] args) {
        A a = new A(1, 2);

        System.out.println(Arrays.toString(a.getClass().getAnnotations()));
        //res: @Annotations.MyAnn(name=brix,val=11)

        //getting the params:
        Annotation annotation = a.getClass().getAnnotation(MyAnn.class);

        if(annotation instanceof MyAnn){
            MyAnn myAnnotation = (MyAnn) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("val: " + myAnnotation.val());
        }
    }
}
