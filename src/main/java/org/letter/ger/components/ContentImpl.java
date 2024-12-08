package org.letter.ger.components;

import org.letter.LatexComponentImpl;

import java.util.HashMap;

public class ContentImpl extends LatexComponentImpl implements Content {
    private StringBuilder subject = new StringBuilder();
    private StringBuilder opening = new StringBuilder();
    private StringBuilder content = new StringBuilder();
    private StringBuilder closing = new StringBuilder();
    private StringBuilder signature = new StringBuilder();


    public ContentImpl() {

    }

    @Override
    public boolean loadParameters(HashMap<String, String> parameters) {
        setSubject(parameters.get("subject"));
        setOpening(parameters.get("opening"));
        setContent(parameters.get("content"));
        setClosing(parameters.get("closing"));
        return false;
    }


    @Override
    public void setSubject(String subject) {
        this.subject.append("\\setkomavar{subject}{").append(subject).append("}").append("\n");
    }

    @Override
    public String getSubject() {
        return subject.toString();
    }

    @Override
    public String getOpening() {
        return opening.toString();
    }


    @Override
    public String getClosing() {
        return closing.toString();
    }

    @Override
    public void setOpening(String opening) {
        this.opening.append("\\opening{").append(opening).append("}").append("\n");
    }


    @Override
    public void setClosing(String closing) {
        this.closing.append("\\closing{").append(closing).append("}").append("\n");
    }

    @Override
    public void addOpening(String opening) {
        this.opening.append(opening);
    }

    @Override
    public void addContent(String content) {
        this.content.append(content).append("\n");
    }

    @Override
    public String getContent() {
        return content.toString();
    }

    @Override
    public String toTex() {
        super.contentAdd(getSubject());
        super.contentAdd(getOpening());
        super.contentAdd(getContent());
        super.contentAdd(getClosing());
        super.contentAdd(getSignature());
        return super.getContent();
    }


    @Override
    public void setSignature(String signature) {
        this.signature.append("\\signature{").append(signature).append("}").append("\n");
    }

    @Override
    public String getSignature() {
        return signature.toString();
    }



}
