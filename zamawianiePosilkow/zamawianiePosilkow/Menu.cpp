#include "Menu.h"


Menu::Menu() {
	answer = -1;
	list = MealsList();
	discount = "nie";
}


void Menu::loadFromFileMeals() {
	ifstream plik("posilki.txt");
	if (plik) {
		plik >> list;
		plik.close();
	}
	else {
		cout << "Nie udalo sie odtworzyc pliku";
		exit(1);
	}
}


void Menu::welcome() {

	cout << "Witaj w naszej restauracji. Oto nasza karta dan." << endl;
	list.showList();
	cout << "podaj numer pozycji, ktora chcesz zamowic." << endl;
	cin >> answer;
	while (!cin.good() || !(answer > 0 && list.getElements() >= answer) ){
		cout << "wybierz pozycje z naszej karty." << endl;
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cin >> answer;
	}
	
	//cout << "Twoje zamowienie to: ";
	meal = list.findMeal(answer);
	//cout << meal.getName() << endl;;

}


void Menu::loadFromFileClients() {
	ifstream plik("klienci.txt");
	if (checkIfFileEmpty("klienci.txt")) {
		if (plik) {
			plik >> cList;
			plik.close();
		}
		else {
			cout << "Nie udalo sie odtworzyc pliku";
			exit(1);
		}
	}
}

bool Menu::checkIfFileEmpty(string fileName) {
	ifstream plik(fileName);
	if (plik) {
		plik.seekg(0, ios::end);
		int temp = plik.tellg();
		if (temp == 0) {
			plik.close();
			return 0;
		}
		else {
			plik.close();
			return 1;
		}
	}
	plik.close();
	return 0;
}

void Menu::verification() {
	string name, surname, phone;
	
	cout << "Aby zakonczyc dokonczyc zamowienie wypelnij formularz." << endl;
	cout << "Podaj swoje imie." << endl;
	//getline(cin, name);
	cin >> name;
	cout << "Podaj nazwisko." << endl;
	//cin.clear();
	cin >> surname;
	cout << "Podaj numer telefonu komorkowego." << endl;
	cin >> phone;

	validator = new PhoneValid(phone);
	while (validator->check() != 1) {
		cout << "Numer telefonu jest niepoprawny. Numer powinien byæ wpisany w formacie np. 888652300" << endl;
		cin >> phone;
		validator->variable = phone;
	}

	client = Client(name, surname, phone);
	cList += client;
	
	if (client.checkId()) {
		cout << "Witaj staly kliencie! Twoje zamowienie ma 50% znizki." << endl;
		discount = "tak";
	}

}

void Menu::status() {
	cout << "Status Twojego zamownienia to: oczekujace." << endl;
	Sleep(3000);
	cout << "Status Twojego zamownienia to: w realizacji." << endl;
	Sleep(10000); 
	cout << "Status Twojego zamownienia to: gotowe." << endl;

}

void Menu::confirm() {
	
	cout << "Podsumowanie zamowienia: " << endl;
	cout << "Imie i nazwisko: " << client.getName() << " " << client.getSurname() << endl;
	cout << "Numer telefonu: " << client.getPhone() << endl;
	cout << "Zamowienie: " << meal.getName() << endl;
	cout << "Znizka dla stalego klienta: " << discount << endl;
	cout << "Czy potwierdzasz swoje zamowienie? tak/nie " << endl;
	string answ;
	cin >> answ;
	while (!cin.good() || !(answ == "tak" || answ == "nie")) {
		cout << "Potwierdz zamowienie." << endl;
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cin >> answ;
	}

	if (answ == "tak") {
		cout << "Dziekujemy za zlozenia amowienia. Zapraszamy ponownie!" << endl;
		status();
		cList.changeAmount(client);
	}
	else {
		cout << "Moze nastepnym razem zlozysz zamowienie! Zapraszamy ponownie!" << endl;
	}
}

void Menu::saveClients() {
	ofstream plik("klienci.txt");
	if (plik) {
		plik << cList.head;
		plik.close();
	}
	else {
		exit(1);
	}
}