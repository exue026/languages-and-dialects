import random
import sys
import os

print('Hello, World!')

# This is a comment

'''
This is a
multi-line
comment
'''

name = "Ethan"
print(name)

name = 26
print(name)

# +, -, *, /, %, ** (exponent)

print('5 / 2 = {}'.format(5 / 2))
print('\"Ethan is the GOAT\"')

full_name = "Ethan Xue" # convention is to use _ rather than camelCase
description = "GOAT"

the_truth = full_name + ' is the ' + description
print(the_truth)

# lists

grocery_list = ['Juice', 'Tomatoes', 'Meat']
print('first item is ' + grocery_list[0])

grocery_list[0] = 'Apple juice'
print(grocery_list)

print(grocery_list[1:3]) # substring

