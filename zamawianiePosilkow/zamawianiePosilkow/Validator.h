#ifndef VALIDATOR_H_
#define VALIDATOR_H_



#include <string>
#include <regex>
using namespace std;

class Validator {
protected:
	regex reg;
public:

	string variable;

	virtual bool check() = 0;

	Validator(const string & date) {
		this->variable = date;
	}
};

#endif