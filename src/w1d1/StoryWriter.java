package w1d1;

import java.io.*;

public class StoryWriter {
    public static void main(String[] args) throws IOException {
        File tedsFile = new File("story.txt");
        FileReader tedsFileReader = new FileReader(tedsFile);
//        i want to load characters into some type of memory so that way we can easily manipulate it
//        an array.. (java) this is a fixed length number of some type (could be primitives or objects)
        char[] charArray = new char[1000];
        int numCharacters = 0;
        boolean readingFile = true;

        File fixedFile = new File("fixedFile.txt");
        FileWriter fixedFileWriter = new FileWriter(fixedFile);

        while(readingFile){
            int readByteFromFile = tedsFileReader.read();
            if(readByteFromFile == '_'){
                readByteFromFile = ' ';
            }
            if(readByteFromFile == -1){
                readingFile = false;
            }else if(readByteFromFile != -1){
                charArray[numCharacters] = (char) readByteFromFile;
                numCharacters++;
            }
        }
        for(int i = 0; i < numCharacters; i++){
//            System.out.print(charArray[i]);
            fixedFileWriter.append(charArray[i]);
        }
        fixedFileWriter.close();
        /*
        is the same as saying something like this:

        int i = 0;
        while(i < charArray.length){
            //do something
            i++
        }

         */


    }
}
