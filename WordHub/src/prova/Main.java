/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

/**
 *
 * @author Fabio
 */
public class Main {

    public static void main(String[] args) {
        // file input
        String in = "in.txt";
        // file output
        String out = "out.txt";
        Management man = new Management(in, out);

        String anag = "afta";

        man.deleteWordsAfterSlashCharacter();
        System.out.println("Words between eight and eleven characters: " + 
                man.wordsBetweenEightAndElevenCharacters());
        System.out.println();
        System.out.println("Letters between three and seven characters: "
                + man.wordsBetweenThreeAndSevenLetters().toString());
        man.writeOnFileWordsBetweenThreeAndSevenLetters("3to7.txt");
        System.out.println();
        System.out.println("All \"afta\" anagrams: " + 
                man.anagramGenerator(anag).toString());
        System.out.println();
        System.out.println("All \"afta\" anagrams contained in the array: "
                + man.anagramsInAnArrayList(anag).toString());
        System.out.println();
        System.out.println("Substrings' anagrams of \"afta\": " + 
                man.substringsAnagrams(anag));
        System.out.println();
        System.out.println("Substrings' anagrams of \"afta\" (it's greater than three): "
                + man.substringAnagramsForWordLengthGreaterThanThree(anag));
        System.out.println();
        System.out.println("Frequency of letters in dictionary: "
                + man.frequencyOfAlphabetLettersInDictionary().toString());
        System.out.println();
        System.out.println("Frequency of letters in dictionary from a word to another: "
                + man.frequencyOfAlphabetLettersInDictionaryFromAWordToAnother
                ("ddd", "hhh"));
        System.out.println();
    }
}
