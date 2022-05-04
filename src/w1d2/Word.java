package w1d2;

public class Word {
//    this is a constructor.. a method that is called when an object is instantiated
    private char[] charArray;
    private int length;

    public Word(){
        charArray = new char[]{'c', 'h', 'a', 'r'};
    }
//    we can have multiple constructors.. typically we'd call this method overloading
    public Word(char[] charArray){
        this.charArray = charArray;
        length = charArray.length;
    }
//let's say that this constructor is for when we're loading in data from a buffer that may be overwritten...
//    let's copy the values over!
    public Word(char[] charArray, int length){
        char[] copiedValues = new char[length];
        for(int i = 0; i < length; i++){
            copiedValues[i] = charArray[i];
        }
        this.charArray = copiedValues;
        this.length = length;
    }

//    getters and setters are convention to allow other objects to be able to access private variables
    public int getLength(){
        return length;
    }
//    it wouldn't make sense, for instance, for developers to be able to set length,
//    either with a setlength method or by directly modifying a public variable
//    it wouldn't make sense for someone be able to say the length of 'cat' is 10 characters..
    /*
    public void setLength(int n){
        length = n;
    }
     */
    public void setCharArray(char[] charArray){
        this.charArray = charArray;
        length = charArray.length;
    }

    public static void doSomething() {
    }

    //    this is a method.. a reusable block of code that belongs to an object
    public void print(){
        System.out.println("Hello, this is a word object!");
    }
//    a method that converts our char array to a string...
    public String toString(){
        String stringRepresentation = "";
        for(int i = 0; i < length; i++){
            stringRepresentation = stringRepresentation + charArray[i];
        }
        return stringRepresentation;
    }
//    return true if the char array contains a certain character, false otherwise
    public boolean contains(char c){
        for(int i = 0; i < charArray.length; i++){
            if(charAt(i) == c){
                return true;
            }
        }
        return false;
    }
//    returns the character at a specific position in the char array
    public char charAt(int n){
        return charArray[n];
    }
//    returns the index position of a specific character in the char array
    public int indexOf(char c){
//        iterate through the characters
        int count = 0;
        for(count = 0; count < charArray.length; count++){
            if(charArray[count] == c){
                return count;
            }
        }
        return -1;
    }
//    a method that replaces all instances of a certain character with another character
    public void replaceAll(char toBeReplaced, char replacer){
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == toBeReplaced){
                charArray[i] = replacer;
            }
        }
    }
/*
there is something called an enhanced for loop which integrates with something we call collections, which we'll
get to next week,
for(word i : dictionary){
    //do something with i - meaning i is the element itself and not an index
//    for each element, we do something
}
 */
//    append two words - eg bat.append(man) makes bat.toString() = batman
    public void append(Word toBeCombined){

//        multiple steps..
//        because arrays are of a fixed size, we're going to need to create a new array that is the size
        char[] combined = new char[length + toBeCombined.getLength()];
//        of both words combined..
//        then, we should add all the elements of this word,
        for(int i = 0; i < length; i++){
            combined[i] = charArray[i];
        }
        for(int i  = length; i < combined.length; i++){
            combined[i] = toBeCombined.charAt(i-length);
        }
        setCharArray(combined);
//        i could just say charArray = combined;

//        followed by all the elements of the next word
    }

}
