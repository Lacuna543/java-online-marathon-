package Sprint01.task1;



class Main {
    public long operation(int...nums){
        return nums[0] + nums[1];
    }
    public long operation(long num1, long num2){
        return num1-num2;
    }
    public static void main(String[] args) {
        Main m = new Main();
        long result = m.operation(5,3);
        System.out.println(result);
    }
}
