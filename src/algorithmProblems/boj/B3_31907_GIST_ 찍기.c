#include <stdio.h>
#include <math.h>

int M = 4; int N = 3;
char *original[] = 
{
    "G...",
    ".I.T",
    "..S."
};

int main(){
    int K;
    scanf("%d",&K);
    
    for (int i = 0; i < K*N; i++){
        int r = (i+K)/K - 1;
        for (int j = 0; j < K*M; j++){
            int c = (j+K)/K - 1;
            printf("%c",original[r][c]);
        }
        printf("\n");
    }
    
    return 0;
}