################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Copyconstr.cpp \
../src/DefaultArguments.cpp \
../src/Esempi.cpp \
../src/Ovmpri.cpp \
../src/Slicing.cpp \
../src/UsoRefs.cpp 

OBJS += \
./src/Copyconstr.o \
./src/DefaultArguments.o \
./src/Esempi.o \
./src/Ovmpri.o \
./src/Slicing.o \
./src/UsoRefs.o 

CPP_DEPS += \
./src/Copyconstr.d \
./src/DefaultArguments.d \
./src/Esempi.d \
./src/Ovmpri.d \
./src/Slicing.d \
./src/UsoRefs.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cross G++ Compiler'
	g++ -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


