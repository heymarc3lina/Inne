#include <iostream>
#include "Menu.h"
#include "Client.h"

int main() {

	/*Meal meal;
	meal.setName("Kalafiorowa_zupa");
	meal.changeName();
	cout << meal.getName();*/

	Menu menu;
	menu.loadFromFileMeals();
	menu.loadFromFileClients();
	menu.welcome();
	menu.verification();
	menu.confirm();
	menu.saveClients();
	/*Client client = Client("Kasia", "Bak");
	bool ma1= client.checkId();
	bool ma2 = client.checkId();
	bool ma3 = client.checkId();
	bool ma4 = client.checkId();
	bool ma5 = client.checkId();
	bool ma6 = client.checkId();
	cout << client.getId();*/


	return 0;
}