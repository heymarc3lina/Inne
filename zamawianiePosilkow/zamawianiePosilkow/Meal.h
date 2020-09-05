#ifndef MEAL_H_
#define MEAL_H_
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class Meal {
protected:
	string name;
	int kcal;
	int quantity;

public:
	Meal();
	void changeName();
	void setQuantity(int newQuantity);
	void setName(string newName);
	void setKcal(int newKcal);
	Meal & operator=(const Meal & meal);
	
	inline string getName() {
		return name;
	}

	inline int getKcal() {
		return kcal;
	}

};

#endif