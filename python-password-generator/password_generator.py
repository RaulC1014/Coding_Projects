import random

uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
lowercase_letters = uppercase_letters.lower()
digits = "0123456789"
symbols = "(){}[],;._/?+-*#$%"

upper, lower, nums, symbs = True, True, True, True

all = ""

if upper:
    all += uppercase_letters
if lower:
    all += lowercase_letters
if nums:
    all += digits
if symbs:
    all += symbols

length = int(input('How long would you like the passwords? '))
amount = 10

for x in range(amount):
    password = "".join(random.sample(all, length))
    print(password)


