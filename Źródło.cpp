#include  <iostream>
#include <fstream>
#include <Windows.h>
#include <string>
using namespace std;

bool sudoku(const string nazwaPliku) {
	string daneZPliku[9];
	string pomocniczy[9];

	ifstream plik(nazwaPliku);
	if (plik) {
		for (int i = 0; i < 9; i++) {
			plik >> daneZPliku[i];

		}
		plik.close();
	}

	for (int w = 0; w < 9; w++) {
		for (int i = 0; i < 9; i++) {
			for (int l = 1; l < 8 - i; l++) {
				if (daneZPliku[w][i] == daneZPliku[w][l + i]) {
					cout << "1";
					return false;
				}
				else if (daneZPliku[i][w] == daneZPliku[l + i][w]) {
					cout << "1";
					return false;


				}
			}
		}
	}

	for (int w = 0; w < 9; w++) {
		for (int i = 0; i < 3; i++) {
			for (int l = 0; l < 3; l++) {
				pomocniczy[w] += daneZPliku[i + (w / 3) * 3][l + (w % 3) * 3];
			}
		}
	}

	for (int w = 0; w < 9; w++) {
		for (int i = 0; i < 9; i++) {
			for (int l = 1; l < 8 - i; l++) {
				if (pomocniczy[w][i] == pomocniczy[w][l + i]) {
					cout << "1";
					return false;
				}

			}
		}
	}

	return true;
}

int main() {
	const string nazwaPliku = "sudoku.txt";

	cout << sudoku(nazwaPliku);

	system("pause");
	return 0;
}