public class Competition199_1 {
    public String restoreString(String s, int[] indices) {
        if (s == null) return null;
        int n = s.length();
        char[] str = new char[n];
        for (int i = 0; i < n; i++) {
            str[indices[i]] = s.charAt(i);
        }
        return new String(str);
    }
}
