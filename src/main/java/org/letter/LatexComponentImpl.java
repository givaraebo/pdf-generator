package org.letter;

import java.util.ArrayList;
import java.util.List;

public abstract class LatexComponentImpl implements LatexComponent {
    protected List<String> importPackages = new ArrayList<>();
    protected List<String> setUps = new ArrayList<>();
    protected StringBuilder content = new StringBuilder();
    protected List<LatexComponent> components = new ArrayList<>();
    public void LatexDocumentImpl() {
    }

    @Override
    public String toTex() {
        getComponents().forEach(component -> importPackagesAddAll(component.getImportPackages()));
        getImportPackages().forEach(this::contentAdd);
        getComponents().forEach(component -> setUpsAddAll(component.getSetUps()));
        getSetUps().forEach(this::contentAdd);
        contentAdd(getStart());
        getComponents().forEach(component -> contentAdd(component.toTex()+"\n"));
        contentAdd(getEnd());
        return getContent();
    }

    @Override
    public String getStart() {
        return "\\begin{document}\n";
    }

    @Override
    public String getEnd() {
        return "\\end{document}\n";
    }

    @Override
    public void setUpsAddAll(List<String> setUps) {
        setUps.forEach(this::addSetUp);
    }

    @Override
    public void importPackagesAddAll(List<String> importPackages) {
        importPackages.forEach(this::addImportPackage);
    }

    @Override
    public void contentAdd(String s) {
        content.append(s);
    }

    @Override
    public void addComponent(LatexComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(LatexComponent component) {
        components.remove(component);
    }

    @Override
    public List<LatexComponent> getComponents() {
        return components;
    }

    @Override
    public void clearComponents() {
        components.clear();
    }

    @Override
    public void addImportPackage(String importPackage) {
        importPackages.add(importPackage);
    }

    @Override
    public void removeImportPackage(String importPackage) {
        importPackages.remove(importPackage);
    }

    @Override
    public List<String> getImportPackages() {
        return importPackages;
    }

    @Override
    public void clearImportPackages() {
        importPackages.clear();
    }

    @Override
    public void addSetUp(String setUp) {
        setUps.add(setUp);
    }

    @Override
    public void removeSetUp(String setUp) {
        setUps.remove(setUp);
    }

    @Override
    public List<String> getSetUps() {
        return setUps;
    }

    @Override
    public void clearSetUps() {
        setUps.clear();
    }

    @Override
    public void setContent(String content) {
        this.content = new StringBuilder(content);
    }

    @Override
    public String getContent() {
        return content.toString();
    }

    @Override
    public void clearContent() {
        content = new StringBuilder();
    }

    @Override
    public void appendContent(String content) {
        this.content.append(content);
    }

    @Override
    public void prependContent(String content) {
        this.content.insert(0, content);
    }

    @Override
    public void insertContent(int index, String content) {
        this.content.insert(index, content);
    }

    @Override
    public void removeContent(String content) {
        this.content = new StringBuilder(this.content.toString().replace(content, ""));
    }
    @Override
    public void clear() {
        importPackages.clear();
        setUps.clear();
        components.clear();
        content = new StringBuilder();
    }

}
