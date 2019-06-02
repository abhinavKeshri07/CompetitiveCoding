import java.io.*;
import java.util.*;
public class Main {
    //fibonnaci using bottom up approach
    public static void fib(int n)
    {
        int res;
        if(n == 0)
        {
            System.out.println(0);
            return;
        }
        else if(n==1)
        {
            System.out.println(1);
        }
        int a = 0;
        int b = 1;
        for(int i = 1 ;i < n ; i++)
        {
            res = a+b;
            a = b;
            b = res;
        }
        System.out.println(res);
    }
    public static void main(String args[]) {
        fib(0);
        fib(1);
        fib(2);
        fib(3);
        fib(4);
        fib(5);
        fib(6);
    }
}
