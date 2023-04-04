package com.dbs.csvfileoperations.service;

import java.util.List;
import java.util.Map;

import com.dbs.csvfileoperations.exception.CSVFileException;

public interface CSVFileService {

	public List<List<String>> readFile(String path, boolean includeHeader, String separator) throws CSVFileException;

	public void addRecords(String path, boolean includeHeader, String separator, List<List<String>> records)
			throws CSVFileException;

	public void addRecord(String path, boolean includeHeader, String separator, List<String> record)
			throws CSVFileException;

	public void findByKey(String path, boolean includeHeader, String separator, String key)
			throws CSVFileException;

	public List<List<String>> find(String path, boolean includeHeader, String separator, Map<Integer, List<String>> map)
			throws CSVFileException;
	
	
//	TDD
	
	
//	H16    H8
// EX V 	
//	TDD, which stands for test-driven development, is a software development methodology. As the name suggests, TDD consists of using tests to drive the development of the application, leading to simple, iterative implementation with high test coverage from the beginning.
	
}
