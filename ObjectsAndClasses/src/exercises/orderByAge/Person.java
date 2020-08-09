package exercises.orderByAge;

public class Person {
    private String name;
    private String id;
    private int age;

    public Person() {
    }

    public Person(String name, String id, int age) {
        this.setName(name);
        this.setId(id);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.getName(), this.getId(), this.getAge());
    }
}
