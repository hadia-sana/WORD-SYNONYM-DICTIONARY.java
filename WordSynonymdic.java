/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordsynonymdic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Hp
 */
public class WordSynonymdic {
public static void insertword(HashMap<String,List<String>>hh){
System.out.println("enter word:");
Scanner s=new Scanner(System.in);
String word=s.nextLine();
Scanner syn=new Scanner(System.in);

List<String> l2=new ArrayList();

int i=1;
while(i==1){
    System.out.println("enter synonym:");
    l2.add(syn.nextLine());
System.out.println("enter 1 to add synonym:");
String i2=s.nextLine();
i=Integer.parseInt(i2);

}
hh.put(word, l2);



}
public static void updatesynonym(HashMap<String,List<String>>hh,String word,String presynonym,String newSynonym){
List <String> arr=hh.get(word);
if(hh.containsKey(word)&&arr.contains(presynonym)){
arr.remove(presynonym);
arr.add(newSynonym);
}
else{
System.out.println(" not found");
}

}
public static void updateword(HashMap<String,List<String>>hh,String word,List<String>l){
if(hh.containsKey(word)){
    hh.put(word, l);}
else{System.out.println("word not found");}
}
public static void  searchword(HashMap<String,List<String>>hh,String word){
if(hh.containsKey(word)){
    for(String key:hh.keySet()){
if(key.equals(word)){
System.out.println(hh.get(word));}
break;
}
}else{System.out.println("word not found");}

}

public static void search(HashMap<String,List<String>>hh){
    
hh.forEach((key,value)->{System.out.println(key +" "+value);});
}
public static void remove(HashMap<String,List<String>>hh,String word){
if(hh.containsKey(word)){
    hh.remove(word);}
else{System.out.println("word not found");}
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    HashMap<String, List<String>> dictionary = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
        System.out.println("\n--- Word Synonym Dictionary ---");
        System.out.println("1. Insert Word");
        System.out.println("2. Update Synonym");
        System.out.println("3. Update Word");
        System.out.println("4. Search Dictionary");
        System.out.println("5. Search word");
        System.out.println("6. Remove Word");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                insertword(dictionary);
                break;
            
            case 2:
                System.out.print("Enter the word to update synonym for: ");
                String wordToUpdate = scanner.nextLine();
                if(dictionary.containsKey(wordToUpdate)){
                System.out.print("Enter the existing synonym to replace: ");
                String oldSynonym = scanner.nextLine();
                System.out.print("Enter the new synonym: ");
                String newSynonym = scanner.nextLine();
                updatesynonym(dictionary, wordToUpdate, oldSynonym, newSynonym);}
                else{System.out.println("not found");}
                
                break;
            
            case 3:
                System.out.print("Enter the word to update: ");
                String word = scanner.nextLine();
                if(dictionary.containsKey(word)){
                List<String> newSynonyms = new ArrayList<>();
                System.out.println("Enter new synonyms (type 'done' to finish): ");
                while (true) {
                    String synonym = scanner.nextLine();
                    if (synonym.equalsIgnoreCase("done")) {
                        break;
                    }
                    newSynonyms.add(synonym);
                }
                updateword(dictionary, word, newSynonyms);}
                else{System.out.println("WORD NOT FOUND");}
                break;
            
            case 4:
                System.out.println("Current dictionary contents:");
                search(dictionary);
                break;
            case 5:
                System.out.print("Enter the word to search: ");
                String wordTosearch = scanner.nextLine();
                searchword(dictionary,wordTosearch);
                
                break;
            case 6:
                System.out.print("Enter the word to remove: ");
                String wordToRemove = scanner.nextLine();
                if(dictionary.containsKey(wordToRemove)){
                remove(dictionary, wordToRemove);
                System.out.println("Word removed.");}
                else{
                System.out.println("NOT FOUND.");
                }
                break;
            
            case 7:
                exit = true;
                System.out.println("Exiting program.");
                break;
            
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    scanner.close();
}

    
}
