/*
 * Time.h
 */

using namespace std;

#include <iostream>

#include "TemplateStringify.h" // Template per la conversione di interi in stringhe

#ifndef TIME_H_
#define TIME_H_

class Time {
private:
	int hour, minutes, seconds;

public:
	Time() {
		hour = minutes = seconds = 0;
	}
	Time(int h) {
		setTime(h, 0, 0);
	}
	Time(int h, int m, int s = 0) { // Default arguments
		setTime(h, m, s);
	}

	void setTime(int h, int m, int s) {
		hour = (h >= 0 && h < 24) ? h : 0;
		minutes = (m >= 0 && m < 60) ? m : 0;
		seconds = (s >= 0 && s < 60) ? s : 0;
	}

	void printMilitary() {
		cout << hour << ":" << minutes << ":" << seconds;
	}

	string getMilitary() {
		return "" + stringify(hour) + ":" + stringify(minutes) + ":"
				+ stringify(seconds);
	}
};

#endif /* TIME_H_ */
