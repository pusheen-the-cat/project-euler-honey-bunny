package projecteuler.honeybunny;

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    public static void main(String[] args) {
        dumbWay();
        additive();
    }

    private static void additive() {
        int sum = addSum(3);
        sum += addSum(5);
        sum -= addSum(15);
        System.out.println("sol 2 Sum: " + sum);
    }

    private static int addSum(int addition) {
        int sum = 0;
        for (int i = addition; i < 1000; i += addition) {
            sum += i;
        }
        return sum;
    }

    private static void dumbWay() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println("sol 1 Sum: " + sum);
    }
}
