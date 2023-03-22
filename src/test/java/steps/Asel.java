package steps;

public class Asel {

    public static void armstrongNum(int num){
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, 3); // vosvedenie v stepen
            temp /= 10;
        }
        if (sum == num) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }

    public static void main(String[] args) {
        armstrongNum(154);

        String company = "Google ";

        System.out.println("My company" + company);
    }
}
