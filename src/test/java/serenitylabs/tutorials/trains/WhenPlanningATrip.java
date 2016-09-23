package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheOutBoundJourneySummery;
import serenitylabs.tutorials.trains.questions.TheOutBoundJourneySummery.*;
import serenitylabs.tutorials.trains.tasks.EnterHerName;
import serenitylabs.tutorials.trains.ui.ChosenTo;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
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
    @WithTag("Priority:High")
    public void booking_a_simple_trip() {

        tracy.has(ChosenTo.bookATicket());

        // WHEN
        tracy.attemptsTo(
                ViewTheAvailableTickets.from("London Paddington").to("Oxford")
        );

        // THEN
        tracy.should(
                seeThat(TheOutBoundJourneySummery.origin(), is("London Paddington")),
                seeThat(TheOutBoundJourneySummery.destination(), is("Oxford"))
        );
    }


    @Test
    public void request_assisted_travel(){
        tracy.has(ChosenTo.requestAssistedTravel());

        tracy.attemptsTo(EnterHerName.as("Dr","Tracy","The Traveller"));
    }
}