# Exercici 1 – Lectura segura des del teclat
**Descripció**: Aprendre a capturar i gestionar excepcions a l’hora d’introduir dades per teclat.
Evitar que l’aplicació es tanqui per errors d’entrada de l’usuari/ària.
Pràctica amb excepcions estàndard (InputMismatchException) i personalitzades.
Consolidar l’ús de mètodes estàtics per facilitar la reutilització del codi.

##  Enunciat de l'exercici
Crea una classe utilitària anomenada ConsoleReader que permeti llegir diferents tipus de dades des del teclat de manera segura. Aquesta classe ha de gestionar els errors que poden aparèixer quan l’usuari/ària introdueix valors incorrectes, com per exemple text en comptes de números.

Per fer-ho, crea un únic objecte Scanner i defineix una sèrie de mètodes estàtics per llegir dades. Aquests mètodes han de mostrar un missatge personalitzat, llegir el valor i validar-lo. Si l’entrada és incorrecta, es mostrarà un missatge d’error (per exemple: “Error de format”) i es tornarà a demanar la dada fins que sigui vàlida.

### Requeriments

Tots els mètodes reben com a paràmetre un String amb el missatge que es vol mostrar.
Tots gestionen errors i només retornen la dada quan és vàlida.
El missatge s’ha de tornar a mostrar cada vegada que hi hagi un error.

### Mètodes a implementar

**Amb tractament d'InputMismatchException:**

````java
public static byte readByte(String message);
public static int readInt(String message);
public static float readFloat(String message);
public static double readDouble(String message);
````
***Amb una excepció personalitzada:***

````java
public static char readChar(String message);
// Només accepta un únic caràcter. Si se n’introdueix més d’un, llença una excepció personalitzada.

public static String readString(String message);
// Llegeix una cadena tal com es rep, però podries validar longitud mínima o contingut si cal.

public static boolean readYesNo(String message);
// Si l’usuari/ària introdueix “s” (minúscula), retorna true. Si introdueix “n”, retorna false.
// Qualsevol altra entrada hauria de generar una excepció personalitzada.
````

### Exemple d’ús esperat

Introdueix la teva edat: hola
Error de format. Torna-ho a provar.
Introdueix la teva edat: 25

### Consell

Per no repetir codi, pots encapsular la lògica comuna (mostrar el missatge, capturar excepcions, tornar-ho a intentar) dins de bucles while, i utilitzar excepcions personalitzades per als casos que no cobreix InputMismatchException.
## 🛠 Tecnologies
- Backend: Java

##  Instal·lació i Execució
1. Clonar el repositori: `git clone ...`
2. Execució de l'aplicació.
3. Proves: Executar el `Main()`.


## 📌 Anotacions
### Checked Exceptions
- Les "checked exceptions" són les que el java compiler pot verificar al moment de compilar.
- D'aquestes, si el programa està ben escrit, es pot recuperar sense haver de finalitzar-ho.
- S'utilitza l'expressió "try-catch" per agafar les "checked exceptions" llençades dins del programa. I "throws" per definir que un methode pot llençar-ne una.

### Unchecked Exceptions
- Les "unchecked exceptions" són les que el java compiler no pot verificar al moment de compilar.
- Per tant, el programa no s'hi pot recuperar i ha de terminar el programa.
- No estan sotmeses al requeriment del bloc "try-catch".