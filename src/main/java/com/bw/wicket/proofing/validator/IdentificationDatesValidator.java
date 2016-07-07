package com.bw.wicket.proofing.validator;


import org.apache.commons.lang3.time.DateUtils;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;

import java.util.Date;

/**
 * <code>IdentificationDatesValidator</code> performs the validation of the <b>issue date</b>
 * against the <b>expires date</b> for an identification item such as a driver's license.
 *
 * It is expected that we have both a specified issue and expiration date.
 */
public class IdentificationDatesValidator extends AbstractFormValidator {
    private final FormComponent<?>[] components;
    private final String dateFormat;

    /**
     * Creates a validator for the two components which must have a property map that returns
     * a <code>java.util.Date</code> object.
     *
     * @param issueDateComponent - date identification was issued
     * @param expiresDateComponent - date identification will expire
     * @param format - format for parsing the date.  @see java.util.ParseDate
     */
    public IdentificationDatesValidator(FormComponent<?> issueDateComponent, FormComponent<?> expiresDateComponent, String format) {
        if (issueDateComponent == null)
            throw new IllegalArgumentException("Argument issueDateComponent cannot be null");

        if (expiresDateComponent == null)
            throw new IllegalArgumentException("Argument expiresDateComponent cannot be null");

        components = new FormComponent[] { issueDateComponent, expiresDateComponent};

        dateFormat = format;
    }

    @Override
    public FormComponent<?>[] getDependentFormComponents() {
        return components;
    }

    @Override
    public void validate(Form<?> form) {
        final FormComponent<?> issueDateComponent = components[0];
        final FormComponent<?> expiresDateComponent = components[1];
        Date issueDate;
        Date expiresDate;

        try {
            issueDate = convertDateReportError(issueDateComponent);
            expiresDate = convertDateReportError(expiresDateComponent);

            checkIssueDate(issueDate, issueDateComponent);
            checkExpireDate(expiresDate, issueDate, expiresDateComponent);
        }
        catch (Exception e) {
            // do nothing
        }
    }

    private void checkExpireDate(Date expiresDate, Date issueDate, FormComponent<?> expiresDateComponent) {
        if (expiresDate.before(issueDate) || DateUtils.isSameDay(issueDate, expiresDate))
            error(expiresDateComponent, "EXPIRE_NOT_AFTER_ISSUE");
    }

    private void checkIssueDate(Date issueDate, FormComponent issueDateComponent) {
    }

    /*
    * parses the date and returns the successfully parsed date.  If parsing fails, it reports
    * the error for the component.
     */
    private Date convertDateReportError(FormComponent component) throws Exception {
        Date date;
        String input;
        String [] patterns = new String[] { dateFormat};

        input = component.getValue();

        try {
            date = DateUtils.parseDateStrictly(input, patterns);
        }
        catch (Exception e) {
            error(component);
            throw e;
        }

        return date;
    }

    @Override
    protected String resourceKey() {
        return "IdentificationDatesValidator";
    }
}
