public class HashtableDriver
{
    public static void main (String[] args)
    {
        HashTable table = new HashTable();

        // Instantiate three books, all of which will generate the same key
        Book book1 = new Book("0-5422-6341-6", "The Grapes of Wrath");
        Book book2 = new Book("0-5422-6302-0", "Slaughterhouse-Five");
        Book book3 = new Book("0-5422-6303-1", "Foundation");

        System.out.println("Adding three books.");
        System.out.println("Book 1: " + book1 + " added: " + table.add(book1));
        System.out.println("Book 2: " + book2 + " added: " + table.add(book2));
        System.out.println("Book 3: " + book3 + " added: " + table.add(book3));

        System.out.println(table);

        // Remove all three books, and re-add in a different order to demonstrate
        // how the same set of values can result in different hashes.
        System.out.println("Clear hash table: " + table.clear());

        System.out.println();

        System.out.println("Book 3: " + book3 + " added: " + table.add(book3));
        System.out.println("Book 1: " + book1 + " added: " + table.add(book1));
        System.out.println("Book 2: " + book2 + " added: " + table.add(book2));

        System.out.println(table);

        System.out.println("----------------------------------------------------------------\n");

        // Remove book 1 (current index of 10), add a volume in its place,
        // then re-add book 1.
        System.out.println("Book 1 hash index: " + table.getIndex(book1));
        System.out.println("Book 1 removed: " + table.remove(book1));
        System.out.println(table);

        Book book4 = new Book("0-2569-9892-3", "Of Mice and Men"); // produces key = 10
        System.out.println("Book 4: " + book4 + " added: " + table.add(book4));
        System.out.println("Book 4 hash index: " + table.getIndex(book4));
        System.out.println("Book 1: " + book1 + " re-added: " + table.add(book1));
        System.out.println("Book 1 new hash index: " + table.getIndex(book1));

        System.out.println(table);

        System.out.println("----------------------------------------------------------------\n");

        // populate the hash table until it needs to be resized.
        Book book5 = new Book("0-9998-9110-3", "How the World Works");
        Book book6 = new Book("0-1405-3941-7", "Fidelity: Five stories");
        Book book7 = new Book("0-6937-7718-4", "Wanderlust: A History of Walking");

        System.out.println("Book 5: " + book5 + " added: " + table.add(book5));
        System.out.println("Book 6: " + book6 + " added: " + table.add(book6));
        System.out.println("Book 7: " + book7 + " added: " + table.add(book7));

        System.out.println(table);

        System.out.println("----------------------------------------------------------------\n");

        Book book8 = new Book("0-4648-6997-8", "Tools for Conviviality");

        System.out.println("Book 8: " + book8 + " added: " + table.add(book8));
        System.out.println("\nTriggers expandCapacity.");

        System.out.println(table);

        System.out.println("----------------------------------------------------------------\n");

        // Test finding items in the hash table
        System.out.println("Book found at index = 0: " + table.getBook(0));
        System.out.println("Index for " + book7 + ": " + table.getIndex(book7));

        System.out.println();

        Book book9 = new Book("0-3586-0906-2", "Moneyball: The Art of Winning an Unfair Game");
        System.out.println("Table contains " + book9 + ": " + table.contains(book9));
        System.out.println("Index for " + book9 + ": " + table.getIndex(book9));

        System.out.println("\n----------------------------------------------------------------\n");

        // Test .remove(int i) method
        System.out.println("Index for " + book1 + ": " + table.getIndex(book1));
        System.out.println("Removing book at index 2: " + table.remove(2));

        System.out.println(table);

        System.out.println("Hash table size: " + table.size());
        System.out.println("Hash table is empty : " + table.isEmpty());

        System.out.println("\n----------------------------------------------------------------\n");

        System.out.println("Clear hash table: " + table.clear());

        System.out.println(table);

        System.out.println("Hash table size: " + table.size());
        System.out.println("Hash table is empty : " + table.isEmpty());

        System.out.println("\n----------------------------------------------------------------\n");

        // test various methods for null values

        System.out.println("Testing various methods for null inputs.\n");

        Book book10 = null;

        System.out.println("Book 10: " + book10 + " added: " + table.add(book10));
        System.out.println("Table contains book10: " + table.contains(book10));
        System.out.println("Index for book10: " + table.getIndex(book10));
        System.out.println("Book 10 removed: " + table.remove(book10));
    }
}
