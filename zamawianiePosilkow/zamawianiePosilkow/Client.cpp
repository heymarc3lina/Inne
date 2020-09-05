#include "Client.h"

Client::Client(string n, string s, string p) {
	name = n;
	surname = s;
	amount = 0;
	id = "Brakdanych";
	phone = p;
	
 }

bool Client::checkId() {
	if (id == "Brakdanych") {
		if (amount > 5) {
			setId();
			return true;
		}
	
		return false;
		
	}
	   
	   return true;
}


//string& Client::operator=(string tab) {
//	string iq;
//	for (int i = 0; i < 8; i++) {
//		iq[i] = tab[i];
//	}
//
//	return iq;
//}

void Client::setId() {
	string help = "Brakdany";
	

	if (name.length() >= 3 && surname.length() >= 3) {
		for (int i = 0; i < 3; i++) {
			help[i] = name[i];
			help[i + 3] = surname[i];
		}

		for (int i = 6; i < 8; i++) {
			random_device r;
			default_random_engine e1(r());
			uniform_int_distribution<int> uniform_dist(48, 57);
			int r1 = uniform_dist(e1);
			char znak = static_cast<char>(r1);
			help[i] = znak;
		}
	}
	else {
		help[0] = name[0];
		help[1] = surname[0];
		for (int i = 2; i < 8; i++) {
			random_device r;
			default_random_engine e1(r());
			uniform_int_distribution<int> uniform_dist(48, 57);
			int r1 = uniform_dist(e1);
			char znak = static_cast<char>(r1);
			help[i] = znak;
		}
	}
	id = help;
}
	

int Client::operator==(Client client) {
	if (this->getName() == client.getName() && this->getSurname() == client.getSurname() && this->getPhone() == client.getPhone()) {
		return true;
	}
	return false;
}

Client::Client(string n, string s, string i, int a, string p) {
	name = n;
	surname = s;
	id = i;
	amount = a;
	phone = p;
}