lexer grammar CalcLexer;

ADD         : '+';
SUBTRACT    : '-';
MULTIPLY    : '*';
DIVIDE      : '/';
LPAREN      : '(';
RPAREN      : ')';
DOT         : '.';
WHITESPACE: [ \r\n\t]+ -> skip;

fragment
NonZeroDigit: [1-9];

fragment
Digit: [0-9];

PositiveDoubleLiteral
    :    '0' (DOT Digit+)?
    |    NonZeroDigit Digit* (DOT Digit+)?
    ;

NegativeDoubleLiteral
    :    SUBTRACT '0' DOT Digit+
    |    SUBTRACT NonZeroDigit Digit* (DOT Digit+)?
    ;
