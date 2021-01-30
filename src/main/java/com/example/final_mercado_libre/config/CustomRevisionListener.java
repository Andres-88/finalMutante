package com.example.final_mercado_libre.config;

import com.example.final_mercado_libre.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity;
    }
}
