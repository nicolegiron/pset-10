
public class Definition {
	private String definition;
	private String partOfSpeech;
	
	public String getDefinition() {
        return definition;
    }
	
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String getpartOfSpeech() {
        return partOfSpeech;
    }
	
	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
	
	@Override
    public String toString() {
    	return "Definitions: " +  definition + "\nPart of Speech: " + partOfSpeech;
    }
}
