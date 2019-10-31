package com.company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[][] twoDimensionalArray = createTwoDimensionalArray(5, 5);
        int[] intArray = createArray(5, 10);
        int[] intArrayTwo = createArray(8, 10);
        int[] intArrayThree = new int[]{0, 2, 3, 4, 6, 5, 8, 7, 9};
        System.out.println("Task 1");
        System.out.println(daysOfMonth(Months.DECEMBER));
        System.out.println("-----------------------");
        System.out.println("One dimensional array:");
        System.out.println(Arrays.toString(intArray));
        System.out.println("-----------------------");
        System.out.println("Task 2");
        System.out.println(deltaMinMaxElementArray(intArray));
        System.out.println("-----------------------");
        System.out.println("Task 3");
        System.out.println(isEqualArray(intArray, intArrayTwo));
        System.out.println("-----------------------");
        System.out.println("Task 4");
        System.out.println(findMissedNumber(intArrayThree));
        System.out.println("-----------------------");
        System.out.println("Two dimensional array:");
        printTwoDimensionalArray(twoDimensionalArray);
        System.out.println("-----------------------");
        System.out.println("Task 5");
        System.out.println(findMinElementInTwoDimensionalArray(twoDimensionalArray));
        System.out.println("-----------------------");
        System.out.println("Task 6");
        printTwoDimensionalArray(swapMinMaxElementsInTwoDimensionalArray(twoDimensionalArray));
        System.out.println("-----------------------");
        System.out.println("Task 7");
        printTwoDimensionalArray(replaceOddElements(twoDimensionalArray));
        System.out.println("-----------------------");
        System.out.println("Task 8");
        System.out.println(productOfDiagonalElements(twoDimensionalArray, 2, 3));
        System.out.println("-----------------------");
        System.out.println("Task 9");
        System.out.println(isPassHoliday(Holidays.NEW_YEAR));
        System.out.println("-----------------------");

        // write your code here
    }

    public static int daysOfMonth(Months months) {
        switch (months) {
            case DECEMBER:
                return 31;

            case JANUARY:
                return 31;

            case FEBRUARY:
                return 28;

            case MARCH:
                return 31;

            case APRIL:
                return 30;

            case MAY:
                return 31;

            case JULY:
                return 30;

            case JUNE:
                return 31;

            case AUGUST:
                return 31;

            case SEPTEMBER:
                return 30;

            case OCTOBER:
                return 31;

            case NOVEMBER:
                return 30;
        }
        return -1;


    }

    public static int[] createArray(int n, int bound) {


        int[] intArray = new int[n];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = RANDOM.nextInt(bound * 2) - bound * 2 / 2;
        }
        return intArray;
    }

    public static int deltaMinMaxElementArray(int[] intArray) {
        int max = 0;
        int min = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (max < intArray[i]) {
                max = intArray[i];
            }
            if (min > intArray[i]) {
                min = intArray[i];
            }
        }
        return min - max;


    }

    public static boolean isEqualArray(int[] intArray, int[] intArrayTwo) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != intArrayTwo[i]) {
                return false;
            }

        }
        return true;

    }

    public static int findMissedNumber(int[] intArrayThree) {
        sortIntArray(intArrayThree);
        for (int i = 0; i < intArrayThree.length; i++) {
            if (i != intArrayThree[i]) {
                return i;

            }
        }
        return -1;

    }

    public static int[] sortIntArray(int[] intArrayThree) {
        for (int j = 0; j < intArrayThree.length; j++) {
            for (int i = 0; i < intArrayThree.length - 1; i++) {
                if (intArrayThree[i] > intArrayThree[i + 1]) {
                    int temp = intArrayThree[i];
                    intArrayThree[i] = intArrayThree[i + 1];
                    intArrayThree[i + 1] = temp;

                }
            }


        }

        return intArrayThree;
    }

    public static int findMinElementInTwoDimensionalArray(int[][] twoDimensionalArray) {
        int min = twoDimensionalArray[0][0];
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][j] < min) {
                    min = twoDimensionalArray[i][j];

                }
            }
        }
        return min;
    }

    public static int[][] createTwoDimensionalArray(int length, int width) {
        int[][] twoDimensionalArray = new int[length][width];


        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                twoDimensionalArray[i][j] = RANDOM.nextInt(20) - 10;


            }

            // write your code here
        }

        return twoDimensionalArray;
    }

    public static void printTwoDimensionalArray(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            System.out.println(Arrays.toString(twoDimensionalArray[i]));
        }
    }

    public static int[][] swapMinMaxElementsInTwoDimensionalArray(int[][] twoDimensionalArray) {
        int min = 0;
        int max = 0;
        int indexMaxI = 0;
        int indexMaxJ = 0;
        int indexMinI = 0;
        int indexMinJ = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (max < twoDimensionalArray[i][j]) {
                    max = twoDimensionalArray[i][j];
                    indexMaxI = i;
                    indexMaxJ = j;

                }
                if (twoDimensionalArray[i][j] < min) {
                    min = twoDimensionalArray[i][j];
                    indexMinI = i;
                    indexMaxJ = j;

                }
            }


        }
        twoDimensionalArray[indexMaxI][indexMaxJ] = min;
        twoDimensionalArray[indexMinI][indexMinJ] = max;
        return twoDimensionalArray;


    }

    public static int[][] replaceOddElements(int[][] twoDimensionalArray) {

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][0] % 2 != 0) {
                    twoDimensionalArray[i][0] = 0;
                }


            }
            for (int j = 1; j < twoDimensionalArray[i].length; j++) {
                if (twoDimensionalArray[i][j] % 2 != 0) {
                    twoDimensionalArray[i][j] = twoDimensionalArray[i][j - 1];

                }
            }

        }
        return twoDimensionalArray;
    }

    public static int productOfDiagonalElements(int[][] twoDimensionalArray, int numberArray, int numberElementArray) {
        int product = 0;
        try {
            product = twoDimensionalArray[numberArray - 1][numberElementArray - 1] * twoDimensionalArray[numberArray - 1][numberElementArray + 1] * twoDimensionalArray[numberArray + 1][numberElementArray - 1] * twoDimensionalArray[numberArray + 1][numberElementArray + 1];


        } catch (Exception e) {


        }
        return product;
    }

    public static boolean isPassHoliday(Holidays holidays) {

        LocalDate date = LocalDate.now();
        int year = date.getYear();


        switch (holidays) {
            case NEW_YEAR:
                if (date.isAfter(LocalDate.of(year, 1, 1))) ;
                return true;

            case WOMANS_DAY:
                if (date.isAfter(LocalDate.of(year, 3, 8))) ;
                return true;
            case VICTORY_DAY:
                if(date.isAfter(LocalDate.of(year,5,9)));
                return true;
            case HALLOWEEN:
                if(date.isAfter(LocalDate.of(year, 10,31)));
                return true;
        }
        return false;

    }
}


