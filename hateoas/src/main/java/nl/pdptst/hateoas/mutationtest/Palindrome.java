package nl.pdptst.hateoas.mutationtest;

public class Palindrome {


    public boolean isPalindrome(String inputString) {
        //negated conditional
        if (inputString.length() == 0) {
            return true;
        } else if (inputString.length() == 1){
            return false;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }
}
