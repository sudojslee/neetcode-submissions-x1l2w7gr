class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;
        int minEatingSpeed = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hours = getHours(piles, mid);
            if (hours > h) {
                left = mid + 1;
                // eatingSpeed increase
            } else {
                right = mid - 1;
                minEatingSpeed = mid;
                // eatingSpeed decrease
            }
            
        }
        return minEatingSpeed;
    }

    int getHours(int[] piles, int eatingSpeed) {
        int h = 0;
        for (int pile : piles) {
            h += pile / eatingSpeed;
            if (pile % eatingSpeed != 0) {
                h++;
            }
        }

        return h;
    }
}
