package com.ilyamur.antlrcalc.service;

import com.ilyamur.antlrcalc.CalcLexer;
import com.ilyamur.antlrcalc.CalcParser;
import com.ilyamur.antlrcalc.parser.CalcParserVisitorImpl;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

@Service
public class CalcParserVisitorCalculator {

    public Double calculate(String input) {
        CharStream chars = CharStreams.fromString(input);

        Lexer lexer = new CalcLexer(chars);
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new ParseCancellationException(msg, e);
            }
        });
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalcParser parser = new CalcParser(tokens);
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new ParseCancellationException(msg, e);
            }
        });
        ParseTree tree = parser.start();

        CalcParserVisitorImpl calculator = new CalcParserVisitorImpl();
        return calculator.visit(tree);
    }
}
