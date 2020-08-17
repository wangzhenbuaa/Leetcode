public class Competition201_2 {
    private StringBuilder reverseAndInverse(StringBuilder str) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                temp.append("1");
            } else {
                temp.append("0");
            }
        }
        return temp.reverse();
    }

    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = reverseAndInverse(str);
            str.append("1");
            str.append(temp);
        }
        System.out.println(str);
        return str.charAt(k - 1);
    }

    public static void main(String[] args) {
        Competition201_2 competition201_2 = new Competition201_2();
        System.out.println(competition201_2.findKthBit(4,1));
    }
}
