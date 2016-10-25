//ReadFile.java
//Used to take in a text file and turn it into an array of Strings
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


class ReadFile{
	private String path;
	//sets path to file_path aka user inputted file name
	public ReadFile(String file_path){
		path=file_path;
	}
	int readsLines() throws IOException{
		FileReader ftr = new FileReader(path);
		BufferedReader br = new BufferedReader(ftr);

		String aLine;
		int numOfLines=0;
		while((aLine=br.readLine())!=null){
			numOfLines++;
		}
		br.close();
		return numOfLines;
	}

	//reads and buffers the raw text of the user inputted file, then creates a new String array to store the buffered text on.
	public String[] OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines=readsLines();
		String[] textData = new String[numberOfLines];
		int i;
		for(i=0;i<numberOfLines;i++){
			textData[i]=textReader.readLine();
		}
		textReader.close();
		return textData;
	}
}