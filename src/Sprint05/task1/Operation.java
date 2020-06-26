package Sprint05.task1;

class Operation {
    public static int squareRectangle(int a, int b) throws IllegalArgumentException { //этот метод возможно выбросит такое исключение, в ходе метода может возникнуть ошибка, кр текст, таким образом обраюат. исключ. (контролируем)


        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");//если мы считаем, что программа рабоатет ошибочноЮ если пришли не в то состояние, которое должны, то выбрасывает исключ
        }
                return a * b;

    }

    public static int trySquareRectangle(int a, int b) {

        try { //пытается вызвать эту часть кода и надеемся что искл. не будкет выброшено
            return squareRectangle(a, b);
        }catch (IllegalArgumentException illegalArgumentException){ //но если вырошено, обрабатываем тут
            illegalArgumentException.getMessage();
        }
        return -1;
    }
}
