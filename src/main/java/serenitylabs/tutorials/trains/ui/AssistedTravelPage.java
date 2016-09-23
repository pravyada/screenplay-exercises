package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

/**
 * Created by pravyada on 9/23/2016.
 */
public class AssistedTravelPage extends PageObject {
    public static final Target TITLE = Target.the("title").locatedBy("//div[label[contains(.,'Title')]]/select") ;
}
