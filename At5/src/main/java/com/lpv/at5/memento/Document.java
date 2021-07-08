/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.memento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor.marcelino
 */
public class Document {
    private String title;
    private IDocumentState state;   
    
    private List<IDocumentState> memento = new ArrayList<IDocumentState>();

    public Document() {
        this.state = DocumentStateDraft.getInstance();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IDocumentState getState() {
        return state;
    }

    public void setState(IDocumentState state) {
        this.state = state;
        this.memento.add(this.state);
    }
    
    public String toDraft(){
        return state.toDraft(this);
    }
    
    public String toModerate(){
        return state.toModerate(this);
    }
    
    public String toPublish(){
        return state.toPublish(this);
    }    
    
    public void resetState(int index) {
        if (index < 0 || index > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.state = this.memento.get(index);
    }
    
    public List<IDocumentState> getStates() {
        return this.memento;
    }
}
