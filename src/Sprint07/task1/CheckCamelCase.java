package Sprint07.task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {

}

class ClassForAnnot {
    @CamelCase()
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

public class CheckCamelCase {
    public static void main(String[] args) {
        checkAndPrint(Class1.class);
    }

    public final static String CAMELCASE_PATTERN = "^[a-z]+[a-zA-Z]*$";

    @SuppressWarnings("unchecked")
    public static boolean checkAndPrint(Class clazz) {

        Method[] methods = clazz.getMethods();
        boolean checkedFalse = false;

        for (Method reflectionMethods : methods) {
            CamelCase checkCamelCase = reflectionMethods.getAnnotation(CamelCase.class);
            if (checkCamelCase != null) {
                if (reflectionMethods.getName().matches(CAMELCASE_PATTERN))
                    checkedFalse = true;
                else {
                    String exception = "method " + clazz.getName() + "." + reflectionMethods.getName() + " doesn't satisfy camelCase naming convention";
                    System.out.println(exception);
                }

            }
        }
        return checkedFalse;
    }
}

    class Class1 {
        @CamelCase
        public void correct() {
        }

        @CamelCase
        public void InCorrect() {
        }

        @CamelCase
        public void JustMethod() {
        }
    }

    class Class2 {
        @CamelCase
        public void correct() {
        }

        @CamelCase
        public void oneMoreCorrect() {
        }
    }

