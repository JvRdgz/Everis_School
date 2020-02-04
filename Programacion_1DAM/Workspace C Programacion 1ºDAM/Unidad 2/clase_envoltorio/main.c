#include <stdio.h>
#include <limits.h>
#include <float.h>

void main(void)
{
    printf("\n\tTIPO CHAR\n");
    printf("\nValor minimo char: %d\n", CHAR_MIN);
    printf("Valor maximo char: %d\n", CHAR_MAX);
    printf("\n\tTIPO INT\n");
    printf("\nValor minimo int: %d\n", INT_MIN);
    printf("Valor maximo int: %d\n", INT_MAX);
    printf("\n\tTIPO SHORT\n");
    printf("\nValor minimo short: %d\n", SHRT_MIN);
    printf("Valor maximo short: %d\n", SHRT_MAX);
    printf("\n\tTIPO LONG\n");
    printf("\nValor minimo long: %ld\n", LONG_MIN);
    printf("Valor maximo long: %ld\n", LONG_MAX);
    printf("\n\tTIPO FLOAT\n");
    printf("\nValor minimo float: %g\n", FLT_MIN);
    printf("Valor maximo float: %g\n", FLT_MAX);
    printf("\n\tTIPO DOUBLE\n");
    printf("\nValor minimo double: %g\n", DBL_MIN);
    printf("Valor maximo double: %g\n", DBL_MAX);
    printf("\n");
}
