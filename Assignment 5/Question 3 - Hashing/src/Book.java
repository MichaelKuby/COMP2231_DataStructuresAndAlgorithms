import java.util.Objects;

/**
 * Represents a book.
 *
 * @author MichaelKuby
 * @version Feb. 25, 2022
 */
public class Book
{
    protected String title, ISBN;

    /**
     * Creates a book with a title and ISBN coding.
     *
     * @param ISBN the ISBN code for this book
     * @param title the title of this book
     */
    public Book(String ISBN, String title)
    {
        this.ISBN = ISBN;
        this.title = title;
    }

    /**
     * Gets the ISBN for this book.
     *
     * @return the ISBN for this book
     */
    public String getISBN()
    {
        return ISBN;
    }

    /**
     * Set's the ISBN for this book.
     * @param ISBN the ISBN for this book
     */
    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    /**
     * Gets the title of this book.
     * @return the title of this book.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title of this book.
     * @param title the title of this book
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Returns a string representation of this book.
     *
     * @return a string representation of this book
     */
    @Override
    public String toString()
    {
        return "{" +
                "Title:'" + title + '\'' +
                ", ISBN:'" + ISBN + '\'' +
                '}';
    }

    /**
     * Overrides the inherited equals method definition
     * for one that compares instance data.
     *
     * @param o the book to compare this book to
     * @return true if the two books have the same instance data
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(ISBN, book.ISBN);
    }
}
