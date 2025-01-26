class Student{

    private int id;
    private String name;
    private double gross_salary;

    Student(Builder b){
        this.id = b.id;
        this.name = b.name;
        // validation:-
        if(b.gross_salary>150000.0){
            throw new RunTimeexception("Can't be considered as Student. He can be Professor or HOD")
        }
        this.gross_salary = b.gross_salary;
    }
}
