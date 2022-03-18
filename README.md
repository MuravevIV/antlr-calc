# ANTLR4 Calculator Example

Custom syntax interpreter (example).

- Spring framework
- CLI - PicoCLI library with built-in help page
- ANTLR4 Lexer and Parser with java code generation
- Interpreter example

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

## ANTLR4 files

- Lexer: [CalcLexer.g4](src/main/antlr4/com/ilyamur/antlrcalc/CalcLexer.g4)
- Parser: [CalcParser.g4](src/main/antlr4/com/ilyamur/antlrcalc/CalcParser.g4)

## Interpreter (visitor)

- Implementation: [CalcParserVisitorImpl.java](src/main/java/com/ilyamur/antlrcalc/parser/CalcParserVisitorImpl.java)
- Tests: [CalcParserVisitorCalculatorTest.java](src/test/java/com/ilyamur/antlrcalc/service/CalcParserVisitorCalculatorTest.java)
