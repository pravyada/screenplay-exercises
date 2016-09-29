package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.trains.ui.LiveUpdates;

public class ViewTheLiveUpdates implements Task {
    public static Target lineUpdateTarget;

    public ViewTheLiveUpdates(Target lineUpdateTarget){
        this.lineUpdateTarget = lineUpdateTarget;
    }


    @Override
    @Step("{0} views the live updates for #updateType")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(lineUpdateTarget)
        );
    }

    public static Performable forLineUpdate() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(LiveUpdates.LINE_UPDATE_TOGGLE);
    }


    public static Performable forGeneralUpdate() {
        return Instrumented.instanceOf(ViewTheLiveUpdates.class).withProperties(LiveUpdates.GENERAL_UPDATE_TOGGLE);
    }
}
