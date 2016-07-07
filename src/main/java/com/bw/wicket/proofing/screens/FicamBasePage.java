package com.bw.wicket.proofing.screens;

import com.bw.wicket.proofing.FicamSession;
import com.bw.wicket.proofing.dto.DriversLicense;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Base page for the application.
 */
public abstract class FicamBasePage extends WebPage {
    /**
     * Returns the application session for this instance.
     *
     * @return FicamSession
     * TODO: replace with the proper way to handle application session in our framework
     */
    public FicamSession getFicamSession () {
        return (FicamSession) getSession();
    }

    public DriversLicense getDriversLicense () {
        return getFicamSession().getDriversLicense();
    }

    public FicamBasePage () {
        super();
        setup();
    }

    private void setup() {
        add (new Label("pageTitle", getPageTitle()));
    }

    /**
     *  <code>getPageTitle</code> returns the value for the page's title
     * @return The title for the page
     */
    public abstract String getPageTitle ();

}
