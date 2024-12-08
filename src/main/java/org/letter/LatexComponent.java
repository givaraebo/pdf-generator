package org.letter;

import java.util.List;

public interface LatexComponent {

    String toTex();

    String getStart();

    String getEnd();

    void setUpsAddAll(List<String> setUps);

    void importPackagesAddAll(List<String> importPackages);

    void contentAdd(String s);

    void addComponent(LatexComponent component);

    void removeComponent(LatexComponent component);

    List<LatexComponent> getComponents();

    void clearComponents();

    void addImportPackage(String importPackage);

    void removeImportPackage(String importPackage);

    List<String> getImportPackages();

    void clearImportPackages();

    void addSetUp(String setUp);

    void removeSetUp(String setUp);

    List<String> getSetUps();

    void clearSetUps();

    void setContent(String content);

    String getContent();

    void clearContent();

    void appendContent(String content);

    void prependContent(String content);

    void insertContent(int index, String content);

    void removeContent(String content);

    void clear();
}
