package org.parami.ygds.tool;

import org.parami.ToolApplication;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CompareTool {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ToolApplication.class);

    protected HashMap<String, String> books = new HashMap<String, String>();

    public CompareTool()
    {
        books.put("增广文钞卷一", "http://www.honghuashe.com/ygds/wenchao2014new/zg01/index.htm");
        books.put("增广文钞卷二", "http://www.honghuashe.com/ygds/wenchao2014new/zg02/index.htm");
        books.put("增广文钞卷三", "http://www.honghuashe.com/ygds/wenchao2014new/zg03/index.htm");
        books.put("增广文钞卷四", "http://www.honghuashe.com/ygds/wenchao2014new/zg04/index.htm");
        books.put("文钞续编卷上", "http://www.honghuashe.com/ygds/wenchao2014new/xb01/index.htm");
        books.put("文钞续编卷下", "http://www.honghuashe.com/ygds/wenchao2014new/xb02/index.htm");
        books.put("文钞三编卷一", "http://www.honghuashe.com/ygds/wenchao2014new/3b01/index.htm");
        books.put("文钞三编卷二", "http://www.honghuashe.com/ygds/wenchao2014new/3b02/index.htm");
        books.put("文钞三编卷三", "http://www.honghuashe.com/ygds/wenchao2014new/3b03/index.htm");
        books.put("文钞三编卷四", "http://www.honghuashe.com/ygds/wenchao2014new/3b04/index.htm");
        books.put("文钞三编补", "http://www.honghuashe.com/ygds/wenchao2014new/3bb/index.htm");
        books.put("印光法师文钞_佛学频道_新浪网", "http://fo.sina.com.cn/zt/ygfswenchao/index.shtml");
    }

    protected void parseOne(){
        String url = books.get("文钞三编补");
        logger.info("文钞三编补 =》 " + url);
        if(url.startsWith("http://www.honghuashe.com"))
        {
            HonghuasheParser honghsParser = new HonghuasheParser(url);
            honghsParser.parse();
        }
        else
        {
            logger.warn(url + " can not parse, no parser for it");
        }
    }

    public void run()
    {
        logger.info("Compare Article with http://www.honghuashe.com/");
        Set set = books.entrySet();
        final AtomicInteger indexHolder = new AtomicInteger();
        for (Object aSet : set) {
            final int index = indexHolder.getAndIncrement();
            Map.Entry mentry = (Map.Entry) aSet;
            System.out.print(index + " key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
        parseOne();
    }
}
