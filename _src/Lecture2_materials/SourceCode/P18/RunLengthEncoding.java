/**
 * Created by jananiravi on 11/7/15.
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(String.format(
                "Original string is: %s code is: %s", "aaabbbccc", decode(encode("aaabbbccc"))));
        System.out.println(String.format(
                "Original string is: %s code is: %s", "abbccc", decode(encode("abbccc"))));
        System.out.println(String.format(
                "Original string is: %s code is: %s", "sadasdasdrrrt", decode(encode("sadasdasdrrrt"))));
    }

    public static String decode(String encodedString) {
        if (encodedString == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int numIndex = 0;
        int charIndex = numIndex + 1;
        while (charIndex < encodedString.length()) {
            int num = Integer.valueOf(Character.toString(encodedString.charAt(numIndex)));
            for (int i = 0; i < num; i++) {
                sb.append(encodedString.charAt(charIndex));
            }
            numIndex = charIndex + 1;
            charIndex = numIndex + 1;
        }

        return sb.toString();
    }

    public static String encode(String originalString) {
        if (originalString == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int currIndex = 0;
        while (currIndex < originalString.length()) {
            char currChar = originalString.charAt(currIndex);

            int num = 0;
            int compareIndex = currIndex;
            while (compareIndex < originalString.length()
                    && currChar == originalString.charAt(compareIndex)) {
                compareIndex++;
                num++;
            }
            sb.append(num);
            sb.append(currChar);

            currIndex = compareIndex;
        }

        return sb.toString();
    }
}
