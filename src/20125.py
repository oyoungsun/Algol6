#include <stdio.h>

int main() {
    int i, j;
    if i==1 :
        print("*")

    for (i = 1; i <= n; i++) {
        for (j = 2; j <= i; j++) {
            printf(" ");
        } #띄우기
        for (j = n; j >= i * 2 - 1; j--) {
            if (j % 2 == 0) {
                printf(" ");
            } else {
                printf("*");
            }
        }
        printf("\n");
    }

    for (i = 1; i <= n; i++) {
        for (j = 4; j >= i; j--) {
            printf(" ");
        }
        for (j = 1; j <= i * 2 - 1; j++) {
            if (j % 2 == 0) {
                printf(" ");
            } else {
                printf("*");
            }
        }
            printf("\n");
        }

    return 0;
}
