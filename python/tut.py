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

number_list = [1, 3, 4]

item_list = [number_list, grocery_list]

print(item_list[1][2])

grocery_list.append('Onions')
grocery_list.insert(0, 'Cucumber')
grocery_list.sort()
grocery_list.reverse()
del grocery_list[3] # wow,this is pretty BS..
print(grocery_list)

print(len(grocery_list))
name = "exue026"
print(len(name))

# tuples

pi_tuple = (3, 1, 4, 1, 5, 9) # tuples are immutable; lists are not
new_tuple = list(pi_tuple)
print(new_tuple)

new_tuple.remove(1) # removes the first instance of 1
pi_tuple = tuple(new_tuple)

print(pi_tuple)
print(max(pi_tuple)) # damn these functions are convenient!

# dictionaries

sports_rating = {
    'swimming': 1,
    'basketball': 2,
    'soccer': 8,
    'ping_pong': 5,
}

print(sports_rating.get('swimming'))
# use get() or else you'll get a key error thrown if no key exists

del sports_rating['ping_pong'] # ah this is so ugly and inconsistent
sports_rating['ping_pong'] = 5

print(sports_rating)

not_none_value = sports_rating.get('badminton', -1)
print(not_none_value)

def_none = None
not_none_value = def_none or 'hi!'
print(not_none_value)

print(len(sports_rating))
print(sports_rating.keys())
print(sports_rating.values())

# conditionals

age = 10

if age > 16:
    print('you are old enough to drive')
elif age > 12:
    print('you are in high school')
else:
    print('you are pretty damn young eh?')

# and, or, and not are logical operators

# looping

for x in range(0, 10): # up to, not including 10
    print(x)

for item in grocery_list:
    print(item)

random_num = random.randrange(0, 20)

while (random_num != 15):
    print(random_num)
    random_num = random.randrange(0, 20)

# break and continue exist


# functions

def addNumber(num1, num2):
    return num1 + num2

print(addNumber(1, 2))

# more strings

long_string = "come at me bro"
print(long_string[-5:]) # last 5 chars
print(long_string[:-5]) # up to last 5 chars

print(long_string.find('bro')) # index of start of 'bro'
print(long_string.replace('bro', 'buddy'))
string_arr = long_string.split(' ')
print(string_arr)

space = ' '
print(space.join(string_arr)) # so much cheese LMAO

# OOP

class Animal: 
    __name = None
    __height = 0
    __weight = 0
    __sound = None

    def __init__(self, name, height, weight, sound):
        self.__name = name
        self.__height = height
        self.__weight = weight
        self.__sound = sound

    def set_name(self, name):
        self.__name = name

    def get_name(self):
        return self.__name

    def toString(self):
        return "some animal"

wolf = Animal('bob', 50, 15, 'woof')

print(wolf.toString())

# inheritance

class Dog(Animal):
    __owner = None

    __init__(self, name, height, weight, sound, owner):
        super(Dog, self).__init__(name, height, weight, sound)
        self.__owner = owner
    # methods can be overidden without any special syntax



