import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) {
    // Prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.print("Enter rational r1 with numerator and denominator separated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.print("Enter rational r2 with numerator and denominator separated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    RationalUsingBigInteger r1 = new RationalUsingBigInteger(
      new BigInteger(n1), new BigInteger(d1));
    RationalUsingBigInteger r2 = new RationalUsingBigInteger(
      new BigInteger(n2), new BigInteger(d2));

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

// Name the revised Rational class RationalUsingBigInteger 
class RationalUsingBigInteger extends Number 
    implements Comparable<RationalUsingBigInteger> {
  
  // Data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  /** Construct a rational with default value 0 */
  public RationalUsingBigInteger() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  /** Construct a rational with specified numerator and denominator */
  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Denominator cannot be zero");
    }

    // Simplify and normalize sign
    BigInteger gcd = gcd(numerator, denominator);
    if (denominator.compareTo(BigInteger.ZERO) < 0) {
      numerator = numerator.negate();
      denominator = denominator.negate();
    }
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
  }

  /** Return numerator */
  public BigInteger getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public BigInteger getDenominator() {
    return denominator;
  }

  /** Add two rationals */
  public RationalUsingBigInteger add(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
            .add(denominator.multiply(second.numerator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  /** Subtract two rationals */
  public RationalUsingBigInteger subtract(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
            .subtract(denominator.multiply(second.numerator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  /** Multiply two rationals */
  public RationalUsingBigInteger multiply(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.numerator);
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  /** Divide two rationals */
  public RationalUsingBigInteger divide(RationalUsingBigInteger second) {
    if (second.numerator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Division by zero");
    }
    BigInteger n = numerator.multiply(second.denominator);
    BigInteger d = denominator.multiply(second.numerator);
    return new RationalUsingBigInteger(n, d);
  }

  /** GCD helper */
  private static BigInteger gcd(BigInteger n, BigInteger d) {
    return n.gcd(d);
  }

  /** Override toString() */
  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator.toString();
    else
      return numerator + "/" + denominator;
  }

  /** Override equals */
  @Override
  public boolean equals(Object other) {
    if (other instanceof RationalUsingBigInteger) {
      RationalUsingBigInteger o = (RationalUsingBigInteger) other;
      return numerator.equals(o.numerator) &&
             denominator.equals(o.denominator);
    }
    return false;
  }

  /** Implement compareTo */
  @Override
  public int compareTo(RationalUsingBigInteger o) {
    BigInteger left = numerator.multiply(o.denominator);
    BigInteger right = o.numerator.multiply(denominator);
    return left.compareTo(right);
  }

  /** Implement Number methods */
  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

  @Override
  public float floatValue() {
    return (float) doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }
}
