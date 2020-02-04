#include <stdio.h>
#include <stdlib.h>

double	pi = 3.1415;

void	main(void)
{
	double	radio;
	double	result;

	printf("\nIntroduce radio: ");
	scanf("%lg", &radio);

	result = pi*radio*radio;

	printf("\nEl radio del circulo es: %g\n", result);
}
