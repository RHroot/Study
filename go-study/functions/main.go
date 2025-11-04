package main

import "fmt"

func add(a int, b int) int {
	return a + b
}

func divide(a float64, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("cannot divide by zero")
	}
	return a / b, nil
}

func greet() {
	fmt.Println("Hello from function!")
}

func main() {
	result := add(5, 3)
	fmt.Println("5 + 3 =", result)

	quotient, err := divide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("10 / 2 =", quotient)
	}

	greet()

	fmt.Println("Sum:", sum(1, 2, 3, 4, 5))
}
