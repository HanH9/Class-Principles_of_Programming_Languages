#include<stdio.h>
#include <stdlib.h>

/**
 * @File name: BasedOnStruct
 * @Author: H9
 * @Version: 1.1
 * @Date: 2022-10-10
 * @Description: Store and get information of students by using struct
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
   if ((cfPtr = fopen("data2.txt", "r")) == NULL)
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

int main()
{
	printf("Based on Struct:\n");
	BasedStruct();
}
