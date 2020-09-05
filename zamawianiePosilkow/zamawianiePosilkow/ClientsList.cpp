#include "ClientsList.h"


ClientsList::ClientsList() {
	head = nullptr;
}

bool ClientsList::findClient(Client client) {
	cList * temp = head;
	while (temp) {
		if (temp->client == client) {
			return true;
		}
		temp = temp->next;
	}

	return false;
}

istream & operator>>(istream & is, ClientsList & head) {
	string name, surname, id, phone;
	int amount;
		while (is >>  name >> surname >> id >> amount >> phone){
			Client help = Client(name, surname, id, amount, phone);
			head += help;
		}
		return is;
}

ClientsList & ClientsList::operator+=(Client &client) {
	if (!findClient(client)) {
		head = new cList{ client, head };
	}

	return *this;
}

ostream &operator<<(ostream & os, cList * head) {
	cList * temp = head;
	while (temp) {
		os << head->client.getName() << " " << head->client.getSurname() << " " << head->client.getId() << " " << head->client.getAmount() << " " << head->client.getPhone() << endl;
		temp = temp->next;
	}

	return os;
}

void ClientsList::changeAmount(Client client) {
	cList * temp = head;
	while (temp) {

		if (temp->client == client) {
			temp->client.setAmount(temp->client.getAmount() + 1);
		}
		temp = temp->next;
	}
}