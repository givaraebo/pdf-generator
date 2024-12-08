package org.letter.ger.components;


import org.letter.LatexComponentImpl;

public class RecipientImpl extends LatexComponentImpl implements Recipient {
    private String name = "<Name>";
    private String address = "<Adresse>";

    public RecipientImpl(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public RecipientImpl() {

    }

    @Override
    public String toTex() {
        return "% Empfängerdaten\n" +
                "            \\node[align=left, anchor=north west] at ([xshift=2.4cm,yshift=-6.3cm ]current page.north west) {\n" +
                "                \\parbox{6cm}{\n" +
                "                    \\textbf{"+getRecipientName()+"} \\\\\n" +
                "                    \\small {"+getRecipientAddress()+"}\n" +
                "                }\n" +
                "            };";
    }

    @Override
    public void setRecipientName(String name) {
        this.name = name;
    }

    @Override
    public String getRecipientName() {
        return name;
    }

    @Override
    public void setRecipientAddress(String address) {

        this.address = address.replace(",", "\\\\");
    }

    @Override
    public String getRecipientAddress() {
        return address;
    }
}
