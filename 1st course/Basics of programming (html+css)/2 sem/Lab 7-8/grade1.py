def grade1(mark):
    if mark == "5":
        return "отлично"
    elif mark == "4":
        return "хорошо"
    elif mark == "3":
        return"удовлеворительно"
    elif mark == "2":
        return "неудовлетворительно"
    else:
        return "недопустимая оценка"

print(grade1(input("Введите оценку: ")))
