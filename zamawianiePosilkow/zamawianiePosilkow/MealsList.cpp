#include "MealsList.h"


MealsList::MealsList() {
	head = nullptr;
	elements = 0;
}


MealsList & MealsList::operator+=(Meal meal) {
	head = new list{ meal,head };
	return *this;
}


istream & operator>> (istream & is, MealsList & head) {
	Meal help;
	string name;
	int quantity ,kcal;
	while (is >> name >> quantity >> kcal) {
		help.setName(name);
		help.changeName();
		help.setQuantity(quantity);
		help.setKcal(kcal);
		head += help;
	}
	return is;
}

void MealsList::showList() {
	list * temp = head;
	int counter = 0;
	while (temp) {
		counter++;
		cout << "Pozycja " << counter << endl;
		cout << "Nazwa posilku i wartosc energetyczna: " << temp->meal.getName() << "    " << temp->meal.getKcal() << " kcal"  << endl;
		temp = temp->next;
	}

	elements = counter;
}

Meal MealsList::findMeal(int answer) {
	
		list * temp = head;
		for (int i = 1; i < answer; i++) {
			temp = temp->next;
		}
		return temp->meal;
	
}

MealsList::~MealsList() {
	while (head) {
		list * help = head->next;
		delete  head;
		head = help;
	}
}