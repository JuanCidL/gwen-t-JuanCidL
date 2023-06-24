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

This project currently has 3 general packages that describe the behavior of the base of a turn-based card game:

* Cards
* Board
* Player

## Card
In the cards, there are 2 general types that extend from a common interface: Weather Cards and Unit Cards. The latter are separated into a total of 3 different classifications:

* MeleeCard: is a melee combat card.
* RangedCard: is a ranged combat card.
* SiegeCard: is a siege card.

Each of these currently has only one double dispatch method to resolve the type of each card to be played from a board, which will be discussed later.

## Board

The board consists of 2 classes: the first is a board section, and the second is the board itself, which has 2 board sections. The behaviors are explained below:

* Board: has 2 public board sections for each player, and one weather type card; this last one is defined this way since both board sections must share a common area to place weather cards. This class is responsible for handling weather cards.
* BoardSection: in its constructor it receives a board to handle the weather card area, and also has 3 private areas for each type of unit card. This class is responsible for handling the plays of cards on the board.


## Player

The player is a class that is identified by their name. In its constructor it receives its name, a gem counter, and its deck and hand of cards. The player has the ability to shuffle their deck, play a card on the board and also has their respective methods to handle those attributes.

<div style="text-align: center;"> <h2> UML : </h2> 

![UML.png](src%2FUML.png)

</div>

<div style="text-align: center;"> <h2> State Diagram: </h2> 

![State.png](src%2FState.png)

</div>