package JavaCode;

public class Palindrome {

    public boolean isPalindrome(String s){

        //A null or a single character string is by definition a palindrome
        if(s == null || s.isEmpty()){
            return false;
        }

        String sLower = s.toLowerCase();
        int left = 0;
        int right = sLower.length() - 1 ;

        while(left < right){
            if(sLower.charAt(left) != sLower.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

}
