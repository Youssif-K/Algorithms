package three_sum_problem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
public class Main {
    public static double timeTrial(int N, long seed){
        int MAX = 1000000;
        int[] a = new int[N];
        Random random = new Random(seed);
        for(int i = 0; i < N; i++){
            a[i] = random.nextInt();
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.optimizedCounting(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Do you want to read the numbers from a public url file?[y/n]");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if(answer.toLowerCase().equals("y")){
            System.out.println("How many numbers you want to have [1,2,4,8,16]");
            int argument = sc.nextInt();
            String url;
            if(argument <= 32 && argument >= 1){
                url = "https://algs4.cs.princeton.edu/14analysis/" + argument + "Kints.txt";
                System.out.println(url);
            }else{
                url = "https://algs4.cs.princeton.edu/14analysis/1Mints.txt";
            }
            sc.close();
            URL accessURL = new URI(url).toURL();
            URLConnection connection = accessURL.openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int[] a = buffer.lines().mapToInt(num -> Integer.parseInt(num.replace(" ", ""))).toArray();
            Arrays.sort(a);
            Stopwatch watch = new Stopwatch();
            System.out.println("Number of triples in the file: "+ ThreeSum.optimizedCounting(a));
            System.out.println("Elapsed time: "+ watch.elapsedTime());
            buffer.close();
        }else{
            for(int N = 250; N<16_000; N+=N){
                int seed = 0;
                System.out.println("Number of digits: " + N + "\n" + "Time taken: " + timeTrial(N, seed));
            }
        }
    }
}
