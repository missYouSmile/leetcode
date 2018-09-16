#include <stdio.h>
#include <ctype.h>

// leetcode NO. 58
int lengthOfLastWord(char *s) {

    int ret = 0;
    int len = 0;

    while (*s) {
        // printf("the temp is : %c \t and ret = %d , len = %d \n", *s, ret, len);
        if (isspace(*s)) {
            if (len != 0) {
                ret = len;
                len = 0;
            }
        } else {
            len++;
        }
        s++;
    }
    // printf("the ret = %d , len = %d \n", ret, len);
    return len != 0 ? len : ret;
}

int lengthOfLastWord2(char *s) {
    int len = 0;
    while (*s) {
        len++;
        s++;
    }
    // *s == '\0'
    s--;
    // trim()
    while (isspace(*s) && (len > 0)) {
        s--;
        len--;
    }

    int ll = 0;
    // last char
    while (!isspace(*s) && (len > 0)) {
        ll++;
        len--;
        s--;
    }
    return ll;
}

int main() {
    int ret = lengthOfLastWord(" ");
    printf("the length is : %d", ret);
    return 0;
}