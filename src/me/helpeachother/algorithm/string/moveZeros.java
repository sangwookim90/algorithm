package me.helpeachother.algorithm.string;

public class moveZeros {

    //        #2 MoveZeros
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        moveZeros(nums);
    }


    static void moveZeros(int[] nums){
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
            if(nums[i] !=0) {
                nums[index]=nums[i];
                index++;
                System.out.println("index: "+index);
            }
        }

        while(index<nums.length) {
            nums[index]=0;
            index++;
        }
    }

    // #2 MoveZeros
    static void moveZeros_practice(int[] nums){
        int cnt = 0;
        int result[] = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != 0) {
                result[i-cnt] = nums[i];
            } else {
                cnt++;
            }
        }

        for(int j=0; j<cnt; j++){
            result[nums.length-cnt+j] = 0;
        }


        for (int k=0; k < result.length ; k++) {
            System.out.println(result[k]);
        }
    }
}
