// Abstract Data Type (Record opaco)

#ifndef STUDENTE_H_
#define STUDENTE_H_

// Puntatore a una struct definita dopo in Studente.c
typedef struct Studente *studenteRef;

studenteRef makeStudent(char *n, char *c);

void printStudente(studenteRef s);

char* studentData(studenteRef s);

void deleteStudente(studenteRef *s); // Puntatore a un puntatore opaco

void addVoto(studenteRef s, int x);

void stampaMedia(studenteRef s);

#endif /* STUDENTE_H_ */
