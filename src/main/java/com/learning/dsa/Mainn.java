package com.learning.dsa;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Mainn {

    public static void main(String[] args){
        int[] arr  = new int[]{94,-33,-13,40,-82,94,-33,-13,40,-82};
        int k = 52;
        int i = longestSubarray(arr, k);
//        System.out.println(i);

//        int[] arr = new int[]{1,2,3};
//        int sum = 0;
//        int count=0;
//        Map<Integer,Integer> map =new HashMap<>();
//        int k =3;
//        for(int i=0;i<arr.length;i++){
//            sum = sum + arr[i];
//            if(sum == k || arr[i]==k){
//                count+=1;
//            }
//            int diff = sum-k;
//            if(map.containsKey(diff) && map.get(diff)!=i-1){
//                count+=1;
//            }
//            map.put(sum,i);
//        }
//        System.out.println(count);
    }

//    public static int longestSubarray(int[] arr, int k) {
//        // code here
//
//        for(int i=1;i<arr.length;i++){
//
//            arr[i] = arr[i-1]+arr[i];
//        }
//       log.info("prefix sum :: {}",arr);
//        int maxOccurence = 0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==k) {
//                maxOccurence = i+1;
//            }
//        }
//        return maxOccurence;
//    }

    public static int longestSubarray(int[] arr, int k) {
        // code here

        int sum =0;
        int max= -1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0;i<arr.length;i++){

            sum +=arr[i];

            if(map.containsKey(sum-k)){
                if(i>max) max = i-map.get(sum-k);
            }
            map.put(sum,i);

        }
        return max+1;
    }
}
