/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
/*

/*
Method
需要用两个指针，一个不停的向后扫，找到非零位置，然后和前面那个指针交换位置即可
自己写两个例子就能明白了
/**

// Loop through nums, if nums[i] is non-zero, replace the leftmost 
// zero element nums[j] with nums[i] and set nums[i] to zero if i > j. 
// Note that i == j happens when nums has leading non-zero 
// elements, nums = {2, 1, 3, 0, 5, 0, 6}. In this case, we don't perform
// any swap and keep incrementing i and j until i > j.

public void moveZeroes(int[] nums) {
    int j = 0; // The index of the leftmost zero in nums.
    for(int i = 0; i < nums.length; i++){
        if(nums[i] != 0){
            if(i > j){ // i can only be larger than or equal to j.
                nums[j] = nums[i];
                nums[i] = 0;
            }
            j++;
        }
    }
}

