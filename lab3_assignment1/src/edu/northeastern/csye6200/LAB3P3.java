package edu.northeastern.csye6200;
import java.util.Arrays; 

public class LAB3P3 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2};
        int[] originalNums = Arrays.copyOf(nums, nums.length);
        int k = removeDuplicates(nums); 
        System.out.println("Original nums: " + java.util.Arrays.toString(originalNums));
        int[] finalNums = Arrays.copyOf(nums, k);
        System.out.println("Final nums: " + java.util.Arrays.toString(finalNums));
        System.out.println("Final k value: " + k);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i=0;
        for (int j=1; j<nums.length; j++) {
            if ( nums[j] != nums[i] ) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}