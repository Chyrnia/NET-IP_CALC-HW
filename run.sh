#!/bin/bash

# Step 1: Build the project
make

# Step 2: Change to the bin directory
cd bin || exit

# Step 3: Run the Java program
java Main $1

# Step 4: Return to the previous directory
cd ..

