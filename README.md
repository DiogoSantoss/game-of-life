# Game of Life

## What is the Game of Life
The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.  
It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input.

## Rules of the game
The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead, (or populated and unpopulated, respectively).  Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
- Any live cell with fewer than two live neighbours dies, as if by underpopulation.           
- Any live cell with two or three live neighbours lives on to the next generation.              
- Any live cell with more than three live neighbours dies, as if by overpopulation.
- Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## How do we represent this ?
We can represent the universe with a 2D array in which every entrie of the array is a cell that is alive (1) or dead (0).  
Let's say that __C__ is a cell, calculated __N__, the number of lives in the neighborhood is possible to infer __C'__.  

| C | N                     | C' | Rule   |
|---|-----------------------|----|--------|
| 1 | 0,1                   | 0  | Rule 1 |
| 1 | 2,3                   | 1  | Rule 2 |
| 1 | 4,5,6,7,8             | 0  | Rule 3 |
| 0 | 0,1,2,4,5,6,7,8       | 0  | Rule 4 |
| 0 | 3                     | 1  | Rule 4 |

Following this method it's possible to define the next iteration of the array and so on.  

## How to compile (C)
Run 
```
make
```
then
```
./gameoflife width height
```
Since the simulation runs inside the terminal it's advised to scale down the size to have a better experience.  
You can speed-up or slow-down the simulacion by adjusting the *DELAY*.  
Some inicial states have a minimum map size required.

## How to compile (Java)
TODO