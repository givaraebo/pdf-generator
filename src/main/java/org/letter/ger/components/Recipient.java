package org.letter.ger.components;

import org.letter.LatexComponent;
public interface Recipient extends LatexComponent {

    void setRecipientName(String maxMustermann);

    String getRecipientName();

    void setRecipientAddress(String address);

    String getRecipientAddress();
}
