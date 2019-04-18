package id.backendk3.engifarm.Cell;

import id.backendk3.engifarm.Sprite;

/**
 * Kelas abstrak Cell
 * 
 * <p>Kelas ini merepresentasikan Cell yaitu sebuah kotak pada peta.
 * Cell dapat berupa tanah atau fasilitas yang direpresentasikan dengan kelas
 * {@link id.backendk3.engifarm.Cell.Land Land} dan {@link id.backendk3.engifarm.Cell.Facility Facility}.
 * 
 * @author backendk3
 * @see id.backendk3.engifarm.Cell.Facility Facility
 * @see id.backendk3.engifarm.Cell.Land Land
 */
public abstract class Cell implements Comparable<Cell>, Sprite{
    /**
     * Tipe-tipe Cell yang mungkin
     */
    public enum CellType{
        /** Tipe {@link id.backendk3.engifarm.Cell.Facility.Mixer} */
        MixerType, 
        /** Tipe {@link id.backendk3.engifarm.Cell.Facility.Truck} */
        TruckType,
        /** Tipe {@link id.backendk3.engifarm.Cell.Facility.Well} */ 
        WellType, 
        /** Tipe {@link id.backendk3.engifarm.Cell.Land.Barn} */
        BarnType, 
        /** Tipe {@link id.backendk3.engifarm.Cell.Land.Coop} */
        CoopType, 
        /** Tipe {@link id.backendk3.engifarm.Cell.Land.GrassLand} */
        GrassLandType 
    }

    /** Lokasi X */
    protected final int X;
    /** Lokasi Y */
    protected final int Y;
    /** Tipe Cell */
    protected final CellType TYPE; 
    /** 
     * Apakah Cell terisi 
     * 
     * <p>Akan bernilai true jika terisi.
     * Jika terisi maka artinya tidak dapat dilewati, karena
     * satu Cell hanya boleh diisi satu objek
     */
    protected boolean occupied;

    /**
     * Konstruktor kelas Cell
     * 
     * @param _x Lokasi X
     * @param _y Lokasi Y
     * @param _type Tipe Cell
     */
    public Cell(int _x,int _y,CellType _type){
        X=_x;
        Y=_y;
        TYPE=_type;
    }

    /**
     * Mengecek apakah sebuah Cell terisi
     * @return True jika terisi
     */
    public boolean isOccupied(){
        return occupied;
    }

    /**
     * Mengembalikan Tipe Cell
     * @return Tipe Cell
     */
    public CellType getType(){
        return TYPE;
    }

    /**
     * Mengembalikan lokasi X
     * @return Lokasi X
     */
    public int getX(){
        return X;
    }

    /**
     * Mengembalikan lokasi Y
     * @return Lokasi Y
     */
    public int getY(){
        return Y;
    }

    /**
     * Membandingkan suatu Cell dengan Cell lain
     * 
     * @param otherCell Cell untuk dibandingkan
     * @return 1 jika sama
     */
    @Override
    public int compareTo(Cell otherCell){
        if(TYPE==otherCell.TYPE){
            return 1;
        }else{
            return 0;
        }
    }
}