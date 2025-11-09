package main

import "fmt"

func main() {
	fmt.Println("Traditional loop:")
	for i := 0; i < 5; i++ {
		fmt.Println(i)
	}

	fmt.Println("\nWhile-like loop:")
	count := 0
	for count < 3 {
		fmt.Println(count)
		count++
	}

	fmt.Println("\nRange loop:")
	numbers := []int{10, 20, 30, 40}
	for index, value := range numbers {
		fmt.Printf("Index: %d, Value: %d\n", index, value)
	}

	fmt.Println("\nInfinite loop:")
	i := 0
	for {
		fmt.Println(i)
		i++
		if i == 3 {
			break
		}
	}
}
