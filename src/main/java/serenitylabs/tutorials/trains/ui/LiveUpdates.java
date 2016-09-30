package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import serenitylabs.tutorials.trains.enums.UpdateType;

import java.util.HashMap;
import java.util.Map;

public class LiveUpdates {


    public static final Target LINE_UPDATE_BADGE = Target.the("Line updates badge").locatedBy("#line_updatesCount");
    public static final Target GENERAL_UPDATE_BADGE = Target.the("General update badge").locatedBy("#general_updatesCount");
    public static final Target STATION_UPDATE_BADGE = Target.the("Station update badge").locatedBy("#station_updatesCount");
    public static final Target TRAIN_CANCELLATION_BADGE = Target.the("Train Cancel badge").locatedBy("#train_cancel_updatesCount");

    private static Map<UpdateType,Target> UPDATE_TOGGLE = new HashMap<UpdateType,Target>();
    private static Map<UpdateType,Target> UPDATE_MESSAGES = new HashMap<UpdateType,Target>();

    static {
    UPDATE_MESSAGES.put(UpdateType.GeneralUpdates,Target.the("General Update Messages").locatedBy("#general_updates .incident"));
    UPDATE_MESSAGES.put(UpdateType.LineUpdates,Target.the("Line updates").locatedBy("#line_updates .incident"));
    UPDATE_MESSAGES.put(UpdateType.StationUpdates,Target.the("Line updates").locatedBy("#station_updates .incident"));
        UPDATE_MESSAGES.put(UpdateType.TrainCancelation,Target.the("Train Cancelation incidents").locatedBy("#train_cancel_updates .incident"));


    UPDATE_TOGGLE.put(UpdateType.GeneralUpdates,Target.the("General updates").locatedBy("//span[contains(.,'General Update')]"));
    UPDATE_TOGGLE.put(UpdateType.LineUpdates,Target.the("Line updates button").locatedBy("//span[contains(.,'Line Updates')]"));
    UPDATE_TOGGLE.put(UpdateType.StationUpdates,Target.the("Station Updates").locatedBy("//span[contains(.,'Station Update')]"));
    UPDATE_TOGGLE.put(UpdateType.TrainCancelation,Target.the("Train cancelation Updates").locatedBy("//span[contains(.,'Train Cancellation')]"));
    }


    public static Target toggleFor(UpdateType updateType){
        return UPDATE_TOGGLE.get(updateType);
    }

    public static Target updateMessagesFor(UpdateType updateType){
        return UPDATE_MESSAGES.get(updateType);
    }





}
