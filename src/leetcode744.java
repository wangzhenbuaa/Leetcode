public class leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) l = m + 1;
            else h = m;
        }
        return letters[l] <= target ? letters[0] : letters[l];
    }
}
