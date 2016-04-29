package com.clearfaun.mdlag_hw;

/**
 * Created by SpencerDepas on 4/28/16.
 */
public class QuickSort {

    private static int[] theArray;
    private static int arraySize;

    //quicksort
    QuickSort(int newArraySize){

        arraySize = newArraySize;
        theArray = new int[arraySize];
        generateRandomArray();

    }

    public int [] quickSort(int left, int right){

        if(right - left <= 0){
            return null;
        }else {

            int pivot = theArray[right];



            int pivotLocation = partitionArray(left, right, pivot);


            quickSort(left, pivotLocation -1);
            quickSort(pivotLocation +1, right);
        }
        return theArray;

    }

    public int[] generateRandomArray (){
        //Construct the array we're using here


        for(int i = 0 ; i < 10; i ++){

            theArray[i] =  (int)(Math.random() * ( 50 ) + 10);

        }

        return  theArray;
    }

    public int partitionArray(int left, int right, int pivot){

        int leftPointer = left -1;
        int rightPointer = right;


        while(true){

            while(theArray[++leftPointer] < pivot)
                ;



            while (rightPointer > 0
                    && theArray[--rightPointer] > pivot);
            //fins the index of the right side that is smaller than the pivot




            if(leftPointer >= rightPointer){


                 break;


            }else{


                swapValues(leftPointer, rightPointer);


            }




        }


        swapValues(leftPointer, right);

        return leftPointer;

    }


    public void swapValues(int indexOne, int indexTwo){

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }
}
