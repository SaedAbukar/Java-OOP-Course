public class PalindromeChecker {

    public Boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        // Remove all non-alphanumeric characters and convert to lowercase
        String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the sanitized string
        String reversed = new StringBuilder(s).reverse().toString();

        // Compare the sanitized string with its reversed version
        return s.equals(reversed);
    }
}
