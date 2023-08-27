package SeleniumJava.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {
		
		//reading json to string
		String jsonContext = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/main/java/SeleniumJava/data/PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//string to hashmap using jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContext, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		
		return data;
		
	}

}
