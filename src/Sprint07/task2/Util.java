package Sprint07.task2;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String date() default " today";

    String reviewer();
}


public class Util {

    public static String review(String className) throws ClassNotFoundException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());

        Class tempClass = Class.forName(className);
        Annotation[] annotations = tempClass.getAnnotations();

        return "Class " + className.getClass() + " was reviewed " + dateString + " by " + Arrays.toString(Review.class.getAnnotations());

    }
}
