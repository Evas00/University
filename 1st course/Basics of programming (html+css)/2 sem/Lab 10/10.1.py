def get_word_1():
    global word
    no_data = True
    while no_data:
        word = str(input("Введите слово: "))
        if word.isalpha():
            no_data = False
        else:
            print("Повторить ввод!")

def is_palindrome(word):
    word_lower = word.lower()
    return word_lower==word_lower[::-1]

def is_palindrome_old(word):
    global what_is
    what_is = "палиндром" if word==word[::-1]  else "не палиндром"

def message(word, what_is):
    prefix = "" if is_palindrome(word) else "не"
    return ("Слово %s - %s палиндром" % (word, prefix))

def check_palindrome():
    get_word_1()
    print(message(word, is_palindrome(word)))

check_palindrome()
