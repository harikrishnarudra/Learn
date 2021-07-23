package Interviews.amz.demo;

public class GCDOnAList {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {
        int result = arr[0];
        for (int i=0;i<arr.length; i++){
            result = this.gcd(arr[i],result);
        }
        return result;
    }

    public int gcd(int a, int b){
        if (a==0)
            return b;
        return gcd(b%a,a);

    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args){
        GCDOnAList gcdOnAList = new GCDOnAList();
        int res = gcdOnAList.generalizedGCD(5,new int[]{2,4,6,8,10});
        System.out.println(res);
    }


}
