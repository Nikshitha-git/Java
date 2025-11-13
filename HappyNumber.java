public class HappyNumber {
    public static void main(String[] args) {
        int number = 13;
        if (isHappy(number)) {
            System.out.println(number + " is a happy number.");
        } else {
            System.out.println(number + " is not a happy number.");
        }
    }
    static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 4) {
            return false;
        }
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return isHappy(sum);
    }
}
