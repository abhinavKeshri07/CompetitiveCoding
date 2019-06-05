import java.io.*;
import java.util.*;
//https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/min-max-difference/
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            int n, m;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i < n ; i++)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int e = n - m;
            int minSum , maxSum;
            minSum = maxSum = 0;

            for(int i = 0; i<e; i++)
            {
                minSum += arr[i];
                maxSum += arr[n-1-i];
            }
            System.out.println(maxSum - minSum);

        }
    }
}