#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

//symbol displayed when Cell is alive 
char symbol = 254;

//dimensions of the Map
int x,y;

/**
 * Shows the Map.
 * @param map
*/
void showMap(char** map){

    for(int i = 0; i < y ; i++){
        for(int k = 0; k < x; k++){
            if(map[i][k] == symbol)
                printf(" %c ",map[i][k]);
            else
                printf(" %c ",map[i][k]);
        }
        printf("\n");
    }
}

/**
 * Allocates memory and inicializes the Map.
 * @return map
*/
char** createMap(){

    char** map = (char**) malloc(sizeof(char*)*y);

    for(int i = 0; i < y; i++){
        map[i] = (char*) malloc(sizeof(char)*x);
        for(int k = 0; k < x; k++){
            map[i][k] = ' ';
        }
    }
    return map;
}

/**
 * Frees the memory associated with a Map.
 * @param map
*/
void freeMap(char** map){

    for(int i = 0; i < y; i++){
        free(map[i]);
    }
    free(map);
}

/**
 * Generates the next iteration of a given Map.
 * @param map
 * @return map
*/
char** evolveMap(char** map){

    //Next iteration will be stored in new
    char** new = createMap();

    for(int i = 0; i < y; i++){
        for(int k = 0; k< x ; k++){
            //Calculate the value of N from the adjacent positions
            int N = 0;
            for(int yi = i-1; yi <= i+1; yi++){
                for(int xk = k-1; xk <= k+1; xk++){
                    if(yi < y && xk < x && yi >= 0 && xk >= 0){
                        if(map[yi][xk] == symbol){
                            if(yi != i || xk != k)
                                N++;
                        }
                    }
                }
            }
            if(N == 3 || (N == 2 && map[i][k] == symbol))
                new[i][k] = symbol;   
        }
    }

    freeMap(map);
    return new;
}

char** insertBlinker(char** map){

    map[10][13]=symbol;
    map[11][13]=symbol;
    map[12][13]=symbol;

    return map;
}

char** insertToad(char** map){
    
    map[1][1] = symbol;
    map[1][2] = symbol;
    map[1][3] = symbol;
    map[2][0] = symbol;
    map[2][1] = symbol;
    map[2][2] = symbol;

    return map;
}

char** insertGlider(char** map){

    map[1][2] = symbol;
    map[2][3] = symbol;
    map[3][1] = symbol;
    map[3][2] = symbol;
    map[3][3] = symbol;

    return map;
}

void delay(int loops){
    for(int i=0;i<loops;i++);
}

int main(int argc,char** argv){

    system("clear");
    x = atoi(argv[1]);  //largura
    y = atoi(argv[2]);  //altura 

    char** map = createMap();
    map = insertGlider(map);
    map = insertBlinker(map);

    while(1){
        showMap(map);
        map = evolveMap(map);
        delay(50000000);
        system("clear");
    }

    return 0;
}