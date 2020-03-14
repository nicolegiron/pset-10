import java.lang.Object;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*; 


public class GSONWritingToFileExample {
	
	static Word[] wordObj;
	private static FileWriter file;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

	}
	
	public static void addWord(String word, ArrayList<Object> definitions) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	    Word newWord = new Word(word);
	    
//	    String jsonStr = gson.toJson(word, Word.class);
//	    System.out.println("JSON String: \n" + jsonStr);
	    
//	    JsonElement jsonElement = gson.toJsonTree(newWord);
	    
//	    jsonElement.getAsJsonObject().addProperty("id", "115");
	    
//	    JsonObject definitionsJSON = new JsonObject();
	    
//	    definitionsJSON.add("definitions", );
	    
//	    jsonStr = gson.toJson(jsonElement);
//	    System.out.println("JSON String after inserting additional property: \n" + jsonStr);
	}


	public static void removeWord(Object thisWord) throws FileNotFoundException, IOException, ParseException{
//		JSONParser jsonParser = new JSONParser();
//        
//        try (FileReader reader = new FileReader("words.json")){
//        	
//            Object obj = jsonParser.parse(reader);
//            JSONArray wordList = (JSONArray) obj;
//            
//            file = new FileWriter("words.json");
//            for (int index = 0; index < wordList.size(); ++index) {
//                JSONObject jsonObject = (JSONObject) wordList.get(index);
//                Object words =  jsonObject.get("word");
//                if(words.toString().equals(thisWord.toString())) {
//                	System.out.println("deeper removing...");
//                	jsonObject.remove("word");
//                }
//                file.write(jsonObject.toJSONString());
//                file.flush();
//                if (index == wordList.size() - 1)
//                    file.close();
//            }
//            
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
	}
}
