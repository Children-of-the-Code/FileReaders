package w1d2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordReader {
    public static void main(String[] args) {
//        try/catch is a better way of handling exceptions.. we 'try' to do something, and if we have an exception,
//        we catch it, meaning we have some behavior predefined for what we do with the exception
//        i would describe this as gracefully handling errors
        try {
            File story = new File("fixedFile.txt");
            FileReader storyReader = new FileReader(story);

            Word[] wordArray = new Word[1000];
//            we still have a problem.. we don't know what a word is while we're still reading it..
//            we will need to use a buffer of characters that we will send to the word when we encounter
//            a space or a new line
            char[] charBuffer = new char[1000];
//            because we are using a big buffer, we need to keep track of how much of that buffer space
//            should be in a word
            int bufferWordSize = 0;
            int numberOfWords = 0;
            boolean readingFile = true;
            while(readingFile){
                int readByteFromFile = storyReader.read();
                char charFromByte = (char) readByteFromFile;
                if(readByteFromFile == -1){
                    readingFile = false;
                }if(charFromByte == ' ' || charFromByte == '\n'){
//                    we have a new word in the buffer that we should send to the word array
                    wordArray[numberOfWords] = new Word(charBuffer, bufferWordSize);
//                    we've encountered a new word, so we should insert the next word and the next space in wordarray
                    numberOfWords++;
//                    we should start inserting the new characters into the buffer starting at 0
                    bufferWordSize = 0;
                }else{
//                    load the new char into the buffer..
                    charBuffer[bufferWordSize] = charFromByte;
//                    the next char should go into the next array space
                    bufferWordSize++;
                }
            }
            for(int i = 0; i < numberOfWords; i++){
//                this demonstrates the power of objects.. and how they can all have independent lives
                if(!(wordArray[i].contains('e')) && wordArray[i].contains('c')) {
                    System.out.println(wordArray[i]);
                }
                /*
                boolean expression syntax:
                ! : not
                == : is equal
                != : not equals
                || : or
                && : and
                () : parentheses... everywhere
                >
                <
                >=
                <=
                ? : ternary expression .. eg ifBoolean ? doTrueThing : doFalseThing

                 */

            }

        } catch(FileNotFoundException exception){
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
