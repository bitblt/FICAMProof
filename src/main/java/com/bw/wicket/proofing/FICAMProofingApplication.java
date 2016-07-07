package com.bw.wicket.proofing;

import com.bw.wicket.proofing.screens.IntroPage;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.bw.wicket.proofing.Start#main(String[])
 */
public class FICAMProofingApplication extends WebApplication
{
	public FICAMProofingApplication() {
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage()
	{
		return IntroPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}

	public static FICAMProofingApplication get () { return (FICAMProofingApplication) Application.get(); }

	/**
	 * TODO: replace this with the proper mechanism in our framework to get data into session
	 */
	@Override
	public Session newSession(Request request, Response response) {
		return new FicamSession(request);
	}
}
