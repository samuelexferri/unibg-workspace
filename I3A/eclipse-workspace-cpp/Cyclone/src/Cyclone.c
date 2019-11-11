#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

const int MAX = 1000; // Buffer maximum dimension

char * mplain;
long int * e, * d, * mcrypted, * mdecrypted;
int x, y, n, t;

// Interface
int prime(long int);
long int cd(long int);
void keys();
void encrypt();
void decrypt();

int main() {
	mplain = malloc(sizeof(char) * MAX);
	mcrypted = malloc(sizeof(long int) * MAX);
	mdecrypted = malloc(sizeof(long int) * MAX);
	e = malloc(sizeof(long int) * MAX);
	d = malloc(sizeof(long int) * MAX);

	// TODO Numelts?
	// TODO FILE *@notnull test = (FILE@)fopen("test.txt", "r");

	FILE *messagefile = fopen("message.txt", "r");
	if (messagefile == NULL) {
		printf("Failed to open file!\n");
		return 1;
	}

	char ch;
	int i = 0;

	while ((ch = (char) fgetc(messagefile)) != EOF) {
		mplain[i]= ch;
		i++;
	}
	mplain[i] = '\0';

	printf("Message: ");
	for (int i = 0; mplain[i] != (int) NULL; i++)
		printf("%c", mplain[i]);
	printf("\n\n");

	pclose(messagefile);

	printf("Enter first prime number X (ex. 23): ");
	fflush(stdout);
	scanf("%d", &x);

	if (prime(x) == 0) {
		printf("\nInvalid input!\n");
		exit(0);
	}

	printf("\nEnter second prime number Y, different from first (ex. 53): ");
	fflush(stdout);
	scanf("%d", &y);

	if (prime(y) == 0 || x == y) {
		printf("\nInvalid input!\n");
		exit(0);
	}

	keys();

	encrypt();
	decrypt();

	printf("\n\n");
	// system("PAUSE");

	return 0;
}

int prime(long int primemaybe) {
	int i;

	for (i = 2; i <= sqrt(primemaybe); i++) {
		if (primemaybe % i == 0)
			return 0;
	}

	return 1;
}

// Create the keys
void keys() {
	// Calculate N
	n = x * y;
	printf("\nN = %d", n);

	// Calculate T
	t = (x - 1) * (y - 1);
	printf("\nT = %d", t);

	int k = 0;

	// Calculate E (must be coprime of T and less than T) and D
	for (int i = 2; i < t; i++) {
		if (t % i == 0)
			continue;

		if (prime(i) == 1 && i != x && i != y) {
			e[k] = i;
			d[k]= cd(e[k]);
			k++;

			if (k == 99) // Limit the number of the possible pairs
				break;
		}
	}

	printf("\nPossible values of E and D are:");
	for (int i = 0; e[i] != (int) NULL; i++)
		printf("\n %ld \t %ld", e[i], d[i]);
}

// Calculate D
long int cd(long int ek) {
	long int k = 1;

	while (1) {
		k = k + t;
		if (k % ek == 0)
			return (k / ek);
	}
}

// Encrypt
void encrypt() {
	int i = 0;

	while (mplain[i] != '\0') {
		int k = 1;

		for (int j = 0; j < e[0]; j++) { // Key used is E[0]!
			k = (k * (mplain[i])) % n;
		}

		mplain[i] = k;
		i++;
	}

	mcrypted[i] = -1; // Terminator

	printf("\n\nThe encrypted message is:\n");
	for (i = 0; mcrypted[i] != -1; i++)
		printf("%c", mcrypted[i]);
}

// Decrypt
void decrypt() {
	long int key = d[0]; // Key used is D[0]!
	int i = 0;

	while (mcrypted[i] != -1) {
		long int cryptedtext = mcrypted[i];
		int k = 1;

		for (int j = 0; j < key; j++) {
			k = (k * cryptedtext) % n;
		}

		mdecrypted[i] = k;
		i++;
	}

	mdecrypted[i] = -1; // Terminator

	printf("\n\nThe decrypted message is:\n");
	for (i = 0; mdecrypted[i] != -1; i++)
		printf("%c", mdecrypted[i]);
}
