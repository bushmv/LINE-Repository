package fluent;

public class ImmutableUser {

    private final String name;
    private final int age;

    public ImmutableUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ImmutableUser() {
        this.name = "undefined";
        this.age = -1;
    }

    public ImmutableUser name(String name) {
        return new ImmutableUser(name, this.age);
    }

    public ImmutableUser age(int age) {
        return new ImmutableUser(this.name, age);
    }
}
