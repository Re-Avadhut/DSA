#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
    int pipefd[2];
    if (pipe(pipefd) == -1) {
        perror("pipe");
        return 1;
    }

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork");
        return 1;
    }

    if (pid == 0) {
        close(pipefd[1]);

        char message[100];
        ssize_t bytes = read(pipefd[0], message, sizeof(message) - 1);
        if (bytes == -1) {
            perror("read");
            close(pipefd[0]);
            return 1;
        }
        message[bytes] = '\0';
        printf("Child received: %s\n", message);
        close(pipefd[0]);
        return 0;
    }

    close(pipefd[0]);
    const char message[] = "Hello through pipe!";
    if (write(pipefd[1], message, sizeof(message)) == -1) {
        perror("write");
        close(pipefd[1]);
        return 1;
    }
    close(pipefd[1]);
    wait(NULL);
    return 0;
}
