package fr.simplon.domedespuys.Views;

public class UserView {
    public interface Id {}
    public interface Email {}
    public interface Firstname {}
    public interface Lastname {}
    public interface Phone {}
    public interface Role {}
    public interface CreatedAt {}
    public interface Addresses {}
    public interface Purchases {}

    public interface UserListView extends Id, Email, Firstname, Lastname, Phone, Role, CreatedAt {}
    public interface UserDetailView extends
            UserListView,
            Addresses,
            Purchases,
            AddressView.AddressListView,
            PurchaseView.PurchaseListView {}
}