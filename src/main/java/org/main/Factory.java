package org.main;

import java.util.Map;

public interface Factory {
    String buildLetter(Map<String, String> parameters);

    boolean latexToPdf(String fileName, String outputDir);
}
