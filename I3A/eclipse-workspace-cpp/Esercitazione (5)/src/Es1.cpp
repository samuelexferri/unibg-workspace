#include <iostream>
#include <string.h>
using namespace std;

class Studente {
public:
	string corso;

	Studente(string c) {
		corso = c;
	}

	virtual ~Studente() {

	}

	virtual void getCorsoStudiVirtual() {
		cout << "Corso: " << corso << endl;
	}

	void getCorsoStudi() {
		cout << "Corso: " << corso << endl;
	}
};

class StudenteLS: public Studente {
public:
	StudenteLS(string c) :
			Studente(c) {
	}

	virtual void getCorsoStudiVirtual() {
		cout << "CorsoLS: " << corso << endl;
	}

	void getCorsoStudi() {
		cout << "CorsoLS: " << corso << endl;
	}
};

class StudenteIL: public Studente {
public:
	StudenteIL(string c) :
			Studente(c) {
	}

	virtual void getCorsoStudiVirtual() {
		cout << "CorsoIL: " << corso << endl;
	}

	void getCorsoStudi() {
		cout << "CorsoIL: " << corso << endl;
	}
};

int main() {
	// Esercizio (1)
	// Puntatore
	Studente *ps1 = new Studente("C1");
	ps1->getCorsoStudiVirtual();
	ps1->getCorsoStudi();

	Studente *ps2 = new StudenteLS("C1");
	ps2->getCorsoStudiVirtual();
	ps2->getCorsoStudi();

	Studente *ps3 = new StudenteIL("C1");
	ps3->getCorsoStudiVirtual();
	ps3->getCorsoStudi();

	/*
	 StudenteLS *psLS1 = new Studente("C1");
	 psLS1->getCorsoStudiVirtual();
	 psLS1->getCorsoStudi();
	 */

	StudenteLS *psLS2 = new StudenteLS("C1");
	psLS2->getCorsoStudiVirtual();
	psLS2->getCorsoStudi();

	/*
	 StudenteLS *psLS3 = new StudenteIL("C1");
	 psLS3->getCorsoStudiVirtual();
	 psLS3->getCorsoStudi();
	 */

	/*
	 StudenteIL *psIL1 = new Studente("C1");
	 psIL1->getCorsoStudiVirtual();
	 psIL1->getCorsoStudi();
	 */

	/*
	 StudenteIL *psIL2 = new StudenteLS("C1");
	 psIL2->getCorsoStudiVirtual();
	 psIL2->getCorsoStudi();
	 */

	StudenteIL *psIL3 = new StudenteIL("C1");
	psIL3->getCorsoStudiVirtual();
	psIL3->getCorsoStudi();

	// Normale
	Studente s1 = Studente("C1");
	s1.getCorsoStudiVirtual();
	s1.getCorsoStudi();

	Studente s2 = StudenteLS("C1");
	s2.getCorsoStudiVirtual();
	s2.getCorsoStudi();

	Studente s3 = StudenteIL("C1");
	s3.getCorsoStudiVirtual();
	s3.getCorsoStudi();

	/*
	 StudenteLS sLS1 = Studente("C1");
	 sLS1.getCorsoStudiVirtual();
	 sLS1.getCorsoStudi();
	 */

	StudenteLS sLS2 = StudenteLS("C1");
	sLS2.getCorsoStudiVirtual();
	sLS2.getCorsoStudi();

	/*
	 StudenteLS sLS3 = StudenteIL("C1");
	 sLS3.getCorsoStudiVirtual();
	 sLS3.getCorsoStudi();
	 */

	/*
	 StudenteIL sIL1 = Studente("C1");
	 sIL1.getCorsoStudiVirtual();
	 sIL1.getCorsoStudi();
	 */

	/*
	 StudenteIL sIL2 = StudenteLS("C1");
	 sIL2.getCorsoStudiVirtual();
	 sIL2.getCorsoStudi();
	 */

	StudenteIL sIL3 = StudenteIL("C1");
	sIL3.getCorsoStudiVirtual();
	sIL3.getCorsoStudi();

	cout << "Hello World!" << endl; // prints Hello World!
	return 0;
}
