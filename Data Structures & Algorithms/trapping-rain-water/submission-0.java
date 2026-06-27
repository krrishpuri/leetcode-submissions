class Solution {
    public int trap(int[] h) {

        if (h == null || h.length == 0)
            return 0;

        int n = h.length;

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = h[0];
        rmax[n - 1] = h[n - 1];

        // Left max
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], h[i]);
        }

        // Right max
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], h[i]);
        }

        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            totalWater += Math.min(lmax[i], rmax[i]) - h[i];
        }

        return totalWater;
    }
}