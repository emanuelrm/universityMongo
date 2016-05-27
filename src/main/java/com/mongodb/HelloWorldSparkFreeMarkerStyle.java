package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;

/**
 * Created by emanuelrm on 25/05/16.
 */
public class HelloWorldSparkFreeMarkerStyle {

    public static void main(String[] args) {
        get("/", (req, res) -> makeIntegration());
    }

    private static Object makeIntegration() {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
        StringWriter writer = new StringWriter();

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            Map<String, Object> helloMap = new HashMap<>();
            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, writer);
        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }

        return writer;
    }
}
