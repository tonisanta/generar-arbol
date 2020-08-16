# Generar recorrido postorden
Este programa permite generar un árbol a partir de sus recorridos de preorden 
e inorden. Se genera el árbol con un algoritmo **recursivo** para luego poder
obtener los valores de su recorrido **postorden**.

## Uso
Los elementos se deben introducir **separados por comas** `,` Para ejecutar esta
aplicación Java se puede ejecutar la versión ya compilada con la
siguiente instrucción:
```
cd (directorio del proyecto)
java -jar out/artifacts/GenerarArbol_jar/GenerarArbol.jar  
``` 
![introducirDatos](/home/toni/IdeaProjects/generar-arbol/pictures/introducirDatos.png)

![resultados](/home/toni/IdeaProjects/generar-arbol/pictures/resultados.png)


## Consideraciones
Por definición, **las claves en un conjunto son únicas**, por tanto no puede haber
elementos repetidos. Si los recorridos proporcionados son incorrectos este
programa no verifica que los recorridos proporcionados generen un árbol correcto.
