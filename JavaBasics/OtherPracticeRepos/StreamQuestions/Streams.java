/*
// When should we use the Collections & when to Stream?
If we want to represent group of objects as a single entity then we should use the Collections.

If we want to process something on the data/object of collections, we should use the Stream.

- So there are 2 Streams. one is IO Streams used for data. another one is for Stream used for objects in any collection.


filter:- so whenever you want to filter some data from the collection of any objects, you can use the stream on it
and specifically you can use the filter method on it.

Map:- similarly for any data if you want to have transformation for each object from a collection to some other transformed
value, then you can use the Map.
- So map is specifically used for 1 to 1 object transformation present inside collection.
- that's why suppose before applying map, if there are 10 elems in the collections, then after applying map also
you will get 10 elems only but with the transformation logic applied on each element.
 */
class Streams{
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(5);
        l.add(10);
        l.add(15);
        l.add(20);
        l.add(25);

        // So here suppose you have collection of numbers (i.e. Integers), now you want to have only even numbers from list
        // then to apply this filter you can use the filter() method.

        List<Integer> filteredData =  l.stream().filter(num -> num%2==0).collect(Collectors.toList());

        // filter is taking lambda exrpession/function as an argument. And as we know Lambda function always represents
        // implementation for some functional interface.
        // So here filter() method is taking lambda function as argument i.e functional interface as argument.
        // So filter() method takes Predicate functional interface as an argument.



        // Map:-

        // now for example, suppose below is the list of marks.

        ArrayList<Integer> marks = new ArrayList<>();
        l.add(0);
        l.add(5);
        l.add(10);
        l.add(15);
        l.add(20);
        l.add(25);

        // Now teacher wants to give +5 marks as grace to each student for some question mistake in question paper.

        // so see here, if you observe carefully, then you have to add +5 marks for each element. and recall based on
        // our previous discussion, whenever we want to perform something on each elem/object, then we have to use the
        // map method.

        List<Integer> updatedMarks = marks.stream().map(mark -> mark + 5).collect(Collectors.toCollect());


        // Collect():-

        // count() :- this is terminal method which is returning the total elems present in the stream on whic count()
        // method is called.

        // sorted():-
        // - By default Natural Sorting Order (NSO) is followed.
        // - If we want to have Customised Sorting Order (CSO) then we have to provide the Comparator Interface implementation
        // to the sorted(Comparator) method. then it will sort with our provided custom logic.

        // Very imp Note:-
        /*
        - For Natural Sorting Order, Comparable Interface is used (i.e. it's obj1.compareTo(obj2) method will be used).
        - For Customised Sorting Order Comparatpr Interface (i.e. it's compare(obj1,obj2) method will be used).
        - to provide the Natural Sorting Order, class has to implement the Comparable Interface.
        - to Provide the Customised Sorting Order, separately comparator interface implementation needs to be passed
        while calling sort() method or any other method.

        - For any comparator (be it Comparabal or comparator), always remember how it works internally is: you should
            returns -ve :- if obj1 has to come before obj2
            returns +ve :- if obj1 has to come after obj2
            returns 0:- if obj1 & obj2 are equal.
        - For Descending order we can write in this way:- (i1,i2) -> (i1<i2)? 1 : (i1>i2) ? -1 : 0
        with above explanation it's self understood that suppose 1st elem is lesser than 2nd, then I want to have 1st elem
        after 2nd so sent some +ve value. in else condition if i1>i2, then i.e. i1 i.e. 1st elem only should comes first,
        so I have sent some -ve value, and if both are equal then I have sent 0.

        - sorted() :- According to default natural sorting order
        - sorted(Comparator) :- According to Customised sorting order

        - Alternatively for strin operations, developers are using below ways widely to just reverse the order like from
        ascendning to descending or from descending to ascending.
        - for example Natural sorting order is (see natural sorting order also someone has to define while writing that
        class by implementing Comparable interface, so Natural sortng order can be descending as well that is completely
        based on the impl provided in the class.
        - so for example Natural Sorting order is:-
        (s1,s2) -> s1.compareTo(s2) ===> Natural Sorting order is ascending
        (s1,s2) -> s2.compareTo(s1) ===> reverse of natural sorting order i.e. with swapping args we can change to descending
        (s1,s2) -> -s1.compareTo(s2) ===> reverse of Natural Sorting Order i.e. just with minus (-) sign to have descending

         */

        // - min()
        // - max()
        // Note:- it is must to have comparator for finding min or max. so min/max is a bit tricky. you need to understand
        // very well how i is giving answer.
        // - I have taken screenshot of one code snippet from durga sir video pls write that here later.

        // - toArray
        // - Stream.of()

    }
}

