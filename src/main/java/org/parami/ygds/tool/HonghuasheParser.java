package org.parami.ygds.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.parami.ToolApplication;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HonghuasheParser {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ToolApplication.class);

    protected String url;
    protected String dirUrl;
    protected Document doc;


    public HonghuasheParser(String url) {
        this.setUrl(url);
    }

    public void setUrl(String url) {
        this.url = url;
        this.dirUrl = getParent(url);
        init();
    }

    private String getParent(String resourcePath) {
        int index = resourcePath.lastIndexOf('/');
        if (index > 0) {
            return resourcePath.substring(0, index);
        }
        return "/";
    }


    protected void init() {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    protected String getFullLink(String lastFileName)
    {
        return this.dirUrl  + "/" + lastFileName;
    }

    protected Element getBookTagElement(Element linkElement) {
        Element parentTag = linkElement.parent();
        Elements linkBookTags = parentTag.select(".style2");

        return linkBookTags.first();
    }

    protected Elements getHeaders() {
        return doc.select("[class^=style]");
    }

    protected void printElements(Elements elements) {
        final AtomicInteger indexHolder = new AtomicInteger();
        for (Element one_element : elements) {
            final int index = indexHolder.getAndIncrement();
            logger.info(index + " -- " + one_element.text());
        }
    }

    protected void printLinkElements(Elements elements) {
        final AtomicInteger indexHolder = new AtomicInteger();
        for (Element linkElement : elements) {
            String full_link = getFullLink(linkElement.attr("href"));
            final int index = indexHolder.getAndIncrement();
            Element linkBookTag = getBookTagElement(linkElement);
            String cat = "";
            if(linkBookTag != null)
            {
                cat = linkBookTag.text();
            }


            logger.info("索引： {} 标题：{} 目录： {} 链接：{}", index, linkElement.text().replace(' ', ' ').trim(), cat, full_link);
            String content = getArticleContent(full_link);
            logger.info("内容: " + content);
            sleep();
        }
    }

    protected void sleep()
    {
        try {
            Thread.sleep(1000);                 //1000 毫秒，也就是1秒. 避免源站负载过高
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    protected String getArticleContent(String url)
    {
        ArticlePage ap = new ArticlePage(url);
        return ap.getContent();
    }

    public void parse() {
        Elements aLinks = doc.select(".content a");
        printLinkElements(aLinks);
    }
}
