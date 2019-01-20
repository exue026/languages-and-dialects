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
}

int main() {
    // single line comment

    /*
    multiline
    comment
    */

   printf("printing to the console \n");

   datatypes();
}
