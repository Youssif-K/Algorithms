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

    // public static void main(String[] args) throws Exception {
    //     String loadFile = args[0];
    //     String url;
    //     if(loadFile.equals("1")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/1Kints.txt";
    //     }else if(loadFile.equals("2")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/2Kints.txt";
    //     }else if(loadFile.equals("4")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/4Kints.txt";
    //     }else if(loadFile.equals("8")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/8Kints.txt";
    //     }else if(loadFile.equals("16")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/16Kints.txt";
    //     }else if(loadFile.equals("32")){
    //         url = "https://algs4.cs.princeton.edu/14analysis/32Kints.txt";
    //     }else{
    //         url = "https://algs4.cs.princeton.edu/14analysis/1Mints.txt";
    //     }

    //     //url = "https://algs4.cs.princeton.edu/14analysis/2Kints.txt";
    //     URL accessURL = new URI(url).toURL();
    //     URLConnection connection = accessURL.openConnection();
    //     BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
    //     Stopwatch watch = new Stopwatch();
    //     System.out.println("Number of triples in the file: "+ count(buffer.lines().mapToInt(num -> Integer.parseInt(num.replace(" ", ""))).toArray()));
    //     System.out.println("Elapsed time: "+watch.elapsedTime());
    //     buffer.close();
    // }
}
