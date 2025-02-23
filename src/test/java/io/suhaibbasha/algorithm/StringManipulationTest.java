package io.suhaibbasha.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringManipulationTest {

    @ParameterizedTest
    @ValueSource(strings = { "alpha beta", "Alpha beTa GaMma", "", "aLpHa BeTa gAmMa" })
    public void toTitleCase_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.toTitleCase(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "level", "ANoTonA", "Leopoel", "Level", "", "NotPalindrome", "AlmostNsomlA" })
    public void checkPalindrome_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.checkPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "level", "ANoTonA", "Leopoel", "Level", "", "NotPalindrome", "AlmostNsomlA" })
    public void checkPalindromeWithReversedStr_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.checkPalindromeWithReversedStr(input));
    }

    @ParameterizedTest
    @CsvSource({ "listen,silent", "civic,ivic", "NotAnAnagram,Nougat", "Able was I,I wass Elba" })
    public void checkAnagram_mapInputsToTheirOutput_printOutput(String input1, String input2) {
        System.out.println(input1 + ", " + input2 + ": " + StringManipulation.checkAnagram(input1, input2));
    }

    @ParameterizedTest
    @ValueSource(strings = { "listen", "silent", "civic", "JustRandomIlen", "Ablen was I", "iLeben" })
    public void checkSubstringExistence_mapInputsToTheirOutput_printOutput(String input1) {
        System.out.println(input1 + ", ilen" + ": " + StringManipulation.checkSubstringExistence(input1, "ilen"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "123456", "49 177000100", "123 123A", "A13", "", "iLeben2025" })
    public void checkNumericString_mapInputsToTheirOutput_printOutput(String input1) {
        System.out.println(input1 + ": " + StringManipulation.checkNumericString(input1));
    }


    @ParameterizedTest
    @ValueSource(strings = { "(Correct)", "(x + (y+a))", "(notbalanced))", "(notbalanced", "()()()((a()))" })
    public void checkBalancedParanthesis_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.checkBalancedParanthesis(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello World", "aabbbccd", "ababababc", "mnoooixziii", "oihqadiiivooa" })
    public void countCharacters_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.countCharacters(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Heelloooo Worrld", "aabbbccdeff", "abaabbababcc", "mnoooixziii", "oihqadiiivooa" })
    public void removeRepetitiveCharacters_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.removeRepetitiveCharacters(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello World", "ab ab bb cc", "ab", "bb dd ee", "oih q ad iiiv ooa" })
    public void countWords_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.countWords(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello World", "ab ab bb cc", "ab", "bb dd ee", "oih q ad iiiv ooa" })
    public void getMostFrequentChar_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.getMostFrequentChar(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "aabbb", "abb abbbcccc", "aabccccd", "bbdeeea", "oihiiivvvooa" })
    public void getLongestWord_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.compressString(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "a2b3", "a1b2a1b3c4", "a2b1c4d1", "bbddee", "o1i1h1i3v3o2a1" })
    public void decompressString_mapInputsToTheirOutput_printOutput(String input) {
        System.out.println(input + ": " + StringManipulation.decompressString(input));
    }
}
