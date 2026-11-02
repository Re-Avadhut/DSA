#!/bin/bash
# 1. Add two numbers
echo "Enter two numbers:"
read a b
echo "Sum = $((a+b))"

# 2. Check even or odd
echo "Enter a number:"
read n
if (( n % 2 == 0 )); then
  echo "Even"
else
  echo "Odd"
fi

# 3. Find largest of two numbers
echo "Enter two numbers:"
read a b
if (( a > b )); then
  echo "$a is largest"
else
  echo "$b is largest or equal"
fi

# 4. Factorial
echo "Enter a non-negative number:"
read n
fact=1
for ((i=1; i<=n; i++)); do
  fact=$((fact*i))
done
echo "Factorial = $fact"

# 5. Fibonacci series
echo "Enter number of terms:"
read n
a=0
b=1
for ((i = 0; i < n; i++)); do
  echo -n "$a "
  next=$((a + b))
  a=$b
  b=$next
done
echo
