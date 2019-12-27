#include <iostream>
#include <string>
#include <sstream> // Metodo str

// Variadic template
template <typename Args>
std::string sstr(Args args)
{
    std::ostringstream sstr;
    sstr << args;
    return sstr.str();
}
