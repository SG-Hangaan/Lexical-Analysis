# Lexical Analysis

A basic lexer that will extract lexemes from a single line input. This program only accounts for the assignment operator, identifier, data type, value, and delimiter ";". A brief explanation of how mine works; A user will input a string, the string will be shredded into individual characters, those individual characters (still as String objects) will be rebuilt back into words, then finally the words will be categorized into tokens.

The Lexical Analysis (aka “Scanner”) is a phase within a compiler that converts an input code into an array of tokens.
Create a simple scanner program that will accept a single line assignment statement written in Java.

Examples:
1) int x = 1;
2) String str = “Hello World”;
3) double number;

The Tokenizer program should then identify the lexemes in your statement then categorize them into their respective tokens. Refer to the symbol table below.

<p align="center">
  <img src="https://github.com/SG-Hangaan/Lexical-Analysis/assets/127215110/a6b11055-b3eb-4c1f-a27f-f6ee5bcca55d"/>
</p>

Sample input/output:
Enter Source Language: int num = 2;
Output is: <data_type> <identifier> <assignment_operator> <value> <delimiter>

# Implementation of Lexical Analysis

<p align="center">
  <img src="https://github.com/SG-Hangaan/Lexical-Analysis/assets/127215110/f5626ea7-3f62-4639-b423-83e3a618e866"/>
</p>
