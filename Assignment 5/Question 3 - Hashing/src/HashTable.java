import java.util.Arrays;

/**
 * HashTable is a dynamically resizable hash table for books with 10-digit
 * ISBN numbers. First hash uses the extraction method with division.
 * Collisions are resolved using linear probing.
 *
 * @author MichaelKuby
 * @version Feb 25, 2022
 */
public class HashTable
{
    final static int DEFAULT_CAPACITY = 11;
    final static double LOAD_FACTOR = 0.70;
    protected int count;    // the number of books in the table
    protected Book[] hashTable;
    protected Boolean[] bookFlags;  // tracks the books in the table

    /**
     * Constructs a hash table with the default capacity.
     */
    public HashTable()
    {
        count = 0;
        hashTable = new Book[DEFAULT_CAPACITY];
        bookFlags = new Boolean[DEFAULT_CAPACITY];
        Arrays.fill(bookFlags, false);
    }

    /**
     * Constructs a hash table with, at minimum, the specified minCapacity.
     * Makes sure that the size of the hash table is prime, for efficiency
     * purposes.
     *
     * @param minCapacity the specified minCapacity of the hash table
     */
    public HashTable(int minCapacity)
    {
        int idealCapacity = findNextPrime(minCapacity);
        count = 0;
        hashTable = new Book[idealCapacity];
        bookFlags = new Boolean[idealCapacity];
        Arrays.fill(bookFlags, false);
    }

    /**
     * Seeks the next prime number, given some integer.
     *
     * @param minNumberToCheck the integer given
     * @return the next prime number
     */
    private int findNextPrime(int minNumberToCheck)
    {
        for (int i = minNumberToCheck; true; i++)
            if (isPrime(i))
                return i;
    }

    /**
     * Checks to see if the given values is prime.
     *
     * @param number the given value
     * @return true if prime
     */
    private boolean isPrime(int number)
    {
        if (number % 2 == 0)
            return false;

        for (int i = 3; i * i <= number; i+=2)
            if (number % i == 0)
                return false;

        return true;
    }

    /**
     * Adds the specified book to this hash table.
     *
     * @param book the book to be added
     */
    public boolean add (Book book)
    {
        if (book == null)
            return false;

        if ((count + 1) / ((double)hashTable.length) > LOAD_FACTOR)
            expandCapacity();

        int key = getHashKey(book);

        // if the index is occupied, linearly probe until
        // a free space is found.
        while (bookFlags[key])
            key = (key + 1) % hashTable.length;

        hashTable[key] = book;
        bookFlags[key] = true;
        count++;
        return true;
    }

    /**
     * Removes the specified book from this hash table.
     *
     * @param book the book to be removed
     */
    public boolean remove(Book book)
    {
        if (book == null)
            return false;

        int key = getHashKey(book);

        while (!hashTable[key].equals(book) && hashTable[key] != null)
            key = (key + 1) % hashTable.length;

        if (hashTable[key].equals(book) && bookFlags[key])
        {
            bookFlags[key] = false;
            count--;
            return true;
        }
        return false;
    }

    /**
     * Removes the book associated with this key from this hash table.
     *
     * @param key the key at which the book should be removed
     */
    public boolean remove(int key)
    {
        if (!keyIsValid(key))
            return false;

        bookFlags[key] = false;
        count--;
        return true;
    }

    /**
     * Expands the capacity of this hash table
     */
    private void expandCapacity()
    {
        HashTable newHashTable = new HashTable(hashTable.length * 2);

        for (Book book : hashTable)
            newHashTable.add(book);

        hashTable = newHashTable.hashTable;
        bookFlags = newHashTable.bookFlags;
        count = newHashTable.count;
    }

    /**
     * Uses the given book's ISBN number to formulate a hash key.
     *
     * @param book the book to be stored
     * @return the hash key
     */
    private int getHashKey(Book book)
    {
        String dashlessISBN = book.getISBN().replaceAll("-", "");
        String key = dashlessISBN.substring(dashlessISBN.length() - 3);

        return Integer.parseInt(key) % hashTable.length;
    }

    /**
     * Checks to see if this hash table contains the specified book.
     *
     * @param book the book to be searched for
     * @return true if this hash table contains the specified book
     */
    public boolean contains(Book book)
    {
        if (book == null)
            return false;

        int key = getHashKey(book);

        if (hashTable[key] == null)
            return false;

        // check for the book at the key, then linearly search
        while (!hashTable[key].equals(book) && hashTable[key] != null)
            key = (key + 1) % hashTable.length;

        return hashTable[key].equals(book) && bookFlags[key];
    }

    /**
     * Returns the key to which the specified book is mapped to in this hash table.
     *
     * @param book the book that is sought
     * @return the key for which the book is mapped to, or -1 if not found
     */
    public int getIndex(Book book)
    {
        int result = -1;

        if (book == null)
            return result;

        int key = getHashKey(book);

        while (hashTable[key] != null && !hashTable[key].equals(book))
            key = (key + 1) % hashTable.length;

        if (bookFlags[key] && hashTable[key].equals(book))
            result = key;

        return result;
    }

    /**
     * Returns the book to which the specified key is mapped in this hash table.
     *
     * @param key the key that is given
     * @return the book mapped to by the key that is given
     */
    public Book getBook(int key)
    {
        Book result;

        if (!keyIsValid(key))
            throw new ArrayIndexOutOfBoundsException("Key is out of range.");
        else
            result = hashTable[key];

        return result;
    }

    /**
     * Checks to see whether the given key is valid.
     *
     * @param key the key value to be checked
     * @return true if the key is valid
     */
    private boolean keyIsValid(int key)
    {
        return (key >= 0 && key < hashTable.length);
    }

    /**
     * The number of elements in this hash table
     *
     * @return the number of elements in this hash table
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns true if this hash table contains no key-value mappings
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Clears this hash table of all mappings
     */
    public boolean clear ()
    {
        for (Book book : hashTable)
            remove(book);

        return true;
    }

    /**
     * Returns a string representation of this hash table.
     *
     * @return a string representation of this hash table.
     */
    public String toString()
    {
        String result = "\nHashTable: \n";

        for (int i = 0; i < hashTable.length; i++)
        {
            result += "Index " + i + ":";
            if (bookFlags[i])
                result += hashTable[i] + "\n";
            else
                result += "{" + null + "}" + "\n";
        }
        return result;
    }
}