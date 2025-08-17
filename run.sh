#!/bin/bash
function build(){
    make # Step 1: Build the project
    cd bin || exit # Step 2: Change to the bin directory
    java CalculadoraRed $@ # Step 3: Run the Java program
    cd ..  # Step 4: Return to the previous directory
}

function run(){
	cd bin || exit #Change to the bin directory
	java CalculadoraRed $@ #Run the program
	cd .. #Go back
}

