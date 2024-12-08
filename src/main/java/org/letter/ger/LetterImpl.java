package org.letter.ger;


import org.letter.LatexComponentImpl;

import java.util.ArrayList;
import java.util.List;

public class LetterImpl extends LatexComponentImpl implements Letter {

    private List<String> importPackages= new ArrayList<>() {{
        add("\\usepackage{fancyhdr}  % Paket für benutzerdefinierte Kopf- und Fußzeilen");
        add("\n");
        add("\\usepackage{lastpage}   % Paket, um die letzte Seite des Dokuments zu ermitteln");
        add("\n");
        add("\\usepackage[ngerman]{babel} % für deutsche Spracheinstellungen");
        add("\n");
        add("\\usepackage[ngerman]{isodate} % 7. Dezember 2024");
    }};

    private List<String> setUps =  new ArrayList<>() {{
        add("\\pagestyle{fancy}  % Aktiviert die Verwendung von fancyhdr");
        add("\n");
        add("\\setlength{\\parindent}{0pt}  % Entfernt die Einrückung für alle Absätze");
        add("\n");
        add("% Remove the horizontal line at the top of the page");
        add("\n");
        add("\\renewcommand{\\headrulewidth}{0pt}");
        add("\n");
        add("\\fancyhf{}");
        add("\n");
        add("\\date{}");
        add("\n");
        add("% Fügt die Seitennummer in jeder Fußzeile rechts ein");
        add("\n");
        add("\\fancyfoot[c]{" + "\n" +
                "    \\begin{tikzpicture}[remember picture, overlay]" + "\n" +
                "        % Seitennummer im unteren rechten Bereich" + "\n" +
                "        \\node[align=right, anchor=south east] at ([xshift=-2cm, yshift=2cm]current page.south east) {" + "\n" +
                "            \\thepage/\\pageref{LastPage}" + "\n" +
                "        };" + "\n" +
                "    \\end{tikzpicture}" + "\n" +
                "}" + "\n"+
                "% Fügt die Seitennummer in jeder Fußzeile rechts ein" + "\n"
        );
    }};


    @Override
    public List<String> getImportPackages() {
        return importPackages;
    }

    @Override
    public List<String> getSetUps() {
        return setUps;
    }

    @Override
    public String getStart() {
        return "\\begin{letter}{}\n";
    }

    @Override
    public String getEnd() {
        return "\\end{letter}\n";
    }




    @Override
    public String toTex() {
        contentAdd(getStart());
        getComponents().reversed().forEach(component -> contentAdd(component.toTex()+"\n"));
        contentAdd(getEnd());
        return getContent();
    }


}
