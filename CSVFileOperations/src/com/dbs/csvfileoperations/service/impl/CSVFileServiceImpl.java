package com.dbs.csvfileoperations.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dbs.csvfileoperations.enums.Column;
import com.dbs.csvfileoperations.exception.CSVFileException;
import com.dbs.csvfileoperations.service.CSVFileService;

public class CSVFileServiceImpl implements CSVFileService {


	@Override
	public List<List<String>> readFile(String path, boolean includeHeader, String separator)
			throws CSVFileException {
		
		checkIsNull(path, separator);
		String line;
		List<List<String>> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				List<String> values = Arrays.asList(line.split(separator));
				lines.add(values);
			}
			if (includeHeader == true)
				lines.remove(0);
		} catch (IOException e) {
			throw new CSVFileException(e.getMessage());
		}
		return lines;
	}

	private void checkIsNull(String path, String separator) {
		if (path.trim() == null || path.trim().isEmpty()) 
			throw new IllegalArgumentException("path is null please add correct path");
		if (separator.trim() == null || separator.trim().isEmpty()) 
			throw new IllegalArgumentException("separator is null please checking it ");
	}

	private String getLineData(List<String> list, String separator) {
		StringBuilder str =new StringBuilder();
		for (String value : list) {
			str.append(value);
			str.append(separator);
		}
		return str.toString();
	}

	@Override
	public void addRecord(String path, boolean includeHeader, String separator, List<String> record)
			throws CSVFileException {
		checkIsNull(path, separator);
		FileWriter writer;
		try {
			writer = new FileWriter(path, true);
			List<List<String>> listOfList = readFile( path,  includeHeader,  separator);
			if (listOfList.size() == 1 && includeHeader == false) {
					Map<String, List<String>> columns = new LinkedHashMap<>();
					// initialize the map
					for (Column c : Column.values()) {
						columns.put(c.getValue(), new ArrayList<>());
					}
					writer.write(columns.keySet().toString().substring(1, columns.keySet().toString().length() - 1));
					writer.append("\n");
			
			}
			if(record == null || record.isEmpty()) 
				throw new IllegalArgumentException("please enter valid list");
			writer.write(getLineData(record, separator));
			writer.append("\n");
			writer.close();
		} catch (IOException e) {
			throw new CSVFileException(e.getMessage());
		}
		
	}
	
	@Override
	public void addRecords(String path, boolean includeHeader, String separator, List<List<String>> records)
			throws  CSVFileException {
		checkIsNull(path, separator);
		List<List<String>> listOfList = readFile( path,  includeHeader,  separator);
		if (listOfList.size() == 1 && includeHeader == false) {
			for (List<String> list : records) 
				addRecord(path, includeHeader, separator, list);
		}
		else {
			for (List<String> list : records) {
				FileWriter writer;
				try {
					writer = new FileWriter(path, true);
					writer.write(getLineData(list, separator));
					writer.append("\n");
					writer.close();
				} catch (IOException e) {
					new CSVFileException(e.getMessage());
				}
				
			}
		}
	}

	@Override
	public void findByKey(String path, boolean includeHeader, String separator, String key)
			throws CSVFileException {
		checkIsNull(path, separator);
		if(key.trim() == null || key.trim().isEmpty())
			throw new IllegalArgumentException("please enter valid key");
		List<List<String>> listOfList = readFile( path,  includeHeader,  separator);
		try {
			for (List<String> line : listOfList) {
				if (line.contains(key.trim())) 
					System.out.println(line);
			}
		}catch (IllegalArgumentException e) {
			e.getMessage();
		}
		
	}

	@Override
	public List<List<String>> find(String path, boolean includeHeader, String separator, Map<Integer, List<String>> map)
			throws  CSVFileException {
		checkIsNull(path, separator);
		if(map == null || map.isEmpty())
			throw new IllegalArgumentException("please checking correct search values");
		List<List<String>> listOfList = readFile(path, includeHeader, separator);
		List<List<String>> results = new ArrayList<>();
		
		/*for (List<String> line : listOfList) {

			for (Integer index : map.keySet()) {

				String value = line.get(index);

				List<String> list = map.get(index);

				for (String key : list) {
					if (value.equalsIgnoreCase(key)) {
						results.add(line);
						break;
					}
				}
			}
		}	*/
		
		for (List<String> line : listOfList) {
			for (Object index : map.keySet()) {
				String value = line.get((Integer)index);
				boolean isExists = map.values().toString().contains((String) value);
				if (isExists) {
					results.add(line);
					break;
				}
			}
		}
		return results;
	}
}
