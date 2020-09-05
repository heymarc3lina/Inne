#ifndef MEALSLIST_H_
#define MEALSLIST_H_
#include "Meal.h"



struct list {
	Meal meal;
	list * next;

};

class MealsList {
	list * head;
	int elements;

public:
	MealsList();
	friend istream & operator>>(istream & is, MealsList & head); //odczyt z pliku
	//friend ostream & operator<<(ostream & os, MealsList & list); 
	void showList(); //pokazuje liste nas ekranie oraz ustawia ilosc elementow w liscie
	Meal findMeal(int answer);
	MealsList & operator+=(Meal meal); //dodawanie do listy
	~MealsList(); // destruktor do kasowania listy
	inline int getElements() {
		return elements;
	}


};

#endif