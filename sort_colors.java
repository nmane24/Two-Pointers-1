
// Time Complexity : O(n)             
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/sort-colors/description/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


*/

/*
Using Three Pointer technique
We are not allowed to use any sorting technique or extra space. 
Threee pointers left, right, mid are maintained , and each of the pointers will be collecting one of the numbers.
low will be collecting 0's, mid will be collecting 1's and high will be collecting 2's
Mid pointer is used for comparison.

We are trying to maintain low , mid , high like ->   |low | mid| high|. i.e low pointer can be equal to or less than mid but 
not cross the mid ptr.Once high and mid have crossed each other we will stop.


while(mid <= h){
    if(nums[mid] == 0){
        swap(mid, low)
        l++
        mid++;
    }
    else if(nums[mid] == 2){
        swap(mid, h)
        h--;
    }
    else{ 
    mid ++ // collecting 1's so we increment
    }
}
*/
public class sort_colors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low ++;
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
            else{// we have collected 1 in mid here so increase mid
                mid ++;
            }
        }
    }

    private void swap(int []nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    // swap without using third vairable
    private void swap(int []nums, int i , int j){
        if(i !=  j){
            nums[i] = nums[i] + nums[j];
            nums[j] = nums [i] - nums[j];
            nums[i] = nums[i]  - nums[j];
        }
         
    }
}
