package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.farmanimal.FarmAnimal;
import id.backendk3.engifarm.product.Product;
import id.backendk3.engifarm.product.sideproduct.BeefRolade;
import id.backendk3.engifarm.product.sideproduct.EggBenedict;
import id.backendk3.engifarm.product.sideproduct.Meatza;
import id.backendk3.engifarm.product.sideproduct.SideProduct;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Kelas riil
 *
 * <p>Player adalah objek yang digunakan pemain sebagai karakter utama
 *
 * @author backendk3
 */
public class Player extends Observable implements Sprite {
    private static class Resep {
        public static SideProduct getRecipe(Product.ProductType id) {
            if (id == Product.ProductType.EggBenedictType) {
                return new EggBenedict();
            } else if (id == Product.ProductType.MeatzaType) {
                return new Meatza();
            } else if (id == Product.ProductType.BeefRoladeType) {
                return new BeefRolade();
            } else {
                throw new RuntimeException("Enum Not Found");
            }
        }
    }

    private final int MAX_WATER = 50;
    private final int MAX_ITEM_BAG = 10;
    private int itemCount;
    private Map<Product, Integer> bag;
    private int water;
    private int money;
    private int posX;
    private int posY;
    private Farm.MoveType direction;

    private Player() {
    }

    /**
     * Konstruktor kelas Player
     *
     * @param water     Jumlah air awal
     * @param money     Jumlah uang awal
     * @param posX      Lokasi X awal
     * @param posY      Lokasi Y awal
     * @param direction Arah awal Player menghadap
     */
    public Player(int water, int money, int posX, int posY, Farm.MoveType direction) {
        this.water = water;
        this.money = money;
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        itemCount = 0;
        bag = new HashMap<Product, Integer>();
    }

    /**
     * Mengembalikan bag Player
     */
    public Map<Product, Integer> getBag() {
        return bag;
    }

    /**
     * Menambahkan product ke dalam bag
     *
     * @param p product yang ingin ditambahkan
     * @see id.backendk3.engifarm.product.Product
     */
    public void addBag(Product p) {
        if (itemCount < MAX_ITEM_BAG) {
            if (bag.containsKey(p)) {
                Integer tempCount = bag.get(p);
                bag.replace(p, ++tempCount);
            } else {
                bag.put(p, 1);
            }
            setChanged();
            notifyObservers();
            itemCount++;
        } else {
            throw new RuntimeException("Bag is full");
        }
    }

    /**
     * Mengembalikan jumlah air yang dimiliki Player
     *
     * @return Jumlah air
     */
    public int getWater() {
        return water;
    }

    /**
     * Mengembalikan jumlah uang yang dimiliki Player
     *
     * @return Jumlah uang
     */
    public int getMoney() {
        return money;
    }

    /**
     * Mengembalikan posX
     *
     * @return Lokasi X Player
     */
    public int getX() {
        return posX;
    }

    /**
     * Mengembalikan posY
     *
     * @return Lokasi Y Player
     */
    public int getY() {
        return posY;
    }

    /**
     * Mengembalikan direction
     *
     * @return Arah Player
     */
    public Farm.MoveType getDirection() {
        return direction;
    }

    /**
     * Memindahkan posisi Player
     *
     * <p>Mengubah posX dan posY tergantung input arah
     *
     * @param arah Arah gerak Player
     * @param surr cell sekitar Player
     */
    public void move(Farm.MoveType arah, Cell[] surr) {
        boolean move = false;
        if (!surr[arah.getValue()].isOccupied()) {
            switch (arah) {
                case Up:
                    if (surr[Farm.MoveType.Up.getValue()] != null && !surr[Farm.MoveType.Up.getValue()].isOccupied()) {
                        posY--;
                        move = true;
                        ((Land) surr[Farm.MoveType.Up.getValue()]).occupy();
                    }
                    break;
                case Right:
                    if (surr[Farm.MoveType.Right.getValue()] != null && !surr[Farm.MoveType.Right.getValue()].isOccupied()) {
                        posX++;
                        move = true;
                        ((Land) surr[Farm.MoveType.Right.getValue()]).occupy();
                    }
                    break;
                case Down:
                    if (surr[Farm.MoveType.Down.getValue()] != null && !surr[Farm.MoveType.Down.getValue()].isOccupied()) {
                        posY++;
                        move = true;
                        ((Land) surr[Farm.MoveType.Down.getValue()]).occupy();
                    }
                    break;
                case Left:
                    if (surr[Farm.MoveType.Left.getValue()] != null && !surr[Farm.MoveType.Left.getValue()].isOccupied()) {
                        posX--;
                        move = true;
                        ((Land) surr[Farm.MoveType.Left.getValue()]).occupy();
                    }
                    break;
                default:
                    break;
            }
        }

        if (!move) {
            if (direction == arah) {
                throw new RuntimeException("You can't move any further");
            }
        } else {
            ((Land) surr[Farm.MoveType.Center.getValue()]).unoccupy();
        }
        direction = arah;

        setChanged();
        notifyObservers();
    }

    /**
     * Berbicara dengan hewan
     *
     * <p>berbicara dengan hewan dengan memanggil
     * speak pada farmanimal
     *
     * @param hewan Hewan yang diajak bicara
     * @return Suara hewan yang di talk
     * @see id.backendk3.engifarm.farmanimal.FarmAnimal
     */
    public String talk(FarmAnimal hewan) {
        return hewan.speak();
    }

    /**
     * Berinteraksi dengan farmanimal
     *
     * <p>interaksi dengan hewan di Coop menghasilkan egg
     * <p>interaksi dengan hewan di GrassLand menghasilkan milk
     *
     * @param hewan Hewan yang diinteraksikan
     * @see id.backendk3.engifarm.farmanimal.FarmAnimal
     */
    public void interact(FarmAnimal hewan) {
        if (hewan.getHaveProduct() && hewan.getHabitat() != Cell.CellType.BarnType) {
            addBag(hewan.getProduct());
        } else {
            throw new RuntimeException("Can't interact with animal");
        }
    }

    /**
     * Berinteraksi dengan Fasilitas (Well)
     *
     * <p> interaksi dengan Well mengisi water hingga penuh
     *
     * @param w Objek Well yang diambil airnya
     * @see id.backendk3.engifarm.cell.facility.Well
     */
    public void interact(Well w) {
        if (w.isUsable()) {
            if (water < MAX_WATER) {
                water = MAX_WATER;
                setChanged();
                notifyObservers();
            } else {
                throw new RuntimeException("Watering can is full");
            }
        } else {
            throw new RuntimeException("Well is not useable");
        }
    }

    /**
     * Berinteraksi dengan Fasilitas (Truck)
     *
     * <p>interaksi dengan Truck mengosongkan bag dan mendapat money
     * dan menjadikan Truck tidak bisa digunakan untuk beberapa saat
     *
     * @param truck Truck yang akan digunakan untuk menjual product
     * @see id.backendk3.engifarm.cell.facility.Truck
     */
    public void interact(Truck truck) {
        if (truck.isUsable()) {
            if (itemCount > 0) {
                for (Map.Entry<Product, Integer> entry : bag.entrySet()) {
                    money += entry.getValue() * (entry.getKey().getHarga());
                }
                bag.clear();
                setChanged();
                notifyObservers();

                truck.use(15);
                itemCount = 0;
            } else {
                throw new RuntimeException("No product to sell");
            }
        } else {
            throw new RuntimeException("Truck is currently unusable");
        }
    }

    /**
     * Membunuh hewan untuk diambil dagingnya
     *
     * <p>dilakukan untuk mengambil meat dari farmanimal
     * hewan langsung dianggap mati
     *
     * @param hewan Hewan yang akan disembelih
     * @see id.backendk3.engifarm.farmanimal.FarmAnimal
     */
    public void kill(FarmAnimal hewan) {
        if (hewan.getHabitat() == Cell.CellType.BarnType && !hewan.getDeathStatus()) {
            addBag(hewan.getProduct());
            hewan.setDeathStatus(true);
        } else {
            throw new RuntimeException("Can't kill animal");
        }
    }

    /**
     * Menyiram land tempat Player berdiri
     *
     * @param l land yang akan disiram
     * @see id.backendk3.engifarm.cell.land.Land
     */
    public void grow(Land l) {
        if (water > 0) {
            if (!l.haveGrass()) {
                l.addGrass();
                water--;
                setChanged();
                notifyObservers();
            } else {
                throw new RuntimeException("land already have grass");
            }
        } else {
            throw new RuntimeException("Watering can is empty");
        }
    }

    /**
     * Membuat sideproduct
     *
     * <p> digunakan pada Mixer dan menghasilkan sideproduct
     *
     * @param id Enum dari sideproduct yang akan dibuat
     * @see id.backendk3.engifarm.product.Product
     * @see id.backendk3.engifarm.product.sideproduct.SideProduct
     * @see id.backendk3.engifarm.cell.facility.Mixer
     */
    public void mix(Product.ProductType id) {
        if (itemCount < MAX_ITEM_BAG) {
            SideProduct sp;
            try {
                sp = Resep.getRecipe(id);
            } catch (RuntimeException e) {
                throw e;
            }
            MyLinkedList<Product> resep = sp.getRecipe();
            int i = 0;
            boolean same = true;
            while (same && i < resep.size()) {
                same = bag.containsKey(resep.get(i));
                i++;
            }

            if (same) {
                for (int j = 0; j < i; j++) {
                    Product tempProduct = resep.get(j);
                    int count = bag.get(tempProduct);
                    if (count == 1) {
                        bag.remove(tempProduct);
                    } else {
                        bag.replace(tempProduct, count - 1);
                    }
                }
                addBag(sp);
            } else {
                throw new RuntimeException("Item in bag are not enough to make " + sp.render());
            }
        } else {
            throw new RuntimeException("Bag is full");
        }
    }

    /**
     * Mengembalikan warna background untuk Player
     *
     * @return null karena mengikuti BG land yang ada
     */
    public Color getBGColor() {
        return null;
    }

    /**
     * Mengembalikan sprite untuk Player
     *
     * @return Gambar sprite tergantung arah Player
     */
    public Image getSprite() throws IOException {
        return ImageIO.read(getClass().getClassLoader().getResource("sprites/player/" + direction.getValue() + ".png"));
    }


}