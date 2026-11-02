/* POSIX pthread example — this one is C, because pthread is a C library. */
#include <stdio.h>
#include <pthread.h>

void *task(void *arg) {
    printf("Hello from thread %ld\n", (long)arg);
    return NULL;
}

int main(void) {
    pthread_t t1, t2;

    pthread_create(&t1, NULL, task, (void *)1);
    pthread_create(&t2, NULL, task, (void *)2);
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    return 0;
}
