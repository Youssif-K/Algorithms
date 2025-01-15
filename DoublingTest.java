import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Random;
//import java.util.random.*;
public class DoublingTest {
    public static double timeTrial(int N, long seed){
        int MAX = 1000000;
        int[] a = new int[N];
        Random random = new Random(seed);
        for(int i = 0; i < N; i++){
            a[i] = random.nextInt();
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) throws Exception {
        if(args.length > 0){
            String loadFile = args[0];
            String url;
            if(loadFile.equals("1")){
                url = "https://algs4.cs.princeton.edu/14analysis/1Kints.txt";
            }else if(loadFile.equals("2")){
                url = "https://algs4.cs.princeton.edu/14analysis/2Kints.txt";
            }else if(loadFile.equals("4")){
                url = "https://algs4.cs.princeton.edu/14analysis/4Kints.txt";
            }else if(loadFile.equals("8")){
                url = "https://algs4.cs.princeton.edu/14analysis/8Kints.txt";
            }else if(loadFile.equals("16")){
                url = "https://algs4.cs.princeton.edu/14analysis/16Kints.txt";
            }else if(loadFile.equals("32")){
                url = "https://algs4.cs.princeton.edu/14analysis/32Kints.txt";
            }else{
                url = "https://algs4.cs.princeton.edu/14analysis/1Mints.txt";
            }
    
            //url = "https://algs4.cs.princeton.edu/14analysis/2Kints.txt";
            URL accessURL = new URI(url).toURL();
            URLConnection connection = accessURL.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int[] a = buffer.lines().mapToInt(num -> Integer.parseInt(num.replace(" ", ""))).toArray();
            Stopwatch watch = new Stopwatch();
            System.out.println("Number of triples in the file: "+ ThreeSum.count(a));
            System.out.println("Elapsed time: "+watch.elapsedTime());
            buffer.close();
        }else{
            for(int N = 250; N<16_000; N+=N){
                int seed = 0;
                System.out.println("Number of digits: " + N + "\n" + "Time taken: " + timeTrial(N, seed));
            }
        }
    }
}
