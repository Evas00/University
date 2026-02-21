import pandas as pd  # импорт модуля pandas
import numpy as np  # импорт модуля numpy

pd.options.mode.chained_assignment = None  # для избежания ошибки SettingWithCopyWarning мы устанавливаем значение None

data_frame = pd.read_csv('skater_stats.csv', low_memory=False)  # считывает файл, авт-ки разбивая данные на столбцы
year = int(input('Введите сезон(год): '))
data_frame = data_frame.loc[data_frame['Season'] == year]  # сортирует чтобы остались строки, где нужный нам год
tab = data_frame[['Player', 'Tm', 'G']]  # присваиваем tab столбцы с этими названиями
tab.G = pd.to_numeric(tab.G, errors='coerce')  # преобр-ем аргумент в числовой тип и "-" становится NaN
tab = tab.dropna()  # удаляем все строки с пропусками
tab.G = tab.G.astype(int)
tab = tab.sort_values(by='G', ascending=False)  # сортируем от большего к меньшему в столбце G
tab = tab.reset_index()  # переиндексация
tab = tab.drop('index', axis=1)  # удаляем столбец с заголовком index
tab = tab.set_index(np.arange(1, len(tab)+1))
# устанавливаем нашему DataFrame'у индекс с помощью set_index указав в параметрах созданный путем numpy.arange массив

print(tab)
