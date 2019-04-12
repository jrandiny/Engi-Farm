package id.backendk3.engifarm.Product;

public abstract class Product{

    public enum ProductType {BeefRoladeType,EggBenedictType,MeatzaType,ChickenEggType,CowMeatType,CowMilkType,DuckEggType,GoatMeatType,GoatMilkType,HorseMeatType,RabbitMeatType};

    protected final int HARGA;
    protected final ProductType TYPE;

    protected Product(ProductType _type, int _harga){
        HARGA = _harga;
        TYPE = _type;
    }

    public int getHarga(){
        return HARGA;
    }

    public ProductType getType(){
        return TYPE;
    }

    @Override
    public boolean equals(Object P){
        if (P == this) {
            return true;
        }
        if (!(P instanceof Product)) {
            return false;
        }
        Product temp = (Product)P;
        return temp.getType() == this.getType();
    }
}