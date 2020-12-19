#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define DELAY 50000000

//symbol displayed when Cell is alive 
char symbol = 254;

//dimensions of the Map
int x,y;

/**
 * Shows the Map.
 * @param map
*/
void showMap(char** map){

    for(int i = 0; i < x ; i++){
        for(int j = 0; j < y; j++){
            if(map[i][j] == symbol)
                printf(" %c ",map[i][j]);
            else
                printf(" %c ",map[i][j]);
        }
        printf("\n");
    }
}

/**
 * Allocates memory and inicializes the Map.
 * @return map
*/
char** createMap(){

    char** map = (char**) malloc(sizeof(char*)*x);

    for(int i = 0; i < x; i++){
        map[i] = (char*) malloc(sizeof(char)*y);
        for(int j = 0; j < y; j++){
            map[i][j] = ' ';
        }
    }
    return map;
}

/**
 * Frees the memory associated with a Map.
 * @param map
*/
void freeMap(char** map){

    for(int i = 0; i < x; i++){
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

    //Next iteration will be stored here
    char** new = createMap();

    for(int i = 0; i < x; i++){
        for(int j = 0; j < y ; j++){

            //Calculate the value of N from the adjacent positions
            int N = 0;
            for(int xi = i-1; xi <= i+1; xi++){
                for(int yj = j-1; yj <= j+1; yj++){

                    //If it's inside the boundaries of the Map
                    if(xi < x && yj < y && xi >= 0 && yj >= 0){
                        if(map[xi][yj] == symbol){
                            //Doesn't count itself
                            if(xi != i || yj != j)
                                N++;
                        }
                    }
                }
            }
            //Rules
            if(N == 3 || (N == 2 && map[i][j] == symbol))
                new[i][j] = symbol;   
        }
    }

    freeMap(map);
    return new;
}

char** insertBlinker(char** map){

    map[13][10]=symbol;
    map[13][11]=symbol;
    map[13][12]=symbol;

    return map;
}

char** insertToad(char** map){
    
    map[1][1] = symbol;
    map[2][1] = symbol;
    map[3][1] = symbol;
    map[0][2] = symbol;
    map[1][2] = symbol;
    map[2][2] = symbol;

    return map;
}

char** insertGlider(char** map){

    map[2][1] = symbol;
    map[3][2] = symbol;
    map[1][3] = symbol;
    map[2][3] = symbol;
    map[3][3] = symbol;

    return map;
}

char** insertGosperGliderGun(char** map){

    map[1][5] = symbol;
    map[1][6] = symbol;
    map[2][5] = symbol;
    map[2][6] = symbol;

    map[11][5] = symbol;
    map[11][6] = symbol;
    map[11][7] = symbol;
    map[12][4] = symbol;
    map[12][8] = symbol;
    map[13][3] = symbol;
    map[13][9] = symbol;
    map[14][3] = symbol;
    map[14][9] = symbol;
    map[15][6] = symbol;
    map[16][4] = symbol;
    map[16][8] = symbol;
    map[17][5] = symbol;
    map[17][6] = symbol;
    map[17][7] = symbol;
    map[18][6] = symbol;

    map[21][3] = symbol;
    map[21][4] = symbol;
    map[21][5] = symbol;
    map[22][3] = symbol;
    map[22][4] = symbol;
    map[22][5] = symbol;
    map[23][2] = symbol;
    map[23][6] = symbol;
    map[25][1] = symbol;
    map[25][2] = symbol;
    map[25][6] = symbol;
    map[25][7] = symbol;

    map[35][3] = symbol;
    map[35][4] = symbol;
    map[36][3] = symbol;
    map[36][4] = symbol;

    return map;
}

/**
 * Clear terminal screen.
*/
void cleanScreen(){
    for(int i=0;i<DELAY;i++);
    system("clear");
}

/**
 * Display menu with different inicial states for the game.
 * @param map
 * @return map
*/
char** menu(char** map){
    int i;
    
    printf("***************************************************\n");
    printf("*                  Game of Life                   *\n");
    printf("***************************************************\n");
    printf("    1) Insert Glider.\n");
    printf("    2) Insert Toad.\n");
    printf("    3) Insert Blinker.\n");
    printf("    4) Insert Glider and Blinker colliding.\n");
    printf("    5) Insert Gosper Glider Fun\n");
    printf("Option: ");
    scanf(" %d", &i);

    switch(i){
        case(1):
            map = insertGlider(map);
            break;
        case(2):
            map = insertToad(map);
            break;
        case(3):
            map = insertBlinker(map);
            break;
        case(4):
            map = insertGlider(insertBlinker(map));
            break;
        case(5):
            map = insertGosperGliderGun(map);
        default:
            break;
    }
    cleanScreen();
    return map;
}

int main(int argc,char** argv){

    system("clear");
    x = atoi(argv[1]);  //largura
    y = atoi(argv[2]);  //altura 

    char** map = createMap();
    map = menu(map);

    while(1){
        showMap(map);
        map = evolveMap(map);
        cleanScreen();
    }

    freeMap(map);
    return 0;
}