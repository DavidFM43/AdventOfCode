import java.util.*;


import java.io.File;
public class Day10_22 {
   public static void main(String[] args) throws Exception{
        int size = 92;
        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file); 
        
        int[] nums = new int[size+2];
        nums[0] = 0;
        int cont = 1;
        while (scan.hasNextLine()){
            int num = Integer.parseInt(scan.nextLine());
            nums[cont] = num;
            cont++;
        }
        nums[cont] = 141;
        long[] memo = new long[size+2];
        Arrays.sort(nums);
        System.out.println(numWays(nums, 0, memo));

    }
    public static long numWays(int[] arr,int i, long[] memo){
        if (memo[i] != 0){
            return memo[i];
        }
        if(i == arr.length-1)
            return 1;
        long ans = 0;
        if(i+1 < arr.length && arr[i+1]-arr[i] <= 3){
            ans += numWays(arr, i+1, memo);
        }
        if(i+2 < arr.length && arr[i+2]-arr[i] <= 3){
            ans += numWays(arr, i+2, memo);
        }
        if(i+3 < arr.length && arr[i+3]-arr[i] <= 3){
            ans += numWays(arr, i+3, memo);
        }
        memo[i] = ans;
        return ans;

}

   
}
