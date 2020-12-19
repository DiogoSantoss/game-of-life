#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

char symbol = 254;

void showMap(int x, int y, char** map){

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

char** createMap(int x,int y){

    char** map = (char**) malloc(sizeof(char*)*y);

    for(int i = 0; i < y; i++){
        map[i] = (char*) malloc(sizeof(char)*x);
        for(int k = 0; k < x; k++){
            map[i][k] = ' ';
        }
    }
    return map;
}

void freeMap(int x, int y, char** map){

    for(int i = 0; i < y; i++){
        free(map[i]);
    }
    free(map);
}

char** evolveMap(int x, int y, char** map){

    int N;
    char** new = createMap(x,y);

    for(int i = 0; i < y; i++){
        for(int k = 0; k< x ; k++){
            N = 0;
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

    //Updates map based on new values
    for(int i = 0; i < y; i++){
        for(int k = 0; k < x ; k++){
            map[i][k] = new[i][k];
        }
    }
    freeMap(x,y,new);
    return map;
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
    int x = atoi(argv[1]);  //largura
    int y = atoi(argv[2]);  //altura 

    char** map = createMap(x,y);
    map = insertGlider(map);
    map = insertBlinker(map);


    while(1){
        showMap(x,y,map);
        map = evolveMap(x,y,map);
        delay(50000000);
        system("clear");
    }

    return 0;
}