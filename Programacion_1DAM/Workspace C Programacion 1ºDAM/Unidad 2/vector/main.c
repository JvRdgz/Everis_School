#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/**
 * Lo pongo asi porque de esta forma puedo hacer potencias con cualquier
 * tipo de exponente
 */

float ft_pow(float base, int exp)
{
    int cont = 1;
    float result = base;

    while(cont < exp)
    {
        result *= base;
        cont++;
    }
    return (result);
}

float ft_mod(float a, float b)
{
    return (sqrt((ft_pow(a, 2)) + (ft_pow(b, 2))));
}

void main(void)
{
    float ax, ay, bx, by, v_A, v_B, mod, u_A, u_B;

    printf("\nPunto A:");
    printf("\nIntroduce coordenada X: \n");
    scanf("%g", &ax);
    printf("Introduce coordenada Y: \n");
    scanf("%g", &ay);
    printf("\nPunto B:");
    printf("\nIntroduce coordenada X: \n");
    scanf("%g", &bx);
    printf("Introduce coordenada Y: \n");
    scanf("%g", &by);
    v_A = bx - ax;
    v_B = by - ay;
    printf("\nCoordenadas del Vector AB:\n(");
    printf("%g", v_A);
    printf(", ");
    printf("%g", v_B);
    printf(")\n");
    mod = ft_mod(v_A, v_B);
    printf("\nModulo: %g\n", mod);
    u_A = v_A / mod;
    u_B = v_B / mod;
    printf("\nCoordenadas del Vector Unitario:\n(");
    printf("%g", u_A);
    printf(", ");
    printf("%g", u_B);
    printf(")\n");
}