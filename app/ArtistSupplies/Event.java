package app.ArtistSupplies;

import lombok.Getter;

@Getter
public final class Event {
    private String name;
    private String description;
    private final String date;

    public Event(final String name, final String description, final String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
