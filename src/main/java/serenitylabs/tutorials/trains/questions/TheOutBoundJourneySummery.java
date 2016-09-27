package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.tasks.OutBoundJourney;

import java.lang.annotation.Target;

/**
 * Created by pravyada on 9/23/2016.
 */
public class TheOutBoundJourneySummery {

    public static Question<String> origin() {

        return TheTarget.textOf(OutBoundJourney.ORIGIN);
        //return Target.textof(OutBoundJourney.ORIGIN);
    }

    public static Question<String> destination() {
        return TheTarget.textOf(OutBoundJourney.DESTINATION);
        //return actor -> Text.of(OutBoundJourney.DESTINATION).viewedBy(actor).asString();
    }

}
