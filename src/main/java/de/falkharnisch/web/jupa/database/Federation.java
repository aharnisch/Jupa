package de.falkharnisch.web.jupa.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for holding the federation.
 */

@Entity
public class Federation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int displayId;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + displayId + ")";
    }
}
