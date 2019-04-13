package id.backendk3.engifarm.Product;

public abstract class Product{

    public enum ProductType{
        BeefRoladeType(0),
        EggBenedictType(1),
        MeatzaType(2),
        ChickenEggType(3),
        CowMeatType(4),
        CowMilkType(5),
        DuckEggType(6),
        GoatMeatType(7),
        GoatMilkType(8),
        HorseMeatType(9),
        RabbitMeatType(10); 
    
        private final int VALUE;
        private ProductType(int value) {
            this.VALUE = value;
        }
    
        public int getValue() {
            return VALUE;
        }
    }

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

    @Override
    public int hashCode(){
        return getType().getValue();
    }

    public abstract String render();
}