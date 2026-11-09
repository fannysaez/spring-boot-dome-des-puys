package fr.simplon.domedespuys.Views;

public class ProductView {
    public interface Id {}
    public interface Label {}
    public interface Description {}
    public interface Price {}
    public interface Slug {}
    public interface CreatedAt {}
    public interface Images {}
    public interface OrderProducts {}

    public interface ProductListView extends Id, Label, Description, Price, Slug, CreatedAt {}
    public interface ProductDetailView extends
            ProductListView,
            Images,
            OrderProducts,
            ImageView.ImageListView,
            OrderProductView.OrderProductListView {}
}