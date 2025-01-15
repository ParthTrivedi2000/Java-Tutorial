import java.util.*;

public class Basics{
    // public static void main(String[] args){
    //     System.out.println("Hello Parth");
    // }

    
    
    // 2) Taking Input from the user :- 
    // For taking the input from user, we have to use Scanner class. we have to create one object of
    // scanner class, then we have to use methods on that object to get input from user or system.
    public static void main(String[] args) {

        // Scanner input = new Scanner(System.in);  // creating object from scanner class
        // int a = input.nextInt();   // taking Integer value only as an input.
        // float b = input.nextFloat();  // taking float value only as an input.
        // String c = input.next(); //taking only one character or one word. not whole sentance.
        // String name = input.nextLine(); // taking string with some words or more than one words.(i.e. sentances)
        // or we can say taking all the strings or words from that whole line in which cursor is present.
        // long p = input.nextLong(); // taking input as long datatype.
        // it is good practice to write L or l with constants as well while performing operations
        // with long type variable. or else anyway constants will also be converted into long by implicite
        // type casting.
        // long sum = p*(p+1L)/2L;
        // System.out.println(name);
        
        // now for example for variable b, it can only accept or store float. if we enter another
        // type of value while giving input, then java will give InputMismatch error.

        // ***** Important Thing*****
        // if inputs are given in same line or next lines it wont's affect the code.means for exa.
        // int x = input.nextInt();
        // int y = input.nextInt();
        // int z = input.nextInt();

        // Now I am providing input in this manner: 23 45 57 :- it will work fine and store each
        // value in each variable.
        // If I am providing input like this :- 
        // 23
        // 45
        // 57
        // this is also fine.and store each value in each variable. 
        // Because in java, they will inputting the input based on space. means they are using space
        // as identifire.

        // so jst mean to say that, on so many platforms input is given like so many integers are space
        // seperated. so we can take that input as shown above.




        // Time Complexity:-

        // Scanner any = new Scanner(System.in);
        // int n = any.nextInt();
        
        // Below loop will run n times. hence it is having time complexity of O(n).
        // for(int i=0; i<=n; i=i+1){
        //     System.out.println("Hello");
        // }

        // How many times below loop will run?
        // for(int i=0; i<=n; i=i*2){
        //     System.out.println("Hello");
        // }
        // For above loop
        // initially i = 1
        // Stpe - 1:- i = 2*1 = 2
        // Step - 2:- i = 2*2 = 4
        // Step - 3:- i = 4*2 = 2^3 = 8
        // Step - 4:- i = 8*2 = 2^4 = 16
        // i.e. at Kth step value of i will be 2^k. And loop will terminate at below condition.
        // i>n --> 2^k>n
        // taking log base 2 at both sides
        // K > log n base 2.
        // it means above loop will run log n(base 2) times.

        // How many times below loop will run?
        // for(int i=0; i<=n; i=i+2){
        //     System.out.println("Hello");
        // }
        // For above loop take pen nd paper find value of i at each step.
        // So above loop will run n/2 times.

        // Q) get the number from user and print the numbers from 1 to n^2 in grid(matrix) format.

        // Scanner any = new Scanner(System.in);
        // int n = any.nextInt();
        // int number = 1;

        // for (int i=1;i<=n;i=i+1) // for rows
        // {
        //     for (int j=0;j<=n;j=j+1) // task for particular row
        //     {
        //         System.out.println(number+" ");
        //         number = number+1;
        //     }
        //     System.out.println();
        // }

        // How many times above loop will run?
        // Outer loop will un N times and inner loop will run N times. it means 
        // total no. of operations = N^2.

        // Time Complexity Theory:- the time complexity is the computational complexity that describes
        // the amount of computer time it takes to run an algorithm.
        // The amount of memory used by a program contributes to the space complexity.
        // Big-O notation is the language we use for talking about how long an algorithm takes to
        // run(time complexity) or how much memory is used by an algorithm(space complexity)
        // Most discussions of Big-O focus on the "upper-bound" running time of an algorithm, which
        // is often termed the worst-case.
        // Big-O notation is a way to track how quickly the runtime grows relative to the size of
        // the input.
        
        // total no. of operations is contributing to the time complxity. and  variables and
        // data structures is contributing to the space complexity.

        // for(int i=0;i<5*n;i=i+1)
        // {
        //     System.out.println(i);
        // }
        // How much time above loop will run?
        // It will run 5n times. it means 5n operations will be executed.
        // Bt MIMP:- constant won't affect in time complexity. or constant should not be considered
        // in time complexity. 
        // It means time complexity for above loop is O(N).

        // for (int i=0;i<=n;i=i+5)
        // {
        //     System.out.println(i);
        // }
        // How many times above loop will run?
        // avobe loop has n/5 no. of operations. bt as discussed above, constant wo't included in
        // time complexity. hence time complexity of above loop will be O(N).

        // One more important thing is in whole programm, hmare pass bahot sara code hota he (including
        // so many single line operations(which has having constant O(1) time complexity) and so many
        // loops which are having different time complexities.) so pure programm me se hm log vhi loop
        // ki time complexity ko apne main code ki time complexity consider krenge jiski time
        // complexity sbse jyada hogi.
        
        // order:- O(1) < O(log n) < (log N)^2 < O(N) < O(N*log N) < O(N^2) < O(N^3) < O(2^n)

        // for(int i=0;i<=n;i++)
        // {
        //     for (int j=i+1;j<=n;j++)
        //     {
        //         System.out.println("hello");
        //     }
            // step - 1:- i=1, N-1 operations
            // step - 2:- i=2, N-2 operations
            // Step - 3:- i=3, N-3 operations

            // Stpe - n:- i=n, 0 operations

            // total operations:- (N-1)+(N-2)+(N-3)...+0 = N(N-1)/2=N^2 - N
            // Time complexity :- O(N^2)
        // }

        // for(int i=0;i<=n;i++)
        // {
        //     for (int j=1;j<=n;j=j*5)
        //     {
        //         System.out.println("hello");
        //     }
            // Step - 1:- i=1, log n operations
            // Step - 2:- i=2, log N operations
            // Step - 3:- i=3, log N operations

            // Total Operations:- N*(log N)
            // Time Complexity:- N*(log N)

        // }


        // for(int i=0;i<=n;i=i*2)
        // {
        //     for (int j=1;j<=n;j=j*5)
        //     {
        //         System.out.println("hello");
        //     }

        // }


        // ***************** Arrays ****************************************
        // Array is a collection of similar type of data.
        // Arrays can be used to store data.

        // Prototype :-
        // 
        // 1) datatype arrayName[]= new datatype[size];
        // 2) datatype[] name = new datatype[size];
        // 3) datatype name[] = {values}; // values are present inside heap, nd reference is present
        // inside stack.

        // Example :-
        // 1) int arr[] = new int[5];
        // 2) int[] arr = new int[5];
        // 3) double d[]= new double[100];
        // 4) char a[] = new char[100];

        // int arr1[] = new int[5];
        // Note:-
        // 1) All the Variables and Funcions are stored inside the stack memory. And all the Objects
        // and classes of code are stored inside the heap memory.
        // 2) Array always occupies continuous memory blocks in memory. Or array elements always
        // stored in continous manner in memory in java
        // 3) All the 5 elements are stored in heap memory only. But referrence variable (means here arr1)
        // will be stored in the stack memory.
        // 4) That reference variable will contain the starting address of arrays.Pls not that reference
        // itself won't occupy any space in stack, it will jst point out the array presented in the 
        // heap.
        // 5) fetching or searching any element from the array for any indexes will be constant.
        // exa:- searching arr[705] from 1000 elements array has also O(1) time complexity.
        

        // Shallow Copy and Deep copy :-

        // int arr[] = new int[5];
        // arr[0] = 10;
        // arr[1] = 20;
        // arr[2] = 100;
        // arr[3] = 30;
        // arr[4] = 40;

        // int tmp[] = arr;
        // tmp[2] = 10;

        // Now what happens? is the arr[2] is also changed or as it is?
        // Soln:- remember here while creating temp, we haven't used new keyword. and jb tk new 
        // keyword ka use nhi kiya tb tk heap memory me kuch nya create nhi hoga. So this tmp
        // is present inside the stack and it is also referring he same array which is reffred by
        // arr and which is actully present inside the heap memory.


        // How to input array from user?

        // Scanner any = new Scanner(System.in);
        // int n = any.nextInt();
        // int arr[] = new int[n];

        // for(int i=0;i<n;i++)
        // {
        //     arr[i] = any.nextInt();
        // }
        // Space complexity for above program is O(N). And Time Complexity will be O(N).



        // 2-D Arrays :-
        // 2D array can be defined as an array of arrays. The 2D array is organized as  matrices
        // which can be represented as the collection of rows and columns.
        // The syntax of declaring two dimensional array is very much similar to that of a one
        // dimensional array, given as follows.

        // Syntax :- int arr[max_rows][max_columns];

        // Prototype:-
        // datatype arrayName[][] = new datatype[rowsize][columnsize];
        // exxample:- 
        // int arr[][] = new int[4][3]; //Space Complexity:- O(Row*Coumn) or we can say Quadratic.
        // memory allocated :- rowsize*columnsize*datatypeSize-->4*3*4(here)-->48 bytes

        // whenever we want to store data into matrices or in grid form then we can use 2D arrays.

        // How to print or input the elements of 2D array?
        // for(int i=0;i<row;i++){ // iteration n Rows (i.e. row times)
        //     for(int j=0;j<column;j++){ // iterating on clumns (i.e. column times)
        //         // arr[i][j] :- means element at ith row and jth column
        //         System.out.println(arr[i][j]); // it will print all the elements in single line.
        //         // arr[i][j] = any.nextInt(); // to take input or store in 2D array
        //     }
        // }


        // Q) only print the diagonal elements.

        // int row = input.nextInt();
        // int column = input.nextInt();
        // int arr[][] = new int[row][column];

        // Appraoch - 1) O(N^2) time complexity
        // for(int i=0;i<row;i++){
        //     for(int j=0;j<column;j++){
        //         if(i==j){
        //             System.out.println(arr[i][j]+" ");
        //         }
        //     }
        // }
        
        // Approach - 2) O(N) time complexity
        // for(int i=0;i<row;i++){
        //     System.out.println(arr[i][i]+" ");
        // }



        // Q) only print the reverse diagonal elements.

        // for(int i=0;i<row;i++){
        //     System.out.println(arr[i][row-i-1]+" ");
        // }



        // Difference between all inputs:-
        // Scanner any = new Scanner(System.in);
        // int a = any.nextInt(); // what nextInt will do is it will try to find integer. Once it
        // find integer then cursor will stop at space if something is there next after. bt if 
        // next input is in the next line or in 1st line only one integer is present then cursor
        // will move to the nextline after finding 1st integer.
        // String b = any.nextLine(); // above is not the case with nextLine. what nextLine will do is
        // it will store whole line or all the words in the line where cursor is present. after storing
        // it, it will move to the next line if 
        // System.out.println(a);


        // So be very carefull while use nextLine(). so simple ek cheez yad rkhna ki nextInt,
        // nextFloat, nextDouble, nextLong, next() --> in sb ki working kese he ki jb for example
        // mene int a = nextInt likha he to kya hoga ki cursor jo line me he usme nextInt Integer find
        // krne ka start krega. jese hi ,mil jayega integer to vo a me store kr dega and cursor vha pe
        // stop krke vha pe hi rhega. aur agr puri line me integer khi pe bhi nhi mila to cursor automatic niche
        // vali line me jump krega or usme apna search jari rkhega. Bt nextLine() ko use kiya he tb usme
        // cursor jo bhi line me he vo line me search sentence ka search start hoga. agr sentence ya word
        // mil jayega to vo store kr dega bt agr nhi mila to vo search krne ke liye automatic next line me nhi jayega
        // blki ye line me jo nhi mila he(means nothing present) usko hi store kr lega.(i.e empty ko hi).

        
        // ****************** Functions ***********************
        // Prototype or syntax :-
        // access_specifier static return_ytpe functionName(Some Argument)
        // Argument = Give input to the function
        // return_type = Value returned by function datatype is return type
        //  If you don't want to return anything then return type will be void

        //  Static--> keyword (currently writing this is cumpulsory, will learn more in OOPS)
        // Example:- see above main function.


        // ******************** String ***************************
        // Scanner in = new Scanner(System.in);
        // String word = in.next();
        // System.out.println(word.charAt(3)); // string.charAt(index) --> will return
        // the character at that particular index.
        // System.out.println(word.length()); //  will return the length of the string

        // In java, String is basically an object that represents sequence of char values.
        // String s1 = "hello";
        // String s2 = "hello"; // will not create a new instance.
        // Important points :-
        // 1) strings are object in java.
        // 2) Strings are immutable in java. means once it is created we can't modify it.
        //      Case - 1] 
        // String s1 = "abc";
        // now if we write s1.charAt[1] = 'z' // it will give error bec strings are immutable in java
        //      Case - 2]
        // String s1 = "abc";
        // String s2 = "abc"; // it will not create new instance means first java will check weather
        // "abc" is available in heap mmory or not. if not then only it will create. but if present then java
        // will point out to same value only. So here in this case both reference variable s1 and s2
        // are pointing out to same "abc" only. hence if we perform anything on s2 will make change in
        // s1 as well and vice versa. And this senario is same applicable to array as well.
        //      Case - 3]
        // String s1 = "abc";
        // s1.concat("def"); // concat will add multiple strings.
        // now jst after writing above 2 lines try to print s1. still it will give same value "abc". y?
        // reason :- so as we know strings are immutable. so it won't change in the previously created
        // string. instead new value "abcdef" will be created in the heap memory after writing s.concat
        // line. bt no reference variable is pointing out to this value. bec s1 is still pointing out to 
        // "abc" only. So what if I want to add this value to string?
        // we have to write s1 = s1.concat("def"); this will also create new instane in the heap memory
        // with the value of "abcdef". but now there is one reference variable (s1) also which is pointing 
        // out this value "abcdef". so now try to print s1. it will give "abcdef".

        // 3) Strings are also stored similar as Arrays in java. for exmple:-  String name = parth;
        // then parth is the value stored in the variable. so this value will be stored in the 
        // heap memory while execute above line. and name which is variable and which is
        // referencing the value. that reference will be there in the stack memory. And similar
        // things happens with Array as well. But (MIMP) remember one thing that suppose 4 bytes array
        // or string whatever will be created. bt all those 4 bytes are reserved to store the value in
        // the heap memory only. reference which resides in stack memory won't utilize any memory. It 
        // will jst point out the value in the heap.

        // --> if we write
        // int x = 'A' - 'c';  // java will subtract the ASCII value of 'A' and 'c' and result will store in x.

        // Now if we want to compare 2 integers we are directly writing 5<10 or something. but what if we
        // want to compare 2 strings. So for that we are having compareTo function.
        // How compareTo() function works? :- it will do in lexicographic order
        // String s1 = "ABC";
        // String s2 = "ABC";
        // System.out.println(s1.compareTo(s2)); // both strings(s1-s2) are same so it will return 0.

        // String s1 = "ABCD";
        // String s2 = "ABDF";
        // System.out.println(s1.compareTo(s2));
        // in above case compare To function will start comparing from first char. but wherever it 
        // finds first mismatch there it will perform subtraction by actual position. so in this example
        // 'C' comes before 'D' so it will return -1.

        // String s1 = "ZZZ";
        // String s2 = "ZZZZABC";
        // System.out.println(s1.compareTo(s2));
        // So compareTo function will start cheching from 1st character. if in any of the string will be
        // over then the function will return length difference. so here it will return -4.

        // --> Approach in which we are using 2 variables to iterate on single string or single array
        // or multiple strings or multiple array is known as Two Pointer Approach. means we are changing
        // value of those 2 variables or either of them based on certain conditions while iterating.

        // Substring function will return the sub string from the string.
        // String s1 = "ABCDEF";
        // s1.substring(1) // will return string from 1st index to last.
        // s1.substring(1,4) // will return 1st,2nd,3rd index. means last index will be exclusive.
        // Complexities :- compareTo fnc:-O(min length of 2 strings), substring fnc:-O(len of string).


        // mIMP :-
        // So as we know strings are immutable so for example in question I have to apply logic and have
        // to modify the characters of the string. then how to do it?
        // So pls remember this thing. this is MMMIMP. whenever u want to change or modify the characters
        // of the array at that time you can use char array. for example:-
        // String str1 = "ABCDEF";
        // char arr_new[] = new char[str1.length()];
        // for(int i=0; i<str1.length();i++)
        // {
        //     arr_new[i] = str1.charAt(i);
        // }
        // System.out.println(arr_new); 
        // So this is the way to change the chars in the string.
        // One more imp thing is in above line u have tried to print char array arr. and it will be printed.
        // But same case is not true for Int array or double array or String array. means if u try to print
        // Int or double or String or any other type of array, u will get some hexa decimal value on the screen
        // which represents the address of first byte of that array. To print array I have to write loop. 
        // But only in case of char array u can print whole array.

        // One more thing is we can't directly convert a character into the string. But we can convert 
        // char arr into string.
        // char arr2[] = {'A','B','G'};
        // String str2 = new String(arr2);
        // System.out.println(str2); // o/p :- "ABG"

        // bt we can't convert explicitely char to string.
        // char z = 'x';
        // String a = (String)(z);
        // System.out.println(a); // o/p :- error.


        // **** Conversion*****
        // String a = "1234";
        // int b = Integer.parseInt(a); // parse means first it will scan or read.
        // System.out.println(b); // o/p:- 1234
        // String c = "1234abc123";
        // int d = Integer.parseInt(c);
        // System.out.println(c);// o/p:- give error.

        // Q) Suppose user is entering a string with so many digits. but Print all the digits only.
        // Scanner sc = new Scanner(System.in);
        // String f = sc.next();
        // for(int i=0;i<f.length();i++)
        // {
        //     int currentASCII = f.charAt(i); // will give the ASCII value.

        //     if(currentASCII>=48 && currentASCII<=57)
        //     {
        //         System.out.println(f.charAt(i));
        //     }
        // }



        // Topic :- Two Pointer
        // Q) Reverse the array in O(N) time complexity and O(1) Space Complexity.
        // i/p :- [2 1 3 10 8]
        // o/p :- [8 10 3 1 2]

        // Approach:- Here what we have to do is, from the array you can understand like I simply just need to swap the 2 values bt
        // twist is inside the same array i.e. without creating new array (as O(1) space complexity is given in que. so). So from the
        // above sentence only we can understand like we will be requireing 2 variables representing both the 2 different values (hence
        // from the name of approach it is called 2 pointers aese yad rkh skte ho. i.e. pls remember this, whenever it is required to
        // deal with 2 elements from of same data structure, we can use or we should use 2 pointers approach.)
        // Now aese hi 2 pointers (which represent 2 different values in the array) leke value swap krte rehni h bt kb tk? so here is the
        // time to think about stopping condition as we have to repeate something so u r smart enough to start loop. but somewhere u have
        // to stop. So stopping condition would be jb bhi swape hote hote i nd j equal ya to i>j ho jata h tb muje swaping stop kr deni h.
        // u can iterate using pen nd paper, u might be able to see it correctly. and after each swap we jst need to increase one variable
        // and decrease another variable to move ahead in the loop.

        // So simply approach is: 
        // -- take 2 variables. (assign the values as per the requirement of the problem)
        // -- start the loop with correct stopping condition included.
        // -- swap the values in the loop.
        // -- increase nd decrease the corresponding variable.
        // -- print the array.

        // Code :- 
        // Scanner scn = new Scanner(System.in);
        // int number = scn.nextInt();

        // // inputting array values
        // int arr[] = new int[number];
        // for(int k=0; k<number; k++)
        // {
        //     arr[k] = scn.nextInt();
        // }

        // int i = 0;
        // int j = number-1;
        // while(i<j)
        // {
        //     int temp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = temp;

        //     i++;
        //     j--;
        // }

        // // Displaying on the screen.
        // for(int k=0;k<number;k++)
        // {
        //     System.out.print(arr[k] + " ");
        // }
        // scn.close();


        // Q) Count the number of pairs from the array in which sum of element of pairs is divisible by given value K.
        // Soultion :-
        // Will write soon.


            // ----------------------------------------------------
        // Concept :-
        // Prefix Array :-
        // What is prefix array?
        // So basically prefix array is sum of elements of the array.
        // prefix[i] represents sum of all elements till ith index. this is the concept
            // -----------------------------------------------------

        // Q) Q queries were given. Find the sum of elements of the array as per the index range given in the query.

        // Solution:- we will use the prefix array concept to do it in O(N) Time complexity.

        // 1st Method :-

        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int q = scn.nextInt();

        // Inputting Array
        // int arr[] = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        // for(int j=1;j<=q;j++)
        // {
            
        //     int l = scn.nextInt();
        //     int r = scn.nextInt();

        //     int sum = 0;
        //     for(int k=l;k<=r;k++)
        //     {
        //         sum = sum + arr[k];
        //     }
        //     System.out.println(sum);
        // }
        
        // So above solution will also correct ryt? but the main problem is above solution takes approx O(N^2) Time complexity.
        // And we want to achive the result in the O(N) Time Complexity. So the solution is we have to use Prefix Array Concept.
        // But yes there is one drawback. as we are reducing time complexity, I have to compromise with my space complexity. So
        // in the for the above given Q, in prefix array solution my Time complexity will be O(N) but my Space Cmplexity 
        // will be O(N) whcihc was previously O(1) during 1st Solution.

        // 2nd Method :- Using Prefix array

        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int q = scn.nextInt();

        // Inputting Array
        // int arr[] = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        // int prefix[] = new int[n];
        // int sum = 0;
        // for(int i=0;i<n;i++)
        // {
        //     sum = sum + arr[i];
        //     prefix[i] = sum;
        // }

        // int ans = 0;
        // for(int i=1; i<=q;i++)
        // {
        //     int l = scn.nextInt();
        //     int r = scn.nextInt();

        //     if(l==0)
        //     {
        //         ans = prefix[r];
        //     }
        //     else
        //     {
        //         ans = prefix[r] - prefix[l-1];
        //     }

        //     System.out.println(ans);
        // }



        // Concept :- 
        // Subarray:- Subarray is a part of array having some elements which are continous by index.
        // SubSequence :- Subsequence is a part of array in which elements are not continous by index. but yes order
        // matters. i.e. in forward order only.

        // Q) Print all the subarray of a given array.

        // First of all how to print all the subarray of a given array?

        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();

        // int arr[] = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        // Printing all the Subarray
        // for(int start = 0;start<n;start++) // Pls note here that, it is taking O(N^3) T.C.  We will see how to do it in N^2 and O(N).
        // {
        //     for(int end = start; end<n; end++)
        //     {
        //         for(int i=start; i<end; i++)
        //         {
        //             System.out.println(arr[i] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        // scn.close();

        // Q) Find the Maximum Sum of Subarray of a given Array.

        // Approach :- 
        // - take niput from system.
        // - initialize maxSum variable with minimum integer value possible.
        // - start creating subarray. (i.e loops for subarray).
        // - upr vale case me hme print krna tha element so hmne 3rd loop likha bt yha pe hme element or subarray print nh krna h. To
        // innermost 3rd loopn nh likhunga. but 2nd loop k bahar ek variable create kr dunga currentSum jo direct sum track krta rhe.
        // - nd 2nd loop me currentSum me element ki value add krta jaunga.
        // uske bad max function se maxSum ke sath compare krke jo bhi max value hogi usko hi maxValue me store krunga.
        // Fir next iteration me to vapis currentSum 0 ho gya hoga. kyuki hmne 2nd loop k bahar hi declare kiya h so.
        // nd now print the value.


        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();

        // int[] arr = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        // int maxSum = Integer.MIN_VALUE;
        // for(int start = 0;start<n;start++)
        // {
        //     int currentSum = 0;
        //     for(int end = start;end<n;end++)
        //     {
        //         currentSum = currentSum + arr[end];
        //         maxSum = Math.max(maxSum, currentSum);
        //     }
        // }
        // System.out.println(maxSum);

        // Pls note here that this approach will take O(N^2) TC.

        // One more thing is we can even use prefix array as well to find the sum. but to create prefix array (O(N)) TC 
        // nd O(N) SC. hence whole program is having O(N^2) TC and O(N) SC.

        // So let's find some another approach to optimised it.


        // Optimised Approach :-

        // - So main point is, everytime it means in each iteration we just have to find the sum till the current element. So we can have
        // now only 2 options. like either sum till the element is maximum or element is maximum. So this is the concept.
        
        // - take input from system.
        // - take one variable which stores the sum of all till the current element.
        // - take the maxSum variable.
        // - Check it with the current element of the array and store the max from both of it into max variable and return it.

        //  STEP - 1 :- For every element I find the maximum till that position.
        //  STEP - 2 :-  Max of these values = Maximum Sum.

        // Scanner scn = new Scanner(System.in);
        // int n =  scn.nextInt();

        // int arr[] = new int[n];
        // for(int i=0; i<n; i++)
        // {
        //     arr[i] = scn.nextInt();
        // }

        // int maxSum = Integer.MIN_VALUE;
        // int currentSumTillElement = 0;
        // for(int start = 0; start<n; start++)
        // {
        //     int firstoption = arr[start]
        //     int secondOption = currentSumTillElement + arr[start];

        //     currentSumTillElement = Math.max(firstoption,secondOption); // STEP - 1

        //     maxSum = Math.max(maxSum, currentSumTillElement); //STEP - 2
        // }
        // System.out.println(maxSum);

        // Above Approach or Algorithm or Approach is known as Kadane's Algorithm. which is very famous and can be asked in interview.
        // So in interview pls go with brut --> better --> best. i.e O(N^3) --> O(N^2) --> O(N). so Kadane's algo is used to perform
        // this kind of questions in O(N).



        // Q) You are given an array. And you have given an element from the array. find the product of remaining all the elements of
        // the array except given element.

        // Solution :- 
        // Method -1 :- Using Prefix and/or Suffix Array.

        // Note:- Prefix array can be created to store summation or subtraction or multiplication or division results or any
        // consequent result performed by continous elments of any array in forward order.

        // Similarly We can have Suffix array in which everything is same, but order is reverse. i.e. we are starting from end
        // element of an array to move till 1st element nd store the results in the array.

        // Approach :-
        // - create prefix array of multiplication.
        // - create suffix array of multiplication.
        // - now return the product of prefix[i-1] * suffix[i+1]
        
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int elem = scn.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        int ans = 0;

        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int product1 = 1;
        for(int i=0; i<n; i++)
        {
            product1 = product1*arr[i];
            prefix[i] = product1;
        }

        int product2 = 1;
        for(int i=n-1; i>n; i--)
        {
            product2 = product2*arr[i];
            suffix[i] = product2;
        }

        if(elem==0)
        {
            ans = suffix[elem+1];
        }
        else if(elem==n-1)
        {
            ans = prefix[elem-1];
        }
        else
        {
            ans = prefix[elem-1]*suffix[elem+1];
        }
        System.out.println(ans);

    }
}


// Video :- Recursion - 3

// Q) Priyanka and Toys :- 
// Solution :- need to sort and then apply 2-pointer.

// Q) Longest Sub Array with Sum K :-
// Multiple concept needs to be used.