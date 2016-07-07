package com.bw.wicket.proofing.screens;

import com.bw.wicket.proofing.dto.DriversLicense;
import com.bw.wicket.proofing.validator.IdentificationDatesValidator;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import java.util.Date;

/**
 * Created by bwright on 7/1/2016.
 */
public class DriversLicensePage extends FicamBasePage {
    @Override
    public String getPageTitle() {
        return "Driver's License";
    }

    public DriversLicensePage () {
        DriversLicense license = getDriversLicense();

        add(new FeedbackPanel("feedback"));
        Form form = new Form("form");
        form.add(new TextField("state", new PropertyModel(license, "state")).setRequired(true));
        form.add(new TextField("number", new PropertyModel(license, "number")).setRequired(true));



//        DatePicker datePicker = new DatePicker();
//        datePicker.setShowOnFieldClick(true);
//        datePicker.setAutoHide(true);

        DateTextField dateIssuedField = new DateTextField("issueDate", new PropertyModel<Date>(
                license, "issueDate"), new StyleDateConverter("S-", true));

//        TextField dateIssuedField = new TextField("issueDate", new PropertyModel(license, "issueDate"));
        dateIssuedField.setRequired(true);

//        dateIssuedField.add(datePicker);

        DateTextField dateExpiresField = new DateTextField("expiresDate", new PropertyModel<Date>(
                license, "expiresDate"), new StyleDateConverter("S-", true));
//        TextField dateExpiresField = new TextField("expiresDate", new PropertyModel(license, "expiresDate"));
        dateExpiresField.setRequired(true);

        form.add(dateIssuedField);
        form.add(dateExpiresField);

        form.add(new IdentificationDatesValidator(dateIssuedField, dateExpiresField, "MM/dd/yyyy"));

        form.add(new Link("cancel") {
            @Override
            public void onClick() {
                setResponsePage(IntroPage.class);
            }
        });
        form.add(new Button("continue") {
            @Override
            public void onSubmit() {
                System.out.println(getDriversLicense());
                setResponsePage(new ConfirmVerificationPage());
            }
        });
        add(form);
    }
}
