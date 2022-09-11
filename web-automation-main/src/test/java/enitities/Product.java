package enitities;

public class Product {
    private String productCode;
    private String productPrice;
    private String productColor;
    private String productCount;
    private String productName;

    public String getProductCount() {
        return productCount;
    }
    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }
    public String getProductCode() {
        return productCode;
    }
    public String getProductName(){
        return productName;
    }
    public void  setProductName(){
        this.productName=productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductColor() {
        return productColor;
    }
    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

}
