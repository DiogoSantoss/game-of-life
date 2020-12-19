#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void showMap(int x, int y, char** map){

    for(int i = 0; i < y ; i++){
        for(int k = 0; k < x; k++){
            printf("%c",map[i][k]);
        }
        printf("\n");
    }
}

char** createMap(int x,int y){

    char** map = (char**) malloc(sizeof(char*)*y);

    for(int i = 0; i < y; i++){
        map[i] = (char*) malloc(sizeof(char)*x);
        for(int k = 0; k < x; k++)
            map[i][k] = '0';
    }
    return map;
}

void evolveMap(int x, int y, char** map){
    for(int i = 0; i < y; i++){
        for(int k = 0; k< x ; k++){
            
        }
    }
}

int sumAdjacentMembers(int x, int y, char** map, int xEntrie, int yEntrie){

    int N = 0;
    int NyUp = 0;

    if(xEntrie == 0){
        
    }

        
}

int main(int argc,char** argv){

    int x = atoi(argv[1]);  //largura
    int y = atoi(argv[2]);  //altura 

    char** map = createMap(x,y);
    showMap(x,y,map);



    return 0;
}