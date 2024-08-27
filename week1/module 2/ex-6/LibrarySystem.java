import java.util.Arrays;

class Publication {
    private int id;
    private String name;
    private String writer;

    public Publication(int id, String name, String writer) {
        this.id = id;
        this.name = name;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    @Override
    public String toString() {
        return "Publication[ID=" + id + ", Title=" + name + ", Author=" + writer + "]";
    }
}

public class LibrarySystem {

    public static Publication searchLinear(Publication[] publications, String title) {
        for (Publication publication : publications) {
            if (publication.getName().equalsIgnoreCase(title)) {
                return publication;
            }
        }
        return null;
    }

    public static Publication searchBinary(Publication[] publications, String title) {
        int left = 0;
        int right = publications.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = title.compareToIgnoreCase(publications[mid].getName());

            if (comparison == 0) {
                return publications[mid];
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Publication[] publications = {
            new Publication(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Publication(2, "To Kill a Mockingbird", "Harper Lee"),
            new Publication(3, "1984", "George Orwell")
        };

        // Linear Search
        System.out.println("Searching for '1984' using Linear Search:");
        Publication foundPublication = searchLinear(publications, "1984");
        System.out.println(foundPublication != null ? foundPublication : "Publication not found");

        // Binary Search
        // Sorting the array before binary search
        Arrays.sort(publications, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("\nSearching for 'To Kill a Mockingbird' using Binary Search:");
        foundPublication = searchBinary(publications, "To Kill a Mockingbird");
        System.out.println(foundPublication != null ? foundPublication : "Publication not found");
    }
}
