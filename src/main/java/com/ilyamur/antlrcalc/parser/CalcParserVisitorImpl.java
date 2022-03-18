package com.ilyamur.antlrcalc.parser;

import com.ilyamur.antlrcalc.CalcParser;
import com.ilyamur.antlrcalc.CalcParserBaseVisitor;

public class CalcParserVisitorImpl extends CalcParserBaseVisitor<Double> {

    @Override
    public Double visitPositiveDoubleNumber(CalcParser.PositiveDoubleNumberContext ctx) {
        return Double.parseDouble(ctx.PositiveDoubleLiteral().getText());
    }

    @Override
    public Double visitNegativeDoubleNumber(CalcParser.NegativeDoubleNumberContext ctx) {
        return Double.parseDouble(ctx.NegativeDoubleLiteral().getText());
    }

    @Override
    public Double visitParentheses(CalcParser.ParenthesesContext ctx) {
        return visit(ctx.inner);
    }

    @Override
    public Double visitMultiplicationOrDivision(CalcParser.MultiplicationOrDivisionContext ctx) {
        if (ctx.operator.getText().equals("*")) {
            return visit(ctx.left) * visit(ctx.right);
        } else {
            return visit(ctx.left) / visit(ctx.right);
        }
    }

    @Override
    public Double visitAdditionOrSubtraction(CalcParser.AdditionOrSubtractionContext ctx) {
        if (ctx.operator.getText().equals("+")) {
            return visit(ctx.left) + visit(ctx.right);
        } else {
            return visit(ctx.left) - visit(ctx.right);
        }
    }

    @Override
    public Double visitAmbiguousSubtraction(CalcParser.AmbiguousSubtractionContext ctx) {
        return visit(ctx.left) + Double.parseDouble(ctx.right.getText());
    }

    @Override
    protected Double defaultResult() {
        return 0.0;
    }

    @Override
    protected Double aggregateResult(Double aggregate, Double nextResult) {
        return aggregate + nextResult;
    }
}
