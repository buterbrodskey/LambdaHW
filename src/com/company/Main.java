package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] arr1 = getFilledArray(10, input, Integer::sum);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = getFilledArray(10, input, (i, m) -> i * m);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = getFilledArray(10, input, (i, m) -> {
            if (i % 2 == 0) {
                return (i / 2) + m;
            }
            return (i * i) - m;
        });
        System.out.println(Arrays.toString(arr3));
        // индекс в степени модификатора
        int[] arr4 = getFilledArray(10, input, (i, m) -> (int) Math.pow(i, m));
        System.out.println(Arrays.toString(arr4));

        // получение чисел, входящих в m десяток
        int[] arr5 = getFilledArray(10, input, (i, m) -> i + m * 10);
        System.out.println(Arrays.toString(arr5));

        scanner.close();
    }

    public static int[] getFilledArray(int size, int modifier, RuleCreateNum r) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.process(i, modifier);
        }
        return arr;
    }
}