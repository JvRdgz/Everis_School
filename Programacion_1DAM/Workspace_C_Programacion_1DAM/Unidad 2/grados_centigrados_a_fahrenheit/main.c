#include <stdio.h>
#include <stdlib.h>

void	main(void)
{
	float	num;

	printf("Introduce Grados Centigrados: \n");
	scanf("%f", &num);
	printf("%f\n", ((num * 9) / 5) + 32);
}
