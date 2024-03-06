package app.ArtistSupplies;

import lombok.Getter;

@Getter
public final class Merch {
    private String name;
    private String description;
    private int price;

    public Merch(final String name,
                 final String description, final int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setPrice(final int price) {
        this.price = price;
    }
}
