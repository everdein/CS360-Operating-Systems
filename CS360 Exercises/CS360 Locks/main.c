// Matthew Clark
//CS360 - Operating Systems
// Problem Set - Locks

// * Compile using g++ -x c main.c *

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

pthread_mutex_t lock;
pthread_t t1,t2;

void *arun()
{
    pthread_mutex_lock(&lock);
    printf("%s\n", "hello"); 
    pthread_mutex_unlock(&lock);
    pthread_exit(NULL);
}

void *brun()
{
    pthread_mutex_lock(&lock); 
    printf("%s\n", "world"); 
    pthread_mutex_unlock(&lock);
    pthread_exit(NULL);
}

int main() 
{
    pthread_mutex_init(&lock, NULL); 
    pthread_create(&t1, NULL, arun , NULL); 
    pthread_create(&t2, NULL, brun , NULL); 
    pthread_join(t1, NULL); 
    pthread_join(t2, NULL);
}