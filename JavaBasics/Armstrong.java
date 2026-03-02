import java.util.*;
// All Questions by Saksham Started :-
public class Armstrong{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // Approach
        // 1] get digit from number
        // 2] cube it
        // 3] compare and give result
        int temp = n;
        int digit = 0;
        long sum = 0;
        while(n!=0)
        {
            digit = n%10;
            sum = sum + (digit*digit*digit);
            n = n/10;
        }
        
        if(sum == temp)
        {
            System.out.println("Armstrong");
        }
        else
        {
            System.out.println("Not Armstrong");
        }
        scn.close();
    }
}