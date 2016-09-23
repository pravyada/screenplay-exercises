package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import serenitylabs.tutorials.trains.tasks.OutBoundJourney;

/**
 * Created by pravyada on 9/23/2016.
 */
public class TheOutBoundJourneySummery {
    public static Question<String> origin() {

        return actor -> Text.of(OutBoundJourney.ORIGIN).viewedBy(actor).asString();
    }

    public static Question<String> destination() {

        return actor -> Text.of(OutBoundJourney.DESTINATION).viewedBy(actor).asString();
    }

}
