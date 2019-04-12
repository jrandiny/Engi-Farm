package id.backendk3.engifarm;

public class Farm{
    public enum MoveType{
        Up(0),Right(1),Down(2),Left(3),Center(4);

        private final int value;
        private MoveType(int value) {
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }
    }
    public Farm(int width, int height){

    }
    // public void 
}