package fr.simplon.domedespuys.Views;

public class OrderProductView {
    public interface Id {}
    public interface Quantity {}
    public interface Price {}
    public interface Purchase {}
    public interface Product {}

    public interface OrderProductListView extends Id, Quantity, Price {}
    public interface OrderProductDetailView extends
            OrderProductListView,
            Purchase,
            Product,
            ProductView.ProductListView,
            PurchaseView.PurchaseListView {}
}