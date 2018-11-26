package com.bpleines.app;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

/**
 * Hello world and argument parsing
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArgumentParser parser = ArgumentParsers.newArgumentParser("TestArgumentParser")
            .defaultHelp(true)
            .description("A Test Argument Parser");
        parser.addArgument("string")
            .type(String.class)
            .help("The string that will be printed based on what is supplied");
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
            //System.out.println(ns.get("string"));
        } catch (ArgumentParserException e) {
          parser.handleError(e);
          System.exit(1);
        }
        System.out.println("Done!");
    }
}
