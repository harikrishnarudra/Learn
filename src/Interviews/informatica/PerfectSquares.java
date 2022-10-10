package Interviews.informatica;

public class PerfectSquares {

    public void findOutPS(int [] nums){
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length; i++){
            arr[i] = nums[i]*nums[i];
        }
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr.length;j++){
                int z = isNumExistsInArr(arr[i] + arr[j], arr, nums);
                if(z!=-1){
                    System.out.println("x: "+nums[i]+" y:"+nums[j]+" = "+z);
                }
            }
        }
    }

    private int isNumExistsInArr(int num, int[] arr, int[] nums){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        perfectSquares.findOutPS(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
}
