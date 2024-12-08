package org.main;

import org.exceptions.OperationException;
import org.exceptions.OutputException;
import org.letter.LatexDocument;
import org.letter.LatexDocumentImpl;
import org.letter.ger.Letter;
import org.letter.ger.LetterImpl;
import org.letter.ger.components.*;


import java.io.File;
import java.util.Map;

public class FactoryImpl implements Factory {


    /**
     * Builds a letter from the given parameters
     * @return the letter as a string
     */
    @Override
    public String buildLetter(Map<String, String> parameters) {
        try {
            LatexDocument document = new LatexDocumentImpl();
            Letter letter = new LetterImpl();
            Header header = new HeaderImpl();
            Recipient recipient = new RecipientImpl();
            recipient.setRecipientName(parameters.get("recipientName"));
            recipient.setRecipientAddress(parameters.get("recipientAddress"));
            header.setRecipient(recipient);
            Sender sender = new SenderImpl();
            sender.setSenderName(parameters.get("senderName"));
            sender.setSenderAddress(parameters.get("senderAddress"));
            header.setSender(sender);
            Content content = new ContentImpl();
            content.setSubject(parameters.get("subject"));
            content.setOpening(parameters.get("opening"));
            content.addContent(parameters.get("content"));
            content.setClosing(parameters.get("closing"));
            content.setSignature(parameters.get("signature"));
            letter.addComponent(content);
            letter.addComponent(header);
            document.addComponent(letter);
            return document.toTex();
        } catch (NullPointerException e){
            throw new OperationException(
                    "Error while building letter \n",
                    " check if all the parameters are set"
                    +
                    "(recipientName, recipientAddress, senderName, senderAddress)"

            );
        } catch (Exception e){
            throw new OutputException("\nError while building letter \n"
            +e
            );
        }
    }




    @Override
    public boolean latexToPdf(String fileName, String outputDir) {
        try{
            ProcessBuilder processBuilder = new ProcessBuilder("pdflatex", "-output-directory=" + outputDir, fileName);
            processBuilder.directory(new File(outputDir));
            Process process = processBuilder.start();
            process.waitFor();
            return true;
        } catch (Exception e) {
            throw new OutputException("Error while converting latex to pdf");
        }
    }
}
