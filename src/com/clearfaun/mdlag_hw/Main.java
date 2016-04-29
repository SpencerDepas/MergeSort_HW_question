package com.clearfaun.mdlag_hw;

import java.util.Arrays;

public class Main {

    private static int[] arrayA;
    private static int arrayASize = 20;
    private static int[] arrayB;
    private static int arrayBSize = 10;

    public static void main(String[] args) {
	// write your code here

        //Merge question
        //*You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold
        //B. write a method to merge B into A in sorted order.


        //generates two random arrays
        QuickSort quickSort = new QuickSort(20);
        arrayA = quickSort.generateRandomArray();
        arrayA = quickSort.quickSort(0, 9);
        System.out.println("Sorted Array A:" + Arrays.toString(arrayA));
        QuickSort quickSortB = new QuickSort(10);
        arrayB = quickSortB.generateRandomArray();
        arrayB = quickSortB.quickSort(0, 9);
        System.out.println("Sorted Array B:" + Arrays.toString(arrayB));

        //arrayA output [11, 13, 17, 21, 23, 28, 31, 33, 34, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //zero represents buffer

        //arrayA output  B:[11, 14, 21, 31, 32, 43, 48, 54, 58, 58]

        //below is merge sort algorythem


        arrayA = mergeSort(arrayA, arrayB);

        System.out.println("Merge Sorted Array A:" + Arrays.toString(arrayA));
        //output A:[11, 11, 13, 14, 17, 21, 21, 23, 28, 31, 31, 32, 33, 34, 37, 43, 48, 54, 58, 58]

    }

    static int sizeOfArrayA;

    public static int[] mergeSort(int[] arrayA, int[] arrayB){


        int indexForA = 9;
        int indexForB = 9;
        int counter = 0;
        sizeOfArrayA = arrayA.length -1;




        //big o of
        //not ure but it is <= O(n)
        while(true){


            System.out.println("counter : " + counter );
            counter ++;
            if(indexForB < 0 || indexForA  < 0){
                System.out.println("arrayBSize -1 : " + arrayBSize );
                System.out.println("arrayASize -1 : " + arrayASize );
                System.out.println("indexForB > arrayBSize -1 || indexForA > arrayASize -1" );
                break;
            }

            System.out.println("comparing:" );
            System.out.println("arrayA[indexForA]:" + arrayA[indexForA] );
            System.out.println("arrayB[indexForB]:" + arrayB[indexForB] );

            if(arrayA[indexForA] > arrayB[indexForB]){
                //
                System.out.println( arrayA[indexForA] + " arrayA[indexForA] > arrayB[indexForB]" );
                arrayA = putAtEndOfArrayA(indexForA, arrayA);
                indexForA--;

            }else {
                System.out.println(arrayB[indexForB] + " arrayB[indexForB] > arrayA[indexForA]" );
                arrayA = putAtEndOfArrayA(indexForB, arrayB);
                indexForB--;

            }

            System.out.println("Merge Sorted Array A:" + Arrays.toString(arrayA));

        }

        return arrayA;

    }

    public static int[] putAtEndOfArrayA(int highestIndex, int[] array){
        System.out.println("putAtEndOfArrayA highestIndex:" + array[highestIndex]);

        arrayA[sizeOfArrayA] = array[highestIndex];

        sizeOfArrayA--;
        return arrayA;
    }


}
