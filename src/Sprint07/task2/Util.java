package Sprint07.task2;

import java.lang.annotation.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String date() default "today";

    String reviewer();
}


public class Util {

    public static void review(String className) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());

        try {
            Class<?> tempClass = Class.forName(className);
            Annotation annotation = tempClass.getAnnotation(Review.class);
            if (annotation == null) {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            } else {
                if (((Review) annotation).date().equals("today")) {
                    System.out.println("Class " + className + " was reviewed " + LocalDate.now() + " by " + ((Review) annotation).reviewer() + ".");
                } else
                    System.out.println("Class " + className + " was reviewed " + ((Review) annotation).date() + " by " + ((Review) annotation).reviewer() + ".");

            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }


    }
}
