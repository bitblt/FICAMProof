package com.bw.wicket.proofing.screens;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.flow.RedirectToUrlException;

/**
 * Created by bwright on 7/1/2016.
 */
public class IntroPage extends FicamBasePage {
    public IntroPage () {
        Label intro = new Label("intro", getIntroduction());
        intro.setEscapeModelStrings(false);
        add (intro);
        add(new Link("cancel") {
            @Override
            public void onClick() {
                throw new RedirectToUrlException("http://www.google.com");
            }
        });
        add (new Link("continue") {
            @Override
            public void onClick() {
                setResponsePage(DriversLicensePage.class);
            }
        });
    }

    @Override
    public String getPageTitle() {
        return "Start SSO Proofing";
    }

    private String getIntroduction () {
        return "Welcome to dynamic content<br><br><b>You poor smuck</b><br>" +
                "<p>some really long description intended to convince those thinking this will " +
                "be easy, it won't be at all.<br>" +
                "The rules for getting through this process is managed by the sovereign entity which is " +
                "still behind the current issues and technology advancements. <br>" +
                "That said, you should not complain because you are no longer required to make a trip to " +
                "visit an inconvenient location and wait in line.";
    }
}
