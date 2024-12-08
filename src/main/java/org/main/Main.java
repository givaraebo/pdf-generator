package org.main;

import org.letter.LatexDocument;
import org.letter.LatexDocumentImpl;
import org.letter.ger.Letter;
import org.letter.ger.LetterImpl;
import org.letter.ger.components.*;
import org.utils.FileUtils;
import org.utils.FileUtilsImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("recipientName", "John Doe");
        parameters.put("recipientAddress", "1234 Elm Street");
        parameters.put("senderName", "Jane Smith");
        parameters.put("senderAddress", "5678 Oak Street");
        parameters.put("subject", "Bewerbung als Softwareentwickler");
        parameters.put("opening", "Sehr geehrte Damen und Herren,");
        parameters.put("content", "ich schreibe Ihnen, um mich für die Stelle als Softwareentwickler zu bewerben." +
                "Ich habe einen Master-Abschluss in Informatik und mehrere Jahre Erfahrung in der Softwareentwicklung." +
                "Ich bin sehr motiviert und freue mich darauf, von Ihnen zu hören." +
                "Vielen Dank für Ihre Zeit und Aufmerksamkeit.");
        parameters.put("closing", "Mit freundlichen Grüßen");
        parameters.put("signature", "Jane Smith");
        System.out.println(factory.buildLetter(parameters));

        FileUtils fileUtils = new FileUtilsImpl();
        //fileUtils.getProperties().getOutputDir("latex");
        fileUtils.writeToFile("latex/letter.tex",factory.buildLetter(parameters));

        //factory.latexToPdf("letter.tex", fileUtils.getProperties().getOutputDir("latex"));
    }
}
