
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * // Time Complexity : O(n)             
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 * Code Explanation: 
 * 
 * Brute Force way : Using nested iterations where we compare one element and then again we compare for the third element.
 * 
 */
public class three_sum{

    /*
    Approach 1 : using brute force method, comparing one element to entire array first and then doing it again. 
    We i, j ,k loop and i element is fixed and find pairs whose sum is equal to i element
    Time Complexity  : O(n^3)
    Space Complexity : O(1) 
    This method does not provide unique numbers. Also does not run successfully on leetcode
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i< n-3; i++){
            for(int j = 1; j< n-2; j++){
                for(int k = 2; k< n-1; k++){
                    if((nums[i] + nums[j] + nums[k]) == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    /*
    Approach 2 : using two pointer method (Coded)
    Time Complexity  : O(n^2) + nlogn == O(n^2)
    Space Complexity : O(n) 
    
    No Need to implement seperate logic to remove duplicate number in result as the array is sorted and we would be moving the 
    low and high pointers to unique elements of array. We keep an index pointer to check with low and high.
    The index pointer is fixed and the sum of index + low + high < target then we increase the low pointer.
    if the sum is > target then we decrease the high pointer. 
    Ome more optimization we do, if the indexth pointer reaches an element which is greater than 0 after that we wont be able to find any triplet
    so we dont do anything. As we need a negative number in the sum to be able to get the target = 0. 
    */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        //sort the array first
        Arrays.sort(nums);  // O(nlogn)
        for(int i = 0; i<n-2; i++){ // if we have our triplet as the last three elements of array then we will be able to record it and low and high pointers will be at second last and last elements
            // Also if we take i till n then our low and high pointers will go outside the array.
            // optimization 
            if(nums[i] > 0) break;
            //to avoide outside duplicacy ; that the elements outside are equal and we would be moving our pointer by 1, by continue, the for loop would continue.
            if(i!= 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int h = n-1;
            // boundary condition for the inside arrray
            while(l<h){ // inside array we have to find the pairs , we do it by doing sum of all and checking equal to 0
                int currSum = nums[i]+nums[l]+nums[h];
                if(currSum == 0){ // we got our triplet and we will be storing it
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                    // inside duplicacy
                // check condition if all the elements are same example [0 ,0 , 0] which is l<h and here we are trying to avoid duplicates 
                while (l < h && nums[l] == nums[l-1]){
                    l++;
                }
                while(l<h && nums[h] == nums[h+1]){
                    h--;
                }
            }
                else if(currSum < 0){   // if it ist less than the target we are looking for , we need move towards higher side, 
                        l ++;
                }
                else{
                    h--;
                }

            }
            

        }
        return  result;
        
    }


    /*
    Approach 3 : using extension of two sum : using hashset & hashing (Most optimized)
    Time Complexity  : O(n^2)
    Space Complexity : O(1)    ..... because of use of hashset 
    This method does not provide unique numbers. 
    Need to implement seperate logic to remove duplicate number in result. 
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> hSet = new HashSet<>();
        
        int n = nums.length;
        for(int i = 0; i< n-2; i++){
            int twoSum = 0 - nums[i]; // calculate the twoSum here.

            for(int j = 1; j< n-1; j++){
                int target = twoSum - nums[j]; // The target is calculated using twoSum  
                if(hSet.contains(target)){      //we check if target has been added or not as it will be mapped to visited index
                    result.add(Arrays.asList(nums[i],target, nums[j])); /
                }
                else{
                    hSet.add(nums[j]); // we add nums[j] and not target even though we are checking the target in hashSet
                }
            }
        }
        return result;
    }

    /*
    Approach 4 : using two pointer method and binary search on remaining array
    Time Complexity  :n^2 logn 
    Space Complexity : O(1) 
    
    The index pointer is added with the next element pointer and whatever the result of it is checked with BS output of the remaining array.
    */

    public List<List<Integer>> threeSum(int[] nums) {

    }
    
}
