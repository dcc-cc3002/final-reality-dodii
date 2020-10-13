Final Reality
=============

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com), as a part of the work assigned by CC3002 Design
and Programming Methodologies college course.
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

# Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Prerequisites

Gradle Build Tool.
Java
JUnit

Recommended: 
- Java 11 or superior.
- JUnit 5.0 or superior.
- IntelliJ IDE.

## Installing

Cloning the repository onto your computer, then opening the project using an IDE that
supports the recommended Java version.

## Running the tests

Executing the gradle build will run the testing process.
On a side note, sometimes the gradle build doesn't execute any of the tests, so executing it only once 
and then running the build again should solve this. This might be related to compatibility issues 
with my personal machine.

# General Summary

The project is built under the Model-View-Controller software arquitecture pattern, also following 
SOLID principles, along with others programming paradigms, containing an exhaustive amount of tests
to ensure a solid, functional result. 

## Model Summary

The model summary will be explained in a "changelog" kind of way, since the work progress is partitioned
through partial homeworks. Additional and required details will be added for a better insight.

### Partial homework #1

The project got started by programming the model. It consists on the characters and the weapons 
they may equip. Those entities are coded in such a hierarchy that allows future extensions without
altering, in a major way, already written code. 

Some of the base code was altered by the student's criteria so it would fit with the SOLID principles 
and other paradigms such as Liskov's Principle.
By example, the ICharacter interface got the equip(IWeapon weapon) and getEquippedWeapon() methods
deleted and transferred to the IPlayerCharacter interface, since only playable characters may
equip weapons. Others such as the Enemy entities can't do it, according to the requested design 
assigned by the project. All the entities got ordered following this hierarchyr:

[Insert UML image]

A short summary of the rest of the work and added features:
- Additional stats such as HP, atk, def, etc., were added to the respective type characters.
- An interface IWeapon, along with an abstract class AbstractWeapon and subsequents concrete
weapons (Axe, Sword, etc.).
- Additional interfaces for the character entities to distinguish them from others, since Enemies
are different from playable characters, and inside those, common characters are different from mage ones.
- An asbtract entity for mages and concrete classes for Black and White Mages, since there aren't "untyped"
mages. Also an interface IMageCharacter associated to them.
- As supposed, PlayerCharacter is enough to associate it with the creation of common-class characters 
instances, since there aren't any specializes treats to program for those classes yet. When a common class
character is instanced, it will have the ICommonCharacter interface implemented, nonetheless it will remain solely
as a placeholder for now. Common class characters will be instanced by their own classes (e.g Knight dodi = new 
Knight(...)) but there shouldn't be a problem (until now) if they are instanced as PlayerCharacter' class, like
it's done on the testing classes. By convention, they will always be instanced, ingame, as its most particular 
instance.

  

### Partial homework #2
The testing process has been initiated. The test classes involved are built over a hierarchy, similar
to the program's model.

Before explaining the testing classes, some important details added to the model:

- Magic Damage stat on the Staff weapon Class.
- Added mana stat to mage characters.
- getDelay() method which returns the delay of a character before acting on its turn, calculated differently
if it's an enemy (uses its own weight) or if it's a playable character (based on its equipped weapon).
- NullWeapon class created, representing an instance of "unequipped" weapon, with 0 attack and 0 weight.
- isPlayableCharacter() method, returns false if it's an instance of enemy, true otherwise. It's used by the
waitTurn() method. It will be also used in future implementations.
- Equals() and hashcode() methods have a more suitable implementation depending on the class, following the
equals(O1) == equals(O2) <=> hashcode(O1) == hashcode(O2) equivalence.

The test classes, as said before, follow a hierarchy too. For characters, it consists on an AbstractCharacterTest
test class that contains the testing methods for the common behavior of all characters, such as waiting for their
turn, the base constructor of the AbstractCharacter class and some other methods detailed on the code.
From this class emerge two testing subclasses, one for testing the Enemy class behavior (its weight, its coconstructor 
and how it waits for its turn); the other class, PlayerCharacterTest, tests the commom behavior of playable characters.
This class acts in a similar way to its super class, and makes use of its inherited methods to test part of the code. By 
the other hand, when checking the constructor, it creates an array to put the three available common-class instances of 
playable characters, then this array is uses by other testing methods to check the program works correctly. 


# Deployment

Downloading/cloning the project and opening it using IntelliJ IDE, then you can run the gradle build to
check the completeness of the tests.

# Versioning

For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

# Authors

* **Ignacio Slater** - *Initial work* - [islaterm](https://github.com/islaterm)
* **Rodrigo G. Oportot** - *Student work* - [dodii](https://github.com/dodii)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

# License

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

