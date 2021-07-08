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
public class DocumentStatePublication implements IDocumentState {
     private DocumentStatePublication() {};
    private static DocumentStatePublication instance = new DocumentStatePublication();
    public static DocumentStatePublication getInstance() {
        return instance;
    }

    @Override
    public String getState() {
        return "Publicado";
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
        return "Publicação não realizada";
    }
}
