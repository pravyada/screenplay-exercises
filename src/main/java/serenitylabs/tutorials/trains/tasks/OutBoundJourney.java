package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by pravyada on 9/23/2016.
 */
public class OutBoundJourney {
    public static final Target ORIGIN = Target.the("Departaure Station").locatedBy(".planner-header__origin");
    public static final Target DESTINATION = Target.the("Destination").locatedBy(".planner-header__destination");
}
