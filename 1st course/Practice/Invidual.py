import pandas as pd
import matplotlib.pyplot as plt

pd.options.mode.chained_assignment = None  # для избежания ошибки SettingWithCopyWarning мы устанавливаем значение None

data_frame = pd.read_csv('skater_stats.csv', low_memory=False)  # считывает файл, авт-ки разбивая данные на столбцы
year = int(input('Введите сезон(год): '))
data_frame = data_frame.loc[data_frame['Season'] == year].loc[data_frame['Pos'] == ' D ']  # сортировка
tab = data_frame[['Player', 'G']]  # присваиваем tab столбцы с этими названиями
tab.G = pd.to_numeric(tab.G, errors='coerce')  # преобр-ем аргумент в числовой тип и "-" становится NaN
tab = tab.dropna()  # удаляем все строки с пропусками
tab.G = tab.G.astype(int)
tab = tab.sort_values(by='G', ascending=False)  # сортируем от большего к меньшему в столбце G
tab1 = tab[0:10]

hist = tab1.plot(x='Player', y='G', kind='bar', rot=20, fontsize=7, legend=False)  # форматирование графика
hist.set_xlabel('Защитник')  # подпись по x
hist.set_ylabel('Кол-во голов')  # подпись по y
hist.set_title('Лучшие защитники сезона')  # подпись всего графика
plt.show()  # вывод гистограммы
