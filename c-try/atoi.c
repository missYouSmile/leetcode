#include <stdio.h>
#include <ctype.h>

int isOperator(char op) {
    if (op == '-' || op == '+')
        return 1;
    return 0;
}

int myAtoi(char *str) {

    while (isspace(*str)) {
        str++;
    };

    if (!isOperator(*str) && !isdigit(*str)) {
        return 0;
    }

    int sign = *str == '-' ? -1 : 1;

    printf("before operator sign = %d \t *str = %c \n", sign, *str);

    if (isOperator(*str))
        str++;

    printf("after operator sign = %d \t *str = %c \n", sign, *str);

    int carryNumber = 10;

    if (!isdigit(*str))
        return 0;

    long ret = 0;

    printf("sign = %d \t *str = %c \n", sign, *str);

    long l = 1;
    int max = (int) (l << 31) - 1;
    int min = (int) (-l << 31);

    while (isdigit(*str)) {
        printf("*str = %c \n", *str);
        ret = ret * carryNumber + (*str - '0');
        if (sign == -1 && -ret < min)
            return min;
        if (sign == 1 && ret > max)
            return max;
        str++;
        if (!isdigit(*str)) {
            break;
        }
    }

    return ret * sign;
}

int main() {
    int ret = myAtoi("    -42");
    printf("\nret is : %d \n", ret);
    return 0;
}