class Student{

    private int id;
    private String name;
    private double gross_salary;

    Student(Builder b){
        this.id = b.id;
        if(b.name==null) throw new RunTimeException("Name is mandatory to pass");
        this.name = b.name;
        // validation:-
        if(b.gross_salary>150000.0){
            throw new RunTimeException("Can't be considered as Student. He can be Professor or HOD")
        }
        this.gross_salary = b.gross_salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(double gross_salary) {
        this.gross_salary = gross_salary;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
}