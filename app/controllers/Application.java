package controllers;

import models.Lift;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    public static Result index() {

        // import all Lifts from the CSV File
        Lift.importData();
        return ok(index.render(Lift.getAll()));
    }

    public static Result showList() {
        return TODO;
    }

    public static Result showLift() {
        return TODO;
    }

}
