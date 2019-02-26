// Matthew Clark
// CS360 - Operating Systems
// Exercise - Thread Hello 

// * Compile using g++ -x c hello.c *

#include <pthread.h>
#include <stdio.h>

#define NUM_THREADS 5

void *printHello(void *threadId)
{
  int id = (uintptr_t) threadId;
  printf("Hello from thread # %d\n", id);
  pthread_exit(NULL);
}

int main()
{
  pthread_t threads[NUM_THREADS];
  int i;
  for(i=0;i<NUM_THREADS;i++)
  {
    pthread_create(&threads[i],NULL, printHello, (void*)(uintptr_t)i); 
  }
  printf("Main thread is done\n");
  pthread_exit(NULL);
}