package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import serenitylabs.tutorials.trains.enums.UpdateType;
import serenitylabs.tutorials.trains.ui.LiveUpdates;

import java.util.List;

public class LiveUpdateIncidents {
    public static Question<List<String>> forLineUpdates() {
        return actor -> Text.of(LiveUpdates.updateMessagesFor(UpdateType.LineUpdates)).viewedBy(actor).asList();
    }

    public static Question<List<String>> forGeneralUpdates() {
        return actor -> Text.of(LiveUpdates.updateMessagesFor(UpdateType.GeneralUpdates)).viewedBy(actor).asList();
    }
}
