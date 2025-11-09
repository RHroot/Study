#!/usr/bin/env python
"""
debug_practice.py - A script to practice Python debugging
"""


def calculate_factorial(n):
    """Calculate factorial of n"""
    if n < 0:
        return None
    elif n == 0 or n == 1:
        return 1
    else:
        result = 1
        for i in range(2, n + 1):
            result *= i
        return result


def process_data(numbers):
    """Process a list of numbers"""
    results = []
    for num in numbers:
        # Try setting a breakpoint here to inspect variables
        factorial = calculate_factorial(num)
        square = num**2

        data = {
            "number": num,
            "factorial": factorial,
            "square": square,
            "is_even": num % 2 == 0,
        }
        results.append(data)

    return results


def find_max_factorial(results):
    """Find the item with maximum factorial"""
    if not results:
        return None

    max_item = results[0]
    for item in results:
        if item["factorial"] and (
            not max_item["factorial"] or item["factorial"] > max_item["factorial"]
        ):
            max_item = item

    return max_item


def main():
    print("=== Python Debugging Practice ===\n")

    # Sample data
    numbers = [3, 5, 2, 8, 1, 0, 4]

    print(f"Processing numbers: {numbers}\n")

    # Process the numbers
    results = process_data(numbers)

    # Display results
    print("Results:")
    for item in results:
        print(
            f"  {item['number']}: factorial={item['factorial']}, square={item['square']}, even={item['is_even']}"
        )

    # Find max factorial
    max_item = find_max_factorial(results)
    print(f"\nHighest factorial: {max_item['number']}! = {max_item['factorial']}")

    # Intentional bug to practice debugging
    # Uncomment this to create a division by zero error:
    # buggy_value = 10 / (5 - 5)

    print("\n=== Done ===")


if __name__ == "__main__":
    main()
