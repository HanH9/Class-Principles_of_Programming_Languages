/********************************************************************************
* @File name: assignment2.c
* @Author: H9
* @Version: 1.1
* @Date: 2022-10-22
* @Description: Implementing a lexical parser for identifying C annotations.
* It can only identify two types of C comments.
********************************************************************************/

#include <stdio.h>
#include <ctype.h>
#include <string.h>

/* Global declarations */
/* Variables */
int charClass;
char lexeme[100];
char nextChar;
int lexLen;
int token;
char nextToken[50];
FILE* fptr;

/* Function declarations */
void addChar();
void getChar();
void getNonBlank();
char* lex();
void show();

/* Character classes */
#define Symbol 0

/* Token codes */
#define CommentIdentifier1 "/*...*/"
#define CommentIdentifier2 "//..."
#define Comment "Comment"
#define Unknown_OP "Unknown"

/* main driver */
int main(int argc, char *argv[]) {
    /* Open the input data file and process its contents */
    if ((fptr = fopen("data1.txt", "r")) == NULL)
        printf("ERROR - cannot open front.in \n");
    else {
        getChar();
        do {
            lex();
        } while (strcmp(nextToken,"EOF"));
    }
}

/* lookup - a function to lookup operators and parentheses
            and return the token */
char* lookup(char ch) {
    char second;
    switch (ch) 
    {
	    case '/':
		    addChar();
		    //Comment Type1
		    second = getc(fptr);
		    if(second  == '/')
		    {
			    //Analysis comment identifier
			    nextChar = second;
			    addChar();
			    strcpy(nextToken, CommentIdentifier2);
			    show();

			    //Analysis commnet
			    lexLen = 0;
			    while((nextChar = getc(fptr)) != EOF && nextChar != '\n')
			    {
				addChar();
			    }
			    strcpy(nextToken, Comment);
			    show();
			   	
		    }
		    //Comment Type2
		    else if(second == '*')
		    {
			   //Analysis comment identifier
			   nextChar = second;
			   addChar();
			   strcpy(nextToken, CommentIdentifier1);
                           show();

			   //Analysis comment
			   char last;
			   lexLen = 0;
       			   while((nextChar = getc(fptr)) != EOF && !(last == '*' && nextChar == '/'))
			   {
				last = nextChar;
				addChar();
			   }		   
			   for(int i = 0;i<sizeof(lexeme);i++)
			   {
		           	if(lexeme[i] =='\0')
				{
			        	lexeme[i-1]='\0';
				}
			   }
			  strcpy(nextToken, Comment);	
			  show();


			  //Analysis comment identifier
			  lexLen = 0;
			  nextChar = '*';
			  addChar();
			  nextChar = '/';
			  addChar();
			  strcpy(nextToken, CommentIdentifier1);
			  show();
	            }
		    //Not comment
		    else
		    {
			nextChar = second;
                        addChar();
			strcpy(nextToken, Unknown_OP);
			show();
		    }
		    break;

	   //other situations
      	   default:
        	  addChar();
        	  strcpy(nextToken, Unknown_OP);
		  show();
        	  break;
    }
    return nextToken;
}

/* addChar - a function to add nextChar to lexeme */
void addChar() {
    if (lexLen < sizeof(lexeme)-1) {
        lexeme[lexLen++] = nextChar;
        lexeme[lexLen] = 0;
    } else
        printf("Error - lexeme is too long \n");
}

/* getChar - a function to get the next character of 
             input and determine its character class */
void getChar() {
    if ((nextChar = getc(fptr)) != EOF) {
            charClass = Symbol;
    } else
        charClass = EOF;
}

/* getNonBlank - a function to call getChar until it
                 returns a non-whitespace character */
void getNonBlank() {
    while (isspace(nextChar))
        getChar();
}

/* lex - a simple lexical analyzer for arithmetic 
         expressions */
char* lex() {
    lexLen = 0;
    getNonBlank();
    switch (charClass) {
        /* Parse identifiers */
     
        /* Comments and others */
      case Symbol:
        lookup(nextChar);
	getChar();
        break;

        /* EOF */
      case EOF:
        strcpy(nextToken, "EOF");
        lexeme[0] = 'E';
        lexeme[1] = 'O';
        lexeme[2] = 'F';
        lexeme[3] = 0;
	show();
        break;
    } /* End of switch */
    return nextToken;
} 

//Shows nextToken and lexeme
void show()
{
	printf("Next token is: %s, Next lexeme is %s\n",
           nextToken, lexeme);
}
