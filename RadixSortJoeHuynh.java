// Class: CS3305 Data Structures Section 03
// Term: Spring 2022
// Name: Joe Huynh
// Program Number: #2 of Assignment 5
// IDE: Intellij Community Edition 2021.2.2, azul-13 version 15.01(JDK)

import java.util.*;
import java.lang.Math;

public class RadixSortJoeHuynh {public static void main(String[]args) {
    Scanner scan = new Scanner(System.in);
    Queue<Integer>[]list = new Queue[10]; //create the buckets of 0 to 9
    for(int i = 0; i < 10; i++){
        list[i] = new Queue<Integer>();
    }

    int maxValue = 0; //max value for to find the largest digit later
    char choice = 'Y';
    do{
    System.out.print("How many integer numbers do you have?:");
    int numAmount = scan.nextInt();
    int[] input = new int[numAmount];
    System.out.print("Enter " + numAmount + " integer numbers:");
    for (int i = 0; i < numAmount; i++) {
        input[i] = scan.nextInt();
        if(input[i] > maxValue){
            maxValue = input[i]; //gets the max value
        }
    }
    int maxLoop = (int)(Math.log10(maxValue)+1);


    System.out.println("------------------------------------------------------");

    System.out.print("Inputs array before sorting (radix): ");
    for (int j = 0; j < numAmount; j++) {
        if (j == numAmount - 1) {
            System.out.print(input[j]); //if it's the last one, no comma at the end
        } else {
            System.out.print(input[j] + ", "); //print the list out of order first
        }
    }
    radixSort(input, list,maxLoop); //radix sort

    System.out.print("\nInputs array after sorting (radix): ");
    for (int j = 0; j < numAmount; j++) {
        if (j == numAmount - 1) {
            System.out.print(input[j]); //if it's the last one, no comma at the end
        } else {
            System.out.print(input[j] + ", "); //print the list out of order first
        }
    }
        System.out.print("\nDo you want to continue? (Y/N): ");
        choice = scan.next().charAt(0);
    }while(choice == 'Y');
}
    public static void radixSort(int input[],Queue<Integer> list[],int maxLoop){
        for (int j = 0; j < maxLoop; j++) {
    for(int i = 0; i < input.length; i++) {
            int num = input[i]; //assign num to current cell value
            int Edigit = extractDigit(num,j); //extract the digit based on maxLoop's current
            list[Edigit].enqueue(num); //put it in the queue
        }
            int counter = 0; // counter for the input
    for(int c = 0; c < 10; c++){
        while(!list[c].isEmpty()){ //while the queue is not empty, dequeue until empty and increment input array
            input[counter] = list[c].dequeue();
         counter++;
        }
    }
    }
    }
    public static int extractDigit(int num, int RecursionCount){
    num = (num/(int)Math.pow(10,RecursionCount)) % 10;
    return num;
    }
}

