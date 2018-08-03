package com.movie.matcher.configuration.jax.rs;

/**
 * Created by Ortal on 6/2/2018.
 */

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int [] arr = new int[A.length];

        for (int i=0;i<A.length;i++)
        {
            if(A[i]>0 && A[i]<A.length)
                arr[A[i]-1]=1;

        }

        int min =0;
        for (min=0;min<arr.length;min++)
        {
            if(arr[min]==0)
               break;
        }

        return min+1;
    }
}