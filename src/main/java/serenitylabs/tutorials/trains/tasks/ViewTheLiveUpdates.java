package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.enums.UpdateType;
import serenitylabs.tutorials.trains.ui.LiveUpdates;

public class ViewTheLiveUpdates implements Task {
    public static UpdateType updateType;

    public ViewTheLiveUpdates(UpdateType updateType){
        this.updateType = updateType;
    }


    @Override
    @Step("{0} views the live updates for #updateType")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LiveUpdates.toggleFor(updateType))
        );
    }

    public static Performable forLineUpdate() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(UpdateType.LineUpdates);
    }


    public static Performable forGeneralUpdate() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(UpdateType.GeneralUpdates);
    }

    public static Performable forStationUpdates() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(UpdateType.StationUpdates);
    }

    public static Performable forTrainCancelation() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(UpdateType.TrainCancelation);
    }
}
