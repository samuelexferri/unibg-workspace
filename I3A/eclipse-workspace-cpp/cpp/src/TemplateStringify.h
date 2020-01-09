/*
 * TemplateStringify.h
 */

#include <iostream>
#include <string>
#include <sstream> // Metodo str

#ifndef TEMPLATESTRINGIFY_H_
#define TEMPLATESTRINGIFY_H_

// Template per la conversione di interi in stringhe ad esempio
template<typename T>
inline std::string stringify(const T &t) { // Inline
	std::stringstream string_stream;
	string_stream << t;
	return string_stream.str();
}

template<typename T, typename ... Args>
inline std::string stringify(const T &first, Args ... args) { // Inline
	return stringify(first) + stringify(args...);
}

#endif /* TEMPLATESTRINGIFY_H_ */
