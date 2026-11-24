class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(finish(piles, h, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean finish(int[] piles, int h, int speed){
        long totalHours = 0;
        for(int pile : piles) {
            totalHours += (long) Math.ceil((double)pile / speed);
            if(totalHours > h){
                return false;
            }
        }
        return true;
    }
}
