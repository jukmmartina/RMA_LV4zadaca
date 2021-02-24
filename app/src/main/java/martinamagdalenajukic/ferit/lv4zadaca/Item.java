package martinamagdalenajukic.ferit.lv4zadaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("image_link")
    @Expose
    private String imageLink;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private String rating;

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
