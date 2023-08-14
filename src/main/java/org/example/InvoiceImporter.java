package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.example.Attributes.*;

public class InvoiceImporter implements Importer {
    private final static String NAME_PREFIX = "Dear ";
    private final static String AMOUNT_PREFIX = "Amount: ";
    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "INVOICE");
        return new Document(attributes);
    }
}
