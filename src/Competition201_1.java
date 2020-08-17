public class Competition201_1 {
    public static String makeGood(String s) {
        int val = Math.abs('A' - 'a');
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == val) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    flag = true;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(makeGood(""));
    }
}
