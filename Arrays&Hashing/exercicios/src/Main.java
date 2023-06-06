import java.util.*;

public class Main {

    public static boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        System.gc();
        for (int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])    return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        Main.containsDuplicate(nums);
    }
}