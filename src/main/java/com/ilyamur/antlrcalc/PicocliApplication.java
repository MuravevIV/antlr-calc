package com.ilyamur.antlrcalc;

import com.ilyamur.antlrcalc.service.CalcParserVisitorCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import picocli.CommandLine;

@Controller
@CommandLine.Command(version = "1.0.0-SNAPSHOT", mixinStandardHelpOptions = true)
public class PicocliApplication implements Runnable {

    @SuppressWarnings("FieldMayBeFinal")
    @CommandLine.Option(names = {"-e", "--expression"}, required = true, description = "Expression")
    private String expression;

    @Autowired
    private CalcParserVisitorCalculator calculator;

    @Override
    public void run() {
        Double result = calculator.calculate(expression);
        System.out.println(result.toString());
    }
}
