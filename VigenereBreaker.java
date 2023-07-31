import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    private int[] keyFinal;
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder messageBuilder = new StringBuilder(message);
        StringBuilder newString = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            newString.append(messageBuilder.charAt(i));
        }
        return newString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker cc = new CaesarCracker(mostCommon);
        int[] key = new int[klength];
        for (int i = 0; i < klength; i++) {
            String msgPart = sliceString(encrypted, i, klength);
            int keyPart = cc.getKey(msgPart);
            key[i] = keyPart;
        }
        return key;
    }

    public HashSet<String> readDictionary (FileResource fr) {
        HashSet<String> dictionary = new HashSet<String>();
        for (String line : fr.lines()) {
            line = line.toLowerCase();
            dictionary.add(line);
        }
        return dictionary;
    } 
    
    public int countWords (String message, HashSet<String> dictionary) {
        int counter = 0;
        String[] splitMsg = message.split("\\W+");
        for (String word : splitMsg) {
            if (dictionary.contains(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
    
    public char mostCommonCharIn (HashSet<String> dictionary) {
        HashMap<Character, Integer> counters = new HashMap<Character, Integer>();
        char[] charList = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                           'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                           'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < charList.length; i++) {
            counters.put(charList[i], 0);
        }
        for (String word : dictionary) {
            for (char letter : counters.keySet()) {
                if (word.contains(Character.toString(letter))) {
                    counters.put(letter, counters.get(letter) + 1);
                }
            }
        }
        int maxValue = 0;
        int currValue;
        char c = 'a';
        for (char letter : counters.keySet()) {
            currValue = counters.get(letter);
            if (maxValue <= currValue) {
                maxValue = currValue;
                c = letter;
            }
        }
        return c;
    }
    
    public String breakForLanguage (String encrypted, HashSet<String> dictionary) {
        VigenereCipher vc;
        String decryptedFinal = "";
        int maxWords = 0;
        for (int keyLength = 1; keyLength <= 100; keyLength++) {
            int[] key = tryKeyLength(encrypted, keyLength, mostCommonCharIn(dictionary));
            vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int countWords = countWords(decrypted, dictionary);
            if (maxWords <= countWords) {
                maxWords = countWords;
                decryptedFinal = decrypted;
                keyFinal = key;
            }
        }
        System.out.println("This file contains " + maxWords + " valid words out of " + encrypted.split("\\W+").length); 
        return decryptedFinal;
    }
    
    public void breakForAllLangs (String encrypted, HashMap<String, HashSet<String>> languages) {
        String decrypted;
        for (String language : languages.keySet()) {
            System.out.println();
            System.out.println("Checking for " + language);
            System.out.println();
            HashSet<String> lang = languages.get(language);
            decrypted = breakForLanguage(encrypted, lang);
            System.out.print("Key is:");
            for (int i = 0; i < keyFinal.length; i++) {
                System.out.print(keyFinal[i] + " ");
            }
            System.out.println("\nLanguage: " + language);
            System.out.println(decrypted);
        }
    }
    
    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> dictionaries = new HashMap<String, HashSet<String>>();
        for (File f : dr.selectedFiles()) {
            FileResource frd = new FileResource(f);
            HashSet<String> dictionary = readDictionary(frd);
            dictionaries.put(f.getName(), dictionary);
        }
        breakForAllLangs(message, dictionaries);
        
    }
}
