package Sprint03.task4;


enum LineType {
    SOLID, DOTTED, DASHED, DOUBLE;


}


public class Test {

    public static void main(String[] args) {
        System.out.println(drawLine(LineType.SOLID));
    }
    public static String drawLine(LineType lineType) {

        // Write method code here
        //“The line is <LineType> type”.

        return "The line is " + lineType.toString().toLowerCase() + " type";

    }
}
