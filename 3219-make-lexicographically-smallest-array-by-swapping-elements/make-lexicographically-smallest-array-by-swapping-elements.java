class Solution {
    public record Pair(int key, int value) {
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Pair> map = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.add(new Pair(i, nums[i]));
        }

        map.sort((a, b) -> {
            if (a.value() == b.value())
                return a.key() - b.key();
            return a.value() - b.value();
        });

        List<Integer> sorted = new ArrayList<>();
        List<Integer> unsorted = new ArrayList<>();
        int[] ans = new int[n];

        int prev = -1;
        for (Pair entry : map) {
            int key = entry.key();
            int value = entry.value();
            if (prev != -1 && Math.abs(value - prev) > limit) {
                Collections.sort(sorted);
                for (int i = 0; i < sorted.size(); i++) {
                    ans[sorted.get(i)] = nums[unsorted.get(i)];
                }
                sorted.clear();
                unsorted.clear();
            }

            prev = value;
            sorted.add(key);
            unsorted.add(key);
        }

        Collections.sort(sorted);
        for (int i = 0; i < sorted.size(); i++) {
            ans[sorted.get(i)] = nums[unsorted.get(i)];
        }
        return ans;
    }
}