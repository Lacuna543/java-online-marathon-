package Sprint07.task3;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TestSuite {
    String[] value();
}

public class TestSuitHandler {
    @SuppressWarnings("unchecked")
    public static void run(Class clazz) {
        Annotation annotation = clazz.getAnnotation(TestSuite.class);
        if (annotation == null) {
            System.out.println("Class " + clazz.getName() + " isn't annotated");
        } else
            for (String element : ((TestSuite) annotation).value()) {
                try {
                    Method method = clazz.getMethod(element);
                    if (method.getParameterCount() == 0 &&
                            Modifier.isPublic(method.getModifiers()) &&
                            !Modifier.isStatic(method.getModifiers())) {
                        System.out.println("\t -- Method " + clazz.getName() + '.' + method.getName() + " started --");
                        method.invoke(clazz.getDeclaredConstructor().newInstance()); //вызывает объект внутри класса
                        System.out.println("\t -- Method " + clazz.getName() + '.' + method.getName() + " finished --");
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("Method with name " + element + " doesn't exists or not public in class " + clazz.getName());
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }

    }
}
