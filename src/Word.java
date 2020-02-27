import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
	private String word;
	private Definition[] definitions;
	private List<String> synonyms;
	private List<String> antonyms;
	
	public String getWord() {
        return word;
    }
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public Definition[] getDefintions() {
        return definitions;
    }
	
	public void setDefinitions(Definition[] definitions) {
		this.definitions = definitions;
	}
	
	public List<String> getSynonyms() {
        return synonyms;
    }
 
    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }
    
    public List<String> getAntonyms() {
        return antonyms;
    }
 
    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }
    //Arrays.toString(definitions)
    @Override
    public String toString() {
    	return word;
    	//return "Word: " + word + "\n" + definitions[0] + "\nSynonyms: " + synonyms + "\nAntonyms: " + antonyms + "\n";
    }
}
