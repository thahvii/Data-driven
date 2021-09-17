package com.exercise.core;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonFile {
	public static Object[][] getDataFromJson(String file) {
		JSONParser jsonParser = new JSONParser();
		try {

			FileReader reader = new FileReader(file);
			Object obj = jsonParser.parse(reader);
			JSONArray hotelList = (JSONArray) obj;

			int totalRows = hotelList.size();
			int totalColumn = 3;
			Object[][] tabArray = new Object[totalRows][totalColumn];
			for (int i = 0; i < totalRows; i++) {
				Object orgRow = hotelList.get(i);
				JSONObject row = (JSONObject) orgRow;
				JSONObject hotelInfo = (JSONObject) row.get("hotel");

				String name = (String) hotelInfo.get("name");
				String location = (String) hotelInfo.get("location");
				String description = (String) hotelInfo.get("description");

				tabArray[i][0] = name;
				tabArray[i][1] = location;
				tabArray[i][2] = description;
			}
			return tabArray;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
