# Programming-Exercise-Unknown-Language-Unknown-Key-Length
Assignments from OOP Course on Java Programming: Arrays, Lists, and Structured Data, week 4. https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/e5ZZK/programming-exercise-unknown-language-unknown-key-length

PROJECT TITLE: "Programming Exercise: Unknown Language, Unknown Key Length"

PURPOSE OF PROJECT: Assignment : Multiple Languages
                    Modify program that breaks a Vigenère cipher, where you don't know 
                    the language of the original message, neither the key length.  
                    task 1 - In the VigenereBreaker class, write the public method mostCommonCharIn, 
                    which has one parameter—a HashSet of Strings dictionary. This method 
                    should find out which character, of the letters in the English alphabet, 
                    appears most often in the words in dictionary. It should return this most 
                    commonly occurring character. Remember that you can iterate over a HashSet
                    of Strings with a for-each style for loop.
                    task 2 - In the VigenereBreaker class, write the public method breakForAllLangs, 
                    which has two parameters—a String encrypted, and a HashMap, called 
                    languages, mapping a String representing the name of a language to a 
                    HashSet of Strings containing the words in that language. Try breaking 
                    the encryption for each language, and see which gives the best results! 
                    Remember that you can iterate over the languages.keySet() to get the name 
                    of each language, and then you can use .get() to look up the corresponding
                    dictionary for that language. You will want to use the breakForLanguage 
                    and countWords methods that you already wrote to do most of the work 
                    (it is slightly inefficient to re-count the words here, but it is simpler,
                    and the inefficiency is not significant). You will want to print out the 
                    decrypted message as well as the language that you identified for the 
                    message.
                    task 3 - Modify the method breakForLanguage to make use of your mostCommonCharIn 
                    method to find the most common character in the language, and pass that 
                    to tryKeyLength instead of ‘e’.
                    task 4 - Modify your breakVigenere method to read many dictionaries instead of 
                    just one. In particular, you should make a HashMap mapping Strings to a 
                    HashSet of Strings that will map each language name to the set of words 
                    in its dictionary. Then, you will want to read 
                    (using your readDictionary method) each of the dictionaries that we have 
                    provided (Danish, Dutch, English, French, German, Italian, Portuguese, 
                    and Spanish) and store the words in the HashMap you made. Reading all the 
                    dictionaries may take a little while, so you might add some print 
                    statements to reassure you that your program is making progress. Once 
                    you have made that change, you will want to call breakForAllLangs, 
                    passing in the message (the code to read in the message is unchanged 
                    from before), and the HashMap you just created.

DATE: 31.07.2023

HOW TO START THIS PROJECT: Use BlueJ Environment to open project named 
                           "package.bluej". Find inside of this project 4 
                           classes: 
                           CaesarCipher (Caesar Cipher decryption and 
                           encryption algorithm);
                           CaesarCracker (Caesar Cipher decryption based on
                           frequency of a certain letter in a language)
                           VigenereCipher (Vigenere Cipher encryption and
                           decryption algorithm)
                           VigenereBreaker (Vigenere Cipher decryption based 
                           on frequency of a specific letter in a language, 
                           specifically it slices strings in a known amount 
                           of slices based on key length and finds the key 
                           which was used to encrypt a message and uses it to
                           decrypt the message)
                           - compile, create object of 
                           type VigenereBreaker and start the function: 
                           "breakViginere" for task 1, 2, 3 and 4; 

AUTHOR: Gusev Roman

USER INSTRUCTIONS: you will need library: "edu.duke.\*"
                   (simplified version of File function from Java);
                   "java.util.\*" and "java.io.File".
                   Be careful! When launching created object and accessing 
                   the function "breakViginere", you will need to choose first 
                   encrypted message and second multiple files - desired dictionaries.
                   
