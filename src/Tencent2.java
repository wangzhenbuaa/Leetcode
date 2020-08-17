public class Tencent2 {
    //大数加法
    //大整数加法
    static StringBuilder add(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int sum = num1.charAt(idx1--) - '0' + num2.charAt(idx2--) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        while (idx1 >= 0) {
            int sum = num1.charAt(idx1--) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        while (idx2 >= 0) {
            int sum = num1.charAt(idx2--) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse();
    }

    //大整数减法
    static StringBuilder sub(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int borrow = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int n1 = num1.charAt(idx1--) - '0' - borrow;
            int n2 = num2.charAt(idx2--) - '0';
            int ans = 0;
            borrow = 0;
            if (n1 < n2) {
                n1 += 10;
                borrow = 1;
            }
            ans = n1 - n2;
            res.append(String.valueOf(ans % 10));
        }
        if (borrow > 0 && idx1 >= 0) {
            int temp = num1.charAt(idx1--) - '0' - borrow;
            if (idx1 > 0 || temp != 0) {//防止首位为0
                res.append(temp);
            }
        }
        while (idx1 >= 0) {
            res.append(num1.substring(0, idx1 + 1));
        }
        return res.reverse();
    }

    static String cal(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            ans.append("-");
            ans.append(add(num1.substring(1), num2.substring(1)));
        } else if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
            ans.append(add(num1, num2));
        } else if (num1.charAt(0) == '-') {
            num1 = num1.substring(1);
            if (num1.length() > num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) > 0)) {
                ans.append("-");
                ans.append(sub(num1, num2));
            } else {
                ans.append(sub(num2, num1));
            }
        } else if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
                ans.append("-");
                ans.append(sub(num2, num1));
            } else {
                ans.append(sub(num1, num2));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(cal("129", "232"));//361
        System.out.println(cal("183", "-98"));//85
        System.out.println(cal("-183", "98"));//-85
    }
}
