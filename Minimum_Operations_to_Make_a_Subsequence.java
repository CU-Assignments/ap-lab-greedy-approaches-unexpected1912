class Solution {
    int[] tail;
    int idx;
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = map.getOrDefault(num, -1);
            indices[i] = index;
        }
        tail = new int[arr.length];
        idx = -1;
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index == -1) continue;
            binarySearch(0, idx, index);
        }
        return target.length - idx - 1;
    }

    private void binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (tail[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (start > idx) idx = start;
        tail[start] = target;
    }
}