# Mini-shell
# Mini Shell (Command-Line Interpreter) in Java

## Description

This project implements a simple **command-line interface (CLI)** in Java, mimicking basic functionality of a shell or terminal. The shell can interpret and execute a variety of commands, allowing users to interact with the file system.

## Features

- **`pwd`**: Prints the current working directory.
- **`ls`**: Lists files and directories in the current directory.
- **`cd <dir>`**: Changes the current directory to the specified directory.
- **`touch <file>`**: Creates a new empty file.
- **`rm <file>`**: Deletes the specified file.
- **`help`**: Displays a list of available commands and their descriptions.
- **`exit`**: Exits the shell.

The shell uses Java's `File` class to handle file system operations like file creation, deletion, and directory navigation. It runs in an infinite loop, awaiting user input, and continues accepting commands until the user types `exit`.

## Installation

### Requirements

- **Java 8 or above** installed on your machine.
- A text editor or IDE (e.g., **IntelliJ IDEA**, **Eclipse**, or **VS Code**) to run Java projects.

## Compile the Java code using the javac command

javac MiniShell.java

## Run the shell:
java MiniShell

You can now interact with the shell by typing commands.
