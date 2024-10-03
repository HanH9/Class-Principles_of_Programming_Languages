#include<stdio.h>
#include <stdlib.h>

/**
 * @File name: Project1.c
 * @Author: H9
 * @Version: 1.1
 * @Date: 2022-10-10
 * @Description: Assignment1 is accomplished by both using structures and not using structures
 */


/*Struct to store information about student*/
struct student
{
	char name[20];
	int age;
	float gpa;
	char grade[20];
};


/**
 *  Function name ：BasedStruct
 *  Description   : Store  information of students by using struct and print theinformation
 */
void BasedStruct()
{
   struct student stu[10];
   int length = 0;
   // file pointer
   FILE *cfPtr; 

   // fopen opens file; exits program if file cannot be opened 
   if ((cfPtr = fopen("data1.txt", "r")) == NULL)
   {
      puts("File could not be opened");
      exit(1);
   }
   else 
   { 
      while (!feof(cfPtr))
      {
	//input information from file
	fscanf(cfPtr, "%s%d%f%s", stu[length].name, &(stu[length].age), &(stu[length].gpa), stu[length].grade);
	length++;
      }
      // fclose closes the file  
      fclose(cfPtr);  
   }  

   // print the information of student
   for (int i = 0; i < length - 1; i++) 
   {
   	printf("name：%s  age：%d  gpa：%f  grade: %s\n", stu[i].name, stu[i].age, stu[i].gpa, stu[i].grade);
    }
}


/**
 *  Function name ：NotBasedStruct
 *  Description   : Store information of students by anothe way which not bansedon struct and print the information
 */
void NotBasedStruct()
{
	char name[10][20];
	int age[10];
	float gpa[10];
	char grade[10][20];
	int length = 0;
	// file pointer
	FILE *cfPtr;

   	// fopen opens file; exits program if file cannot be opened 
   	if ((cfPtr = fopen("data1.txt", "r")) == NULL)
   	{
      		puts("File could not be opened");
      		exit(1);
   	}
   	else
   	{
      		while (!feof(cfPtr))
      		{
        		fscanf(cfPtr, "%s%d%f%s", name[length], &(age[length]), &(gpa[length]),grade[length]);
        		length++;
      		}

      		// fclose closes the file  
      		fclose(cfPtr);
		// print the information of student
   		for (int i = 0; i < length - 1; i++)
   		{	
        		printf("name：%s  age：%d  gpa：%f  grade: %s\n", name[i], age[i], gpa[i], grade[i]);
    		}

   	}	

}	


int main()
{
	printf("Based on Struct:\n");
	BasedStruct();
	printf("Do not Based on Struct:\n");
	NotBasedStruct();
}
