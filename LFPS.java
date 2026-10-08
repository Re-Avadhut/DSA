package STS;

public class LFPS {
    static String palindrome(String s) {
        int[] freq = new int[26];

        // find freqencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // find odd
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0)
                odd++;
            if (odd > 1)
                return "No Palindromic String ";
        }

        // find prefix
        String prefix = "";
        char mid = ' ';
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                prefix += (char) (i + 'a');
            }
            if (freq[i] % 2 != 0) {
                mid = (char) (i + 'a');
            }

        }
        if (mid == ' ')
            return prefix + new StringBuilder(prefix).reverse().toString();
        else
            return prefix + mid + new StringBuilder(prefix).reverse().toString();
    }
}
