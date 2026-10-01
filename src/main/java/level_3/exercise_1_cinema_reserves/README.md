# Exercici 1 – Reserves en el cinema
**Descripció**: Dissenyar una aplicació basada en múltiples classes que col·laboren entre si.
Treballar amb col·leccions dinàmiques com ArrayList.
Crear i gestionar excepcions personalitzades en Java (no checked).
Aplicar bones pràctiques de validació d’entrada d’usuari.
Aplicar mètodes com equals() i toString() per treballar amb objectes.
Interactuar amb l’usuari/ària mitjançant consola de manera robusta.

##  Enunciat de l'exercici
Una empresa de cinemes et demana que desenvolupis una aplicació per gestionar la reserva de seients a les seves sales. Aquesta aplicació serà utilitzada pels venedors/es a l’hora de vendre entrades.

Quan l’aplicació s’executa, primer demanarà quantes files i quants seients per fila té la sala. Un cop inicialitzada, es mostrarà el següent menú:


        1.- Mostrar totes les butaques reservades.
        2.- Mostrar les butaques reservades per una persona.
        3.- Reservar una butaca.
        4.- Anul·lar la reserva d’una butaca.
        5.- Anul·lar totes les reserves d’una persona.
        0.- Sortir.


Estructura de classes
» Main

    Conté el main() del programa.
    Demana a l’usuari/ària el nombre de files i seients per fila.
    Crea una instància de ReservationService amb aquestes dades.
    Crea la ConsoleUI i li passa el servei.
    Crida ui.start() per començar el programa.
    No conté cap lògica de validació ni de negoci.

» ConsoleUI

    Mostra el menú i llegeix les opcions de l’usuari/ària.
    Demana dades com nom, fila i seient, i crida els mètodes del servei.
    Només gestiona entrada i sortida per consola.
    No conté regles de negoci ni validació lògica.

» ReservationService

    Conté la lògica principal del programa.
    Atributs:

    private int totalRows;
    private int seatsPerRow;
    private List seats;

    Funcions principals:
        reserveSeat(int row, int seat, String name)
        cancelSeat(int row, int seat)
        cancelAllByPerson(String name)
        List<Seat> getAllSeats()
        List<Seat> getSeatsByPerson(String name)
    Valida la posició amb un mètode privat validateSeatPosition(row, seat).
    Si es produeix un error (posició fora de rang, butaca ocupada, etc.), llença una excepció personalitzada (RuntimeException).

» Seat

    Representa una reserva d’una butaca.
    Atributs:
        int row
        int seat
        String personName
    Dues butaques són iguals si tenen mateixa fila i seient (equals() i hashCode()).
    El mètode toString() mostra la butaca i el nom de la persona de manera llegible.

Excepcions personalitzades


class SeatAlreadyTakenException extends RuntimeException { }
class SeatAlreadyEmptyException extends RuntimeException { }
class InvalidSeatException extends RuntimeException { }
class InvalidPersonNameException extends RuntimeException { }

## 🛠 Tecnologies
- Backend: Java

##  Instal·lació i Execució
1. Clonar el repositori: `git clone ...`
2. Execució de l'aplicació.
3. Proves: Executar el `Main()`.

