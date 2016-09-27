package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by pravyada on 9/23/2016.
 */
@DefaultUrl("https://www.southwesttrains.co.uk/contact--help/contact-us/assisted-travel-form")
public class AssistedTravelPage extends PageObject {

    public static final Target TITLE = Target.the("title").locatedBy("//div[label[contains(.,'Title')]]/select");
    public static final Target FULL_NAME = Target.the("full name").locatedBy("//div[label[contains(.,'Full name')]]/input");

}
