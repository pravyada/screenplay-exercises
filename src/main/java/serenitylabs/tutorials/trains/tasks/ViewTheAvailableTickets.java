package serenitylabs.tutorials.trains.tasks;

import gherkin.lexer.En;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import serenitylabs.tutorials.trains.ui.TicketTypeForm;

/**
 * Created by pravyada on 9/23/2016.
 */
public class ViewTheAvailableTickets implements Performable {

    private final String from;
    private final String to;

    public ViewTheAvailableTickets(String from, String to){
        this.from = from;
        this.to = to;
    }

    public static ViewTheAvailableTicketsBuilder from(String departuer) {
        return new ViewTheAvailableTicketsBuilder(departuer);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(from).into(TicketTypeForm.FROM).thenHit(Keys.TAB),
                    Enter.theValue(to).into(TicketTypeForm.DESTINATION).thenHit(Keys.TAB),
                    Click.on(TicketTypeForm.BUY_TICKETS)
            );
    }

    public static class ViewTheAvailableTicketsBuilder {
        private String from;

        public ViewTheAvailableTicketsBuilder(String departuer) {
            this.from = departuer;
        }

        public Performable to(String to) {
            return Instrumented.instanceOf(ViewTheAvailableTickets.class).withProperties(from,to);
        }
    }
}
