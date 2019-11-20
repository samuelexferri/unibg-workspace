#ifndef TIME_HPP_
#define TIME_HPP_

class Time {

public:
	Time();
	Time(int); // Costruttore ora
	Time(int, int, int); // Costruttore ora, min, secondi
	void printStandard() const;

private:
	int hour, minute, second;
};

#endif /* TIME_HPP_ */
