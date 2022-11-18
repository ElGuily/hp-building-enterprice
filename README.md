# hp-building-enterprice

## Niveles de privilegio:
- Si inicia sesión de forma común.
- Si inicia con el usuario: admin y contraseña: admin
- Si desde admin crea un empleado, ingresar con esa cuenta creada 

## Procedimiento para usar:
1. Instalar Tomcat (en el caso de no tener).
2. Crear la base de datos con el nombre "hpbe".
3. Mediante el archivo sql, crear todas las tablas, stores, funciones, triggers, etc.
5. Escribir el comando sql "SET GLOBAL log_bin_trust_function_creators = 1;"
4. Runear el proyecto desde netbeans.
