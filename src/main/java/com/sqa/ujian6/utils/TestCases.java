package com.sqa.ujian6.utils;

public enum TestCases {

T1("Testing register page"),
T2("Testing login page");
	
	
	private String testName;	

	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
