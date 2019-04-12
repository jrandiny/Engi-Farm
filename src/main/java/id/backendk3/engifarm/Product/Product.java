package id.backendk3.engifarm.Product;

public abstract class Product{

    public enum ProductType {BeefRoladeType,EggBenedictType,MeatzaType,ChickenEggType,CowMeatType,CowMilkType,DuckEggType,GoatMeatType,GoatMilkType,HorseMeatType,RabbitMeatType};

    protected final int harga;
    protected final ProductType type;

    protected Product(ProductType _type, int _harga){
        harga = _harga;
        type = _type;
    }

    public int getHarga(){
        return harga;
    }

    public ProductType getType(){
        return type;
    }

    public boolean equals(Product P){
        return (P.getType()==getType());
    }

}