#!/usr/bin/env python

# NOTE: These will take input from the user(two integers to be precise)
a = int(input("Just a Number: "))
b = int(input("Just a Number: "))

# NOTE: Arithmatic Operators
print("\na + b is ", a + b)
print("a - b is ", a - b)
print("a * b is ", a * b)
print("a ** b is ", a**b)
print("a / b is ", a / b)
print("a // b is ", a // b)
print("a % b is ", a % b)

# NOTE: This is just add a new line in between so the output is not clamped
print()
# NOTE: Comparison Operators
print(a > b)
print(a < b)
print(a != b)
print(
    a == b, "\n"
)  # NOTE: You can add a line in between the output like this as well so it's less clamped

# NOTE: Logical Operators
print(a == b and a < b)
print(a == b or a < b)
print(not (False))
print(not (True))

print()
a **= b
print(a)
