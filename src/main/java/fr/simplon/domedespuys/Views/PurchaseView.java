package fr.simplon.domedespuys.Views;

public class PurchaseView {
    public interface Id {}
    public interface Number {}
    public interface Status {}
    public interface CreatedAt {}
    public interface Address {}
    public interface OrderProducts {}

    public interface PurchaseListView extends Id, Number, Status, CreatedAt, Address {}
    public interface PurchaseDetailView extends
            PurchaseListView,
            OrderProducts,
            OrderProductView.OrderProductListView {}
}