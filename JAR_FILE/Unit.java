package KoreanChessGame;

public enum Unit
{
  NULL(0),  BJANG(1),  BCHA(2),  BPHO(3),  BMA(4),  BSANG(5),  BSA(6),  BJOL(7),  RJANG(8),  RCHA(9),  RPHO(10),  RMA(11),  RSANG(12),  RSA(13),  RJOL(14);
  
  private int number;
  
  private Unit(int number)
  {
    this.number = number;
  }
  
  public int getNumber()
  {
    return this.number;
  }
}
