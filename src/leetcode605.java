public class leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < n) return false;
        int num = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) && flowerbed[i] == 0) {
                num++;
                flowerbed[i] = 1;
            }
        }
        return num >= n;
    }
}
