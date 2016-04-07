package KoreanChessGame;

import java.io.PrintStream;

public class KoreanChess
{
  final int NULL = 0;
  final int chang = 1;
  final int cha = 2;
  final int pho = 3;
  final int ma = 4;
  final int sang = 5;
  final int sa = 6;
  final int jol = 7;
  final int Rchang = 8;
  final int Rcha = 9;
  final int Rpho = 10;
  final int Rma = 11;
  final int Rsang = 12;
  final int Rsa = 13;
  final int Rjol = 14;
  static int myTurn = 0;
  boolean start = false;
  boolean janggun = false;
  boolean isStart = false;
  CheckMove checkmove = new CheckMove();
  int[][] janggiBoard;
  int[] nextUnitPosition;
  int[] currentUnitPosition;
  
  public KoreanChess()
  {
    this.janggiBoard = init();
  }
  //유닛움직이기 큰 함수
  public PutResult putUnit(int preX, int preY, Unit unit, int postX, int postY)
  {
    PutResult returnValue = PutResult.FAILURE;
    
    this.currentUnitPosition[0] = preX;
    this.currentUnitPosition[1] = preY;
    
    this.nextUnitPosition[0] = postX;
    this.nextUnitPosition[1] = postY;
    
    //이전 포지션, 나중포지션
    
    
    
    if (unit.getNumber() == this.janggiBoard[preX][preY]) {//preXY 즉, 움직이는 곳에 유닛이 있어야 if발동
      if (this.isStart) {//시작햇는지 즉 초기화되었는지확인하는것.
        if (this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] / 8 == myTurn) {
          //my turn이 누구 턴인지 확인하는것..
          if ((this.nextUnitPosition[0] != this.currentUnitPosition[0]) || (this.currentUnitPosition[1] != this.nextUnitPosition[1])) {
            if (this.checkmove.cheackUnitMove(this.janggiBoard, this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]], this.currentUnitPosition, this.nextUnitPosition)) {
              if (this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] == 0)
              {
                this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] = this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]];
                
                this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] = 0;
                checkJang();
                returnValue = PutResult.SUCCESS;
              }
              else if (this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] / 
                8 == this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] / 8)
              {
                returnValue = PutResult.FAILURE;
              }
              else if ((this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] % 7 == 3) && 
                (this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] % 7 == 3))
              {
                returnValue = PutResult.FAILURE;
              }
              else if ((myTurn == 0) && (this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] == 8))
              {
                this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] = this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]];
                this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] = 0;
                this.start = false;
                returnValue = PutResult.GAMEOVER;
              }
              else if ((myTurn == 1) && (this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] == 1))
              {
                this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] = this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]];
                this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] = 0;
                this.start = false;
                returnValue = PutResult.GAMEOVER;
              }
              else
              {
                this.janggiBoard[this.nextUnitPosition[0]][this.nextUnitPosition[1]] = this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]];
                this.janggiBoard[this.currentUnitPosition[0]][this.currentUnitPosition[1]] = 0;
                checkJang();
                returnValue = PutResult.CAPTURE;
              }
            }
          }
        }
      }
    }
    System.out.println("");
    
    return returnValue;
  }
  
  public void showBoard()
  {
    for (int j = 0; j < 10; j++)
    {
      for (int i = 0; i < 9; i++) {
        switch (this.janggiBoard[i][j])
        {
        case 1: 
          System.out.print(String.format("%-10s", new Object[] { "b_jang" }));
          break;
        case 2: 
          System.out.print(String.format("%-10s", new Object[] { "b_cha" }));
          break;
        case 3: 
          System.out.print(String.format("%-11s", new Object[] { "b_po" }));
          break;
        case 4: 
          System.out.print(String.format("%-10s", new Object[] { "b_ma" }));
          break;
        case 5: 
          System.out.print(String.format("%-10s", new Object[] { "b_sang" }));
          break;
        case 6: 
          System.out.print(String.format("%-10s", new Object[] { "b_sa" }));
          break;
        case 7: 
          System.out.print(String.format("%-12s", new Object[] { "b_jol" }));
          break;
        case 8: 
          System.out.print(String.format("%-10s", new Object[] { "r_jang" }));
          break;
        case 9: 
          System.out.print(String.format("%-10s", new Object[] { "r_cha" }));
          break;
        case 10: 
          System.out.print(String.format("%-11s", new Object[] { "r_po" }));
          break;
        case 11: 
          System.out.print(String.format("%-10s", new Object[] { "r_ma" }));
          break;
        case 12: 
          System.out.print(String.format("%-10s", new Object[] { "r_sang" }));
          break;
        case 13: 
          System.out.print(String.format("%-12s", new Object[] { "r_sa" }));
          break;
        case 14: 
          System.out.print(String.format("%-12s", new Object[] { "r_jol" }));
          break;
        default: 
          System.out.print(String.format("%-13.5s", new Object[] { Integer.valueOf(this.janggiBoard[i][j]) }));
        }
      }
      System.out.println("");
    }
    System.out.println(
      "---------------------------------------------------------------------------------------------------------------------------------------------------");
  }
  
  public Unit getUnit(int x, int y)
  {
    Unit unit = Unit.NULL;
    switch (this.janggiBoard[x][y])
    {
    case 1: 
      unit = Unit.BJANG;
      break;
    case 2: 
      unit = Unit.BCHA;
      break;
    case 3: 
      unit = Unit.BPHO;
      break;
    case 4: 
      unit = Unit.BMA;
      break;
    case 5: 
      unit = Unit.BSANG;
      break;
    case 6: 
      unit = Unit.BSA;
      break;
    case 7: 
      unit = Unit.BJOL;
      break;
    case 8: 
      unit = Unit.RJANG;
      break;
    case 9: 
      unit = Unit.RCHA;
      break;
    case 10: 
      unit = Unit.RPHO;
      break;
    case 11: 
      unit = Unit.RMA;
      break;
    case 12: 
      unit = Unit.RSANG;
      break;
    case 13: 
      unit = Unit.RSA;
      break;
    case 14: 
      unit = Unit.RJOL;
      break;
    default: 
      unit = Unit.NULL;
    }
    return unit;
  }
  
  private int[][] init()
  {
    int[][] Janggipan = { { 2, 0, 0, 7, 0, 0, 14, 0, 0, 9 }, 
      { 5, 0, 3, 0, 0, 0, 0, 10, 0, 11 }, 
      { 4, 0, 0, 7, 0, 0, 14, 0, 0, 12 }, 
      { 6, 0, 0, 0, 0, 0, 0, 0, 0, 13 }, 
      { 0, 1, 0, 7, 0, 0, 14, 0, 8 }, 
      { 6, 0, 0, 0, 0, 0, 0, 0, 0, 13 }, 
      { 5, 0, 0, 7, 0, 0, 14, 0, 0, 12 }, 
      { 4, 0, 3, 0, 0, 0, 0, 10, 0, 11 }, 
      { 2, 0, 0, 7, 0, 0, 14, 0, 0, 9 } };
    
    this.currentUnitPosition = new int[2];
    this.nextUnitPosition = new int[2];
    
    this.isStart = true;
    
    return Janggipan;
  }
  
  private void checkJang()
  {
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 10; j++)
      {
        if (this.janggiBoard[i][j] == 8)
        {
          this.nextUnitPosition[0] = i;
          this.nextUnitPosition[1] = j;
          this.janggun = true;
        }
        if (this.janggun) {
          break;
        }
      }
      if (this.janggun) {
        break;
      }
    }
    //넥스트 유닛 포지션이 
    
    
    this.janggun = false;
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 10; j++)
      {
        if ((this.janggiBoard[i][j] / 8 == 0) && (this.janggiBoard[i][j] != 0))
        {
          this.currentUnitPosition[0] = i;
          this.currentUnitPosition[1] = j;
          if (this.checkmove.cheackUnitMove(this.janggiBoard, this.janggiBoard[i][j], this.currentUnitPosition, this.nextUnitPosition))
          {
            System.out.println("JangGun !!");
            this.janggun = true;
          }
        }
        if (this.janggun) {
          break;
        }
      }
      if (this.janggun) {
        break;
      }
    }
    this.janggun = false;
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 10; j++)
      {
        if (this.janggiBoard[i][j] == 1)
        {
          this.nextUnitPosition[0] = i;
          this.nextUnitPosition[1] = j;
          this.janggun = true;
        }
        if (this.janggun) {
          break;
        }
      }
      if (this.janggun) {
        break;
      }
    }
    this.janggun = false;
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 10; j++)
      {
        if (this.janggiBoard[i][j] / 8 == 1)
        {
          this.currentUnitPosition[0] = i;
          this.currentUnitPosition[1] = j;
          if (this.checkmove.cheackUnitMove(this.janggiBoard, this.janggiBoard[i][j], this.currentUnitPosition, this.nextUnitPosition))
          {
            System.out.println("JangGun !!");
            this.janggun = true;
          }
        }
        if (this.janggun) {
          break;
        }
      }
      if (this.janggun) {
        break;
      }
    }
    this.janggun = false;
    if (myTurn == 0) {
      myTurn = 1;
    } else {
      myTurn = 0;
    }
  }
}
