import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*what is java?
java is what we call a
	a) strongly typed
	b) object oriented
	c) compiled language that runs on its own virtual machine
	virtual machine : meaning it runs in a virtual environment in the same way that you can run a linux virtual machine on a windows operating system
	(but java's virtual machine is naturally much more simple, the JVM)
	advantage - java can be run anywhere so long as you have the JVM - platform agnostic
	vm = sandbox
	in order run, java first needs to be compiled to machine code

*/
public class StoryReader {

	//main method.. is the starting point of a java program
	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		the thing is.. i have a file to read, and the tools to read it, but
		the tools are primitive, and currently i'd only be able to read a single character at a time
		what can we do?
		we could, eg, count the amount of characters.. count the amount of words or sentences.. convert to uppercase/lowercase, replace letters,
		delete white space, only count every other word, and most importantly send this information to a new file
		*/
		//if i'm going to solve the counting number of characters problem, i need a few things..
		//a place where that count is stored
		
		//primitive type: a simple, atomic unit of information - char (characters), boolean(true/false), double (unit with decimals), etc
		int numCharacters = 0;
		boolean readingFile = true;

		//something that reads from a file
		//object: you can think of as a custom type.. but it has its own states and its behavior

		File tedsFile = new File("story.txt");
		FileReader tedsFileReader = new FileReader(tedsFile);

		while(readingFile) {
			int readByteFromFile = tedsFileReader.read();
			char readCharacterFromByte = (char) readByteFromFile;

			if(readByteFromFile == -1){
				readingFile = false;
			}else{
				//i want to also print out what i have read
				//System.out.println(readByteFromFile + " : " + readCharacterFromByte);
				System.out.print(readCharacterFromByte);
				numCharacters = numCharacters + 1;
				//alternatively, numCharacters++; does the same
			}

		}
//		System.out.print();
		System.out.println('\n' + "Number of characters: " + numCharacters);

		//something that allows us to repeat that behavior an arbitrary amount of times

		
		


	}

}