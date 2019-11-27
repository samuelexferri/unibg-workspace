// Usiamo STL ed ereditarietà

#include <iostream>
#include <vector>
using namespace std;

class Persona {
public:
	virtual void stampa() {
		cout << "Persona" << endl;
	}
};

class Studente: public Persona {
public:
	virtual void stampa() {
		cout << "Studente" << endl;
	}
};

int main() {
	/* NO
	 vector<persona> gente;
	 studente s1, s2;
	 gente.push_back(s1);
	 gente.push_back(s2);
	 gente[0].stampa();
	 */

	vector<Persona*> gente;
	Studente s1, s2;
	gente.push_back(&s1);
	gente.push_back(&s2);
	gente[0]->stampa();
}
