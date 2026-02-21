def convert_list14(ege):
    s1=ege.split(",")
    s2 = list()
    for i in s1:
        s2.append(i.strip())
    s3 = list()
    for i in s2:
        p = i.split(" — ")
        p[1] = int(p[1])
        s3.append(p)
    return s3


ege1 = "Математика — 78,          Информатика — 75,   Русский язык — 62"
print(convert_list14(ege1))

