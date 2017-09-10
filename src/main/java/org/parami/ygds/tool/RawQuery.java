package org.parami.ygds.tool;

import com.google.gson.Gson;
import org.parami.ygds.entity.ArticleEntity;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@EnableAutoConfiguration
public class RawQuery {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(RawQuery.class);

    @PersistenceContext
    EntityManager em;

    public void getInfo(Integer i)
    {
        Query listTyped = em.createNativeQuery("Select * from article limit 2", ArticleEntity.class);

        List<ArticleEntity> list = listTyped.getResultList();
        for (ArticleEntity articleEntity : list) {
            logger.info(articleEntity.getArticleTitle());
        }
    }

    public void getInfo() {
        Query query = em.createNativeQuery("SELECT article_id, article_title, article_content FROM article  where article_id=?");
        query.setParameter(1,1);
        Object article =  query.getSingleResult();
        logger.info(new Gson().toJson(article));
    }
}
