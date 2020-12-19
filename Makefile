# Makefile
# Game of Life

CC   = gcc
LD   = gcc
CFLAGS =-Wall -std=gnu99 -I../
LDFLAGS=-lm -pthread

# A phony target is one that is not really the name of a file
# https://www.gnu.org/software/make/manual/html_node/Phony-Targets.html
.PHONY: all clean run

all: gameoflife

gameoflife.o: gameoflife.c
	$(CC) $(CFLAGS) -o gameoflife.o -c gameoflife.c

clean:
	@echo Cleaning...
	rm -f *.o gameoflife

run: gameoflife
	./gameoflife