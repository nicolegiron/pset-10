import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.google.gson.Gson;

public class GSONReadingFromFileExample {

	static Word[] wordObj;
	static Word[] definitions;

	public static void main(String[] args) {
		 returnWords();
	}
	
	public static List<Word> returnWords() {
		Gson gson = new Gson();
		   
		  try {
		   BufferedReader br = new BufferedReader(new FileReader("words.json"));
		   
		   wordObj = gson.fromJson(br,  Word[].class);
		   
		   List<Word> list = Arrays.asList(wordObj);
		   list.sort((Comparator.comparing(Word::toString)));
		   return list;
		  
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		return null;
	}
}
