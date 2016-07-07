package com.bw.wicket.proofing;

import com.bw.wicket.proofing.dto.DriversLicense;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * Created by bwright on 7/1/2016.
 */
public class FicamSession extends WebSession {
    private DriversLicense license = new DriversLicense();

    protected FicamSession(Request request) {
        super(request);
    }

    public DriversLicense getDriversLicense () {
        return license;
    }
}
