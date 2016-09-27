package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by pravyada on 9/23/2016.
 */
public class ChosenTo implements Task {
    public static Performable bookATicket() {
        return instrumented(ChosenTo.class);
    }

    @Override
    @Step("{0} chosen to buy some ticket")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Navigate.to(MainMenu.BuyTickets)
        );
    }

    public static Performable requestAssistedTravel() {
        return instrumented(ChosenTo.class,MainMenu.GetTravelAssistance);
    }
}
