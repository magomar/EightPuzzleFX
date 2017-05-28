# EightPuzzleFX

EightPuzzle solver using AStar search and JavaFX for the GUI

This project solves the classical eightpuzzle problem using a search approach.

The project is divided in two modules 

## EightPuzzleSolver

* search: library to solve generic search problems. It uses a generics approach to easily implement
domain-specific states and transitions. Current version only includes breadth-first and best-first search algorithms
* task: utility library to ease the creation and execution of search tasks
* util: various utilities
* model: implementation of the eightpuzzle solver by definining specific states, actions and heuristics

## EightPuzzleApp

JavaFX application using the EightPuzzleSolver module to solve the EightPuzzle problem in a visual environment
