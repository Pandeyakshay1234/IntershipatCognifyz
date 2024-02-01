import java.util.*;

public class Grade_Cal {
    public static void main(String[] args) {
        System.out.println("enter how many grades to be entered");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter grades to calculate average of that");
        float[] arr = new float[n];
        float total = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextFloat();
        }
        float average = calculate(arr, n);
        System.out.println("average is :" + average);
    }

    public static float calculate(float[] arr, int size) {
        float totalscore = 0;
        for (int i = 0; i < arr.length; i++) {
            totalscore += arr[i];
        }
        float average = totalscore / size;

        return average;
    }
}
