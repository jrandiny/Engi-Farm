package id.backendk3.engifarm.Product;

/**
 * Kelas abstrak Product
 * 
 * <p>Product adalah barang yang dihasilkan oleh animal yang memiliki nilai jual
 * Product dapat berupa FarmProduct, Product hasil dari FarmAnimal, atau SideProduct hasil dari pengolahan 2 atau lebih FarmProduct
 * 
 * @author backendk3
 * @see id.backendk3.engifarm.Product.FarmProduct
 * @see id.backendk3.engifarm.Product.SideProduct
 */
public abstract class Product{

    /**
     * Tipe-tipe Product yang mungkin
     */
    public enum ProductType{
        /** Tipe {@link id.backendk3.engifarm.Product.SideProduct.BeefRolade} */
        BeefRoladeType(0),
        /** Tipe {@link id.backendk3.engifarm.Product.SideProduct.EggBenedict} */
        EggBenedictType(1),
        /** Tipe {@link id.backendk3.engifarm.Product.SideProduct.Meatza} */
        MeatzaType(2),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.ChickenEgg} */
        ChickenEggType(3),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.CowMeat} */
        CowMeatType(4),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.CowMilk} */
        CowMilkType(5),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.DuckEgg} */
        DuckEggType(6),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.GoatMeat} */
        GoatMeatType(7),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.GoatMilk} */
        GoatMilkType(8),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.HorseMeat} */
        HorseMeatType(9),
        /** Tipe {@link id.backendk3.engifarm.Product.FarmProduct.RabbitMeat} */
        RabbitMeatType(10); 
    
        private final int VALUE;
        private ProductType(int value) {
            this.VALUE = value;
        }
    
        public int getValue() {
            return VALUE;
        }
    }

    /**
     * Atribut konstanta nilai harga jual produk
     */
    protected final int HARGA;

    /**
     * Atribut konstanta tipe produk yang membedakan setiap kelas turunan produk
     */
    protected final ProductType TYPE;

    /**
     * Konstruktor kelas abstract Product
     * @param _type tipe produk
     * @param _harga harga produk
     */
    protected Product(ProductType _type, int _harga){
        HARGA = _harga;
        TYPE = _type;
    }

    /**
     * Fungsi yang mengembalikan nilai harga suatu produk
     * @return harga produk
     */
    public int getHarga(){
        return HARGA;
    }

    /**
     * Fungsi yang mengembalikan tipe produk
     * @return tipe produk
     */
    public ProductType getType(){
        return TYPE;
    }

    /**
     * Fungsi yang mengoveride fungsi equals dengan membandingkan tipe produk objek dengan tipe produk objek P
     * @param P Objek yang merupakan produk
     * @return True jika tipe produk objek sama dengan tipe produk objek P
     */
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

    /**
     * Fungsi yang mengoveride fungsi hashCode dengan mengembalikan nilai dari suatu method agar dapat digunakan sebagai perbandingan pada fungsi overide equals
     * @return nilai dari suatu method agar dapat digunakan sebagai perbandingan pada fungsi overide equals
     */
    @Override
    public int hashCode(){
        return getType().getValue();
    }

    /**
     * Fungsi abstrak render yang akan menghasilkan string untuk dirender
     * @return string untuk dirender yang merepresentasikan produk
     */
    public abstract String render();
}