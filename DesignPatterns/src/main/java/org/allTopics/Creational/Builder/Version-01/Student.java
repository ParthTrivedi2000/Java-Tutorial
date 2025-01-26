class Student{
    private int attr1;
    private String attr2;
    private double attr3;

    Student(){}

    Student(int a1, String a2, double a3){
        attr1 = a1;
        attr2 = a2;
        attr3 = a3;
    }

    public void setAttr1(int attr1) {
        this.attr1 = attr1;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public void setAttr3(double attr3) {
        this.attr3 = attr3;
    }
}