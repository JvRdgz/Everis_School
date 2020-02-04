#include <stdio.h>
#include <string.h>

int     main(void)
{
    float   precio[4];
    int     i;
    size_t  len;
    float   media;

    len = sizeof(precio) / sizeof(precio[0]);
    i = 0;
    media = 0.0;
    while (i < 4) {
        printf("\nIntroduce el precio del establecimiento %d\n", (i + 1));
        scanf("%g", &precio[i]);
        media += precio[i];
        i++;
    }
    printf("\nMedia del producto de los cuatro establecimientos: %g", media / len);
}