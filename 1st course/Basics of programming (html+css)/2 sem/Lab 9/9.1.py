def get_info(str):
    s = str.split(" - ")
    s[1] = int(s[1])
    return s

def subjects(ege):
    s = list()
    s.append(get_info(ege[0])[0])
    s.append(get_info(ege[1])[0])
    s.append(get_info(ege[2])[0])
    return s

def marks(ege):
    s = list()
    s.append(get_info(ege[0])[1])
    s.append(get_info(ege[1])[1])
    s.append(get_info(ege[2])[1])
    return s

def print_results(subjects, marks):
    print("%s - %d\n%s - %d\n%s - %d\nСумма баллов %d" % (subjects[0], marks[0], subjects[1], marks[1], subjects[2], marks[2], sum(marks)))

ege2 = ["Математика - 78", "Информатика - 75", "Русский язык - 62"]
lst3 = list()
lst4 = []
for i in ege2:
    res = get_info(i)
    lst3.append(res[0])
    lst3.append(res[1])
    lst4.append(res)

print(lst3, "\n", lst4)
print_results(subjects(ege2), marks(ege2))
