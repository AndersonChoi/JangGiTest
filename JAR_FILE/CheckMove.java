package KoreanChessGame;

public class CheckMove
{
  public boolean cheackUnitMove(int[][] board, int position, int[] currentPosition, int[] nextPosition)
  {
    if ((position == 1) || (position == 6))
    {
      if (checkOne(currentPosition, nextPosition))
      {
        if ((nextPosition[0] >= 3) && (nextPosition[0] <= 5))
        {
          if ((nextPosition[1] >= 0) && (nextPosition[1] <= 2)) {
            return true;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    if ((position == 8) || (position == 13))
    {
      if (checkOne(currentPosition, nextPosition))
      {
        if ((nextPosition[0] >= 3) && (nextPosition[0] <= 5))
        {
          if ((nextPosition[1] >= 7) && (nextPosition[1] <= 9)) {
            return true;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    if (position % 7 == 2)
    {
      if (countSomeDiagonal(board, currentPosition, nextPosition, position) == 0) {
        return true;
      }
      if (currentPosition[0] == nextPosition[0])
      {
        if (countSomeRow(board, currentPosition, nextPosition) == 0) {
          return true;
        }
        return false;
      }
      if (currentPosition[1] == nextPosition[1])
      {
        if (countSomeCol(board, currentPosition, nextPosition) == 0) {
          return true;
        }
        return false;
      }
      return false;
    }
    if (position % 7 == 3)
    {
      if (((currentPosition[0] >= 3) && (currentPosition[0] <= 5) && (currentPosition[1] >= 0) && (currentPosition[1] <= 2)) || (
        (currentPosition[0] >= 3) && (currentPosition[0] <= 5) && (currentPosition[1] >= 7) && (currentPosition[1] <= 9) && 
        (checkCenter(board, currentPosition, nextPosition)))) {
        return true;
      }
      if (currentPosition[0] == nextPosition[0])
      {
        if (countSomeRow(board, currentPosition, nextPosition) == 1) {
          return true;
        }
        return false;
      }
      if (currentPosition[1] == nextPosition[1])
      {
        if (countSomeCol(board, currentPosition, nextPosition) == 1) {
          return true;
        }
        return false;
      }
      return false;
    }
    if (position % 7 == 4)
    {
      if (countSomeMa(board, currentPosition, nextPosition) == 0) {
        return true;
      }
      return false;
    }
    if (position % 7 == 5)
    {
      if (countSomeSang(board, currentPosition, nextPosition) == 0) {
        return true;
      }
      return false;
    }
    if (position == 7)
    {
      if ((checkOne(currentPosition, nextPosition)) && 
        (currentPosition[1] - nextPosition[1] <= 0)) {
        return true;
      }
      return false;
    }
    if (position == 14)
    {
      if ((checkOne(currentPosition, nextPosition)) && 
        (currentPosition[1] - nextPosition[1] >= 0)) {
        return true;
      }
      return false;
    }
    return true;
  }
  
  public boolean checkOne(int[] preposition, int[] nowposition)
  {
    if (((nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 0) && (nowposition[1] <= 2)) || (
      (nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 7) && (nowposition[1] <= 9)))
    {
      int a = preposition[0] - nowposition[0];
      int b = preposition[1] - nowposition[1];
      if (a * a + b * b == 2) {
        return true;
      }
      a = preposition[0] - nowposition[0];
      b = preposition[1] - nowposition[1];
      if (a * a + b * b == 1) {
        return true;
      }
      return false;
    }
    int a = preposition[0] - nowposition[0];
    int b = preposition[1] - nowposition[1];
    if (a * a + b * b == 1) {
      return true;
    }
    return false;
  }
  
  public boolean checkCenter(int[][] board, int[] preposition, int[] nowposition)
  {
    int a = preposition[0] - nowposition[0];
    int b = preposition[1] - nowposition[1];
    if ((nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 0) && (nowposition[1] <= 2))
    {
      if ((board[4][1] != 0) && 
        (a * a + b * b == 8)) {
        return true;
      }
    }
    else if ((nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 7) && (nowposition[1] <= 9) && 
      (board[4][8] != 0) && 
      (a * a + b * b == 8)) {
      return true;
    }
    return false;
  }
  
  public int countSomeDiagonal(int[][] board, int[] preposition, int[] nowposition, int mal)
  {
    int count = -1;
    if ((preposition[0] >= 3) && (preposition[0] <= 5) && (preposition[1] >= 0) && (preposition[1] <= 2) && 
      (nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 0) && (nowposition[1] <= 2))
    {
      if ((preposition[0] == 3) && (preposition[1] == 0))
      {
        int i = preposition[0] + 1;
        for (int j = preposition[1] + 1; i <= 5; j++)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i++;
        }
      }
      else if ((preposition[0] == 3) && (preposition[1] == 2))
      {
        int i = preposition[0] + 1;
        for (int j = preposition[1] - 1; i <= 5; j--)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i++;
        }
      }
      else if ((preposition[0] == 5) && (preposition[1] == 0))
      {
        int i = preposition[0] - 1;
        for (int j = preposition[1] + 1; i >= 3; j++)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i--;
        }
      }
      else if ((preposition[0] == 5) && (preposition[1] == 2))
      {
        int i = preposition[0] - 1;
        for (int j = preposition[1] - 1; i >= 3; j--)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i--;
        }
      }
      else if ((preposition[0] == 4) && (preposition[1] == 1))
      {
        if ((board[nowposition[0]][nowposition[1]] == 0) || (board[nowposition[0]][nowposition[1]] / 8 != mal / 8)) {
          return count + 1;
        }
      }
      else
      {
        return 1;
      }
      return 1;
    }
    if ((preposition[0] >= 3) && (preposition[0] <= 5) && (preposition[1] >= 7) && (preposition[1] <= 9) && 
      (nowposition[0] >= 3) && (nowposition[0] <= 5) && (nowposition[1] >= 7) && (nowposition[1] <= 9))
    {
      if ((preposition[0] == 3) && (preposition[1] == 7))
      {
        int i = preposition[0] + 1;
        for (int j = preposition[1] + 1; i <= 5; j++)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i++;
        }
      }
      else if ((preposition[0] == 3) && (preposition[1] == 9))
      {
        int i = preposition[0] + 1;
        for (int j = preposition[1] - 1; i <= 5; j--)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i++;
        }
      }
      else if ((preposition[0] == 5) && (preposition[1] == 7))
      {
        int i = preposition[0] - 1;
        for (int j = preposition[1] + 1; i >= 3; j++)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i--;
        }
      }
      else if ((preposition[0] == 5) && (preposition[1] == 9))
      {
        int i = preposition[0] - 1;
        for (int j = preposition[1] - 1; i >= 3; j--)
        {
          if ((nowposition[0] == i) && (nowposition[1] == j)) {
            return count + 1;
          }
          if (board[i][j] != 0) {
            count++;
          }
          i--;
        }
      }
      else if ((preposition[0] == 4) && (preposition[1] == 8))
      {
        if ((board[nowposition[0]][nowposition[1]] == 0) || (board[nowposition[0]][nowposition[1]] / 8 != mal / 8)) {
          return count + 1;
        }
      }
      else
      {
        return 1;
      }
      return 1;
    }
    return 1;
  }
  
  public int countSomeRow(int[][] board, int[] preposition, int[] nowposition)
  {
    int count = 0;
    if (board[preposition[0]][preposition[1]] == 3) {
      if (preposition[1] <= nowposition[1]) {
        for (int i = preposition[1] + 1; i < nowposition[1]; i++) {
          if (board[preposition[0]][i] % 7 == 3) {
            return 0;
          }
        }
      } else {
        for (int i = preposition[1] - 1; i > nowposition[1]; i--) {
          if (board[preposition[0]][i] % 7 == 3) {
            return 0;
          }
        }
      }
    }
    if (preposition[1] <= nowposition[1]) {
      for (int i = preposition[1] + 1; i < nowposition[1]; i++) {
        if (board[preposition[0]][i] != 0) {
          count++;
        }
      }
    } else {
      for (int i = preposition[1] - 1; i > nowposition[1]; i--) {
        if (board[preposition[0]][i] != 0) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int countSomeCol(int[][] board, int[] preposition, int[] nowposition)
  {
    int count = 0;
    if (board[preposition[0]][preposition[1]] == 3) {
      if (preposition[0] <= nowposition[0]) {
        for (int i = preposition[0] + 1; i < nowposition[0]; i++) {
          if (board[i][preposition[1]] % 7 == 3) {
            return 0;
          }
        }
      } else {
        for (int i = preposition[0] - 1; i > nowposition[0]; i--) {
          if (board[i][preposition[1]] % 7 == 3) {
            return 0;
          }
        }
      }
    }
    if (preposition[0] <= nowposition[0]) {
      for (int i = preposition[0] + 1; i < nowposition[0]; i++) {
        if (board[i][preposition[1]] != 0) {
          count++;
        }
      }
    } else {
      for (int i = preposition[0] - 1; i > nowposition[0]; i--) {
        if (board[i][preposition[1]] != 0) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int countSomeMa(int[][] board, int[] preposition, int[] nowposition)
  {
    if ((nowposition[0] - preposition[0] == 1) && (nowposition[1] - preposition[1] == 2)) {
      return board[preposition[0]][(preposition[1] + 1)];
    }
    if ((nowposition[0] - preposition[0] == -1) && (nowposition[1] - preposition[1] == 2)) {
      return board[preposition[0]][(preposition[1] + 1)];
    }
    if ((nowposition[0] - preposition[0] == -2) && (nowposition[1] - preposition[1] == 1)) {
      return board[(preposition[0] - 1)][preposition[1]];
    }
    if ((nowposition[0] - preposition[0] == -2) && (nowposition[1] - preposition[1] == -1)) {
      return board[(preposition[0] - 1)][preposition[1]];
    }
    if ((nowposition[0] - preposition[0] == -1) && (nowposition[1] - preposition[1] == -2)) {
      return board[preposition[0]][(preposition[1] - 1)];
    }
    if ((nowposition[0] - preposition[0] == 1) && (nowposition[1] - preposition[1] == -2)) {
      return board[preposition[0]][(preposition[1] - 1)];
    }
    if ((nowposition[0] - preposition[0] == 2) && (nowposition[1] - preposition[1] == -1)) {
      return board[(preposition[0] + 1)][preposition[1]];
    }
    if ((nowposition[0] - preposition[0] == 2) && (nowposition[1] - preposition[1] == 1)) {
      return board[(preposition[0] + 1)][preposition[1]];
    }
    return 1;
  }
  
  public int countSomeSang(int[][] board, int[] preposition, int[] nowposition)
  {
    if ((nowposition[0] - preposition[0] == 2) && (nowposition[1] - preposition[1] == 3)) {
      return board[preposition[0]][(preposition[1] + 1)] + board[(preposition[0] + 1)][(preposition[1] + 2)];
    }
    if ((nowposition[0] - preposition[0] == -2) && (nowposition[1] - preposition[1] == 3)) {
      return board[preposition[0]][(preposition[1] + 1)] + board[(preposition[0] - 1)][(preposition[1] + 2)];
    }
    if ((nowposition[0] - preposition[0] == -3) && (nowposition[1] - preposition[1] == 2)) {
      return board[(preposition[0] - 1)][preposition[1]] + board[(preposition[0] - 2)][(preposition[1] + 1)];
    }
    if ((nowposition[0] - preposition[0] == -3) && (nowposition[1] - preposition[1] == -2)) {
      return board[(preposition[0] - 1)][preposition[1]] + board[(preposition[0] - 2)][(preposition[1] - 1)];
    }
    if ((nowposition[0] - preposition[0] == -2) && (nowposition[1] - preposition[1] == -3)) {
      return board[preposition[0]][(preposition[1] - 1)] + board[(preposition[0] - 1)][(preposition[1] - 2)];
    }
    if ((nowposition[0] - preposition[0] == 2) && (nowposition[1] - preposition[1] == -3)) {
      return board[preposition[0]][(preposition[1] - 1)] + board[(preposition[0] + 1)][(preposition[1] - 2)];
    }
    if ((nowposition[0] - preposition[0] == 3) && (nowposition[1] - preposition[1] == -2)) {
      return board[(preposition[0] + 1)][preposition[1]] + board[(preposition[0] + 2)][(preposition[1] - 1)];
    }
    if ((nowposition[0] - preposition[0] == 3) && (nowposition[1] - preposition[1] == 2)) {
      return board[(preposition[0] + 1)][preposition[1]] + board[(preposition[0] + 2)][(preposition[1] + 1)];
    }
    return 1;
  }
}
