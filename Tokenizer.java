package Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Tokenizer {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 header();
		 
	          do {        
	        	  System.out.println("\n1. Lexical Analysis");
		          System.out.println("2. Exit");
		          System.out.print("\nEnter Number: ");
		            int choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    EnterSource();
		                    break;
		                case 2:
		                    displayProgrammer();
		                    System.exit(0);
		                    break;
		                default:
		                	System.out.println("Error. Please input number only from 1 - 2.\n");
		            }
		        } while (true);
		    }
	      
		public static void EnterSource() {
			
			Scanner sc = new Scanner(System.in);
	
	        System.out.print("\nEnter Source Language: ");
	        String input = sc.nextLine();
	
	        System.out.println("\nInput Analysis : [  " + input + " ]");
	        
	        System.out.print("Output is: ");
		        for (String str : tokenize(lex(input))) {
		            System.out.print(str + " ");
		        }
			
	        System.out.println();
	        System.out.print("\nDo you want to continue? [Y/N]: ");
	        
	        String continueChoice2 = sc.next().toLowerCase();  
		        if (continueChoice2.equals("y")) {
		        	EnterSource();
		        }
		        else if (!continueChoice2.equals("y")) {
		        	displayProgrammer();
		            System.exit(0);
		        }
			
		}
	
	    public static ArrayList<String> tokenize(ArrayList<String> lexemes) {
	        ArrayList<String> dataTypes = new ArrayList<>(
	                Arrays.asList("int", "double", "char", "String", "float", "boolean")),
	                tokens = new ArrayList<>();

	        for (String lexeme : lexemes) {
	            if (dataTypes.contains(lexeme)) {
	                tokens.add("<data_type>");
	            } else if (lexeme.contains("=")) {
	                tokens.add("<assignment_operator>");
	            } else if (lexeme.contains("\"") || lexeme.contains("'") ||
	                    Character.isDigit(lexeme.charAt(0)) || lexeme.contains(".") ||
	                    lexeme.equals("true") || lexeme.equals("false")) {
	                tokens.add("<value>");
	            } else if (lexeme.contains(";")) {
	                tokens.add("<delimiter>");
	            } else {
	                tokens.add("<identifier>");
	            }
	        }
	        return tokens;
	    }

	    public static ArrayList<String> lex(String input) {
	        String[] individualChars = input.split("");

	        ArrayList<String> lexemes = new ArrayList<>();

	        StringBuilder temp = new StringBuilder(),
	                quotedString = new StringBuilder();

	        boolean isQuote = false;

	        for (String tochar : individualChars) {
	            if (tochar.equals("=") && !isQuote) {
	                lexemes.add(temp.toString());
	                lexemes.add(tochar);
	                temp = new StringBuilder();
	            } else if (tochar.equals(";") && !isQuote) {
	                lexemes.add(temp.toString());
	                lexemes.add(tochar);
	                temp = new StringBuilder();
	            } else if (tochar.equals(" ") && !isQuote) {
	                lexemes.add(temp.toString());
	                temp = new StringBuilder();
	            } else if (tochar.equals("\"")) {
	                quotedString.append(tochar);
	                if (isQuote) {
	                    lexemes.add(temp.toString());
	                    temp = new StringBuilder();
	                    lexemes.add(quotedString.toString());
	                    quotedString = new StringBuilder();
	                    isQuote = false;
	                } else {
	                    isQuote = true;
	                }
	            } else if (isQuote) {
	                quotedString.append(tochar);
	            } else {
	                temp.append(tochar);
	            }
	        }
	        lexemes.add(temp.toString());
	        lexemes.removeIf(n -> (n.equals("")));
	        return lexemes;
	    }
	    
	    public static void header() {
	        System.out.println("\n\t(=============== LEXICAL ANALYSIS  ===============)");
	        System.out.println("\t(============ Laboratory004 - Tokenizer ==========)");
	        System.out.println("\t---------------------------------------------------\n");
	        System.out.println("This is a Tokenizer program that identify the lexemes in your\n"
	        		+ "statement then categorize them into their respective tokens.\n");
	    }

	    public static void displayProgrammer() {
	    	System.out.println("\n\t\t-----------> Program Terminated <--------------");
			System.out.println("# =========================================================================== #");		
			System.out.println("|                   2023 @ Sharon Grace T. Hangaan                            |");
			System.out.println("|             Follow me in: https://github.com/SG-Hangaan                     |");
			System.out.println("|                  Email: sharonygracehangaan@gmail.com                       |");
			System.out.println("# =========================================================================== #");	
	    }

	}


