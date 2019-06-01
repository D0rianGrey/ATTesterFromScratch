package ToNinja.Lesson152_First_TestNG_Class_Test_Annotation;

import org.testng.annotations.Test;

public class TestNG_TestAnnotation {

    @Test
    public void testMethod1() {
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1, 2);
        System.out.println("Running Test -> testMethod1");
        System.out.println("Result " + result);
    }

    @Test
    public void testMethod2() {
        System.out.println("Running Test -> testMethod2");
    }

    @Test
    public void testMethod3() {
        System.out.println("Running Test -> testMethod3");
    }
}