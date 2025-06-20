package net.serenitybdd.screenplay.accesing_the_application;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.questions.Aplicacion;
import net.serenitybdd.screenplay.tasks.Iniciar;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("Screenplay")
public class LearnOfTheAppTest {
    private final Actor john = Actor.named("John");

    @Managed
    private WebDriver hisBrowser;

    @BeforeEach
    public void johnCanBrowseTheWeb() {
        john.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_identify_the_application() {
        givenThat(john).wasAbleTo(Iniciar.withAnEmptyTodoList());
        then(john).should(
                seeThat(Aplicacion.information(),
                        displays("title",equalTo("Swag Labs"))
                        //displays("heading",equalTo("Todos"))
                )
        );
    }
}
