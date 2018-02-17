package com.hellosign.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.jackrabbit.webdav.version.report.Report;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BeckendTest {

	@Test
	public void getStatusofStockSite() throws ClientProtocolException, IOException {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("https://www.amazon.com");
		HttpResponse response = httpClient.execute(getRequest);
		Reporter.log("status code of amazon Website is "+response.getStatusLine().getStatusCode());
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "site it down");
	}

}
