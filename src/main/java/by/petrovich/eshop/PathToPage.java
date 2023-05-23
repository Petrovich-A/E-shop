package by.petrovich.eshop;

public enum PathToPage {
    HOME_PAGE("home"),
    CATEGORY_PAGE("category"),
    ERROR_PAGE("error"),
    PRODUCT_PAGE("product");

    private final String path;

    PathToPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
