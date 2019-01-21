#include <stdio.h>

void datatypes() {
    // sizeof is used to compute the size of an argument in bytes
    printf("storage size of int is : %lu \n", sizeof(int));
    printf("storage size of double is : %lu \n", sizeof(double));
    printf("storage size of char is : %lu \n", sizeof(char));

    // the void type specifies that no value is available

    int integer;
    double decimal;

    printf("uninitialized integer : %d \n", integer);
    printf("uninitialized double : %E \n", decimal);

    // defining constants

    // #define preprocessor

    #define LENGTH 10
    #define SPECIAL_CHAR 'e'

    printf("the constant LENGTH has value : %d \n", LENGTH);
    printf("the constant SPECIAL_CHAR has value : %c \n", SPECIAL_CHAR);

    // using const keyword

    const int X = 500;
    const int Y = 600;
    int area;
    
    area = X * Y;
    printf("area is : %d \n", area);
}

void operators() {
    // bitwise operations include: <<, >>, &, |, ^

    int a = 4;
    printf("value of a is %d and address of a is %p \n", a, &a);

    int b = a > 4 ? a : -1;
    printf("the value of b is : %d \n", b);
}

int main() {
    // single line comment

    /*
    multiline
    comment
    */

   printf("printing to the console \n");

   // datatypes();
   operators();
}
