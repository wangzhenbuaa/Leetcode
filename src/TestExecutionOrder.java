public class TestExecutionOrder {
    static int n;
    static int m = n + 1;

    //成员变量的赋值顺序在main()函数之前
    private static void print() {
        n = 4;
        System.out.println(m);
    }

    public static void main(String[] args) {
        n = 2;
        System.out.println(m);//m==1
        print();
    }
}
