// 
// Write a Java program that asks the user for a number n.
// After the user chooses an n, the program should ask for n numbers, creating an array through this process.
// After the first n numbers, the program should ask again for n numbers, creating a second array through this process.
// With the two arrays given by the user, the program should print a new array with size n, with each element being the sum of the elements in the previous arrays.
// 
// example:
// input:
// 3
// 1
// 2
// 3
// 4
// 5
// 6
// output:
// 5 7 9
// 
// explanation:
// 3 // number of elements in the arrays
// [1, 2, 3]  // array 1
// [4, 5, 6]  // array 2
// [5, 7, 9]  // output array
// 

import java.util.Scanner;

public class NumbersSum {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("How many numbers: ");
        int amountOfNumbers = sc.nextInt();

        int[] numbers1 = new int[amountOfNumbers];
        int[] numbers2 = new int[amountOfNumbers];
        int[] sum = new int[amountOfNumbers];

        System.out.println("== Numbers for array1 ==");
        numbers1 = askArrayNumbers(numbers1);
        System.out.println("== Numbers for array2 ==");
        numbers2 = askArrayNumbers(numbers2);

        //  sum[0] = numbers1[0] + numbers2[0];
        //  sum[1] = numbers1[1] + numbers2[1];
        //  sum[2] = numbers1[2] + numbers2[2];

        //  sum[..] = numbers1[..] + numbers2[..];

        //  sum[n] = numbers1[n] + numbers2[n];
        for(int i = 0; i < sum.length; i++) {
            sum[i] = numbers1[i] + numbers2[i];
        }

        printArray(numbers1);
        printArray(numbers2);
        printArray(sum);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%02d ", array[i]);
        }

        System.out.println();
    }

    public static int[] askArrayNumbers(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.printf("number #%d: ", i);
            array[i] = sc.nextInt();
        }

        return array;
    }
}
