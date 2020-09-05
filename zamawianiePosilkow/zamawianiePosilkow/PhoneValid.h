#ifndef PHONEVALID_H_
#define PHONEVALID_H_
#include "Validator.h"

class PhoneValid : public virtual Validator {

public:
	PhoneValid(const string & number) : Validator(number) {
		reg.assign("[1-9]{1}[0-9]{8}");
	}
	bool inline check() {
		return regex_match(variable, reg);
	}
};
#endif