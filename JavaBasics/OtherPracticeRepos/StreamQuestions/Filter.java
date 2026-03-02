package org.allTopics.StreamQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Filter {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter method of stream
        //Q-1) all numbers which are > 5
        /*
        List<Integer> numsGreaterThan5 = numbers.stream()
                .filter((elem)->{return elem>5;}).collect(Collectors.toList());

        System.out.println(numsGreaterThan5);

         */


        // Map
        // Q-2) transform each string in uppercase
        /*
        List<String> strings = Arrays.asList("banana", "apple", "orange", "grapes");

        List<String> upperCaseList = strings.stream()
                .map(elem -> elem.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCaseList);

         */


        // FlatMap
        // Q - 3) Given list<list<String>>, flatten them in the single list of strings

        /*
        List<List<String>> words = List.of(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five","six")
        );

        List<String> overall = words.stream()
                .flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(overall);

         */

        // Research:- difference between peek() vs forEach()

        // Reduce
        // Q-)
        /*
        Optional<Integer> product = numbers.stream().reduce((a,s)->a+s);
        System.out.println(product);

         */


        // Q) find the occurrence of each char in string.
        // String str = "I love scaler academy";

        // Solution:-
        /*
        Steps:
        - Convert the string to a stream of characters.
        - Use Collectors.groupingBy() to group by each character.
        - Use Collectors.counting() to count the frequency.
         */

        // Solution - 1 :-
        // By GPT:-
        /*
        String str = "I love scaler academy";
        Map<Character, Long> freqMap = str
                .toLowerCase()                  // Step 1: lowercase
                .chars()                        // Step 2: get IntStream of characters
                .mapToObj(c -> (char) c)        // Step 2: convert to Character
                .filter(c -> c != ' ')          // Step 3: remove spaces
                .collect(Collectors.groupingBy( // Step 4: group and count
                        c -> c,
                        Collectors.counting()
                ));

        // Print the result
        freqMap.forEach((k, v) -> System.out.println(k + " : " + v));

         */


        // Solution - 2:- Java techie:- More understandable
        /*
        String str = "I love scaler academy";
        String[] strArr = str.split(""); // --> ["i","l","o",...]
        Map<String,Long> uniqueMap =  Arrays.stream(strArr)
                .collect(Collectors.groupingBy((elem)->(String)elem, Collectors.counting()));
        uniqueMap.forEach((k, v) -> System.out.println(k + " : " + v));
        
         */




        // Q) Find all the duplicate chars from string.
        // Solution:- since for that we anyhow need the above map. So on top of it simply we can apply filter
        // to just get the count>1 elem's list.

        /*
        String str = "I love scaler academy";
        String[] strArr = str.split(""); // --> ["i","l","o",...]
        Map<String,Long> map =  Arrays.stream(strArr)
                .collect(Collectors.groupingBy((elem)->(String)elem, Collectors.counting()));
        List<String> duplicates = map.keySet().stream().filter(elem -> map.get(elem)>1).collect(Collectors.toList());
                System.out.println(map);
                System.out.println(duplicates);
//        uniqueMap.forEach((k, v) -> System.out.println(k + " : " + v));

         */


        // Q) find unique letters from given string.
        // Solution:- same as above. only need to check count==1 & filter those into a list.


        // Q) Write a program to find 1st non repeating char from a string.
        // String = "ilovejavatechie"

        // Solution :-

        /*
        String ip = "ilovejavatechie";
        String[] strArr1 = ip.split("");
        Optional<String> element = Arrays.stream(strArr1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(elem->elem.getValue()==1)
                .map(elem->elem.getKey())
                .findFirst();
        System.out.println(element);

         */
        // Above is a little bit incorrect, Since we are picking 1st elem which has val=1 in the map.
        // but we want it from the string only --> i.e. l in the output.
        // So that is due to HashMap, means while groupingBy, it is returning the hashmap which is incorrect
        // I mean we need to preserve the insertion order --> hence we want to store output in LinkedHashMap
        // after groupingBy. So we can mention that in the groupingBy clause like you should give me output in
        // LinkedHashMap not in Map. See below code.

        /*
        String ip = "ilovejavatechie";
        String[] strArr1 = ip.split("");
        String element = Arrays.stream(strArr1)
                .collect(Collectors.groupingBy(Function.identity(), ()-> new LinkedHashMap<>(), Collectors.counting()))
                .entrySet().stream()
                .filter(elem->elem.getValue()==1)
                .findFirst().get().getKey();
        System.out.println(element);

         */

        // Q) find the 1st repeating char from string.
        // Solution:- simply in above question, in filter instead of ==1, you can write the >1.


        // Q) Find the 2nd highest number from an array
        // arr = [5,9,11,2,8,21,1]

        /*
        int[] arr = new int[]{5,9,11,2,8,21,1}; // --> 11

        int ans = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(ans);

         */

        //Q) FInd the Longest String from given array.
        // String[] = ["Scaler","Academy", "SpringBoot", "Microservices"]

        // Simply we can use the reduce() method here.
        /*
        String[] strArr = new String[]{"Scaler","Academy", "SpringBoot", "Microservices"};
        Optional<String> longestString = Arrays.stream(strArr)
                .reduce((a,b)->a.length()>b.length()?a:b);
        System.out.println(longestString);

         */

        // Q) Write a program to find all the elements which is starting from 1.
        // arr = [5,9,11,2,8,21,1] ==> output = [11,1]
        /*
        int[] arr = {5,9,11,2,8,21,1}; // --> [11,1]
        List<String> ans = Arrays.stream(arr).boxed()
                .map(num->num+" ")
                .filter(elem->elem.charAt(0)=='1')
                .collect(Collectors.toList());
        System.out.println(ans);

         */

        // Q) String.join() method example
        /*
        List<String> str = List.of("a","b","c","d","e","f","g","h");
        String result = String.join("-", str);
        System.out.println(result);

         */

        // Q) skip & limit use example
        // for example interviewer might ask to just print from 2 to 9 out of 1 to 10, then how to do it?
        /*
        IntStream.range(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);

         */

        // Q) Sort a List and Map
        // Q) Map & flatMap examples

        // Q) Nth highest salary of an employee (Myntra)
        // Suppose ask n=2 --> 2nd highest => so here output would be "prashant"
        Map<String,Integer> mp = new HashMap<>();
        mp.put("Parth", 50);
        mp.put("Lisa", 20);
        mp.put("Germany", 10);
        mp.put("Prashant",100);
        mp.put("Param",150);

        String ans = mp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(2-1)
                .findFirst().get().getKey()
                ;

        // Code is not completed. will do it letter.


        // Q) How to convert a List of objects into a Map by considering duplicated keys and store them in
        // sorted order?

        /*
        class Notes{
                    private int i;
                    private String note;
                    private int i1;
                    public Notes(int i, String note1, int i1) {
                        this.i = i;
                        this.note = note1;
                        this.i1 = i1;

                    }
                }
                List<Notes> noteLst = new ArrayList<>();
                noteLst.add(new Notes(1, "note1", 11));
                noteLst.add(new Notes(2, "note2", 22));
                noteLst.add(new Notes(3, "note3", 33));
                noteLst.add(new Notes(4, "note4", 44));
                noteLst.add(new Notes(5, "note5", 55));

                noteLst.add(new Notes(6, "note4", 66));


                Map<String, Long> notesRecords = noteLst.stream()
                        .sorted(Comparator
                                .comparingLong(Notes::getTagId)
                                .reversed()) // sorting is based on TagId 55,44,33,22,11
                        .collect(Collectors.toMap
                                (Notes::getTagName, Notes::getTagId,
                                        (oldValue, newValue) -> oldValue,LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
                System.out.println("Notes : " + notesRecords);

         */
    }


}
