package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by pravyada on 9/23/2016.
 */
public class TicketTypeForm {
    public static final Target FROM = Target.the("Departure-Station").located(By.id("depart-from"));
    public static final Target DESTINATION = Target.the("Destination-Station").located(By.id("#going-to"));
    public static final Target BUY_TICKETS = Target.the("BuyTicketButton").located(By.id("button planner__submit"));
}

