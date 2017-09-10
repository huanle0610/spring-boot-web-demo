package org.parami.ygds.entity;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "ygds", catalog = "")
public class BookEntity {
    private int bookId;
    private String bookName;
    private String bookOrgLink;

    @Id
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "book_org_link")
    public String getBookOrgLink() {
        return bookOrgLink;
    }

    public void setBookOrgLink(String bookOrgLink) {
        this.bookOrgLink = bookOrgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bookId != that.bookId) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (bookOrgLink != null ? !bookOrgLink.equals(that.bookOrgLink) : that.bookOrgLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookOrgLink != null ? bookOrgLink.hashCode() : 0);
        return result;
    }
}
