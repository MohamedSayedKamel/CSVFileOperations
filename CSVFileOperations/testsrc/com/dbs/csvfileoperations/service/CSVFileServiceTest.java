package com.dbs.csvfileoperations.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dbs.csvfileoperations.exception.CSVFileException;
import com.dbs.csvfileoperations.service.impl.CSVFileServiceImpl;

public class CSVFileServiceTest {
	CSVFileService test  = new CSVFileServiceImpl();

	@Test
	public void testReadFile() throws IOException, CSVFileException {
//		List<List<String>> readFile = test.readFile("D:\\CSV\\database.csv", true, ",");
		//List<List<String>> readFile = test.readFile("D:\\CSV\\database.csv", true, ",");

	}

	@Test
	public void testAddRecords() throws IOException, CSVFileException {
		//test.addRecords("D:\\CSV\\database.csv", true, ",", createCsvDataComplex());
	}
	public static List<List<String>> createCsvDataComplex() {
		List<List<String>> listOfLists = new ArrayList<>();
		  List<String> innerList = new ArrayList<>();
		  innerList.add("1004");
		  innerList.add("XXXX");
		  innerList.add("doctor");
		  innerList.add("26");
		  innerList.add("tanta");
		  List<String> innerList1 = new ArrayList<>();
		  innerList1.add("10099");
		  innerList1.add("YYYYY");
		  innerList1.add("teacher");
		  innerList1.add("23");
		  innerList1.add("bani-suef");
		  listOfLists.add(innerList);
		  listOfLists.add(innerList1);
		
		return listOfLists;
    }

	@Test
	public void testAddRecord() throws IOException, CSVFileException {
		//test.addRecord("D:\\CSV\\database.csv", true, ",", Arrays.asList("1006", "ali", "teacher", "40", "tanta"));
	}

	@Test
	public void testFindStringBooleanStringString() throws IOException, CSVFileException {
		//test.findByKey("D:\\CSV\\database.csv", true, ",","         doctor            ");
	}

	@Test
	public void testFindStringBooleanStringMapOfIntegerListOfString() throws IOException, CSVFileException {
		//List<List<String>>  result= test.find("D:\\CSV\\database.csv", true, ",",getTestData());
		//System.out.println(result);
	}
	private static Map<Integer, List<String>> getTestData() {
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(3, Arrays.asList("100", "101"));
		return map;
	}

}
