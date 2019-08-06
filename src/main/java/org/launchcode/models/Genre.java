package org.launchcode.models;

public enum Genre {

    ADVENTURE ("Adventure"),
    AUTOBIOGRAPHY ("Autobiography"),
    BIOGRAPHY ("Biography"),
    FANTASY ("Fantasy"),
    HISTORICALFICTION ("Historical Fiction"),
    INFORMATIONAL ("Informational"),
    MYSTERY ("Mystery"),
    NONFICTION ("Non-Fiction"),
    POETRY ("Poetry"),
    SCIFI ("Sci-Fi"),
    REALISTICFICTION ("Realistic Fiction");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
