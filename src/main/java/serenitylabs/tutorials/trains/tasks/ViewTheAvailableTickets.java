package serenitylabs.tutorials.trains.tasks;

import gherkin.lexer.En;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import serenitylabs.tutorials.trains.ui.TicketTypeForm;

/**
 * Created by pravyada on 9/23/2016.
 */
public class ViewTheAvailableTickets implements Performable {

    private final String departureStation;
    private final String destinationStation;

    public ViewTheAvailableTickets(String departureStation, String destinationStation){
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public static ViewTheAvailableTicketsBuilder from(String departuer) {
        return new ViewTheAvailableTicketsBuilder(departuer);
    }

    @Step("View the available tickets from #departureStation to #destinationStation")
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(departureStation).into(TicketTypeForm.FROM).thenHit(Keys.ARROW_DOWN,Keys.TAB),
                    Enter.theValue(destinationStation).into(TicketTypeForm.DESTINATION).thenHit(Keys.ARROW_DOWN,Keys.TAB),
                    Click.on(TicketTypeForm.BUY_TICKETS)
            );
    }

    public static class ViewTheAvailableTicketsBuilder {
        private String departureStation;

        public ViewTheAvailableTicketsBuilder(String departureStation) {
            this.departureStation = departureStation;
        }

        public Performable to(String destinationStation) {
            return Instrumented.instanceOf(ViewTheAvailableTickets.class).withProperties(departureStation,destinationStation);
        }
    }
}
