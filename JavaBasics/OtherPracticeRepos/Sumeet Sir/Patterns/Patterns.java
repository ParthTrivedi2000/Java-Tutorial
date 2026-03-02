public class Patterns {
    public static void main(String[] args) {
        
    }

    static void pattern1(int n){
        // normal vali jisme sari rows m sare columns pe * print ho.
    }

    static void pattern2(int n){
        // left aligned triangle
    }

    static void pattern3(int n){
        // left aligned ulta triangle
    }

    static void pattern4(int n){
        // right aligned triangle
    }

    static void pattern5(int n){
        // right aligned ulta triangle
    }

    static void pattern6(int n){
        // diamond shape 
    }

    static void pattern7(int n){
        // *** ***
        // **   **
        // *     *
        // **   **
        // *** ***
         

        int prev_stars = (int) n/2 + 1;
		int spaces = 1 ;
		int post_stars = (int) n/2 + 1;
		
		for(int i=1; i<=n; i++)
		{
		    for(int j=1;j<=prev_stars;j++)
		    {
		        System.out.print("*");
		    }
		    for(int j=1;j<=spaces;j++)
		    {
		        System.out.print(" ");
		    }

		    for(int j=1;j<=prev_stars;j++)
		    {
		        System.out.print("*");
		    }
            
		    if(i<=n/2)
		    {
		        prev_stars--;
		        spaces +=2;
		        post_stars--;
		    }
		    else
		    {
		        prev_stars++;
		        spaces -=2;
		        post_stars++;
		    }
		    
		    System.out.println();
		}
    }
}
