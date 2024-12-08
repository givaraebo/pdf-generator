package org.letter.ger.components;

import org.letter.LatexComponent;

public interface Header extends LatexComponent {
    void setRecipient(Recipient recipient);

    void setSender(Sender sender);
}
