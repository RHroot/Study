package main

import "fmt"

func main() {
	fruits := []string{"apple", "banana", "orange"}
	fmt.Println("Fruits:", fruits)

	fruits = append(fruits, "mango")
	fmt.Println("After append:", fruits)

	fmt.Println("Fruits fruit:", fruits[0])

	subset := fruits[1:3]
	fmt.Println("Subset:", subset)

	person := map[string]string{
		"name": "Rishabh",
		"city": "Saharanpur",
		"job":  "Engineer",
	}
	fmt.Println("Person:", person)

	fmt.Println("Name:", person["name"])

	person["age"] = "25"

	fmt.Println("\nMap contents:")
	for key, value := range person {
		fmt.Printf("%s: %s\n", key, value)
	}

	if job, exists := person["job"]; exists {
		fmt.Println("Job:", job)
	}
}
