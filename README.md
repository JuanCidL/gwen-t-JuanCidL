# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en) card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

## Structure

This project currently has 4 general packages that describe the behavior of the base of a turn-based card game:

* Cards
* Board
* Player
* Controller

## Card
In the cards, there are 2 general types that extends from a common interface: Weather Cards and Unit Cards.
The latter extends by an own interface, and are separated into a total of 3 different classifications:

* MeleeCard: is a melee combat card.
* RangedCard: is a ranged combat card.
* SiegeCard: is a siege card.

Unit cards are identified by their name and their strength, which defines the power of each card. In contrast, weather cards are only identified by their name.
All cards have a default null effect that can be changed using the setEffect method, which only accepts effects corresponding to the general type of the card.
Furthermore, these cards are effect observables, which means they will notify their respective observers (board sections) its own effect.

### Effects

An Effect is a common interface that is extended by two other interfaces representing the effects of unit cards and weather cards.
The Unit Card Effects are designed to be applied to a single CardList, while the Weather Card Effects are designed using the visitor pattern.
This allows them to visit all the CardList on the board and act in a specific way for each, depending on the effect.
By default, each of these methods is defined as empty in an abstract class, so they can be overridden later to specify what to do in each specific CardList.

## Board

The board consists of 3 classes:
The Board consists of two player sections, each with a slot for placing weather cards.
Additionally, there is a BoardSection that contains 3 lists of cards, one for each type of unit card.
Finally, there are the CardList, with one list for each type of unit card, implemented as subclasses of CardList.

* Board: It has two board sections and a weather card zone.
* BoardSection: It has 3 CardList, one for each type of unit card, and its constructor receives a board so that the player assigned to this section can interact indirectly with it.
* CardList: It possesses a card list parameterized by a generic type and has functionalities to add cards and to check if it contains a specific card. This class extends an Effect Observer and acts according to the notifications of the cards that enter the class, obtaining their effects (only weather effects).
* MeleeZone: A subclass of CardList parameterized by melee cards.
* RangedZone: A subclass of CardList parameterized by ranged cards.
* SiegeZone: A subclass of CardList parameterized by siege cards.


## Player

The player is a class that is identified by their name. In its constructor it receives its name, a gem counter, and its deck and hand of cards. The player has the ability to shuffle their deck, play a card on the board and also has their respective methods to handle those attributes.
The player extends from a Notification Observable, this allowing it to subscribe to Notification Observers and send its message, for example, to the Controller.

## Controller

The controller is a class that allows handling the game states, performing the corresponding transitions for each stage of the game. This class extends from a Notification Observer.
In this case, when a player is subscribed to this class, it will notify the controller when the player has 0 gems or, in the case of having negative gems, to trigger the end state of the game.

### States

The states are subclasses of the State class, which are defined for each stage of the game with their corresponding transitions.

Below is the state diagram:


<div style="text-align: center;"> <h2> State Diagram: </h2> 

![State.png](src%2FState.png)

</div>


<div style="text-align: center;"> <h2> UML : </h2> 

![UML.png](src%2FUML.png)

</div>

