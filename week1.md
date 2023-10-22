# Week 1 lab report

## cd

`cd` changes the working directory.

1. Example with no arguments (valid):

    ```
    cowpox@Cowpox:~/Desktop/screenshots$ cd
    cowpox@Cowpox:~$
    ```

    The starting working directory was */home/cowpox/Desktop/screenshots*, in the user cowpox. When `cd` is given no arguments, the working directory is set to be the user home directory, or */home/cowpox*, also known as *~*. In other words, `cd` is equivalent to `cd ~` .

2. Example with a single directory as an argument (valid):

    ```
    cowpox@Cowpox:~$ cd /sbin
    cowpox@Cowpox:/sbin$ 
    ```

    The starting directory here is `/sbin`. When `cd` gets a single directory as its argument, it enters that directory. In this case, I passed it an absolute path to `sbin`, which contains Linux system binaries. The working directory was moved from `/home/cowpox` to `/sbin`.

3. Example when passing a file (invalid):

    ```
    cowpox@Cowpox:/sbin$ cd /bin/bash
    bash: cd: /bin/bash: Not a directory
    cowpox@Cowpox:/sbin$ 
    ```

    It does not make sense to set the working directory to a file, so `cd` returns an error code and does not change the directory.

## ls

1. Example when passing no arguments (valid):


    ```
    cowpox@Cowpox:/usr/local/bin$ ls
    asy  intel-sde  ninja  xasy
    cowpox@Cowpox:/usr/local/bin$
    ```

    The working directory here is `/usr/local/bin`. `ls` prints a list of the files and directories of the working directory. Although it can't be shown here, on my system, the directories are blue and the files are green. 

2. Example when passing a directory (valid):

    ```
    cowpox@Cowpox:/usr/local/bin$ ls ./intel-sde
    ia32     Licenses  pinkit      sde    sde64.sig  xed    xed64.sig
    intel64  misc      README.txt  sde64  sde.sig    xed64  xed.sig
    cowpox@Cowpox:/usr/local/bin$
    ```

    The working directory is not changed from its initial value of `/usr/local/bin`. Here,`ls` prints the contents of the passed directory, which is relative to the working directory. `intel-sde` contains some files associated with Intel's emulator for its various microarchitectures. 

3. Example when passing a file (valid):

    ```
    cowpox@Cowpox:/usr/local/bin$ ls ./asy
    ./asy
    cowpox@Cowpox:/usr/local/bin$
    ```

    The working directory is `/usr/local/bin`. When passing a file, only the path to the file is given. The path is given as a full relative path from the working directory, in the same form as passed to `ls`; essentially, `ls` just passes through the first argument. To wit:

    ```
    cowpox@Cowpox:/usr/local/bin$ ls ../../local/bin/asy
    ../../local/bin/asy
    cowpox@Cowpox:/usr/local/bin$
    ```

## cat

1. Example of using no arguments (valid):

    ```
    cowpox@Cowpox:/usr/local/bin$ cat
    wi<Enter>
    wi
    ^C
    cowpox@Cowpox:/usr/local/bin$
    ```

    The working directory is `/usr/local/bin`. When cat is invoked without arguments, it forwards input from stdin to stdout, until an EOF (usually, Ctrl-D) or a keyboard interrupt is entered. Note that the <Enter> is just where I pressed enter and is not actually printed.

2. Example of using a directory argument (invalid):

    ```
    cowpox@Cowpox:/usr/local/bin$ cat .
    cat: .: is a directory
    cowpox@Cowpox:/usr/local/bin$
    ```

    The working directory is `/usr/local/bin`. Printing the contents of a directory to stdout does not make sense, so `cat` returns an error in this case.

3. Example of using a file argument (valid):

    ```
    cowpox@Cowpox:~$ cat .gitignore
    *.swp
    cowpox@Cowpox:~$
    ```

    The working directory is `/usr/local/bin`. Here, `cat` prints the contents of the file to stdout, the same as what would be seen were it opened with a text editor.
