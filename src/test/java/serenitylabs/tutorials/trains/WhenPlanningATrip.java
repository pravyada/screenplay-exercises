package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheOutBoundJourneySummery;
import serenitylabs.tutorials.trains.tasks.EnterHerDetails;
import serenitylabs.tutorials.trains.ui.AssistedTravelPage;
import serenitylabs.tutorials.trains.ui.ChosenTo;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;
import serenitylabs.tutorials.trains.ui.TicketTypeForm;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isSelected;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.selectedValueOf;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.valueOf;
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
                seeThat("the departuer station",TheOutBoundJourneySummery.origin(), is("London Paddington")),
                seeThat("the destination station",TheOutBoundJourneySummery.destination(), is("Oxford"))
        );
    }


    @Test
    public void request_assisted_travel(){
        //GIVEN

       tracy.has(ChosenTo.requestAssistedTravel());

        //GIVEN
        tracy.attemptsTo(EnterHerDetails.as("Dr","Tracy","The Traveller"));

        //THEN

        tracy.should(
                seeThat(valueOf(AssistedTravelPage.FULL_NAME),is("Tracy The Traveller")),
                seeThat(selectedValueOf(AssistedTravelPage.TITLE),is("Dr"))
        );
    }



    @Test
    public void sensible_default_trip_options_are_proposed(){

        //GIVEN
        tracy.has(ChosenTo.bookATicket());

        //THEN
        tracy.should(
                seeThat(the(TicketTypeForm.HEADING), isVisible()),
                seeThat((the(TicketTypeForm.SINGLE)),isSelected())
        );

    }
}