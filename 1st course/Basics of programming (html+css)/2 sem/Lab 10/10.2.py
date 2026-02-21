import sys

def get_word_2():
    global word
    max_attempts = 3
    for attempt in range(max_attempts):
        word = input("Введите слово: ")
        if word.isalpha():
            break
        else:
            print('Повторить ввод!')
    else:
        print("Выполнено %s неудачных попыток. Выход из программы!" % (max_attempts))
        sys.exit()

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
    get_word_2()
    print(message(word, is_palindrome(word)))

check_palindrome()
