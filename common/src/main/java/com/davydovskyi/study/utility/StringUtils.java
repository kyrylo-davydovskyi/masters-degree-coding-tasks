package com.davydovskyi.study.utility;

public class StringUtils {

    public static String replaceCharByIndex(String word, int index, char replacer) {
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(index, replacer);
        return sb.toString();
    }

    public static String swapChars(String word, int index1, int index2) {
        var charArray = word.toCharArray();

        var temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;

        return new String(charArray);
    }

    public static String deleteCharAt(String word, int index) {
        var builder = new StringBuilder(word);
        builder.deleteCharAt(index);
        return builder.toString();
    }

    public static String addCharAt(String word, int index, char symbol) {
        var builder = new StringBuilder(word);
        builder.insert(index, symbol);
        return builder.toString();
    }
}
