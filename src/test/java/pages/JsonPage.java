package pages;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonPage {
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\backend";
	JSONObject packageJSON;
	public JSONObject JSONHelper() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(filePath + "api.json");
		// Read JSON file
		Object obj = jsonParser.parse(reader);
		JSONArray Product = (JSONArray) obj;

		for (Object pageDetail : Product) {
			JSONObject detailsJSON = (JSONObject) pageDetail;/// 36 from master package
			if (detailsJSON.containsValue(Product)) {
				return detailsJSON;
			}
		}
		return null;

	}

}
