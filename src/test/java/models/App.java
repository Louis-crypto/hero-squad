package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import models.Hero;

public class App {
    public static void main(String[] args){
    staticFileLocation("/public");

    get("/", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
