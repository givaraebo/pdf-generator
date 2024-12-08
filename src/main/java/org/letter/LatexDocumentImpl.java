package org.letter;

import java.util.ArrayList;
import java.util.List;


public class LatexDocumentImpl extends LatexComponentImpl implements LatexDocument {
    protected List<String> importPackages = new ArrayList<>() {{
        add("\\documentclass[11pt]{scrlttr2}");
        add("\n");
        add("\\usepackage{tikz}");
        add("\n");
        add("\\usepackage{graphicx}");
        add("\n");
        add("\\usepackage{geometry}");
        add("\n");
    }};
    protected List<String> setUps = new ArrayList<>() {{
        add("% Anpassung der Seitenränder");
        add("\n");
        add("\\geometry{left=2.5cm, right=1.5cm, top=1.69cm, bottom=3cm}");
        add("\n");
    }};

    @Override
    public List<String> getImportPackages() {
        importPackages.addAll(super.getImportPackages());
        return importPackages;
    }

    @Override
    public List<String> getSetUps() {
        setUps.addAll(super.getSetUps());
        return setUps;
    }





}
