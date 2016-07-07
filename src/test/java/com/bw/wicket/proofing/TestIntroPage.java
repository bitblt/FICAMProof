package com.bw.wicket.proofing;

import com.bw.wicket.proofing.screens.IntroPage;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestIntroPage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new FICAMProofingApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(IntroPage.class);

		//assert rendered page class
		tester.assertRenderedPage(IntroPage.class);
	}
}
