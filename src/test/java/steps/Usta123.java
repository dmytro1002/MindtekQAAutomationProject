package steps;


public class Usta123 {
    public static void main(String[] args) {
        // Write a program that will print Fibonacci numbers between 1 and 100.
        // 0 1 1 2 3 5 8 13 ....
        int fib1 = 0;
        int fib2 = 1;
        int fibNext =0 ;

        System.out.print(fib1 +" ");

        while (fibNext<100) {
            fibNext = fib1+fib2;
            fib1=fib2;
            fib2=fibNext;
            System.out.print(fib1 + " ");
        }
    }


}
