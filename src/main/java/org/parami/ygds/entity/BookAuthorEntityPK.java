package org.parami.ygds.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BookAuthorEntityPK implements Serializable {
    private int authorId;
    private int bookId;

    @Column(name = "author_id")
    @Id
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Column(name = "book_id")
    @Id
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthorEntityPK that = (BookAuthorEntityPK) o;

        if (authorId != that.authorId) return false;
        if (bookId != that.bookId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + bookId;
        return result;
    }
}
