# Enigma

Translate a name to klingon.

**_All the tasks given with the document regarding this coding challange is fulfilled._**

## Requirements

* [**java**](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) = JDK 1.8_181 
* [**maven**](https://maven.apache.org/download.html) >= v3.5 Package Manager
* [**Git**](https://git-scm.com) Source Control

_IDE's, particularly **NetBeans** have excellent Maven integration._


## Setup

The project can be run this way:

```bash
$ git clone https://github.com/jexiaprogrammingchallenge/enigma.git
$ cd enigma
$ mvn package
$ chmod +x transcribe
```

## Usage

Any parameter passed to transcribe is going to be considered a Star Trek character name. My program will generate hexedecimal transcription of the given name and the species of the character.

```bash
$ ./transcribe Nyota Uhura
0xF8DB 0xF8E8 0xF8DD 0xF8E3 0xF8D0 0x0020 0xF8E5 0xF8D6 0xF8E5 0xF8E1 0xF8D0
Human
```

## Output Examples

### Valid Name

This command has a valid name and the species was found. Be careful with the Klingon names though as they may contain **'** character which is a valid Klingon symbol.

```bash
$ ./transcribe "B'Elanna Torres"
0xF8D1 0xF8E9 0xF8D4 0xF8D9 0xF8D0 0xF8DB 0xF8DB 0xF8D0 0x0020 0xF8E3 0xF8DD 0xF8E1 0xF8E1 0xF8D4 0xF8E2
Klingon
```

### Invalid Name

This command has a name that is not translatable.

```bash
$ ./transcribe Kaalbahad
Kaalbahad contains illegal characters, program exiting...
```

### The species is not found

This command has a name translatable, but the species was not found.

```bash
$ ./transcribe Chatlhng
0xF8D2 0xF8D0 0xF8E4 0xF8DC
Species is not found.

```

## Tests

All the tests written are run automaticly by maven when the project is building.

The tests can be found at :

```
enigma/src/test/java/com/challenge/enigma/
```