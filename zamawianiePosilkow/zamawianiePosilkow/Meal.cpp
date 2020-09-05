#include "Meal.h"

Meal::Meal() {
	name = " ";
	quantity = 0;
	kcal = 0;
}

void Meal::changeName() {
	for (unsigned int i = 0; i < name.length(); i++) {
		if (name[i] == '_') {
			name[i] = ' ';
		}
	}
}

void Meal::setQuantity(int newQuantity) {
	quantity = newQuantity;
}

void Meal::setName(string newName) {
	name = newName;
}

void Meal::setKcal(int newKcal) {
	kcal = newKcal;
}

Meal & Meal::operator=(const Meal & meal) {
	if (this == &meal) {
		return *this;
	}
	
	this->kcal = meal.kcal;
	this->name = meal.name;
	this->quantity = meal.quantity;
	return *this;
}