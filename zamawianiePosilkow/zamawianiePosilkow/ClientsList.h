#ifndef CLIENTSLIST_H_
#define CLIENTSLIST_H_

#include "Client.h"


struct cList {
	Client client;
	cList* next;
};



class ClientsList {
	
public:
	cList *head;
	ClientsList(); //konsturkotr
	bool findClient(Client client); //sprawdza czy taka osoba jest juz w liscie
	friend istream & operator>>(istream & is, ClientsList & head); //odczytuje z pliku
	ClientsList & operator+=(Client &client); //dodaje do listy jesli nie ma kogos takiego
	friend ostream &operator<<(ostream & os, cList * head);
	void changeAmount(Client client);



};

#endif