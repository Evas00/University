def get_tested(ege, subject):
    return False if ege.lower().find(subject.lower()) == -1 else True

ege1 = "Математика - 78, Информатика - 75, Русский язык - 62"
subjects = ["Информатика", "информатика", "Физика", "ФИЗИКА", "hggh"]

for i in subjects:
    p = "" if get_tested(ege1, i) else "не"
    print("ЕГЭ по дисциплине %s %s сдан" % (i, p))
