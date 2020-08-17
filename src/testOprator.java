public class testOprator {
    private static boolean print() {
        System.out.println("ok");
        return false;
    }

    public static void main(String[] args) {
        boolean flag1 = true, flag2 = true, flag3 = false;
        //逻辑或运算符当确定其中一个式子为true时，不计算另一个式子
        System.out.println("--------1--------");
        flag1 = flag1 || print();
        System.out.println("--------2--------");
        flag2 = flag2 || print();
        System.out.println("--------3--------");
        flag3 = flag3 || print();
    }
}
