package main

import (
	"fmt"
)

// single line comment

/*
multi-line comments
*/

func main() {
	fmt.Println("Hello, world!")

	// ways to declare a variable
	var num int = 19
	var num2 = 19
	num3 := 19
	const num4 int = 19
	const num5 = 19

	fmt.Println(num, num2, num3, num4, num5)

	var firstName = "Ethan"
	var lastName = "Xue"

	fmt.Println(firstName + " " + lastName)

	// loops

	// error thrown if round brackets used
	for i := 0; i < 10; i++ {
		fmt.Println(i + 1)
	}

	// go's while loop
	i := 1
	for i <= 10 {
		fmt.Println(i)
		i++
	}

	//if statements

	yourAge := 19

	if yourAge >= 16 {
		fmt.Println("you can drive")
	} else {
		fmt.Println("you can drive")
	}

	// can declare temp var in if-else statement scope

	myNum := 10

	if temp := myNum + 2; temp < 20 {
		// save an extra step of computing myNum + 2
		fmt.Println(temp)
	} else {
		fmt.Println(temp * 2)
	}

	// switch statement
	// no need for break
	// cases need not be constants

	currDayOfMonth := 20
	futureDay := 21

	switch futureDay {
	case currDayOfMonth:
		fmt.Println("today")
	case currDayOfMonth + 1:
		fmt.Println("tomorrow")
	case currDayOfMonth - 1:
		fmt.Println("yesterday")
	default:
		fmt.Println("not today, yesterday, or tomorrow")
	}

	// switch without argument is the same as switch true
	// can be used in place of if-else statemnts due to scope

	switch {
	case futureDay > currDayOfMonth:
		fmt.Println("some time in the future")
	case futureDay < currDayOfMonth:
		fmt.Println("some time in the past")
	default:
		fmt.Println("some time today")
	}
}
