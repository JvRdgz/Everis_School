#include <stdio.h>
#include <math.h>

int main(void)
{
    float base = 0.0f, altura = 0.0f, radio = 0.0f;
    char op;

    do {
        printf("\n\tMENU PRINCIPAL\n");
        printf("\nSelecciona una opcion:\n");
        printf("\na) Area de un rectangulo:\n");
        printf("\nb) Area de un triangulo:\n");
        printf("\nc) Area de un circulo:\n");
        printf("\nd) Salir\n");

        scanf("%c", &op);
        
        switch (op)
        {
        case 'a':
            printf("\nIntroduce base:");
            scanf("%g", &base);
            printf("\nIntroduce altura:");
            scanf("%g", &altura);
            printf("\nArea del rectangulo:%g", base * altura);
        break;
        case 'b':
            printf("\nIntroduce base:");
            scanf("%g", &base);
            printf("\nIntroduce altura:");
            scanf("%g", &altura);
            printf("\nArea del triangulo:%g", (base * altura) / 2);
        }
    } while (op != 'd');
    
}