package caseStudy.percolation;

import java.io.*;
import java.util.*;
import princetonLibs.*;

public class Percolation {

    public static void main(String[] args) throws FileNotFoundException {

        String addressFile = "resources/test1.txt";
        File file = new File(addressFile);
        Scanner input = new Scanner(file);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] isOpen = new int[n][m];

        // Read grid from file
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isOpen[i][j] = input.nextInt();
            }
        }
        input.close();

        // Print original file content
        System.out.println("The Original File Content: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(isOpen[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Print the flow (full sites)
        StdArrayIO.print(flow(isOpen));

        // Check and print if it percolates vertically
        StdOut.println("Percolates: " + percolate(isOpen));
    }

    //-------------------- flow Method --------------------
    public static int[][] flow(int[][] isOpen) {
        int n = isOpen.length;
        int[][] isFull = new int[n][n];

        // Fill top row if open. we want to check if the top is 0 which indicates the water can percolates
        for (int j = 0; j < n; j++) {
            if (isOpen[0][j] == 0) {
                isFull[0][j] = 1;
            }
        }

        // Vertical percolation (top to bottom only)
        // For each site, we want to check:
        // if it’s open (0) and the site above it is full (1),
        // then water flows down, so we mark it full (1) too.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	
                // site is open AND above site is full
                if (isOpen[i][j] == 0 && isFull[i - 1][j] == 1) {
                    isFull[i][j] = 1;
                } else {
                    isFull[i][j] = 0;
                }
            }
        }

        return isFull;
    }

    //-------------------- percolate Method --------------------
    public static boolean percolate(int[][] isOpen) {
        int[][] isFull = flow(isOpen);
        int n = isOpen.length;

        // Check if bottom row has a full site (1)
        for (int j = 0; j < n; j++) {
            if (isFull[n - 1][j] == 1) return true;
        }
        return false;
    }
}
