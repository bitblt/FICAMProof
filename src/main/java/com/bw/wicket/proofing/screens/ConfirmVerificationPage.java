package com.bw.wicket.proofing.screens;

import com.bw.wicket.proofing.dto.DriversLicense;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import java.util.Date;

/**
 * Created by bwright on 7/1/2016.
 */
public class ConfirmVerificationPage extends FicamBasePage {
    public ConfirmVerificationPage() {
        DriversLicense license = getDriversLicense();

        add(new Label("state", license.getState()));
        add(new Label("number", license.getNumber()));
        add(new Label("issueDate", license.getIssueDate()));
        add(new Label("expiresDate", license.getExpiresDate()));

        add(new Link("cancel") {
            @Override
            public void onClick() {
                setResponsePage(IntroPage.class);
            }
        });
        add(new Link("continue") {
            @Override
            public void onClick() {
                setResponsePage(VerificationPage.class);
            }
        });
    }

    @Override
    public String getPageTitle() {
        return "Confirmation Page";
    }
}
