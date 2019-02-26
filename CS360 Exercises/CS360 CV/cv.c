// Matthew Clark
// CS360 - Operating Systems

// * Compile using g++ -x c cv.c *

#include <stdio.h>
#include <pthread.h>
pthread_mutex_t lock;
pthread_t tid[3];
int count = 0;
pthread_cond_t aboveZero;
void* increment()
{
    pthread_mutex_lock(&lock);
    count++;
    printf("incremented %d\n", count);
    if(count>0)pthread_cond_signal(&aboveZero);
    pthread_mutex_unlock(&lock);
    return NULL;
}
void* decrement()
{
    pthread_mutex_lock(&lock);
    count--;
    printf("decremented %d\n", count);
    pthread_mutex_unlock(&lock);
    return NULL;
}
void* print()
{
    pthread_mutex_lock(&lock);
    while(count<=0)pthread_cond_wait(&aboveZero,&lock);
    printf("printing %d\n", count);
    pthread_mutex_unlock(&lock);
    return NULL;
}
int main()
{
    pthread_mutex_init(&lock, NULL);
    pthread_cond_init(&aboveZero, NULL);
    pthread_create(&(tid[0]), NULL, &increment, NULL);
    pthread_create(&(tid[1]), NULL, &print, NULL);
    pthread_create(&(tid[2]), NULL, &decrement, NULL);
    pthread_join(tid[0], NULL);
    pthread_join(tid[1], NULL);
    pthread_join(tid[2], NULL);
    return 0;
}