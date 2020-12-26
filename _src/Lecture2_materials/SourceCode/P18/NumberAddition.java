import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananiravi on 11/7/15.
 */
public class NumberAddition {

    public static void main(String[] args) {
        printNumber(addNumbers(new int[] {9, 9, 9, 5}, new int[] {9, 6}));
    }

    public static int[] addNumbers(int[] num1, int[] num2) {
        List<Integer> digitList = new ArrayList<Integer>();
        int lastIndex1 = num1.length - 1;
        int lastIndex2 = num2.length - 1;

        int carry = 0;
        int total = 0;
        int digit = 0;
        while (lastIndex1 >= 0 && lastIndex2 >= 0) {
            total = num1[lastIndex1] + num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
            lastIndex2--;
        }
        while (lastIndex1 >= 0) {
            total = num1[lastIndex1] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
        }
        while (lastIndex2 >= 0) {
            total = num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex2--;
        }
        if (carry != 0) {
            digitList.add(0, carry);
        }

        int[] sum = new int[digitList.size()];
        for (int i = 0; i < digitList.size(); i++) {
            sum[i] = digitList.get(i);
        }

        return sum;
    }

    public static void printNumber(int[] number) {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println();
    }
}
