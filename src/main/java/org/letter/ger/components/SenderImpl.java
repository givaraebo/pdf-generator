package org.letter.ger.components;


import org.letter.LatexComponentImpl;

public class SenderImpl extends LatexComponentImpl implements Sender {
    private String name = "Max Mustermann";
    private String address = "Musterstraße 1, 12345 Musterstadt";
    private String department = "Musterabteilung";
    private String phone = "0123/456789";
    private String email = "";
    private String internet = "";
    private String date = "\\today";

    public SenderImpl() {
    }

    @Override
    public void setSenderName(String name) {
        this.name = name;
    }

    @Override
    public void setSenderAddress(String address) {
        this.address = address;
    }

    @Override
    public String getSenderName() {
        return name;
    }

    @Override
    public String getSenderAddress() {
        return address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toTex() {
        String tex =
            "% Absenderdetails links\n" +
            "\\node[align=left, anchor=north west] at ([xshift=11cm,yshift=-5cm ]current page.north west) {\n" +
            "    % Briefkopf (rechtsbündig, wie in deinem Beispiel)\n" +
            "    {\\fontsize{8}{12}\\selectfont\n" +
            "    \\begin{tabular}{@{}p{3.3cm}p{8cm}@{}}\n" +
            "        \\textbf{Name} & "+getName()+" \\\\\n" +
            "        \\textbf{Abteilung:} & "+getDepartment()+" \\\\\n" +
            "        \\textbf{Telefon:} & "+getPhone()+" \\\\\n" +
            "        \\textbf{E-Mail:} & "+getEmail()+" \\\\\n" +
            "        \\textbf{Internet:} & "+getInternet()+" \\\\\n" +
            "        \\textbf{Datum:} & "+getDate()+" \\\\\n" +
            "    \\end{tabular}\n" +
            "    }\n" +
            "};";
        return tex;
    }
}
