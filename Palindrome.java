import java.util.*;

import javax.naming.spi.ResolveResult;

public class Palindrome {

    public static boolean pali(int n){
        int temp = n;
        int reverse=0;
        while(n>0)
        {
            int rem = n%10;
            reverse = reverse*10+ rem;
            n=n/10;
        }
        if (temp==reverse)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner any = new Scanner(System.in);
        int number = any.nextInt();
        System.out.println(pali(number)); 
    }

}
