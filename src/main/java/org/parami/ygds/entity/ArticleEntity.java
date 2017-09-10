package org.parami.ygds.entity;

import javax.persistence.*;

@Entity
@Table(name = "article", schema = "ygds", catalog = "")
public class ArticleEntity {
    private int articleId;
    private int bookId;
    private int articleIndex;
    private String articleTitle;
    private int articleTypeId;
    private String articleContent;
    private String articleOrgLink;

    @Id
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "article_index")
    public int getArticleIndex() {
        return articleIndex;
    }

    public void setArticleIndex(int articleIndex) {
        this.articleIndex = articleIndex;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_type_id")
    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    @Basic
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "article_org_link")
    public String getArticleOrgLink() {
        return articleOrgLink;
    }

    public void setArticleOrgLink(String articleOrgLink) {
        this.articleOrgLink = articleOrgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (articleId != that.articleId) return false;
        if (bookId != that.bookId) return false;
        if (articleIndex != that.articleIndex) return false;
        if (articleTypeId != that.articleTypeId) return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articleContent != null ? !articleContent.equals(that.articleContent) : that.articleContent != null)
            return false;
        if (articleOrgLink != null ? !articleOrgLink.equals(that.articleOrgLink) : that.articleOrgLink != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId;
        result = 31 * result + bookId;
        result = 31 * result + articleIndex;
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + articleTypeId;
        result = 31 * result + (articleContent != null ? articleContent.hashCode() : 0);
        result = 31 * result + (articleOrgLink != null ? articleOrgLink.hashCode() : 0);
        return result;
    }
}
