import java.util.ArrayList;

// Generic Stack implementation
class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}

public class PrimeStack {
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();

        int count = 0;
        int number = 2;

        // Generate first 50 primes and push to stack
        while (count < 50) {
            if (isPrime(number)) {
                stack.push(number);
                count++;
            }
            number++;
        }

        // Display primes in descending order (by popping)
        System.out.println("First 50 prime numbers in descending order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Helper method to check primality
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
