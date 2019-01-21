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

void conditionals() {
    int a = 100;
    int b = 200;
    if (a == 100) {
        if (b == 100) {
            printf("a is 100 and b is 100\n");
        } else {
            printf("a is 100 and b is not 100\n");
        }
    } else {
        printf("a is not 100\n");
    }

    char coopEvaluation = 'E';
    switch (coopEvaluation) {
        case 'O':
            printf("you did outstanding!");
            break;
        case 'E':
            printf("you got excellent");
            break;
        default:
            printf("you did poorly");
    }
}

void loops() {
    #define LENGTH 10
    for (int i = 0; i < LENGTH; ++i) {
        printf("%d\n", i + 1);
    }
}

// this is a function declaration
int max(int, int);

void arrays() {
    int nums[10];
    for (int i = 0; i < 10; ++i) {
        printf("%d\n", nums[i]);
        nums[i] = i;
    }

    int* pointer = nums;
    for (int i = 0; i < 10; ++i) {
        printf("%d\n", *pointer);
        pointer += 1;
    }

    *(nums + 4) = -100;
    for (int i = 0; i < 10; ++i) {
        printf("%d\n", nums[i]);
    }
}

void pointers() {
    // good practice to make a pointer a nullptr if not in use
    int* nullptr = NULL;
    printf("value of ptr pointing to null is %p\n", nullptr);

    if (nullptr) {
        printf("pointer points to something");
    } else {
        printf("pointer points to nothing");
    }
}

int main() {
    // single line comment

    /*
    multiline
    comment
    */

   printf("printing to the console \n");

   // datatypes();
   // operators();
   // conditionals();
   // loops();

   // printf("max of 1 and 3 is %d\n", max(1, 3));

   // arrays();

   pointers();
}

int max(int a, int b) {
    return a >= b ? a : b;
}
