class Person {
    String name;
    int age;
    String city;

    // Constructor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // To print the object
    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}