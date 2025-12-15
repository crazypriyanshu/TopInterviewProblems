# def function():
#     i = 0
#     sum = 0
#     while(i < 100):
#         sum = sum + i
#         sum = i + sum
#         i += 1
#     print(sum)
#
# function()
#
# def printOddNumber(n):
#     counter = 0
#     while(counter < n):
#         if(counter%2) == 1:
#             print(counter+"+")
#         counter += 1
#
# printOddNumber(5)
#
# def printOddNumberCorrect(n):
#     # Start at 1, go up to n (exclusive, so we use n+1 to include n if it's odd), step by 2
#     for counter in range(1, n + 1, 2):
#         print(f"{counter}+")
#
# printOddNumberCorrect(5)
#
#
# # Generate the first 5 odd numbers: start at 1, step by 2, need 5 numbers
# # range(1, 10, 2) generates 1, 3, 5, 7, 9
# odd_numbers = range(1, 10, 2)
#
# # Unpack the numbers into the print function
# print(*odd_numbers)
#
# n = 20
# multiples = range(4, n, 4)  # Generates: 4, 8, 12, 16
#
# # 1. Convert each number in the sequence to a string
# string_sequence = [str(num) for num in multiples]
#
# # 2. Join the strings using a single space as the separator
# result = " ".join(string_sequence)
#
# print(result)


import math

def count_perfect_squares(A):
    """
    Counts the number of perfect squares between 1 and A (inclusive).

    Args:
        A (int): The upper limit of the range.

    Returns:
        int: The total count of perfect squares.
    """
    if A < 1:
        return 0

    # 1. Calculate the square root of A
    sqrt_A = math.sqrt(A)

    # 2. Take the integer part (floor) of the result.
    # This gives us the largest integer k such that k*k <= A.
    count = int(sqrt_A)

    return count

# --- Demonstration ---
A1 = 50
print(f"The number of perfect squares between 1 and {A1} is: {count_perfect_squares(A1)}")
# Output: 7 (Squares: 1, 4, 9, 16, 25, 36, 49)

A2 = 100
print(f"The number of perfect squares between 1 and {A2} is: {count_perfect_squares(A2)}")
# Output: 10



count = 0
mul = 0
n = 5
a = [0, 3, 1, 5, 9, 2]
for i in range(1,n):
    mul = int((math.floor(i/a[i])))
    mul += 1
    for j in range(mul * a[i] - i, n+1, a[i]):
        if (j > i and a[i]*a[j] == i+j):
            count+= 1
print(count)

