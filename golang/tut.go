// The entry point of Go programs is
// in package main
package main

import (
	"fmt"
)

func main() {
	// basic comment
	/*
		multiline
		comment
	*/
	fmt.Println("Hello, world!")
	///variables()
	//casting()
	constants()
}

// ThisFuncisExported description
// A name is exported from its file if it begins
// with a capital letter
func ThisFuncisExported() {
	fmt.Println("Hello, world!")
}

// this function does not begin with a capital letter
// so it is unaccessible outside of this package
func thisFuncIsNotExported() {
	fmt.Println("Hello, world!")
}

// basic function
func add(x int, y int) int {
	return x + y
}

// functions can return multiple values
func swap(x string, y string) (string, string) {
	return y, x
}

func variables() {
	// declaring a list of variables
	// the zero value of integers is 0
	// the zero value of strings is ""
	// the zero value of booleans is false
	var num, anotherNum int
	fmt.Println(num, anotherNum)
	// declaring list of variables with initialization
	// type can be omitted if variable is being initialized
	var numWithValue, anotherNumWithValue = 1, 2
	fmt.Println(numWithValue, anotherNumWithValue)
	// short variable declaration (type inference)
	numShortDeclared := 3
	fmt.Println(numShortDeclared)
}

func casting() {
	i := 42
	var f = float32(i)
	var u = uint(f)
	fmt.Println(fmt.Sprintf("%T", i))
	fmt.Println(fmt.Sprintf("%T", f))
	fmt.Println(fmt.Sprintf("%T", u))
}

func constants() {

}
