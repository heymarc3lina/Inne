#include <iostream>
#include <string>
using namespace std;


struct Student {
	string nazwisko;
	Student * pNext;
	double ocena;
};

struct Egzaminator {
	string nazwisko;
	Egzaminator * pNext;
	Student * pStudenci;
};


Egzaminator * znajdzNajmniejObciazonego(Egzaminator * pHead) {
	if (not pHead) {
		return nullptr;
	}
	else {
		int minimalnaIloscStudentow = INT_MAX;
		auto p = pHead;
		auto szukanyegzaminator = pHead;
		while (p) {
			int iloscstudentow = policzStudentow(p);
			if (iloscstudentow == 0) {
				return p;
			}
			else if(minimalnaIloscStudentow > iloscstudentow){
				szukanyegzaminator = p;
			}
			p = p->pNext;
		}
		return szukanyegzaminator;
	}
}

void dodajStudenta(Student *& pGlowa, const string & nazwisko) {
	if (not pGlowa) {
		pGlowa = new Student{ nazwisko, nullptr , 0.0};
	}
	else {
		auto k = pGlowa;
		if (pGlowa->nazwisko > nazwisko) {
			pGlowa = new Student{ nazwisko, pGlowa , 0.0 };
		}
		else if ((k->pNext) && (k->pNext->nazwisko < nazwisko)) {
			k = k->pNext;
			dodajStudenta(k, nazwisko);
		}
		else {
			auto nowy = new Student{ nazwisko, k->pNext, 0.0};
			k->pNext = nowy;
			
		}
	}
}

void dodajStudentaEgzaminatorowi(Egzaminator * pHead, const string & nazwisko) {
	dodajStudenta(znajdzNajmniejObciazonego(pHead)->pStudenci, nazwisko);
}

Student * wytnijStudenta(Student *& pGlowa, const string & naziwsko) {
	if (pGlowa) {
		if (pGlowa->nazwisko == naziwsko) {
				auto student = pGlowa;
				auto next = pGlowa->pNext;
				delete pGlowa;
				pGlowa = next;
				return student;
		}
		else {
		wytnijStudenta(pGlowa->pNext, naziwsko);
		}
	}
}

void wpiszOcene(Student *& pPrzeegzaminowani, Egzaminator * pEgzaminatorzy, const string & egzaminator, const string & student, double ocena) {
	auto szukanyEgzaminator = znajdzEgzaminatora(pEgzaminatorzy, egzaminator);
	auto wycietystudent = wytnijStudenta(szukanyEgzaminator->pStudenci, student);
	pPrzeegzaminowani = new Student{ wycietystudent->nazwisko, pPrzeegzaminowani , ocena };

}