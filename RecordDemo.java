public class RecordDemo {

    record Student(String name, int age) { }

    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 21);
        Student s2 = new Student("Tariro", 21);
        Student s3 = new Student("Farai", 22);

        // Generated toString
        System.out.println("s1: " + s1);

        // Generated equals (value equality)
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // false
        System.out.println("s1 == s2:      " + (s1 == s2));    // false (different objects)

        // Generated accessors
        System.out.println("s1.name(): " + s1.name());
        System.out.println("s1.age():  " + s1.age());
    }
}