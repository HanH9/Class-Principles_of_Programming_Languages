#include<stdio.h>
#include <stdlib.h>

/**
 * @File name: NotBasedOnStruct.c
 * @Author: H9
 * @Version: 1.1
 * @Date: 2022-10-10
 * @Description: Store and get information by using others
 */

/**
 *  Function name ：NotBasedStruct
 *  Description   : Store information of students by anothe way which not bansedon struct and print the information
 */
void NotBasedStruct()
{
	//Constructing string arrays using two-dimensional arrays
	char name[10][20];
	int age[10];
	float gpa[10];
	char grade[10][20];
	int length = 0;
	// file pointer
	FILE *cfPtr;

   	// fopen opens file; exits program if file cannot be opened 
   	if ((cfPtr = fopen("data2.txt", "r")) == NULL)
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
	printf("Do not Based on Struct:\n");
	NotBasedStruct();
}
