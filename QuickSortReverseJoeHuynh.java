// Class: CS3305 Data Structures Section 03
// Term: Spring 2022
// Name: Joe Huynh
// Program Number: #1 of Assignment 5
// IDE: Intellij Community Edition 2021.2.2, azul-13 version 15.01(JDK)

import java.util.*;

public class QuickSortReverseJoeHuynh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice = 'Y';
        do{
            System.out.print("How many integer numbers do you have?:");
            int numAmount = scan.nextInt();
            int[] input = new int[numAmount];

            System.out.print("Enter " + numAmount + " integer numbers:");
            for (int i = 0; i < numAmount; i++) {
                input[i] = scan.nextInt();
            }

            System.out.println("------------------------------------------------------");

            System.out.print("Inputs array before sorting (quick): ");
            for (int j = 0; j < numAmount; j++) {
                if (j == numAmount - 1) {
                    System.out.print(input[j]); //if it's the last one, no comma at the end
                } else {
                    System.out.print(input[j] + ", "); //print the list out of order first
                }
            }
            quickSort(input, 0, input.length - 1);

            System.out.print("\nInputs array after sorting (quick): ");
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

    private static void quickSort(int[] input, int first, int last) {
        if (last > first){ //As long as last is bigger, go on with the recursion, otherwise it stops
            int NewPivot = partition(input, first, last); //partition the array and get a new pivot
            quickSort(input, first, NewPivot - 1); //new pivot is last
            quickSort(input, NewPivot + 1, last);//new pivot is first+1
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivotElement = list[first]; //First is the pivotElement
        int low = first + 1; //lower part of the array
        int high = last; // upper part of the array

        while (high > low) {

            while (low <= high && list[low] >= pivotElement) //look from left and iterate
                low++;

            while (low <= high && list[high] < pivotElement) //look from right and iterate
                high--;

            if (high > low) { //when high is lower than low, switch them
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] <= pivotElement)
            high--;

        if (pivotElement < list[high]) { //if pivot is less than high, swap them
            list[first] = list[high];
            list[high] = pivotElement;
            return high; //high becomes new pivot
        }
        else {
            return first; //return the first element
        }
    }
    }
