OS Lab — Easy-to-Remember Programs

1. Basic Linux commands: see 01_BasicLinuxCommands.txt
2. Basic shell programs: 02_BasicShellPrograms.sh
   Run: bash 02_BasicShellPrograms.sh
3. System calls demo in Java: 03_SystemCalls.java
   Note: Java APIs wrap OS operations; they are not direct calls to C system-call functions such as fork(), exec(), read(), write().
4. FCFS CPU scheduling: 04_FCFS.java
5. Non-preemptive SJF CPU scheduling: 05_SJF.java
6. Non-preemptive Priority scheduling: 06_Priority.java (smaller number = higher priority)
7. Round Robin CPU scheduling: 07_RoundRobin.java
8. Java multithreading: 08_MultithreadingJava.java
9. POSIX pthread: 09_MultithreadingPthread.c (pthread is C, not Java)

Java compile/run examples:
javac 04_FCFS.java
java FCFS

The numbered source filenames are intentional; their entry-point classes are
package-private so each file can be compiled directly despite the number prefix.

For pthread on Linux:
gcc 09_MultithreadingPthread.c -o pthread_demo -pthread
./pthread_demo
