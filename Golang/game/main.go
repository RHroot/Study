package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())

	secret := rand.Intn(100) + 1

	fmt.Println("Welcome to the Guessing Game!")
	fmt.Println("I am thinking of a number between 1 and 100")

	reader := bufio.NewReader(os.Stdin)
	attempts := 0

	for {
		fmt.Println("\nGuess the number: ")
		input, _ := reader.ReadString('\n')
		input = strings.TrimSpace(input)

		guess, err := strconv.Atoi(input)
		if err != nil {
			fmt.Println("Please enter a valid number")
			continue
		}

		attempts++

		if guess == secret {
			fmt.Printf("Correct! You guessed it in %d attempts!\n", attempts)
			break
		} else if guess < secret {
			fmt.Println("Too low, try higher")
		} else {
			fmt.Println("Too high, try lower")
		}
	}
}
