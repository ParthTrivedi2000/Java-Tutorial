package org.allTopics.StreamQuestions;

public class MapvsFlatmap {

    //Q) List<Customer> to list of emails
    // Q) get all the phone numbers in a flattened way i.e. in a single list.
    // testing

    // Q - 1)
    // I/P :- [1,2,3]
    // O/P :- ["value is 1","value is 2", "value is 3"]
    List<Integer> integerList = List.of(1,2,3,4,5);
    List<String> outputList = integerList.stream()
                                .map(elem -> "value is" + elem)
                                .collect(Collectors.toList());
    system.out.println(outputList);
}
