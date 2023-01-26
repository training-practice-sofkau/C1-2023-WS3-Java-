package warmingup;

public class People {
    private String name;
    private int age;
    private String gender; //M, F

    People(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }



    public int getAge(){
        return age;
    }

}
