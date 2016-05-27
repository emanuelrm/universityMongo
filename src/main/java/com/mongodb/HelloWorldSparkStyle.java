package com.mongodb;

import static spark.Spark.*;

/**
 * Created by emanuelrm on 15/08/15.
 */
public class HelloWorldSparkStyle {

    public static void main(String[] args) {
         get("/hello", (req, res) -> "Hello World");
    }
}
