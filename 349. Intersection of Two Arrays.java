/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
/*

/*
Method1: 
HashSet
Binary Search


/*
Complexity Analysis
HashSet: O(N)
Binary Search: O(O(nlogn))
Two Pointer O(nlogn)
/*

/*
Basic Java
Hashset 的用法 
1、Set接口的使用
Set集合里多个对象之间没有明显的顺序，Set不允许包含重复元素。
Set集合不允许重复元素，是因为Set判断两个对象相同不是使用==运算符，而是根据equals方法。即两个对象用equals方法比较返回true，Set就不能接受两个对象。
hashset这种只能用for来遍历，这里要用Integer来表示hashset中的数字记住res++这种用法
最后因为要返回的还是int[]所以要搞一个res

hashset.add();
hashset.contains();
hashset.size();
/*

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                intersect.add(nums2[i]);
            }
        }
        
        int[] res = new int[intersect.size()];
        int i = 0;
        for(Integer num : intersect){
            res[i++] = num;
        }
        
        return res;
    }
}



//Binary Search
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = HashSet<>();
        Arrays.sort(nums2);
        
        for(Integer num : nums1){
            if(binarySearch(nums2, num)){
                set.add(num);
            }
        }
        
        int i = 0
        int[] res = new res[set.size()];
        for(Integer numres : set){
          res[i++] = numres;  
        }
        
        return res;
    }
    
    private boolean binarySearch(int[] nums, int target){
        if(nums == null) return false;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == tareget){
                return true;
            }
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(nums[start] == target){
            return true;
        }
        
        if(nums[end] == target){
            return true;
        }
        
        return false;
    }
}

/*
Two pointer
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[set.size()];
        int k = 0;
        
        for(Integer nums : set){
            res[k++] = nums;
        }
        
        return res;
        
       
    }
}
