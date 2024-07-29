
/*
 * 
 * // Time Complexity : O(n)             
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/container-with-most-water/

You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith 
line are (i, 0) and (i, height[i]).

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


// Two pointer approach - with left and right pointers, we move the pointer on the basis of the one which gives lower height
Example left pointer is at height 4, right pointer is at height 8, then we move our left pointer i.e we increment it and our right 
pointer we decrement it.
We calculate the area by : height * width - heigth is the min of both and width is calculated by subtttracting the indexes.
*/

// Brute Fore Code ( time limit exceeded)
public class container_with_most_water {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        for(int i = 0 ; i< n-1; i ++){
            for(int j = i+1; j< n; j++){
                int currArea = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(max, currArea);
            }
        }
        return max;
    }
}


// Optimized Code, using left and right pointers
public class container_with_most_water {
    public int maxArea(int[] height) {{
        int max = 0;
        int n = height.length;
        int l =0; int r = n-1;
        while(l<r){
            int currArea = Math.max(height[l], height[r]) * (r-l);
            max = Math.max(max, currArea);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}

// Follw up is return the heights or indexes at which we get the max container, the we ill
// additionaally storing those heights in variable everytime we the max is getting updated.
public class container_with_most_water {
    public int maxArea(int[] height) {{
        int max = 0;
        int n = height.length;
        int l =0 ; int r = 0;
        int start = 0 ; int end = n-1; // variables to store the indexes
        while(l<r){
            int currArea = Math.min(height[l], height[r]) * (r-l);
            if(max < currArea){
                max = currArea;
                start = l;
                end = r;
            }
            if(height[l] < height[r]){
                l ++;
            }
            else{
                r --;
            }
        }
        return result;
    }
}

