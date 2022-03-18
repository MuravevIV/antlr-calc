parser grammar CalcParser;

options {
    tokenVocab=CalcLexer;
}

start
    : expression EOF;

expression
   : LPAREN inner=expression RPAREN                                 # Parentheses
   | left=expression operator=(MULTIPLY|DIVIDE) right=expression    # MultiplicationOrDivision
   | left=expression right=NegativeDoubleLiteral                    # AmbiguousSubtraction
   | left=expression operator=(ADD|SUBTRACT) right=expression       # AdditionOrSubtraction
   | PositiveDoubleLiteral                                          # PositiveDoubleNumber
   | NegativeDoubleLiteral                                          # NegativeDoubleNumber
   ;
