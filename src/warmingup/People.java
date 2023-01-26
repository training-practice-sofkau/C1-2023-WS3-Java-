package warmingup;

public class People {
    private String name;
    private int age;
    private String gender; //M, F

    public People(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }
}
