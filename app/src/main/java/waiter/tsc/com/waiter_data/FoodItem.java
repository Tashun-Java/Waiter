package waiter.tsc.com.waiter_data;

/**
 * Created by ANTIROOKIE on 4/14/2018.
 */

public class FoodItem {
    private String image;
    private String name;
    private String price;

    public FoodItem(){}
    public FoodItem(String name,String image,String price){
        this.image=image;
        this.name=name;
        this.price=price;

    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
