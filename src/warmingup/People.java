package warmingup;

public class People {
    private String name;
    private int age;
    private char gender; //M, F

    public People(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
