package WEEK1;
import java.util.Scanner;
public class Q2 {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ether the number:");
        int a=sc.nextInt();
        if(a%2==0)
        {
            System.out.println("the given number "+a+" is an even number");
        }
        else {
            System.out.println("the given number "+a+" is a odd number");
        }
    }
}
