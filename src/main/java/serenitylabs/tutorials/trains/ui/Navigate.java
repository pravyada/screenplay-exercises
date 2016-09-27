package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.tasks.BuyTicketsPage;

/**
 * Created by pravyada on 9/23/2016.
 */
public class Navigate implements Interaction {
    private BuyTicketsPage buyTicketsPage;
    private MainMenu mainMenuOption;

    public Navigate(MainMenu mainMenuOption){

        this.mainMenuOption = mainMenuOption;
    }

    public static Performable to(MainMenu mainMenuOption) {
        return Instrumented.instanceOf(Navigate.class).withProperties(mainMenuOption);
    }


    @Override
    @Step("{0} chosen to navigate to #buyTicketsPage")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(buyTicketsPage)
        );
    }
}
