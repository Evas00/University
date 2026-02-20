#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <sstream>
#include <string>
#include <list>
using namespace std;

class Spisok {

private:
	class uzel {
	public:
		uzel* next;
		int x;
		uzel(uzel* next, int x) {
			this->next = next;
			this->x = x;
		};
	};
public:

	Spisok() {
		first = 0;
		size = 0;
	};

	uzel* first; //указатель на первый элемент
	int size;

	void swapIndexes(int pos1, int pos2) {
		if (pos1 == pos2) return;

		// Ищем первый узел
		uzel* prev1 = nullptr, * node1 = first;
		for (int i = 0; i < pos1 - 1; i++) {
			prev1 = node1;
			node1 = node1->next;
		}

		// Ищем второй узел
		uzel* prev2 = nullptr, * node2 = first;
		for (int i = 0; i < pos2 - 1; i++) {
			prev2 = node2;
			node2 = node2->next;
		}
		
		// Обновляем ссылки у предыдущих узлов
		if (prev1) prev1->next = node2;
		else first = node2;
		if (prev2) prev2->next = node1;
		else first = node1;

		// Меняем ссылки next у найденных узлов
		uzel* temp = node1->next;
		node1->next = node2->next;
		node2->next = temp;
	}

	// Добавление элемента в начало списка
	void addFirst(int x) {
		uzel* Nuz = new uzel(first, x);
		first = Nuz;
		size++;
	}

	// Добавление элемента после указанного индекса
	bool addAfterIndex(int pos, int x) {
		if (pos > size) return false;
		if (pos == 0) {
			addFirst(x);
			return true;
		}
		uzel* current = first;
		for (int i = 0; i < pos; i++) {
			current = current->next;
		}
		uzel* Nuz = new uzel(current->next, x);
		current->next = Nuz;
		size++;
		return true;
	}

	// Добавление элемента в конец списка
	void add(int x) {
		if (size > 0) addAfterIndex(size - 1, x);
		else addFirst(x);
	}

	// Удаление элемента по индексу
	bool deleteIndex(int pos) {
		if (pos >= size) return false;
		uzel* current = first;
		if (pos == 0) {
			first = first->next;
			delete current;
			size--;
			return true;
		}
		for (int i = 0; i < pos - 1; i++) {
			current = current->next;
		}
		uzel* Deluz = current->next;
		current->next = Deluz->next;
		delete Deluz;
		size--;
		return true;
	}

	// Проверка пустой ли список
	bool isEmpty() {
		return !size;
	}

	// Получение размера списка
	int getSize() {
		return size;
	}

	// Вывод списка
	string toString()
	{
		stringstream s;
		uzel* current = first;
		while (current != 0) {
			s << current->x << " ";
			current = current->next;
		}
		return s.str();
	}

};

int main()
{
	setlocale(LC_ALL, "RUS");
	cout << "Саргсян Ева 02.04" << endl;
	Spisok list;
	int n, x, p, p1, p2;

	while (true) {
		cin >> n;
		switch(n)
		{
			case 0: break;

			case 1: {
				cout << "Вывод списка" << endl << endl;
				cout << list.toString() << endl;
				break;
			}
			case 2: {
				cout << "Добавление элемента в начало списка" << endl << endl;
				cin >> x;
				list.addFirst(x);
				break;
			}
			case 3: {
				cout << "Добавление элемента в конец списка" << endl << endl;
				cin >> x;
				list.add(x);
				break;
			}
			case 4: {
				cout << "Добавление элемента после индекса" << endl << endl;
				cin >> p >> x;
				list.addAfterIndex(p,x);
				break;
			}
			case 5: {
				cout << "Удаление элемента по индексу" << endl << endl;
				cin >> p;
				list.deleteIndex(p);
				break;
			}
			case 6: {
				cout << "Взаимообмен двух узлов списка по индексу" << endl << endl;
				cin >> p1 >> p2;
				list.swapIndexes(p1, p2);
				break;
			}
			case 7: {
				cout << "Проверка пуст ли список" << endl << endl;
				cout << list.isEmpty() << endl;
				break;
			}
			case 8: {
				cout << "Количество элементов в списке" << endl << endl;
				cout << list.getSize() << endl;
				break;
			}
		}
	}
}