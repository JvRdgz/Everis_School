Algoritmo PrecioProducto
	respuesta <- 'si'
	Mientras (respuesta=='si') Hacer
		Escribir 'Escriba precio inicial'
		Leer dato1
		Escribir 'Escriba el porcentaje de descuento'
		Leer dato2
		descuento <- (dato1*dato2)/100
		Escribir 'Nuevo precio: ',dato1-descuento
		Escribir '¿Desea repetir el calculo con otras cifras?'
		Leer respuesta
	FinMientras
FinAlgoritmo

