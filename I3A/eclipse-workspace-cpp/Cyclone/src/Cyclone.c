#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int e, d, n;

// Coprimarity
int gcd(int a, int b);

// Primarity
int PrimarityTest(int a, int i);

// Inverse of the rest of the Euclidean division
int inverse(int a, int b);

// Find the ciphered/deciphered character
int FindT(int a, int m, int n);

// Fast Modulo Multiplication
void FastExponention(int bit, int n, int *y, int *a);

void KeyGeneration();
void Encryption(int value, FILE *out);
void Decryption(int value, FILE *out);

// Coprimarity
int gcd(int a, int b) {
	int q, r1, r2, r;

	if (a > b) {
		r1 = a;
		r2 = b;
	} else {
		r1 = b;
		r2 = a;
	}

	while (r2 > 0) {
		q = r1 / r2;
		r = r1 - q * r2;
		r1 = r2;
		r2 = r;
	}

	return r1;
}

// Primarity
int PrimarityTest(int a, int i) {
	int n = i - 1;
	int k = 0;
	int j, m, T;

	while (n % 2 == 0) {
		k++;
		n = n / 2;
	}

	m = n;
	T = FindT(a, m, i);

	if (T == 1 || T == i - 1)
		return 1;

	for (j = 0; j < k; j++) {
		T = FindT(T, 2, i);
		if (T == 1)
			return 0;
		if (T == i - 1)
			return 1;
	}
	return 0;
}

// Inverse of the rest of the Euclidean division
int inverse(int a, int b) {
	int inv;
	int q, r, r1 = a, r2 = b, t, t1 = 0, t2 = 1;

	while (r2 > 0) {
		q = r1 / r2;
		r = r1 - q * r2;
		r1 = r2;
		r2 = r;

		t = t1 - q * t2;
		t1 = t2;
		t2 = t;
	}

	if (r1 == 1)
		inv = t1;

	if (inv < 0)
		inv = inv + a;

	return inv;
}

// Find the ciphered/deciphered character
int FindT(int a, int m, int n) {
	int r;
	int y = 1;

	while (m > 0) {
		r = m % 2;
		FastExponention(r, n, &y, &a);
		m = m / 2;
	}
	return y;
}

// Fast Modulo Multiplication
void FastExponention(int bit, int n, int *y, int *a) {
	if (bit == 1)
		*y = (*y * (*a)) % n;

	*a = (*a) * (*a) % n;
}

void KeyGeneration() {
	int p, q;
	int phi_n;

	do {
		do
			p = rand();
		while (p % 2 == 0);

	} while (!PrimarityTest(2, p));

	do {
		do
			q = rand();
		while (q % 2 == 0);
	} while (!PrimarityTest(2, q));

	n = p * q;
	phi_n = (p - 1) * (q - 1);

	do
		e = rand() % (phi_n - 2) + 2; // 1 < e < phi_n
	while (gcd(e, phi_n) != 1);

	d = inverse(phi_n, e);
}

void Encryption(int value, FILE *out) {
	int cipher;
	cipher = FindT(value, e, n);
	fprintf(out, "%d ", cipher);
}

void Decryption(int value, FILE *out) {
	int decipher;
	decipher = FindT(value, d, n);
	fprintf(out, "%c", decipher);
}

int main(void) {
	FILE *inp, *out;

	// Destroy contents of these files (from previous runs, if any)
	out = fopen("cipher.txt", "w+");
	fclose(out);
	out = fopen("decipher.txt", "w+");
	fclose(out);

	KeyGeneration();

	inp = fopen("plain.txt", "r+");
	if (inp == NULL) {
		printf("Error opening source file\n");
		exit(1);
	}

	out = fopen("cipher.txt", "w+");
	if (out == NULL) {
		printf("Error opening destination file\n");
		exit(1);
	}

	// Encryption starts
	while (1) {
		char ch = getc(inp);
		if (ch == -1)
			break;
		int value = ch;
		Encryption(value, out);
	}

	fclose(inp);
	fclose(out);

	// Decryption starts
	inp = fopen("cipher.txt", "r");
	if (inp == NULL) {
		printf("Error opening cipher text\n");
		exit(1);
	}

	out = fopen("decipher.txt", "w+");
	if (out == NULL) {
		printf("Error opening file\n");
		exit(1);
	}

	while (1) {
		int cip;
		if (fscanf(inp, "%d", &cip) == -1)
			break;
		Decryption(cip, out);
	}
	fclose(out);

	return 0;
}
