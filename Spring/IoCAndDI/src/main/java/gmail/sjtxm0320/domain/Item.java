package gmail.sjtxm0320.domain;

import  lombok.Data;

@Data // getter, setter, toString
public class Item {
    private int itemId;
    private String itemName;
    private int price;
    private String description;
    private String pictureUrl;
}
