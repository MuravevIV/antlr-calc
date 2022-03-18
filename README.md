# ANTLR4 Calculator Example

Custom syntax interpreter (example).

- Spring framework
- CLI - PicoCLI library with built-in help page

## Prerequisites

- Java: openjdk version "11" (or similar)
- Maven: Apache Maven 3.8.3 (or similar)

## Build

```
mvn clean install
```

## CLI Help page 

```
java -jar target/antlr-calc-1.0-SNAPSHOT.jar --help
```

```
Usage: <main class> [-hV] -e=<expression>
  -e, --expression=<expression>
                  Expression
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```

## Execution example

```
java -jar target/antlr-calc-1.0-SNAPSHOT.jar --expression="4 * (2 + 3)"
```
