package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	fmt.Print("Enter your age: ")
	input, _ := reader.ReadString('\n')
	input = strings.TrimSpace(input)

	age, _ := strconv.Atoi(input)

	if age < 13 {
		fmt.Println("You are a Child")
	} else if age < 18 {
		fmt.Println("You are a Teenager")
	} else if age < 65 {
		fmt.Println("You are a Adult")
	} else {
		fmt.Println("You are a Senior")
	}
}
