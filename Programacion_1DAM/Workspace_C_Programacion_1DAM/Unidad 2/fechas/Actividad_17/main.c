#include <stdio.h>
#include <stdlib.h>

void	main(void)
{
	int	dia = 0;
	int	mes = 0;
	int	anio = 0;

	printf("\nIntroduce dia: ");
	scanf("%d", &dia);
	printf("\nIntroduce mes: ");
	scanf("%d", &mes);
	printf("\nIntroduce anio: ");
	scanf("%d", &anio);

	if (dia < 10 && mes < 10)
	{
		printf("\n0%d", dia);
		printf("0%d", mes);
		printf("%d\n", anio);
		
		printf("%d", anio);
		printf("0%d", mes);
		printf("0%d\n", dia);
		
		printf("0%d-", dia);
		printf("0%d-", mes);
		printf("%d\n", anio);
	}
	else if (dia < 10)
	{
		printf("0%d", dia);
		printf("%d", mes);
		printf("%d\n", anio);
		
		printf("%d", anio);
		printf("%d", mes);
		printf("0%d\n", dia);
		
		printf("0%d-", dia);
		printf("%d-", mes);
		printf("%d\n", anio);		
	}
	else if (mes < 10)
	{
		printf("%d", dia);
		printf("0%d", mes);
		printf("%d\n", anio);
		
		printf("%d", anio);
		printf("0%d", mes);
		printf("%d\n", dia);
		
		printf("%d-", dia);
		printf("0%d-", mes);
		printf("%d\n", anio);
	}
	else
	{
		printf("%d%d%d\n", dia, mes, anio);
		printf("%d%d%d\n", anio, mes, dia);
		printf("%d-%d-%d\n", dia, mes, anio);
	}
	printf("%d/%d/%d\n", dia, mes, anio);
	printf("%d del %d de %d\n", dia, mes, anio);
}
