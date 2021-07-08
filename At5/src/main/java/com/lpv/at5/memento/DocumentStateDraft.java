/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.memento;

/**
 *
 * @author vitor.marcelino
 */
public class DocumentStateDraft implements IDocumentState {
    private DocumentStateDraft() {};
    private static DocumentStateDraft instance = new DocumentStateDraft();
    public static DocumentStateDraft getInstance() {
        return instance;
    }

    @Override
    public String getState() {
        return "Rascunho";
    }

    @Override
    public String toDraft(Document doc) {
        return "Rascunho não realizado";
    }

    @Override
    public String toModerate(Document doc) {
        doc.setState(DocumentStateModeration.getInstance());
        return "Documento em moderação";
    }

    @Override
    public String toPublish(Document doc) {
        return "Publicação não realizada";
    }
}
