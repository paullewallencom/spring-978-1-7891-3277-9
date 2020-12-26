import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananiravi on 11/8/15.
 */
public class IncrementNumber {

    public static List<Character> digitList = new ArrayList<Character>();
    static {
        digitList.add('A');
        digitList.add('B');
        digitList.add('C');
        digitList.add('D');
    }

    public static void main(String[] args) {
        List<Character> originalNumber = new ArrayList<Character>();
        originalNumber.add('D');
        originalNumber.add('D');
        originalNumber.add('D');
        originalNumber.add('D');

        System.out.println(String.format("Original number is: %s, incremented number is: %s",
                originalNumber, increment(originalNumber)));
    }

    /**
     * A number is represented as digits from the digit list. Each digit in the digit list is unique and
     * only the numbers in the digit list are valid. The digit list is sorted by ascending order, with
     * the lower value numbers earlier in the list.
     * Increment the original number, remember next means the next number as per the valid digit list.
     * The units place in the original number is the very last element in the original number list.
     */
    public static List<Character> increment_docs(List<Character> originalNumber) {
        List<Character> incrementedNumber = new ArrayList<Character>();

        boolean incrementComplete = false;
        int currentIndex = originalNumber.size() - 1;
        incrementedNumber.addAll(originalNumber);

        while (!incrementComplete && currentIndex >= 0) {
            // Get the digit to increment for this iteration, it starts with the units place.
            char currentDigit = originalNumber.get(currentIndex);
            int indexOfCurrentDigit = digitList.indexOf(currentDigit);

            // Figure out what the next valid digit is once we increment by 1.
            // The next valid digit will rotate around to the first valid digit if
            // its the last valid digit. Kind of like how 9 wraps around to 0 in decimal
            // increments.
            int indexOfNextDigit = (indexOfCurrentDigit + 1) % digitList.size();

            // Update the digit at the current index to be the next valid digit.
            incrementedNumber.remove(currentIndex);
            incrementedNumber.add(currentIndex, digitList.get(indexOfNextDigit));

            // If the next valid digit has not wrapped around we can terminate the iteration here,
            // the increment is complete.
            if (indexOfNextDigit != 0) {
                incrementComplete = true;
            }

            // If the most significant digit rotated around to the first valid digit it means
            // that we need to add one additional digit in the most significant (leftmost) position.
            // Like how 99 + 1 becomes 100 and the "1" is added to the most significant position.
            if (currentIndex == 0 && indexOfNextDigit == 0) {
                incrementedNumber.add(0, digitList.get(0));
            }

            // If the next valid digit at the current index has wrapped around to the
            // lowest valid digit this means there is a carry over of 1 unit to the next
            // significant digit, we have to go through this iteration again to increment
            // the digit one position to the left.
            currentIndex--;
        }


        return incrementedNumber;
    }

    public static List<Character> increment(List<Character> originalNumber) {
        List<Character> incrementedNumber = new ArrayList<Character>();

        boolean incrementComplete = false;
        int currentIndex = originalNumber.size() - 1;
        incrementedNumber.addAll(originalNumber);

        while (!incrementComplete && currentIndex >= 0) {
            char currentDigit = originalNumber.get(currentIndex);
            int indexOfCurrentDigit = digitList.indexOf(currentDigit);

            int indexOfNextDigit = (indexOfCurrentDigit + 1) % digitList.size();

            incrementedNumber.remove(currentIndex);
            incrementedNumber.add(currentIndex, digitList.get(indexOfNextDigit));

            if (indexOfNextDigit != 0) {
                incrementComplete = true;
            }

            if (currentIndex == 0 && indexOfNextDigit == 0) {
                incrementedNumber.add(0, digitList.get(0));
            }

            currentIndex--;
        }


        return incrementedNumber;
    }

}
