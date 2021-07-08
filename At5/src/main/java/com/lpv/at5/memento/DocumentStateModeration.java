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
public class DocumentStateModeration implements IDocumentState {
    private DocumentStateModeration() {};
    private static DocumentStateModeration instance = new DocumentStateModeration();
    public static DocumentStateModeration getInstance() {
        return instance;
    }

    @Override
    public String getState() {
        return "Moderação";
    }

    @Override
    public String toDraft(Document doc) {
        doc.setState(DocumentStateDraft.getInstance());
        return "Documento em rascunho";
    }

    @Override
    public String toModerate(Document doc) {
        return "Moderação não realizada";
    }

    @Override
    public String toPublish(Document doc) {
        doc.setState(DocumentStatePublication.getInstance());
        return "Documento publicado";
    }
}
