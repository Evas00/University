def grade2(mark):
    mark_2 = int(mark)
    if 85<=mark_2<=100:
        return "Отлично"
    elif 71<=mark_2<=84:
        return "Хорошо"
    elif 60<=mark_2<=70:
        return "Удовлетворительно"
    elif 0<=mark_2< 60:
        return"Неудовлетворительно"
    

print(grade2(input("Введите рейтинговую оценку:")))
