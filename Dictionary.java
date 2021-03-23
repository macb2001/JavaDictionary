//A Dictionary program originally derived from a previous C++ Dictionary Program.
//This Dictionary program allows for definitions of the word to also be inputted.
import java.util.*;
import java.util.Scanner;

public class Dictionary{

    public static void myAdd(HashMap<String, String> dictionary, String aWord){
        if(dictionary.containsKey(aWord)){
            System.out.println(aWord + " has already been added");
        }
        else{
            System.out.print("Enter definition: ");
            Scanner in = new Scanner(System.in);
            String def = in.nextLine();
            dictionary.put(aWord, def);
        }
    }

    public static void myDelete(HashMap<String, String> dictionary, String aWord){
        if(!(dictionary.containsKey(aWord))){
            System.out.println(aWord + " is not in the dictionary!");
        }
        else{
            dictionary.remove(aWord);
            System.out.println(aWord + " has been removed!");
        }
    }

    public static void printMap(HashMap<String, String> dictionary){
        if(!(dictionary.isEmpty())){
            TreeMap<String, String> sorted = new TreeMap<>();
            sorted.putAll(dictionary);
            System.out.println(String.format("%-20s %s" , "Word", "Definition"));
            System.out.println("-------------------------------");
            for(Map.Entry<String, String> entry : sorted.entrySet()){
                
                System.out.println(String.format("%-20s %s" , entry.getKey(), entry.getValue() ));
            }
        }
        else{
            System.out.println("Dictionary is empty!");
        }
        
    }

    public static void mySearch(HashMap<String, String> dictionary, String aWord){
        if(dictionary.containsKey(aWord)){
            System.out.println(aWord + " was found in the dictionary! Would you like to see its definition?(Y/N)");
            Scanner in = new Scanner(System.in);
            char answer = in.next().charAt(0);
            
            if(answer == 'Y' || answer == 'y'){
                System.out.println(String.format("%-20s %s" , aWord, dictionary.get(aWord)));
            }

        }
        else{
            System.out.println(aWord + " was not found in the dictionary!");
        }
    }

    public static void myExit(){
        System.out.println("Leaving dictionary program!");
    }
    
    public static void main(String args[]){
        HashMap<String, String> dictionary = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String aWord, command;
        System.out.print("*Dictionary Program*\nEnter a command(ADD, DELETE, SEARCH, LIST, or EXIT) followed by a word.");
        do{
            System.out.print("\n>>> ");
            command = ((in.next()).toUpperCase());
            if(command.equals("EXIT")){
                myExit();
            }

            else if(command.equals("ADD")){
                aWord = in.next();
                myAdd(dictionary, aWord);
            }

            else if(command.equals("DELETE")){
                aWord = in.next();
                myDelete(dictionary, aWord);
            }

            else if(command.equals("SEARCH")){
                aWord = in.next();
                mySearch(dictionary, aWord);
            }

            else if(command.equals("LIST")){
                printMap(dictionary);
            }

            else{
                System.out.println("Invalid Command!");
            }

        }while(!(command.equals("EXIT")));
    }
}