package io.suhaibbasha.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;

public class StringManipulation {

    public static String toTitleCase(String str) {
        StringBuilder result = new StringBuilder();
        for (String token : str.split(" ")) {
            if (!token.isEmpty()) {
                result.append(Character.toUpperCase(token.charAt(0)));
                result.append(token.substring(1).toLowerCase());
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static boolean checkPalindrome(String str) {
        if (Strings.isEmpty(str)) {
            return false;
        }

        str = str.toLowerCase();
        boolean isPalindrome = true;
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static boolean checkPalindromeWithReversedStr(String str) {
        if (Strings.isEmpty(str)) {
            return false;
        }

        str = str.toLowerCase();
        StringBuilder reversedStr = new StringBuilder(str).reverse();
        return str.equals(reversedStr.toString());
    }

    public static boolean checkAnagram(String str1, String str2) {
        if (Strings.isEmpty(str1) || Strings.isEmpty(str2)) {
            return false;
        }

        str1 = str1.toLowerCase().replaceAll("\\s+", "");
        str2 = str2.toLowerCase().replaceAll("\\s+", "");

        int[] charCount = new int[26];
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkSubstringExistence(String str1, String str2) {
        if (Strings.isEmpty(str1) || Strings.isEmpty(str2)) {
            return false;
        }

        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    public static boolean checkNumericString(String str) {
        if (Strings.isEmpty(str)) {
            return false;
        }

        for (char c : str.replaceAll("\\s+", "").toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkBalancedParanthesis(String str) {
        if (Strings.isEmpty(str)) {
            return false;
        }

        int openParenCount = 0;
        int closeParenCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                openParenCount++;
            } else if (c == ')') {
                closeParenCount++;
                if (openParenCount < closeParenCount) {
                    return false;
                }
            }
        }
        return openParenCount == closeParenCount;
    }

    public static Map<Character, Integer> countCharacters(String str) {
        if (Strings.isEmpty(str)) {
            return new HashMap<>();
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.replaceAll("\\s+", "").toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static String removeRepetitiveCharacters(String str) {
        if (Strings.isEmpty(str)) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        char prev;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (i == 0) {
                prev = current;
                result.append(current);
                continue;
            }
            prev = str.charAt(i - 1);
            if (current != prev) {
                result.append(current);
            }
        }
        return result.toString();
    }

    public static int countWords(String str) {
        if (Strings.isEmpty(str)) {
            return 0;
        }

        return str.replaceAll("\\s+", " ").trim().split(" ").length;
    }

    public static char getMostFrequentChar(String str) {
        if (Strings.isEmpty(str)) {
            return '\0';
        }

        Map<Character, Integer> charCountMap = countCharacters(str);
        return charCountMap.keySet()
                .stream()
                .max((c1, c2) -> charCountMap.get(c1) - charCountMap.get(c2))
                .get();
    }

    public static String removeVowels(String str) {
        if (Strings.isEmpty(str)) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (char c : str.toLowerCase().toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String compressString(String str) {
        if (Strings.isEmpty(str)) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        str = str.replaceAll("\\s+", "");
        char prev;
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (i == 0) {
                prev = current;
                continue;
            } 
            prev = str.charAt(i - 1);
            if (current != prev) {
                result.append(prev);
                result.append(count);
                count = 1;
                if (i == str.length() - 1) {
                    result.append(current);
                    result.append(count);
                }
            } else {
                if (i == str.length() - 1) {
                    result.append(current);
                    result.append(count + 1);
                }
                count++;
            }
        }
        return result.toString();

    }

    public static String decompressString(String str) { 
        if (Strings.isEmpty(str)) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        // Continue from here
        return result.toString();
    }

    public static String reverseString(String str) {
        if (Strings.isEmpty(str)) {
            return str;
        }

        return new StringBuilder(str).reverse().toString();
    }
}
