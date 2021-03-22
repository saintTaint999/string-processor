package ru.sainttaint999.utility;

public class StringProcessor {

    public static String process(String str) {
        StringBuilder result = new StringBuilder();
        int i=0;

        while (i < str.length()) {
            if (isDigit(str.charAt(i))) {
                int numberStartIndex = i;
                while (isDigit(str.charAt(i)))
                    i++;
                int repeats = Integer.parseInt(str.substring(numberStartIndex, i));

                i++;
                int bracketsStartIndex = i;
                int openBracketsCounter = 1;
                while (openBracketsCounter > 0) {
                    i++;
                    if (str.charAt(i) == '[')
                        openBracketsCounter++;
                    else if (str.charAt(i) == ']')
                        openBracketsCounter--;
                }

                result.append( process(str.substring(bracketsStartIndex, i)).repeat(repeats) );
            }

            if (isLowerCaseLetter(str.charAt(i))) {
                result.append(str.charAt(i));
            }
            i++;
        }
        return result.toString();
    }

    public static boolean isValid(String str) {
        char[] symbols = str.toCharArray();
        int openedBracketsCounter = 0;
        int i = 0;
        if (symbols[0] == '[')
            return false;
        for (i = 0; i < symbols.length; i++) {
            if (!isValidSymbol(symbols[i]))
                return false;

            if (symbols[i] == '[')
                openedBracketsCounter += 1;
            else if (symbols[i] == ']')
                openedBracketsCounter -= 1;
            if (openedBracketsCounter < 0)
                return false;
        }
        for (i = 1; i < symbols.length; i++) {
            if (symbols[i] == '[' && !isDigit(symbols[i-1]))
                return false;
        }
        i = 0;
        while (i < symbols.length) {
            if (isDigit(symbols[i])) {
                if (i == symbols.length-1)
                    return false;
                if ( (symbols[i+1] != '[') && (!isDigit(symbols[i+1])) )
                    return false;
            }
            i++;
        }
        return true;
    }

    private static boolean isLowerCaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isValidSymbol(char c) {
        return isLowerCaseLetter(c) || isDigit(c) || (c == '[') || (c == ']');
    }

}
