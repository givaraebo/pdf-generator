package org.letter.ger.components;

import org.letter.LatexComponentImpl;
public class HeaderImpl extends LatexComponentImpl implements Header {
    private Recipient recipient ;
    private Sender sender;



    @Override
    public String getStart() {
        return "\\begin{tikzpicture}[remember picture, overlay]\n";
    }


    @Override
    public String getEnd() {
        return "\\end{tikzpicture}\n";
    }

    @Override
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
        super.addComponent(this.recipient );
    }


    @Override
    public void setSender(Sender sender) {
        this.sender = sender;
        super.addComponent(this.sender );
    }


}
