package phonebook.entity;

public class Contact {
    private String name;
    private String number;

    public Contact() {
    }

    public Contact(String name, String number) {
        this.setName(name);
        this.setNumber(number);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
