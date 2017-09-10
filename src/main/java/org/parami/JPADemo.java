package org.parami;

import org.parami.ygds.tool.RawQuery;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class JPADemo
{
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ToolApplication.class);

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RawQuery.class)
                .web(false) // no, we do not need web(tomcat)
                .headless(false)
                .run(args);
        logger.info("main method");
        RawQuery si = context.getBean(RawQuery.class);
        si.getInfo();
        logger.info("a");
    }
}