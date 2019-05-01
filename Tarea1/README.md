# Tarea 1 Pokemon TCG

CC3002-1 Otono2019 Metodologias y Diseños de Programacion Tarea 1 

## Introduccion

El problema planteado por la tarea era generar un clon del juego de cartas Pokemon segun las siguiente reglas.

### Reglas

En el juego existen Entrenadores Pokemon, quienes usan sus Pokemon para pelear contra otro Entrenador con el objetivo principal de derrotar a los Pokemon de su rival. Se deben considerar 2 tipos de entidades principales, Entrenador y Carta.

Un jugador debe ser representado por la entidad Entrenador, esta entidad debe tener solo un Pokemon activo en el campo de pelea, puede poseer hasta 5 Pokemon en la banca y debe tener una mano con cualquier cantidad de Cartas. Ademas, el entrenador debe poder ver todas sus Cartas, tanto las que estuviesen en la mano como las que se encontrasen en el campo y debe poder jugar una Carta desde su mano, como a su vez utilizar caulquiera de las Habilidades de su Pokemon.

Las Cartas se dividen en dos tipos Pokemon y Energia, las Cartas de Energia representan las "monedas" del juego y existen 6 tipos de estas Panta, Agua, Fuego, Lucha, Psıquica y Relampago, estas Cartas al momento de jugarse se asocian al Pokemon activo del Entrenador. Por otro lado, las Cartas de Pokemon de al momento de jugarse se colocan en la banca del Entrenador, a menos que esta ya contenga 5 Pokemon, en cuyo caso la Carta no podria ser jugada. El Pokemon debe tener un numero identificatorio, puntos de vida, conocer las energias que se le asociaron y hasta 4 Habilidades. En caso de que los puntos de vida del Pokemon llegasen a ser 0, este se reemplazaria por el primer Pokemon en la banca del Entrenador.

Por ultimo, las Habilidades son acciones que puede realizar un Pokemon que en este caso solo consistirian en Ataques contra otro Pokemon. Un Ataque debe tener un nombre, un daño basico, un texto descriptivo y un coste que indicaria cuantas y de que tipo de Energias tiene que tener asociadas un Pokemon para usar dicho Ataque. Tambien, entre los Ataques de cada Pokemon existen distintas relaciones segun el tipo de Pokemon, algunos tipos de Pokemon presentan resistencia o debilidad a los ataques de otro tipos de Pokemon, lo que se traduce en una reduccion o aumento del daño recibido del Ataque.

## Descripcion Implementacion

El programa consiste en una representacion del juego Pokemon TCG de forma simplificada, utilizando la primera materia del curso que consistia en Double Dispatch, Herencia, Visibilidad y Testing. A partir de lo señalado se implementaron 4 Interfaces, la primera es la Interfaz Card que representa a las cartas y hereda a las Interfaces IPokemon y IEnergy que son las que representas las cartas de un pokemon y de una energia respectivamente, tambien se implemento la Interfaz IAbility para representar las habilidades de un pokemon, aunque no hacia falta debido a que solo existen ataques por ahora se creo para que en proximas ediciones del programa se pueda implementar mas facilmente. Las ultimas 3 interfaces mencionadas son implementadas a su vez por clases abstractas, IPokemon es implementada por AbstractPokemon, IEnergy es implementada por AbstractEnergy y IAbility por AbstractAbility, que son las clases encargadas de definir variables y metodos comunes para todos los tipos de pokemon, energias y habilidades. Para las dos primeras clases abstractas se extendieron 6 subclases, una por cada tipo de pokemon y energia, en la que se sobreescribieron los metodos correspondientes segun las caracteristicas de cada tipo de pokemon, mientras que para la ultima clase abstracta solo se extendio un clase para los ataques. Finalmente, se construyo un clase aparte para representar a los entrenadores.

### Clases e Interfaces

Las Interfaces:
- Card
- IPokemon
- IAbility
- IEnergy

Las Clases:
- AbstractPokemon
  - PlantPokemon
  - FirePokemon
  - WaterPokemon
  - ThunderboltPokemon
  - FightPokemon
  - PsychicPokemon
- AbstractEnergy
  - PlantEnergy
  - FireEnergy
  - WaterEnergy
  - ThunderboltEnergy
  - FightEnergy
  - PsychicEnergy
- AbstractAbilty
  - Attack

## Tests

Se creo un test por cada clase no abstracta y publica, en los que se probaron cada uno de sus metodos y los metodos de sus superclases. Ademas, se logro un 100% de class coverge y 94% de line coverage, el 94% es debido a que hubieron casos de los if que no se pudieron probrar, puesto que estos verificaban que no se estuviera incurriendo en errores al ejecutar los meodos, como entregar parametros null. Esto ultimo podria ser corregido con un NullObject Pattern, sin embargo eso no era materia que se considerara en esta parte del curso. 

## Uso del Programa

Para usar el programa hay que crear las instacias de entrenador, crear al menos un Pokemon con sus parametros requeridos e implementar las acciones mediante los metodos de cada clase. Esto debido a que no se genero un main para que el juego se inicializara automaticamente. 

## Authors

* **Ricardo Cordero** - *Trabajo Inicial - [richi-fcfm](https://github.com/richi-fcfm)
