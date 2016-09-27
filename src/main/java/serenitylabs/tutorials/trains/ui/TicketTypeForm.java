package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TicketTypeForm {
    public static final Target FROM = Target.the("Departing From field ").located(By.id("depart-from"));
    public static final Target TO = Target.the("Going To field ").located(By.id("going-to")) ;
    public static final Target BUY_TICKETS = Target.the("Buy Tickets button").located(By.className("planner__submit"));
    public static final Target HEADING = Target.the("Buy Tickets Heading").located(By.className("planner__title")) ;
    public static final Target SINGLE = Target.the("Single status Button").located(By.id("single"));
    public static final Target RETURN = Target.the("Return Button").located(By.id("return"));
    public static final Target RETURN_DATE = Target.the("Return Date Field").located(By.id("Inbound-date-time"));
}
