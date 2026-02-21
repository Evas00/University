def get_word():
    global word
    word = input("Введите слово: ")

def is_palindrome():
    global what_is
    what_is = "палиндром" if word==word[::-1]  else "не палиндром"

def message():
    return ("Слово %s - %s" % (word, what_is))

def check_palindrome():
    get_word()
    is_palindrome()
    print(message())

check_palindrome()
