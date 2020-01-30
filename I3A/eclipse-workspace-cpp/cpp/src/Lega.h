/*
 * Lega.h
 *
 */

#ifndef LEGA_H_
#define LEGA_H_

#include <string>
#include <tr1/unordered_map>
#include "Team.h"

class Lega {
public:
	static Lega* getInstance(); // Singleton

	~Lega();

	string const& getNome() const;
	void setNome(string const &nome);
	void nuovoTeamIscritto(Team *t);
	void stampa();

private:
	static Lega *instance;

	Lega(); // Costruttore privato

	string nome;

	std::list<Team*> teams;
};

#endif /* LEGA_H_ */
