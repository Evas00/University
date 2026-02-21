def chek_word():
    word = input("Введите слово: ")
    return word

def is_palindrome(word):
    return "палиндром" if word==word[::-1]  else "не палиндром"

def message(word, what_is):
    return ("Слово %s - %s" % (word, what_is))

def check_palindrome():
    word = chek_word()
    print(message(word, is_palindrome(word)))
    
check_palindrome()
