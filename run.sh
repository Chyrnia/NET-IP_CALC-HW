#!/bin/bash
function run(){
    make # Step 1: Build the project
    cd bin || exit # Step 2: Change to the bin directory
    java Main $1 # Step 3: Run the Java program
    cd ..  # Step 4: Return to the previous directory
}

