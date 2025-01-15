import java.util.*;
import java.lang.Math;

public class Converter{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // int num = scn.nextInt();

        // int decimal = scn.nextInt();
        // int base = scn.nextInt();

        // int num = scn.nextInt();
        // int b1 = scn.nextInt();
        // int b2 = scn.nextInt();

        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int b = scn.nextInt();

        Converter conv = new Converter();


        // System.out.println(conv.toBinary(num));

        // System.out.println(decimalToAnyBase(decimal, base));

        // System.out.println(anyBaseToDecimal(decimal, base));

        // System.out.println(anyBaseToAnyBase(num,b1,b2));

        System.out.println(anyBaseAddition(num1,num2,b));
    }

    public String toBinary(int decimalNumber) {
        String result = "";

        while(decimalNumber!=0)
        {
            int lastBit = decimalNumber & 1;
            result = lastBit + result;
            decimalNumber = decimalNumber >> 1;
        }

        return result;
    }

    public static int decimalToAnyBase(int decimal,int base)
    {
        int i = 0;
        int sum=0;
        while(decimal != 0)
        {
            int rem = decimal%base;
            sum = sum + ((int)Math.pow(10,i)*rem);
            decimal = decimal/base;
            i++;
        }
        return sum;
    }

    // public static int anyBaseToDecimal(int decimal,int base) :- almost same as above.


    public static int anyBaseToAnyBase(int decimal,int base1, int base2)
    {
        int i = 0;
        int sum=0;
        while(decimal != 0)
        {
            int rem = decimal%base2;
            sum = sum + ((int)Math.pow(base1,i)*rem);
            decimal = decimal/base2;
            i++;
        }
        return sum;
    }

    public static int anyBaseAddition(int num1, int num2, int base)
    {

        // By me :-
        String s1 = "";
        int res = 0;
        int carry = 0;

        while(num1!=0 || num2!=0)
        {
            
            res = ((num1%10 + num2%10 + carry)%base);
            
            if ((num1%10 + num2%10)/base >0)
            {
                carry=1;
            }
            else {
                carry = 0;
            }
            
            s1 = res+s1;
            
            num1 = num1/10;
            num2 = num2/10;
        }
        s1 = carry+s1;

        return Integer.parseInt(s1);


        // By Sumeet sir :-

        //  int rv = 0;
        //  int c = 0;
        //  int p = 1;
        //  while(n1>0 || n2>0 || c>0)
        //  {
        //     int d1 = n1%10;
        //     int d2 = n2%10;

        //     n1 = n1/10;
        //     n2 = n2/10;

        //     int d = d1 + d2 + c;
        //     c = d/b;  // ye kya krega ki agr value d ko base se divide krne pe vo grater than
                        // 1 aati h it masn carry = 1 hoke aagr forward hoti h... to vo divide
                        // hoke 1 aa rhi h ki nh vo yha se check kr rhe h....agr nh aayegi to 
                        // automatically value 0 ho jayegi.
        //     d = d%b;

        //     rv += d*p;
        //     p = p*10;
        //  }

        // return rv;
        
    }

    public static int anyBaseSubtraction(int num1, int num2, int base)
    {
        int res = 0;

        return res;
    }
}