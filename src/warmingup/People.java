package warmingup;

public class People {
    private String name;
    private Integer age;
    private String gender; //M, F

    public People (String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +"; Age: " + this.age;
    }
}
