package org.letter.ger.components;


import org.letter.LatexComponent;

public interface Sender extends LatexComponent {

    void setSenderName(String name);

    void setSenderAddress(String address);


    String getSenderName();

    String getSenderAddress();
}
