package id.backendk3.engifarm.product;

/**
 * Kelas abstrak product
 *
 * <p>product adalah barang yang dihasilkan oleh animal yang memiliki nilai jual
 * product dapat berupa farmproduct, product hasil dari farmanimal, atau sideproduct hasil dari pengolahan 2 atau lebih farmproduct
 *
 * @author backendk3
 * @see id.backendk3.engifarm.product.farmproduct
 * @see id.backendk3.engifarm.product.sideproduct
 */
public abstract class Product {

    /**
     * Tipe-tipe product yang mungkin
     */
    public enum ProductType {
        /**
         * Tipe {@link id.backendk3.engifarm.product.sideproduct.BeefRolade}
         */
        BeefRoladeType(0),
        /**
         * Tipe {@link id.backendk3.engifarm.product.sideproduct.EggBenedict}
         */
        EggBenedictType(1),
        /**
         * Tipe {@link id.backendk3.engifarm.product.sideproduct.Meatza}
         */
        MeatzaType(2),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.ChickenEgg}
         */
        ChickenEggType(3),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.CowMeat}
         */
        CowMeatType(4),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.CowMilk}
         */
        CowMilkType(5),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.DuckEgg}
         */
        DuckEggType(6),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.GoatMeat}
         */
        GoatMeatType(7),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.GoatMilk}
         */
        GoatMilkType(8),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.HorseMeat}
         */
        HorseMeatType(9),
        /**
         * Tipe {@link id.backendk3.engifarm.product.farmproduct.RabbitMeat}
         */
        RabbitMeatType(10);

        private final int VALUE;

        ProductType(int value) {
            this.VALUE = value;
        }

        public int getValue() {
            return VALUE;
        }
    }

    /**
     * Atribut konstanta nilai harga jual produk
     */
    private final int HARGA;

    /**
     * Atribut konstanta tipe produk yang membedakan setiap kelas turunan produk
     */
    private final ProductType TYPE;

    /**
     * Konstruktor kelas abstract product
     *
     * @param _type  tipe produk
     * @param _harga harga produk
     */
    protected Product(ProductType _type, int _harga) {
        HARGA = _harga;
        TYPE = _type;
    }

    /**
     * Fungsi yang mengembalikan nilai harga suatu produk
     *
     * @return harga produk
     */
    public int getHarga() {
        return HARGA;
    }

    /**
     * Fungsi yang mengembalikan tipe produk
     *
     * @return tipe produk
     */
    public ProductType getType() {
        return TYPE;
    }

    /**
     * Fungsi yang mengoveride fungsi equals dengan membandingkan tipe produk objek dengan tipe produk objek P
     *
     * @param P Objek yang merupakan produk
     * @return True jika tipe produk objek sama dengan tipe produk objek P
     */
    @Override
    public boolean equals(Object P) {
        if (P == this) {
            return true;
        }
        if (!(P instanceof Product)) {
            return false;
        }
        Product temp = (Product) P;
        return temp.getType() == this.getType();
    }

    /**
     * Fungsi yang mengoveride fungsi hashCode dengan mengembalikan nilai dari suatu method agar dapat digunakan sebagai perbandingan pada fungsi overide equals
     *
     * @return nilai dari suatu method agar dapat digunakan sebagai perbandingan pada fungsi overide equals
     */
    @Override
    public int hashCode() {
        return getType().getValue();
    }

    /**
     * Fungsi abstrak render yang akan menghasilkan string untuk dirender
     *
     * @return string untuk dirender yang merepresentasikan produk
     */
    public abstract String render();
}