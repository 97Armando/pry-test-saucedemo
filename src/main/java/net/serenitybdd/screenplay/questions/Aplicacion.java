package net.serenitybdd.screenplay.questions;
import net.serenitybdd.screenplay.models.AplicacionInformacion;
import net.serenitybdd.screenplay.user_interfaces.TodoListApp;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Aplicacion implements Question<AplicacionInformacion>{

    @Override
    public AplicacionInformacion answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        String heading = Text.of(TodoListApp.MAIN_HEADING).answeredBy(actor);
        String aboutInformation = Text.of(TodoListApp.FOOTER).answeredBy(actor);

        return new AplicacionInformacion(title, heading, aboutInformation);
    }

    public static Aplicacion information() {
        return new Aplicacion();
    }
}
