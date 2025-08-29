class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums2.length];

        // Step 1: Compute next greater for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        // Step 2: Map nums2[i] → arr[i]
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], arr[i]);
        }

        // Step 3: Build answer for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
