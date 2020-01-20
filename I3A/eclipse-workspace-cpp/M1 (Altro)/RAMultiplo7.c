#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool multiplo7for(int numero) {
	int unita = numero % 10;
	int prenumero = (numero - unita) / 10;

	while (numero > 6) {
		printf("NUMERO: %d - PRENUMERO: %d - UNITA: %d\n", numero, prenumero,
				unita);

		numero = (prenumero + unita * 5);

		if (numero == 7)
			return true;
		else {
			unita = numero % 10;
			prenumero = (numero - unita) / 10;
		}
	}
	return false;
}

bool multiplo7rec(int numero) {
	int unita = numero % 10;
	int prenumero = (numero - numero % 10) / 10;
	numero = prenumero + unita * 5;

	printf("NUMERO: %d - PRENUMERO: %d - UNITA: %d\n", numero, prenumero,
			unita);

	if (numero < 7)
		return false;
	return numero == 7 || multiplo7rec(numero);
}

bool multiplo7tail(int numero) {
	int unita = numero % 10;
	int prenumero = (numero - numero % 10) / 10;
	numero = prenumero + unita * 5;

	if (prenumero < 7)
		return false;
	if (numero == 7)
		return true;
	else
		return multiplo7tail(numero);
}

int main3(void) {
	printf("%d\n", multiplo7for(68089));
	printf("%d\n", multiplo7rec(14));
	printf("%d", multiplo7tail(6853));
	return 0;
}
