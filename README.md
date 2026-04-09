# utez-2e-biblioteca-javafx-equipo04

Catalogo de libros en javafx con crud, validaciones y persistencia en archivo

---

## descripcion

Aplicacion de escritorio hecha en java y javafx para gestionar un catalogo de libros de una biblioteca escolar  

Permite registrar, consultar, editar y eliminar libros, asi como ver su detalle y exportar un reporte  
los datos se guardan en un archivo local para que no se pierdan al cerrar el programa  

---

## funcionalidades

- alta de libros
- consulta en tabla
- edicion de libros
- eliminacion con confirmacion
- pantalla de detalle
- exportar reporte a archivo csv

---

## persistencia

los datos se guardan en un archivo:
data/catalogo.csv


- al iniciar la aplicacion se cargan los datos desde el archivo  
- cada vez que se agrega, edita o elimina un libro se actualiza el archivo automaticamente  
- si el archivo no existe, se crea uno nuevo  

---

## reporte

Se puede exportar un reporte del catalogo actual

archivo generado:
data/reporte_catalogo.csv


el reporte incluye:
- encabezado
- fecha de generacion
- total de libros
- lista completa de libros

---

## validaciones

- no se permiten campos vacios
- titulo minimo 3 caracteres
- autor minimo 3 caracteres
- año numerico y dentro de un rango valido
- no se permiten libros con isbn repetido

---

## estructura del proyecto

- model  
  - clase Libro (representa los datos)

- service  
  - clase LibroService (logica del crud, validaciones y archivos)

- controller  
  - MainController (tabla principal)
  - FormController (formulario)
  - DetalleController (detalle del libro)

---

## interfaz

La aplicacion cuenta con 3 pantallas:

1. principal  
   - tabla con libros  
   - botones: nuevo, editar, eliminar, ver detalle, exportar  

2. formulario  
   - registro y edicion de libros  
   - botones guardar y cancelar  

3. detalle  
   - muestra toda la informacion del libro  
   - boton regresar  

---

## ejecucion

1. abrir el proyecto en un IDE (intellij recomendado)
2. asegurarse de tener java y javafx configurado
3. ejecutar la clase:


MainApp.java


---

## archivo de datos

el proyecto incluye un archivo con libros de prueba en:
data/catalogo.csv


---

## integrantes

- Luis Fernando Camacho Dominguez  
- Omar Emiliano Hernandez Benites  

---

## notas

- no se usa base de datos, solo archivos
- la informacion se conserva entre ejecuciones
