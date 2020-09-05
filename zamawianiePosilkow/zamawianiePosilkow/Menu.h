#ifndef MENU_H_
#define MENU_H_
#include "MealsList.h"
#include "ClientsList.h"
#include <fstream>
#include "Validator.h"
#include "PhoneValid.h"
#include "windows.h"

class Menu {
	MealsList list;
	ClientsList cList;
	Meal meal;
	Validator * validator;
	string discount;
	Client client;
	

public:
	int answer;
	Menu();
	void welcome(); // pisze powitanie oraz daje karte dan i prosi o wybranie zapisujac wybrana odpowiedz
	void loadFromFileMeals(); //laduje z pliku dane
	void loadFromFileClients(); //laduje z pliku dane
	bool checkIfFileEmpty(string fileName); // sprawdza czy plik zawiera juz jakis klientow
	void verification();
	void status();
	void confirm();
	void saveClients();

};

#endif