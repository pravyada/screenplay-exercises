package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.ui.AssistedTravelPage;

/**
 * Created by pravyada on 9/23/2016.
 */
public class EnterHerDetails implements Task{


    private final String title;
    private final String firstName;
    private final String lastName;

    public EnterHerDetails(String title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    @Step("{0} enters #title into title field and #firstName & #lastName into full name field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText("Dr").from(AssistedTravelPage.TITLE),
                Enter.theValue(firstName+" "+lastName).into(AssistedTravelPage.FULL_NAME)

        );
    }

    public static Performable as(String title, String firstName, String lastName) {
        return Instrumented.instanceOf(EnterHerDetails.class).withProperties(title,firstName,lastName);
    }
}
