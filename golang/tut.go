package main

import (
	"fmt"
)

// single line comment

/*
multi-line comments
*/

func main() {
	//basics()
	//controlFlow()
	dataStructs()
}

func basics() {
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

	// default values

	var number int
	var word string
	var boolean bool

	fmt.Println(number, word, boolean)

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
}

func controlFlow() {
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

	// defer statements defer the execution of functions until the enclosing
	// function returns

	defer fmt.Println("world")
	fmt.Println("hello")

	// deferred function calls are pushed onto a stack

	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}
}

func dataStructs() {
	//pointers
	var p *int
	fmt.Println(p)

	// & generates a pointer to its operand
	i := 20
	p = &i

	// * to dereference

	fmt.Println(*p)
	fmt.Println(p)
	*p = 21 // change the value of i via the pointer

	// Go has no pointer arithmetic unlike C

	// structs
	fmt.Println(Point{1, 2})
	point := Point{1, 2}
	point.X = 4
	fmt.Println(point)

	//struct pointers

	ptr := &point
	ptr.X = 1000 //technically (*ptr).X but language allows for implicit deref
	fmt.Println(point)
	fmt.Println(ptr)

	p1 := Point{X: 1}    // Y: 0 implicit
	p2 := Point{}        // X,Y: 0 implicit
	ptr1 := &Point{1, 2} // has data type *Point
	fmt.Println(p1)
	fmt.Println(p2)
	fmt.Println(ptr1)

	// arrays: not resizeable

	var words [2]string
	words[0] = "Hello"
	words[1] = "World"
	fmt.Println(words)
	fmt.Println(words[0], words[1])

	primes := [6]int{2, 3, 5, 7, 11, 13}
	fmt.Println(primes)

	// a slice is a dynamically-sized flexible view into an array's elements

	var s []int = primes[1:4]
	fmt.Println(s)

	names := [4]string{
		"George",
		"James",
		"Isaac",
		"Scott",
	}

	fmt.Println(names)

	a := names[0:3]
	b := names[2:]
	fmt.Println(a, b)

	b[0] = "XXX"

	fmt.Println(a, b)
}

// structs

type Point struct {
	X int
	Y int
}
