package org.letter.ger.components;

import org.letter.LatexComponent;

import java.util.HashMap;

public interface Content extends LatexComponent {
    boolean loadParameters(HashMap<String, String> parameters);

    void setSubject(String subject);

    String getSubject();

    String getOpening();

    String getClosing();

    void setOpening(String opening);

    void setClosing(String closing);

    void addOpening(String opening);

    void addContent(String content);
    void setSignature(String signature);

    String getSignature();
}
