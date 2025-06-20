package net.serenitybdd.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.user_interfaces.TodoList.WHAT_NEEDS_TO_BE_DONE;
import static org.openqa.selenium.Keys.RETURN;

public class AddATodoItems {

    public static Task called(String thingToDo) {
        return Task.where("{0} adds a todo item called: " + thingToDo,
                Enter.theValue(thingToDo)
                        .into(WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(RETURN)
        );
    }
}