package notepad;

import java.util.Arrays;

public class Solution 
{
//	public static int[] removeElement(int[] nums, int val)
//    {
//        int newArr[]=new int[nums.length];
//        for(int i=0,j=0;i<nums.length;i++)
//        {
//            if((nums[i]==val))
//            {
//                i++;
//            }
//            else
//            {
//                newArr[j]=nums[i];
//                j++;
//            }
//        }
//        return newArr;
//
//    }
	
	public static int removeElement(int[] nums, int val)
    {
        int ct=0;
        for(int i=0,j=0;i<nums.length;i++)
        {
            if((nums[i]==val))
            {
                ct++;
            }
            
        
        }
        int newLen= nums.length-ct;
        int newArr[]=new int[nums.length];
        for(int i=0,j=0;i<nums.length;i++)
        {
            if((nums[i]==val))
            {
                i++;
            }
            else
            {
                newArr[j]=nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(newArr));
        return newLen;
    }

	
	public static void main(String[] args) {
		//int arr[]= {0,1,2,2,3,0,4,2};
		int arr[]= {3,2,2,3};
		//System.out.println(Arrays.toString(removeElement(arr, 2)));
		System.out.println(removeElement(arr, 3));
	}
}
