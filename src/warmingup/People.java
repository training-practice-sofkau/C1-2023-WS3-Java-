package warmingup;

public class People {
    private String name;
    private Integer age;
    private String gender; //M, F

    public People(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender +'\''+ "}";
    }
}
