package com.parking.system.rest;

import org.junit.Test;

import com.parking.system.rest.SampleRestClient;

public class SampleRestClientTest {

	SampleRestClient restClent = new SampleRestClient(); 
	
	@Test
	//@Ignore
	public void test() throws Exception {
		System.out.println(restClent.test());
	}

}
