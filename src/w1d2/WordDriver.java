package w1d2;

public class WordDriver {
    public static void main(String[] args){
//        as you might guess, an object can contain a lot of information.. and this information requires
//        the computer to reserve some amount of space in memory
//        the 'new' keyword is special.. it is telling java to reserve a new amount of space for our object
//        likewise, we call the constructor, because usually objects require some amount of setup
//        (eg, files required a file name, filereader required a file object, etc)

//        our goal for now.. will be to create an object that can store a sequence of characters (like a word / string)
//        that object will be able to conduct useful operations on that sequence.. largely these are
//        operations that the string class in java already does

//        the class is what i'm actually writing.. it is the blueprint for the behavior of some object
//        the object is an instation of a class - a word object is a single 'word class' or 'word type'
//        a word class is the set of instructions for the states and behavior of that object

//        what do people struggle with here?
//        whether your knowledge comes from school or tutorials, you're typically engaged in 'functional programming'
//        (every operation is done by individual functions),
//        but enterprise level applications more often revolve around objects - both on the front end and back end
//        this because we have increased reusability of code and increased ability to debug and test code
//        this because object have their own independent life even if they solve the same problem

//        if you're seeing that the ide is asking you to make all of your code (methods, variables) static
//        you're probably something wrong -
//        static means that that method or variable is attached to the existence of a class in memory rather than
//        an object -
//        which is to say that there is only a single static copy of a method or variable across the application

        Word tedsWord = new Word();
        Word.doSomething();
        tedsWord.doSomething();
        tedsWord.print();

        char[] word1 = new char[]{'d', 'o', 'g'};
        char[] word2 = new char[]{'c', 'a', 't'};
        Word dogWord = new Word(word1);
        Word catWord = new Word(word2);

        System.out.println(dogWord.toString());
        System.out.println(catWord.toString());

        System.out.println("Dogword contains c: "+dogWord.contains('c'));
        System.out.println("Catword contains c: "+catWord.contains('c'));

        if(dogWord.contains('c')){
            System.out.println("c is in word dog!");
        }else{
            System.out.println("c is not in word dog!");
        }

        System.out.println("Index of c in dogword: " + dogWord.indexOf('c'));
        System.out.println("Index of c in catword: "+ catWord.indexOf('c'));
        catWord.replaceAll('c', 'b');
//        System.out.println(catWord);

        char[] word3 = new char[] {'m', 'a', 'n'};

        Word manWord = new Word(word3);

        catWord.append(manWord);
        System.out.println(catWord);


    }
}
