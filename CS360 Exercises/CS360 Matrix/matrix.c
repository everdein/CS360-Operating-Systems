// Matthew Clark
// CS360 - Operating Systems
// Exercise - Matrix

#include <pthread.h>
#include <stdio.h>

#define N 3
#define M 4

int matrix[N][M];
void *printSum(void* rowId){
  int r = (int) rowId;
  int sum = 0;
  int i;
  for(i=0;i<M;i++){
    sum+=matrix[r][i];
  }
  printf("Sum = %d", sum);
  
  pthread_exit();
}

int main(){
  pthread_t threads[N];
  int i,j;
  for(i=0;i<N;i++){
    for(j=0;j<M;j++){
      matrix[i][j]=i+1;
    }
  }
  for(i=0;i<N;i++){
    pthread_create(&threads[i],NULL,printSum,(void*)i);
  }
  printf("Main is done\n");
  pthread_exit(NULL);
}

// join function -- something about a value
