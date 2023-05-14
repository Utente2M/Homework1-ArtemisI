package JavaCode;

public class Palindrome {

    public static boolean isPalindrome(String s){

        //A null or a single character string is by definition a palindrome
        if(s == null || s.isEmpty()){
            return false;
        }

        int left = 0;
        int right = s.length() - 1 ;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right++;
        }

        return true;
    }

}
