package org.parami.ygds.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ArticlePage {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ArticlePage.class);

    protected String url;
    protected Document doc;


    public ArticlePage(String url) {
        this.setUrl(url);
    }

    public void setUrl(String url) {
        this.url = url;
        init();
    }

    protected void init() {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    public String getContent() {
        Elements aLinks = doc.select(".content p");
        return aLinks.first().html();
    }
}
