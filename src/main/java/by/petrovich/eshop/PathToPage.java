package by.petrovich.eshop;

public enum PathToPage {
    HOME_PAGE("home"),
    CATEGORY_PAGE("category"),
    SIGN_IN_PAGE("signin"),
    SIGN_UP_PAGE("signup"),
    PRODUCT_PAGE("product"),
    ERROR_PAGE("error");

    private final String path;

    PathToPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}