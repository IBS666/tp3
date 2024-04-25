/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.eniso.projettp3;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class ProjetTP3 {

    public static void main(String[] args) throws IOException {
        //exercice1
        FileHandler fileHandler = new FileHandler("file.log");
        
        int lineIndexToReverse=1;
        fileHandler.reverseString(lineIndexToReverse);
        int lineIndexToRemoveDuplicates=2;
        fileHandler.removeDuplicates(lineIndexToRemoveDuplicates);
        String pattern ="epoch";
        ArrayList<String> linesWithPattern= fileHandler.findLinesWithPatterns(pattern);
        String str1="hello";
        String str2="Hello";
        System.out.println("comparaison avec equals:"+fileHandler.compareStrings1(str1, str2));
        String str5="hello";
        String str6="Hello";
        System.out.println("comparaison avec equalsIgnorCase:"+fileHandler.compareStrings2(str5, str6));
        String str7="hello";
        String str8="Hello";
        System.out.println("comparaison avec ==:"+fileHandler.compareStrings3(str7, str8));        
        System.out.println("comparaison avec ==:"+fileHandler.compareStrings3(new String("hello"),"hello")); 
        System.out.println("comparaison avec ==:"+fileHandler.compareStrings3(new String("hello"),new String("hello"))); 
        System.out.println("Ligne contenant le motif'"+pattern+"': "+linesWithPattern.get(0));
        
        //exercice2
        String key="secret";
        String plaintext="Hello, world";
        XORCipher xorcipher =new XORCipher(key);
        String encryptedText = xorcipher.encrypt(plaintext);
        System.out.println("Texte chiffré : "+encryptedText);
        String decryptedText = xorcipher.decrypt(encryptedText);
        System.out.println("Texte déchiffré : "+decryptedText);
   
    }
}
