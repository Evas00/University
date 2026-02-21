def my_func():
    global var1, var2
    var1="локальная"
    var2="вторая"
    print(var1)

var1="глобальная"
my_func()
print(var1,var2)

