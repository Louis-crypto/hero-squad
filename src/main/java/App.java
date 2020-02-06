import java.util.ArrayList;
import java.util.Map;
import java.util.*;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import models.Hero;
import models.Squad;

public class App {
    public static void main(String[] args){
    staticFileLocation("/public");

    get("/", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "welcome.hbs");
    }, new HandlebarsTemplateEngine());

    get("/welcome", (req, res) ->{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "welcome.hbs");
    }, new HandlebarsTemplateEngine());

        post("/welcome", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String userName = request.queryParams("userName");
            request.session().attribute("userName", userName);
            model.put("userName", userName);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/index", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int yourHeroes = Hero.getAll().size();
            int yourSquads = Squad.getAllSquads().size();

            model.put("yourHeroes", yourHeroes);
            model.put("yourSquads", yourSquads);
            model.put("userName", req.session().attribute("userName"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    //    display create hero form
        get("/heroes/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //       submit new hero
        post("/heroes/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String superPower = req.queryParams("superPower");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name, age, superPower, weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //  show new squad form
        get("/squads/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
//            List<Hero> unRegisteredHeroes = new ArrayList<>();
//            for(Hero hero : Hero.getAll()){
//                if(hero.getHeroesSquad().equalsIgnoreCase("")){
//                    unRegisteredHeroes.add(hero);
//                }
//            }
//            model.put("unRegisteredHeroes", unRegisteredHeroes);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //        submit new squad
        post("/squads/new", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> allHeroes = Hero.getAll();
            String squadName = req.queryParams("squadName");
            String course = req.queryParams("course");
            String heroName = req.queryParams("heroName");
            Hero addThisHero = null;
            for(Hero hero : allHeroes){
                if(hero.getName().equalsIgnoreCase(heroName)){
                    addThisHero = hero;
                    break;
                }
            }
            Squad newSquad = new Squad(squadName, course, addThisHero );
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//    show all heroes
    get("/heroes", (req, res) ->{
        Hero firstHero = new Hero("Iron man", 34, "money", "electricity");
        Map<String, ArrayList<Hero>> model = new HashMap<>();
        ArrayList yourHeroes = Hero.getAll();
        model.put("yourHeroes", yourHeroes);
        return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        //    show all squads
            get("/squads", (req, res) ->{
            Squad firstSquad = new Squad("Guardians", "protect the galaxy", new Hero("Iron man", 34, "money", "electricity"));
            Map<String, ArrayList<Squad>> model = new HashMap<>();
            ArrayList yourSquads = Squad.getAllSquads();
            model.put("yourSquads", yourSquads);
//            model.put("userName", req.session().attribute("userName"));
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
