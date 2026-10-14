import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookSetDemo {

    static class Book {
        private final String isbn;
        private final String title;

        Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public String getIsbn() { return isbn; }
        public String getTitle() { return title; }

        // Equality by ISBN only — two books with the same ISBN are the same book
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book other)) return false;
            return isbn.equals(other.isbn);
        }

        // Consistent with equals: hashCode uses the same field(s)
        @Override
        public int hashCode() {
            return Objects.hash(isbn);
        }

        @Override
        public String toString() {
            return "Book[" + isbn + " \"" + title + "\"]";
        }
    }

    public static void main(String[] args) {
        Set<Book> library = new HashSet<>();

        Book b1 = new Book("978-0132350884", "Clean Code");
        Book b2 = new Book("978-0132350884", "Clean Code"); // same ISBN, different object
        Book b3 = new Book("978-0134685991", "Effective Java");

        System.out.println("add b1: " + library.add(b1)); // true
        System.out.println("add b2: " + library.add(b2)); // false — duplicate by equals/hashCode
        System.out.println("add b3: " + library.add(b3)); // true

        System.out.println("Library size: " + library.size()); // 2
        library.forEach(System.out::println);
    }
}