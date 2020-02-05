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

//    show all heroes
    get("/", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        ArrayList<Hero> newHero = Hero.getAll();
        model.put("hero", newHero);
        return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//    display create hero form
    get("/heroes/new", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//        submit new hero
    post("/heroes/new", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        String name = req.queryParams("name");
        int age = Integer.parseInt(req.queryParams("age"));
        String superPower = req.queryParams("superPower");
        String weakness = req.queryParams("weakness");
        Hero newHero = new Hero(name, age, superPower, weakness);
        model.put("hero", newHero);
        return new ModelAndView(model, "success.hbs");
    }, new HandlebarsTemplateEngine());

    get("/hero/:id", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        int heroId = Integer.parseInt(req.queryParams(":id"));
        Hero selectedHero = Hero.findById(heroId);
        model.put("hero", selectedHero);
        return new ModelAndView(model, "hero-detail.hbs");
    }, new HandlebarsTemplateEngine());

//show new squad form
    get("/squads/new", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "squad-form.hbs");
    }, new HandlebarsTemplateEngine());

//    post("squad/new", (req, res) ->{
//        Map<String, Object> model = new HashMap<>();
//        String name = req.queryParams("name");
//        String cause = req.queryParams("cause");
//    })
    }
}
