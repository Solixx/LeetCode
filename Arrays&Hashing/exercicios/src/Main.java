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

    public static boolean isAnagram(String s, String t) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        char[] str2 = t.toCharArray();
        Arrays.sort(str2);
        return Arrays.equals(str, str2);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnStrs = new ArrayList<>();
        ArrayList<char[]> arrChars = new ArrayList<>();
        ArrayList<char[]> delStr = new ArrayList<>();
        for (String str : strs) {
            char[] r = str.toCharArray();
            Arrays.sort(r);
            arrChars.add(r);
        }
        for (int i = 0; i < arrChars.size(); i++){
            List<String> strToPut = new ArrayList<>();
            if(checkAlreadyVisited(arrChars.get(i), delStr)){
                continue;
            }
            strToPut.add(strs[i]);
            for (int j = i+1; j < arrChars.size(); j++){
                if(Arrays.equals(arrChars.get(i), arrChars.get(j))){
                    if(!checkAlreadyVisited(arrChars.get(j), delStr)){
                        strToPut.add(strs[j]);
                    }
                }
            }
            delStr.add(arrChars.get(i));
            returnStrs.add(strToPut);
        }
        return returnStrs;
    }

    private static boolean checkAlreadyVisited(char[] str, ArrayList<char[]> arr){
        for (char[] chars : arr) {
            if (Arrays.equals(str, chars)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        String s = "anagram", t = "nagaram";
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //Main.containsDuplicate(nums);
        //Main.isAnagram(s,t);
        //Main.twoSum(nums, target);
        Main.groupAnagrams(strs);
    }
}