package org.main;

import org.letter.LatexDocument;
import org.letter.LatexDocumentImpl;
import org.letter.ger.Letter;
import org.letter.ger.LetterImpl;
import org.letter.ger.components.*;

public class Main {
    public static void main(String[] args) {
        LatexDocument document = new LatexDocumentImpl();
        Letter letter = new LetterImpl();
        Header header = new HeaderImpl();
        Recipient recipient = new RecipientImpl();
        recipient.setRecipientName("Max Mustermann");
        recipient.setRecipientAddress("Musterstraße 1, 12345 Musterstadt");
        header.setRecipient(recipient);
        Sender sender = new SenderImpl();
        sender.setSenderName("Erika Mustermann");
        sender.setSenderAddress("Musterstraße 2, 12345 Musterstadt");
        header.setSender(sender);
        letter.addComponent(header);
        document.addComponent(letter);
        System.out.println(document.toTex());
    }
}
