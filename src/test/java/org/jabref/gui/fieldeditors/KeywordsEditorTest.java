package org.jabref.gui.edit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.jabref.gui.autocompleter.SuggestionProvider;
import org.jabref.gui.fieldeditors.KeywordsEditor;
import org.jabref.gui.fieldeditors.KeywordsEditorViewModel;
import org.jabref.logic.integrity.FieldCheckers;
import org.jabref.model.entry.Keyword;
import org.jabref.model.entry.field.StandardField;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class KeywordsEditorViewModelTest {

    private KeywordsEditorViewModel keywordsEditorViewModel;

    private final SuggestionProvider<?> suggestionProvider = mock(SuggestionProvider.class);
    private final FieldCheckers fieldCheckers = mock(FieldCheckers.class);

    @BeforeEach
    void setUp() {
        KeywordsEditor keywordsEditor = new KeywordsEditor(StandardField.KEYWORDS, suggestionProvider,
                fieldCheckers);

    }

    @Test
    void keywordsFilledInCorrectly() {
        ObservableList<Keyword> addedKeywords = keywordsEditorViewModel.keywordListProperty();
        List<Keyword> expectedKeywordsList = Arrays.asList(
                new Keyword("Chatbot"),
                new Keyword("Medical services"),
                new Keyword("Machine Learning"),
                new Keyword("Automation")
        );

        assertEquals(FXCollections.observableList(expectedKeywordsList), addedKeywords);
    }
}
