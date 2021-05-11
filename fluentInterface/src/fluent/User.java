package fluent;

public class User {

    private String name;
    private int age;

    public User() {
        this.name = "undefined";
        this.age = -1;
    }


    public User name(String name) {
        this.name = name;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }



}
