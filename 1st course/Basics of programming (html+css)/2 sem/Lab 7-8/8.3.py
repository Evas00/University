def total(ege):
    mat=ege[0][1]
    inf=ege[1][1]
    rus=ege[2][1]
    return(mat+inf+rus)

ege4=[["Математика",78],["Информатика",75],["Русский язык",62]]
print(ege4[1][0])
s1=total(ege4)
print("Общая сумма баллов %d"%(s1))


def total2(ege3):
    mat=ege3[1]
    inf=ege3[3]
    rus=ege3[5]
    return(mat+inf+rus)

ege3=["Математика",78,"Информатика",75,"Русский язык",62]
s2=total2(ege3)
print("Общая сумма баллов %d"%(s2))


def convert_list(ege3):
    ege_new=[]
    ege_new.append(ege3[0:2])
    ege_new.append(ege3[2:4])
    ege_new.append(ege3[4:6])
    return(ege_new)

print(convert_list(ege3))
s3=total(convert_list(ege3))
print("Общая сумма баллов %d"%(s3))
