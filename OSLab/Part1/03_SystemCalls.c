#include <fcntl.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
    int fd = open("demo.txt", O_CREAT | O_WRONLY | O_TRUNC, 0644);
    if (fd == -1) {
        perror("open");
        return 1;
    }

    write(fd, "Hello from system calls!\n", 25);
    close(fd);

    fd = open("demo.txt", O_RDONLY);
    if (fd == -1) {
        perror("open");
        return 1;
    }

    char buffer[100];
    ssize_t bytes = read(fd, buffer, sizeof(buffer) - 1);
    if (bytes == -1) {
        perror("read");
        close(fd);
        return 1;
    }
    buffer[bytes] = '\0';
    printf("File contents:\n%s", buffer);
    close(fd);

    pid_t pid = fork();
    if (pid == -1) {
        perror("fork");
        return 1;
    }

    if (pid == 0) {
        execlp("ls", "ls", "-l", NULL);
        perror("execlp");
        return 1;
    }

    wait(NULL);
    printf("Child process completed.\n");
    return 0;
}
