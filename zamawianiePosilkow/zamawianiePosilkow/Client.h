#ifndef CLIENT_H_
#define CLIENT_H_

#include <random>
#include <iostream>
#include <string>
using namespace std;

class Client {
	string name, surname, phone;
	string id;
	int amount;


public:
	inline string getName() {
		return name;
	}

	inline string getSurname() {
		return surname;
	}

	inline string getId() {
		return id;
	}
	inline int getAmount() {
		return amount;
	}
	inline string getPhone() {
		return phone;
	}
	inline void setAmount(int newAmount) {
		amount = newAmount;
	}

	Client() = default;
	void setId(); //ustawia unikalne id(3 litery imienia i nazwiska +2 cyfry lub 1 litera imienia i nazwiska a reszta to cyfry)
	Client(string n, string s, string p); 
	Client(string n, string s, string i, int a, string p);//konstruktor
	bool checkId(); //sprawdza czy dany klient ma swoj unikalny id na podstawie ilosci wykonanych zamowien
	//string& operator=(string tab);
	int operator==(Client client); // porownujemy dwa obiekty ze soba 
	
};

#endif 