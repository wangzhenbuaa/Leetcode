public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append(555);
        str.append("->");
        str.append("->");
        str.append("666");
        System.out.println(str.lastIndexOf("->"));
        System.out.println(str.lastIndexOf("66"));
        System.out.println(str.length());
        System.out.println(str.lastIndexOf("."));
        System.out.println("----------------------------");
        StringBuilder str2 = new StringBuilder();
        str2.append(2);
        System.out.println(str2);
        str2.append(0);
        System.out.println(str2);
        //0开头的整数会认为是八进制
        System.out.println(String.valueOf(010));
        System.out.println(String.valueOf(022));
        System.out.println("----------------------");
        String str3 = "hhah.hsh";
        System.out.println(str3);
        String[] str4 = str3.split("\\.");
        for (int i = 0; i < str4.length; i++) {
            System.out.println(str4[i]);
        }
    }
}
