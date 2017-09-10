package org.parami.ygds.entity;

import javax.persistence.*;

@Entity
@Table(name = "article_type", schema = "ygds", catalog = "")
public class ArticleTypeEntity {
    private int articleTypeId;
    private String articleTypeName;

    @Id
    @Column(name = "article_type_id")
    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    @Basic
    @Column(name = "article_type_name")
    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleTypeEntity that = (ArticleTypeEntity) o;

        if (articleTypeId != that.articleTypeId) return false;
        if (articleTypeName != null ? !articleTypeName.equals(that.articleTypeName) : that.articleTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleTypeId;
        result = 31 * result + (articleTypeName != null ? articleTypeName.hashCode() : 0);
        return result;
    }
}
