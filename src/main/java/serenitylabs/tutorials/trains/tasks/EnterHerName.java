package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import serenitylabs.tutorials.trains.ui.AssistedTravelPage;

/**
 * Created by pravyada on 9/23/2016.
 */
public class EnterHerName implements Task{


    private final String title;
    private final String firstName;
    private final String lastName;

    public EnterHerName(String title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText("Dr").from(AssistedTravelPage.TITLE)

        );
    }

    public static Performable as(String title, String firstName, String lastName) {
        return Instrumented.instanceOf(EnterHerName.class).withProperties(title,firstName,lastName);
    }
}
