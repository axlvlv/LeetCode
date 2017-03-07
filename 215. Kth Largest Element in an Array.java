/*
ind the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || n == 0){
            return 0;
        }
        return quickselect(nums, 0, n - 1,  n - k);
    }
    
    private int quickselect(int[] nums, int left, int right, int k){
        int index = left;
        int pivot = nums[right];
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                swap(nums, index++, i);
            }
        }
        swap(nums, index, right);
        
        if(index == k){
            return nums[index];
        }else if(index < k){    //check right part
            return quickselect(nums, index + 1, right, k);
        }else{    //check left part
            return quickselect(nums, left, index - 1, k);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}

public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}
