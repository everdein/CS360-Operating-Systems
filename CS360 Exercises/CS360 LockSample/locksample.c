// Matthew Clark
// CS360 - Operating Systems

// * Compile using g++ -x c locksample.c *

#include <stdio.h>
#include <pthread.h>

pthread_mutex_t lock;
pthread_t tid[3];
int count = 0;

void* increment()
{
    pthread_mutex_lock(&lock);
    count++;
    printf("started - %d\n", count);
    int i;
    for(i=1;i<0xFFFFFFF;i++);
    printf("finished - %d\n", count);
    pthread_mutex_unlock(&lock);
    return NULL;
}
int main()
{
    pthread_mutex_init(&lock, NULL);
    pthread_create(&(tid[0]), NULL, &increment, NULL);
    pthread_create(&(tid[1]), NULL, &increment, NULL);
    pthread_create(&(tid[2]), NULL, &increment, NULL);
    pthread_join(tid[0], NULL);pthread_join(tid[1], NULL);
    pthread_join(tid[2], NULL);return 0;
}