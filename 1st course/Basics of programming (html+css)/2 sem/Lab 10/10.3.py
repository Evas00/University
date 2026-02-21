import sys

def get_word_list_1():
    word=input('Введите список слов в формате [..., ..., ...]:')
    word_list = eval(word)
    word_list_1=[]
    for i in word_list:
        if isinstance(i,str) and i.isalpha():
            word_list_1.append(i)
        else:
            print(i,'- не является строкой')
    if word_list_1==[]:
        print("Проблема с исходными данными!" )
        sys.exit()
    return word_list_1

print(get_word_list_1())
