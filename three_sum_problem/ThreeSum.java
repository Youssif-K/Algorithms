package three_sum_problem;

/******************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum input.txt
 *  Dependencies: In.java StdOut.java Stopwatch.java
 *  Data files:   https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with cubic running time. Reads n integers
 *  and counts the number of triples that sum to exactly 0
 *  (ignoring integer overflow).
 *
 *  % java ThreeSum 1Kints.txt
 *  70
 *
 *  % java ThreeSum 2Kints.txt
 *  528
 *
 *  % java ThreeSum 4Kints.txt
 *  4039
 *
 ******************************************************************************/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class ThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                for(int k = j+1; k < N; k++){
                    if(a[i]+a[j]+a[k] == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static int optimizedCounting(int[] a){
        int N = a.length;
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                int missingNumber = -1*(a[i] + a[j]);
                int min = j+1;
                int middle = (j + N -1)/2;
                int max = N-1;
                while(max >= min){
                    if(missingNumber == a[middle]){
                        cnt++;
                        break;
                    }else if(missingNumber > a[middle]){
                        min = middle + 1;
                        middle = (max+min)/2;
                    }else if(missingNumber < a[middle]){
                        max = middle - 1;
                        middle = (max+min)/2;
                    }
                }
            }
        }

        return cnt;
    }
}
