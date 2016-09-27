package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.SelectedVisibleTextValue;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.eclipse.jetty.util.DateCache;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheOutboundJourneySummary;
import serenitylabs.tutorials.trains.tasks.ChosenTo;
import serenitylabs.tutorials.trains.tasks.EnterHerDetails;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;
import serenitylabs.tutorials.trains.ui.AssistedTravelPage;
import serenitylabs.tutorials.trains.ui.TicketTypeForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isSelected;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.selectedVisibleTextValueOf;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.valueOf;
import static org.assertj.core.api.StrictAssertions.not;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver webDriver;

    Actor tracy;

    @Before
    public void setTheStage() {
        tracy = Actor.named("Tracy");
        tracy.can(BrowseTheWeb.with(webDriver));
    }

    @Test
    public void booking_a_simple_trip() {

        tracy.has(ChosenTo.bookATicket());

        // WHEN
        tracy.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );

        // THEN
        tracy.should(
                seeThat(TheOutboundJourneySummary.origin(), is("London Paddington")),
                seeThat(TheOutboundJourneySummary.destination(), is("Oxford"))
        );
    }

    @Test
    public void sensible_default_trip_options_are_proposed() {
        //GIVEN
        tracy.has(ChosenTo.bookATicket());

        //THEN
        tracy.should(
                seeThat(the(TicketTypeForm.HEADING), isVisible()),
                seeThat(the(TicketTypeForm.SINGLE),isSelected()),
                seeThat(the(TicketTypeForm.SINGLE),isEnabled()),
                seeThat(the(TicketTypeForm.RETURN), Matchers.not(isSelected()))
        );

        // TODO
    }

    @Test
    public void return_date_should_be_only_enabled_for_return_trips() {
        //GIVEN
        tracy.has(ChosenTo.bookATicket());

        //WHEN
        tracy.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );

        //THEN
        tracy.should(
                seeThat(the(TicketTypeForm.RETURN_DATE), isSelected())
        );
    }

    @Test
    public void request_assisted_travel() {
        //GIVEN

        tracy.has(ChosenTo.requestAssistedTravel());

        //WHEN
        tracy.attemptsTo(EnterHerDetails.as("Dr", "Tracy", "Traveller"));

        //THEN

        tracy.should(
                seeThat(valueOf(AssistedTravelPage.FULL_NAME),is("Tracy Traveller")),
                seeThat(selectedVisibleTextValueOf(AssistedTravelPage.TITLE),is("Dr"))
        );

    }
}
