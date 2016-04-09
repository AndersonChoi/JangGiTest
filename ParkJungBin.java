import static org.junit.Assert.*;

import org.junit.Test;

import KoreanChessGame.KoreanChess;
import KoreanChessGame.PutResult;
import KoreanChessGame.Unit;

public class ParkJungBin_201124446 {
	/**
	 * Input: KoreanChessConstructor
	 * Expected: Board Initial Setting
	 */
	@Test
	public void testConstructor() {
		KoreanChess JangGi = new KoreanChess();
		assertEquals(Unit.BCHA, JangGi.getUnit(0,0));
		assertEquals(Unit.BSANG, JangGi.getUnit(1,0));
		assertEquals(Unit.BMA, JangGi.getUnit(2,0));
		assertEquals(Unit.BSA, JangGi.getUnit(3,0));
		assertEquals(Unit.BSA, JangGi.getUnit(5,0));
		assertEquals(Unit.BSANG, JangGi.getUnit(6,0));
		assertEquals(Unit.BMA, JangGi.getUnit(7,0));
		assertEquals(Unit.BCHA, JangGi.getUnit(8,0));
		assertEquals(Unit.BJANG, JangGi.getUnit(4,1));
		assertEquals(Unit.BPHO, JangGi.getUnit(1,2));
		assertEquals(Unit.BPHO, JangGi.getUnit(7,2));
		assertEquals(Unit.BJOL, JangGi.getUnit(0,3));
		assertEquals(Unit.BJOL, JangGi.getUnit(2,3));
		assertEquals(Unit.BJOL, JangGi.getUnit(4,3));
		assertEquals(Unit.BJOL, JangGi.getUnit(6,3));
		assertEquals(Unit.BJOL, JangGi.getUnit(8,3));

		assertEquals(Unit.RCHA, JangGi.getUnit(0,9));
		assertEquals(Unit.RMA, JangGi.getUnit(1,9));
		assertEquals(Unit.RSANG, JangGi.getUnit(2,9));
		assertEquals(Unit.RSA, JangGi.getUnit(3,9));
		assertEquals(Unit.RSA, JangGi.getUnit(5,9));
		assertEquals(Unit.RSANG, JangGi.getUnit(6,9));
		assertEquals(Unit.RMA, JangGi.getUnit(7,9));
		assertEquals(Unit.RCHA, JangGi.getUnit(8,9));
		assertEquals(Unit.RJANG, JangGi.getUnit(4,8));
		assertEquals(Unit.RPHO, JangGi.getUnit(1,7));
		assertEquals(Unit.RPHO, JangGi.getUnit(7,7));
		assertEquals(Unit.RJOL, JangGi.getUnit(0,6));
		assertEquals(Unit.RJOL, JangGi.getUnit(2,6));
		assertEquals(Unit.RJOL, JangGi.getUnit(4,6));
		assertEquals(Unit.RJOL, JangGi.getUnit(6,6));
		assertEquals(Unit.RJOL, JangGi.getUnit(8,6));
	}

	/**
	 * Input: KoreanChess showBoard
	 * Expected:
	 * 		Show Board
	 */
	@Test
	public void testShowBoard(){
		KoreanChess JangGi = new KoreanChess();
		JangGi.showBoard();
	} 

	/**
	 * When move no unit
	 * Input: putUnit BJOL (0,2) -> (0,3)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,2) = NONE
	 */
	@Test
	public void testReturnFailureMoveNoUnit(){
		int[] beforeXY={0,2};
		int[] afterXY={0,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(Unit.NULL, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When first turn is red.
	 * Input: putUnit RJOL (0,6) -> (1,6)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,6) = RJOL
	 */
	@Test
	public void testFailureFirstTurnRed(){
		int[] beforeXY={0,6};
		int[] afterXY={1,6};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When it occur that sequential blue turn
	 * Input: putUnit BJOL (0,4) -> (0,5)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,4) = BJOL
	 */
	@Test
	public void testFailurePutTwoTurnBlue(){
		int[] beforeXY={0,4};
		int[] afterXY={0,5};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 0, 4);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When it occur that sequential red turn
	 * Input: putUnit RJOL (1,6) -> (0,6)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,6) = RJOL
	 */
	@Test
	public void testFailurePutTwoTurnRed(){
		int[] beforeXY={1,6};
		int[] afterXY={0,6};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));		
	}

	/**
	 * When a unit left out of the board
	 * Input: putUnit BJOL (0,3) -> (-1,3)
	 * Expected:
	 * 		return Error (ArrayIndexOutOfBoundsException)
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testFailureMoveOutLeft(){
		int[] beforeXY={0,3};
		int[] afterXY={-1,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When a unit right out of the board
	 * Input: putUnit BJOL (8,3) -> (9,3)
	 * Expected:
	 * 		return Error (ArrayIndexOutOfBoundsException)
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testFailureMoveOutRight(){
		int[] beforeXY={8,3};
		int[] afterXY={9,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When a unit up out of the board
	 * Input: putUnit BCHA (0,0) -> (-1,0)
	 * Expected:
	 * 		return Error (ArrayIndexOutOfBoundsException)
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testFailureMoveOutUp(){
		int[] beforeXY={0,0};
		int[] afterXY={-1,0};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When a unit down out of the board
	 * Input: putUnit RCHA (8,9) -> (8,10)
	 * Expected:
	 * 		return Error (ArrayIndexOutOfBoundsException)
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testFailureMoveOutDown(){
		int[] beforeXY={8,9};
		int[] afterXY={8,10};
		Unit target = Unit.RCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	//초 장

	/**
	 * When Blue JANG move out of castle.
	 * Input: putUnit BJANG (5,1) -> (6,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BJANG
	 */
	@Test
	public void testFailureMoveBJANGOutOfCastle(){
		int[] beforeXY={5,1};
		int[] afterXY={6,1};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JANG move to two space in castle.
	 * Input: putUnit BJANG (5,1) -> (3,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BJANG
	 */
	@Test
	public void testFailureMoveBJANGToTwoSpace(){
		int[] beforeXY={5,1};
		int[] afterXY={3,1};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JANG move to no diagonal line in castle.
	 * Input: putUnit BJANG (5,1) -> (4,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BJANG
	 */
	@Test //********
	public void testFailureMoveBJANGToNoDiagonalLine(){
		int[] beforeXY={5,1};
		int[] afterXY={4,2};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JANG move to illegal path in castle.
	 * Input: putUnit BJANG (5,1) -> (3,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BJANG
	 */
	@Test
	public void testFailureMoveBJANGToIllegalPath(){
		int[] beforeXY={5,1};
		int[] afterXY={3,2};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JANG move to allies in castle.
	 * Input: putUnit BJANG (4,1) -> (3,0)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,1) = BJANG
	 */
	@Test
	public void testFailureMoveBJANGToAllies(){
		int[] beforeXY={4,1};
		int[] afterXY={3,0};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	//초 사
	/**
	 * When Blue SA move out of castle.
	 * Input: putUnit BSA (5,1) -> (6,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BSA
	 */
	@Test
	public void testFailureMoveBSAOutOfCastle(){
		int[] beforeXY={5,1};
		int[] afterXY={6,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue SA move to two space in castle.
	 * Input: putUnit BSA (5,1) -> (3,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BSA
	 */
	@Test
	public void testFailureMoveBSAToTwoSpace(){
		int[] beforeXY={5,1};
		int[] afterXY={3,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue SA move to no diagonal line in castle.
	 * Input: putUnit BSA (5,1) -> (4,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BSA
	 */
	@Test
	public void testFailureMoveBSAToNoDiagonalLine(){
		int[] beforeXY={5,1};
		int[] afterXY={4,2};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue SA move to illegal path in castle.
	 * Input: putUnit BSA (5,1) -> (3,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BSA
	 */
	@Test 
	public void testFailureMoveBSAToIllegalPath(){
		int[] beforeXY={5,1};
		int[] afterXY={3,2};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue SA move to allies in castle.
	 * Input: putUnit BSA (5,0) -> (4,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,0) = BSA
	 */
	@Test
	public void testFailureMoveBSAToAllies(){
		int[] beforeXY={5,0};
		int[] afterXY={4,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	//초 쫄
	/**
	 * When Blue JOL move to back space.
	 * Input: putUnit BJOL (0,3) -> (0,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,3) = BJOL
	 */
	@Test
	public void testFailureMoveBJOLToTheBackSpace(){
		int[] beforeXY={0,3};
		int[] afterXY={0,2};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JOL move to diagonal back space in enomy castle.
	 * Input: putUnit BJOL (4,8) -> (5,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,8) = BJOL
	 */
	@Test
	public void testFailureMoveBJOLToDiagonalBackSpaceInCastle(){
		int[] beforeXY={4,8};
		int[] afterXY={5,7};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 3, Unit.BJOL, 3, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 3, Unit.BJOL, 3, 4);
		JangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
		JangGi.putUnit(3, 4, Unit.BJOL, 3, 5);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 5, Unit.BJOL, 3, 6);
		JangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
		JangGi.putUnit(3, 6, Unit.BJOL, 3, 7);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 8);
		JangGi.putUnit(3, 7, Unit.BJOL, 4, 8);
		JangGi.putUnit(5, 8, Unit.RJANG, 5, 7);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JOL move to no diagonal line in enomy castle.
	 * Input: putUnit BJOL (4,7) -> (5,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,7) = BJOL
	 */
	@Test
	public void testFailureMoveBJOLToNoDiagonalLineInEnomyCastle(){
		int[] beforeXY={4,7};
		int[] afterXY={5,8};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 3, Unit.BJOL, 3, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 3, Unit.BJOL, 3, 4);
		JangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
		JangGi.putUnit(3, 4, Unit.BJOL, 3, 5);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 5, Unit.BJOL, 3, 6);
		JangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
		JangGi.putUnit(3, 6, Unit.BJOL, 3, 7);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 7, Unit.BJOL, 4, 7);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 8);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Blue JOL move to illegal space.
	 * Input: putUnit BJOL (0,3) -> (1,4)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,3) = BJOL
	 */
	@Test
	public void testFailureMoveBJOLToIllegalSpace(){
		int[] beforeXY={0,3};
		int[] afterXY={1,4};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue JOL move to allies.
	 * Input: putUnit BJOL (1,3) -> (2,3)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,3) = BJOL
	 */
	@Test
	public void testFailureMoveBJOLToAllies(){
		int[] beforeXY={1,3};
		int[] afterXY={2,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	////////초의 상~!
	/**
	 * When Blue SANG move to some blocked paths.
	 * Input: putUnit BSANG (6,0) -> (4,3) / (8,3)
	 * 		  putUnit BSANG (3,3) -> (0,1) / (0,5) / (6,1) / (6,5) / (1,0) / (5,0)
	 * Expected:
	 * 		return FAILURE
	 * 		(6,0) = BSANG
	 * 		(3,3) = BSANG
	 */
	@Test
	public void testFailureMoveBSANGToSomeBlockedPaths(){
		int[] beforeXYa={6,0};
		int[] afterXY1={4,3};
		int[] afterXY2={8,3};
		int[] beforeXYb={3,3};
		int[] afterXY3={0,1};
		int[] afterXY4={0,5};
		int[] afterXY5={6,1};
		int[] afterXY6={6,5};
		int[] afterXY7={1,0};
		int[] afterXY8={5,0};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYa[0], beforeXYa[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYa[0], beforeXYa[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXYa[0], beforeXYa[1]));
		JangGi.putUnit(1, 0, Unit.BSANG, 3, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY3[0], afterXY3[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY4[0], afterXY4[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY5[0], afterXY5[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY6[0], afterXY6[1]));
		JangGi.putUnit(4, 1, Unit.BJANG, 3, 2);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY7[0], afterXY7[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY8[0], afterXY8[1]));
		assertEquals(target, JangGi.getUnit(beforeXYb[0], beforeXYb[1]));
	}

	/**
	 * When Blue SANG move to illegal path.
	 * Input: putUnit BSANG (6,0) -> (5,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(6,0) = BSANG
	 */
	@Test
	public void testFailureMoveBSANGToIllegalPath(){
		int[] beforeXY={6,0};
		int[] afterXY={5,2};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue SANG move to diagonal line first in castle.
	 * Input: putUnit BSANG (4,1) -> (5,4)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,1) = BSANG
	 */
	@Test
	public void testFailureMoveBSANGToDiagonalLineFirstInCastle(){
		int[] beforeXY={4,1};
		int[] afterXY={5,4};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 4, 0);
		JangGi.putUnit(4, 6, Unit.RJOL, 3, 6);
		JangGi.putUnit(2, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(1, 0, Unit.BSANG, 3, 3);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(3, 3, Unit.BSANG, 5, 6);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(5, 6, Unit.BSANG, 2, 4);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(2, 4, Unit.BSANG, 4, 1);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	//초 마!!
	/**
	 * When Blue MA move to some blocked paths.
	 * Input: putUnit BMA (6,2) -> (7,0) / (5,0) / (4,1) / (4,3) / (5,4) / (7,4) / (8,3) / (8,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(6,2) = BMA
	 */
	@Test
	public void testFailureMoveBMAToSomeBlockedPaths(){
		int[] beforeXY={6,2};
		int[] afterXY1={7,0};
		int[] afterXY2={5,0};
		int[] afterXY3={4,1};
		int[] afterXY4={4,3};
		int[] afterXY5={5,4};
		int[] afterXY6={7,4};
		int[] afterXY7={8,3};
		int[] afterXY8={8,1};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(7, 0, Unit.BMA, 6, 2);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(8, 0, Unit.BCHA, 7, 0);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY3[0], afterXY3[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY4[0], afterXY4[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY5[0], afterXY5[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY6[0], afterXY6[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY7[0], afterXY7[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY8[0], afterXY8[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue MA move to illegal path.
	 * Input: putUnit BMA (2,0) -> (1,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(2,0) = BMA
	 */
	@Test
	public void testFailureMoveBMAToIllegalPath(){
		int[] beforeXY={2,0};
		int[] afterXY={1,1};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue MA move to diagonal line first in castle.
	 * Input: putUnit BMA (4,1) -> (6,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,1) = BMA
	 */
	@Test
	public void testFailureMoveBMAToDiagonalLineFirstInCastle(){
		int[] beforeXY={4,1};
		int[] afterXY={6,2};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(2, 0, Unit.BMA, 3, 2);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(3, 2, Unit.BMA, 5, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(5, 3, Unit.BMA, 4, 1);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	//초 포~~
	/**
	 * When Blue PHO move over the other pho.
	 * Input: putUnit BPHO (1,2) -> (8,2) / (1,9)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,2) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOOverAnotherPHO(){
		int[] beforeXY={1,2};
		int[] afterXY1={8,2};
		int[] afterXY2={1,9};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue PHO move to capture a enomy pho.
	 * Input: putUnit BPHO (1,2) -> (1,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,2) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOToCaptureAEnomyPHO(){
		int[] beforeXY={1,2};
		int[] afterXY={1,7};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 0, 5);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue PHO move to Direct.
	 * Input: putUnit BPHO (1,2) -> (1,4) / (2,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,2) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOToDirect(){
		int[] beforeXY={1,2};
		int[] afterXY={1,4};
		int[] afterXY2={2,2};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue PHO move over two pieces.
	 * Input: putUnit BPHO (7,2) -> (2,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(7,2) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOOverTwoPieces(){
		int[] beforeXY={7,2};
		int[] afterXY={2,2};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 0, Unit.BMA, 3, 2);
		JangGi.putUnit(0, 6, Unit.RJOL, 0, 5);
		JangGi.putUnit(7, 0, Unit.BMA, 6, 2);
		JangGi.putUnit(0, 5, Unit.RJOL, 0, 4);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue PHO move to allies.
	 * Input: putUnit BPHO (7,2) -> (3,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(7,2) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOToAllies(){
		int[] beforeXY={7,2};
		int[] afterXY={3,2};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 0, Unit.BMA, 3, 2);
		JangGi.putUnit(0, 6, Unit.RJOL, 0, 5);
		JangGi.putUnit(7, 0, Unit.BMA, 6, 2);
		JangGi.putUnit(0, 5, Unit.RJOL, 0, 4);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue PHO move to illegal diagonal direction around castle.
	 * Input1: putUnit BPHO (3,3) -> (5,1)
	 * Expected1:
	 * 		return FAILURE
	 * 		(3,3) = BPHO
	 * Input2: putUnit BPHO (6,3) -> (4,1)
	 * Expected2:
	 * 		return FAILURE
	 * 		(6,3) = BPHO
	 * * Input3: putUnit BPHO (4,1) -> (6,3)
	 * Expected3:
	 * 		return FAILURE
	 * 		(4,1) = BPHO
	 */
	@Test
	public void testFailureMoveBPHOToIllegalDiagonalDirection(){
		int[] beforeXY={3,3};
		int[] afterXY={5,1};
		int[] beforeXY2={6,3};
		int[] afterXY2={4,1};
		int[] beforeXY3={4,1};
		int[] afterXY3={6,3};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(7, 0, Unit.BMA, 6, 2);
		JangGi.putUnit(2, 6, Unit.RJOL, 3, 6);
		JangGi.putUnit(7, 2, Unit.BPHO, 3, 2);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(3, 2, Unit.BPHO, 3, 9);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(3, 9, Unit.BPHO, 3, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(4, 1, Unit.BJANG, 4, 2);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
		JangGi.putUnit(6, 3, Unit.BJOL, 7, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(3, 3, Unit.BPHO, 6, 3);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(4, 2, Unit.BJANG, 5, 2);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY2[0], beforeXY2[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY2[0], beforeXY2[1]));
		JangGi.putUnit(6, 3, Unit.BPHO, 6, 1);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(6, 1, Unit.BPHO, 4, 1);
		JangGi.putUnit(7, 6, Unit.RJOL, 8, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY3[0], beforeXY3[1], target, afterXY3[0], afterXY3[1]));
		assertEquals(target, JangGi.getUnit(beforeXY3[0], beforeXY3[1]));
	}

	//////초 차
	/**
	 * When Blue CHA move over a piece.
	 * Input: putUnit BCHA (0,0) -> (0,6) / (4,0)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,0) = BCHA
	 */
	@Test
	public void testFailureMoveBCHAOverAPiece(){
		int[] beforeXY={0,0};
		int[] afterXY={0,6};
		int[] afterXY2={4,0};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue CHA move to illegal direction.
	 * Input: putUnit BCHA (0,0) -> (2,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,0) = BCHA
	 */
	@Test
	public void testFailureMoveBCHAToIllegalDirection(){
		int[] beforeXY={0,0};
		int[] afterXY={2,2};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue CHA move to Allies.
	 * Input: putUnit BCHA (0,0) -> (1,0)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,0) = BCHA
	 */
	@Test
	public void testFailureMoveBCHAToAllies(){
		int[] beforeXY={0,0};
		int[] afterXY={1,0};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Blue CHA move to no diagonal line in castle.
	 * Input: putUnit BCHA (5,1) -> (4,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,1) = BCHA
	 */
	@Test
	public void testFailureMoveBCHAToDiagonalNoLine(){
		int[] beforeXY={5,1};
		int[] afterXY={4,2};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(8, 0, Unit.BCHA, 8, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 0, 5);
		JangGi.putUnit(8, 1, Unit.BCHA, 5, 1);
		JangGi.putUnit(0, 5, Unit.RJOL, 0, 4);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	////////////////////////위 BLUE / 아래 RED///////////////////////////// 

	//한 장
	/**
	 * When Red JANG move out of castle.
	 * Input: putUnit RJANG (3,8) -> (2,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(3,8) = RJANG
	 */
	@Test
	public void testFailureMoveRJANGOutOfCastle(){
		int[] beforeXY={3,8};
		int[] afterXY={2,8};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 3, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red JANG move to two space in castle.
	 * Input: putUnit RJANG (3,8) -> (5,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(3,8) = RJANG
	 */
	@Test
	public void testFailureMoveRJANGToTwoSpace(){
		int[] beforeXY={3,8};
		int[] afterXY={5,8};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 3, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	/**
	 * When Red JANG move to no diagonal line in castle.
	 * Input: putUnit RJANG (3,8) -> (4,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(3,8) = RJANG
	 */
	@Test
	public void testFailureMoveRJANGToNoDiagonalLine(){//***
		int[] beforeXY={3,8};
		int[] afterXY={4,7};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 3, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red JANG move to illegal path in castle.
	 * Input: putUnit RJANG (3,8) -> (5,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(3,8) = RJANG
	 */
	@Test
	public void testFailureMoveRJANGToIllegalPath(){
		int[] beforeXY={3,8};
		int[] afterXY={5,7};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 3, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	/**
	 * When Red JANG move to allies in castle.
	 * Input: putUnit RJANG (4,8) -> (3,9)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,8) = RJANG
	 */

	@Test
	public void testFailureMoveRJANGToAllies(){
		int[] beforeXY={4,8};
		int[] afterXY={3,9};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	//한 사
	/**
	 * When Red SA move out of castle.
	 * Input: putUnit RSA (5,8) -> (6,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,8) = RSA
	 */
	@Test
	public void testFailureMoveRSAOutOfCastle() {
		int[] beforeXY={5,8};
		int[] afterXY={6,8};
		Unit target = Unit.RSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(5, 9, Unit.RSA, 5, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red SA move to two space in castle.
	 * Input: putUnit RSA (5,9) -> (5,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,9) = RSA
	 */
	@Test
	public void testFailureMoveRSAToTwoSpace() {
		int[] beforeXY={5,9};
		int[] afterXY={5,7};
		Unit target = Unit.RSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red SA move to no diagonal line in castle.
	 * Input: putUnit RSA (5,8) -> (4,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,8) = RSA
	 */

	@Test
	public void testFailureMoveRSAToNoDiagonalLine(){//****
		int[] beforeXY={5,8};
		int[] afterXY={4,7};
		Unit target = Unit.RSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(5, 9, Unit.RSA, 5, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red SA move to illegal path in castle.
	 * Input: putUnit RSA (5,8) -> (3,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,8) = RSA
	 */

	@Test
	public void testFailureMoveRSAToIllegalPath(){
		int[] beforeXY={5,8};
		int[] afterXY={3,7};
		Unit target = Unit.RSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(5, 9, Unit.RSA, 5, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red SA move to allies in castle.
	 * Input: putUnit RSA (5,9) -> (4,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,9) = RSA
	 */

	@Test
	public void testFailureMoveRSAToAllies(){
		int[] beforeXY={5,9};
		int[] afterXY={4,8};
		Unit target = Unit.RSA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	//한 쫄
	/**
	 * When Red JOL move to back.
	 * Input: putUnit RJOL (0,6) -> (0,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,6) = RJOL
	 */
	@Test
	public void testFailureMoveRJOLToTheBackSpace(){
		int[] beforeXY={0,6};
		int[] afterXY={0,7};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red JOL move to diagonal back space in enomy castle.
	 * Input: putUnit RJOL (4,1) -> (5,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,1) = RJOL
	 */
	@Test
	public void testFailureMoveRJOLToDiagonalBackSpaceInCastle(){
		int[] beforeXY={4,1};
		int[] afterXY={5,2};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 6, Unit.RJOL, 3, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(3, 6, Unit.RJOL, 3, 5);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(3, 5, Unit.RJOL, 3, 4);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(3, 4, Unit.RJOL, 3, 3);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(3, 3, Unit.RJOL, 3, 2);
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(3, 2, Unit.RJOL, 4, 1);
		JangGi.putUnit(5, 1, Unit.BJANG, 5, 2);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red JOL move to no diagonal line in enomy castle.
	 * Input: putUnit RJOL (4,2) -> (5,1)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,2) = RJOL
	 */
	@Test
	public void testFailureMoveRJOLToNoDiagonalLineInEnomyCastle(){
		int[] beforeXY={4,2};
		int[] afterXY={5,1};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 6, Unit.RJOL, 3, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(3, 6, Unit.RJOL, 3, 5);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(3, 5, Unit.RJOL, 3, 4);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(3, 4, Unit.RJOL, 3, 3);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(3, 3, Unit.RJOL, 3, 2);
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(3, 2, Unit.RJOL, 4, 2);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/**
	 * When Red JOL move to illegal space.
	 * Input: putUnit RJOL (0,6) -> (1,5)
	 * Expected:
	 * 		return FAILURE
	 * 		(0,6) = RJOL
	 */
	@Test
	public void testFailureMoveRJOLToIllegalSpace(){
		int[] beforeXY={0,6};
		int[] afterXY={1,5};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red JOL move to allies.
	 * Input: putUnit RJOL (1,6) -> (2,6)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,6) = RJOL
	 */
	@Test
	public void testFailureMoveRJOLToAllies(){
		int[] beforeXY={1,6};
		int[] afterXY={2,6};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	////////한 상~!
	/**
	 * When Red SANG move to some blocked paths.
	 * Input: putUnit RSANG (2,9) -> (0,6) / (4,6)
	 * 		  putUnit RSANG (4,6) -> (7,4) / (7,8) / (6,9) / (2,9) / (1,8) / (1,4)
	 * Expected:
	 * 		return FAILURE
	 * 		(2,9) = RSANG
	 * 		(4,6) = RSANG
	 */
	@Test
	public void testFailureMoveRSANGToSomeBlockedPaths(){
		int[] beforeXYa={2,9};
		int[] afterXY1={0,6};
		int[] afterXY2={4,6};
		int[] beforeXYb={4,6};
		int[] afterXY3={7,4};
		int[] afterXY4={7,8};
		int[] afterXY5={6,9};
		int[] afterXY6={2,9};
		int[] afterXY7={1,8};
		int[] afterXY8={1,4};
		Unit target = Unit.RSANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYa[0], beforeXYa[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYa[0], beforeXYa[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXYa[0], beforeXYa[1]));
		JangGi.putUnit(4, 6, Unit.RJOL, 5, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(2, 6, Unit.RJOL, 3, 6);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 9, Unit.RSANG, 4, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 4, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY3[0], afterXY3[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY4[0], afterXY4[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY5[0], afterXY5[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY6[0], afterXY6[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY7[0], afterXY7[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXYb[0], beforeXYb[1], target, afterXY8[0], afterXY8[1]));
		assertEquals(target, JangGi.getUnit(beforeXYb[0], beforeXYb[1]));
	}

	/**
	 * When Red SANG move to illegal path.
	 * Input: putUnit RSANG (6,9) -> (5,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(6,9) = RSANG
	 */
	@Test
	public void testFailureMoveRSANGToIllegalPath(){
		int[] beforeXY={6,9};
		int[] afterXY={5,8};
		Unit target = Unit.RSANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red SANG move to diagonal line first in castle.
	 * Input: putUnit RSANG (4,8) -> (5,5)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,8) = RSANG
	 */
	@Test
	public void testFailureMoveRSANGToDiagonalLineFirstInCastle(){
		int[] beforeXY={4,8};
		int[] afterXY={5,5};
		Unit target = Unit.RSANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 4, 9);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(4, 6, Unit.RJOL, 4, 5);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(6, 6, Unit.RJOL, 7, 6);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(6, 9, Unit.RSANG, 4, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(4, 6, Unit.RSANG, 7, 4);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(7, 4, Unit.RSANG, 5, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(5, 7, Unit.RSANG, 2, 5);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 5, Unit.RSANG, 4, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	//한 마!!
	/**
	 * When Red MA move to some blocked paths.
	 * Input: putUnit RMA (6,7) -> (7,9) / (5,9) / (4,8) / (4,6) / (5,5) / (7,5) / (8,6) / (8,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(6,7) = RMA
	 */
	@Test
	public void testFailureMoveRMAToSomeBlockedPaths(){
		int[] beforeXY={6,7};
		int[] afterXY1={7,9};
		int[] afterXY2={5,9};
		int[] afterXY3={4,8};
		int[] afterXY4={4,6};
		int[] afterXY5={5,5};
		int[] afterXY6={7,5};
		int[] afterXY7={8,6};
		int[] afterXY8={8,8};
		Unit target = Unit.RMA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(7, 9, Unit.RMA, 6, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(8, 9, Unit.RCHA, 7, 9);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY3[0], afterXY3[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY4[0], afterXY4[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY5[0], afterXY5[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY6[0], afterXY6[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY7[0], afterXY7[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY8[0], afterXY8[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red MA move to illegal path.
	 * Input: putUnit RMA (1,9) -> (2,8)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,9) = RMA
	 */
	@Test
	public void testFailureMoveRMAToIllegalPath(){
		int[] beforeXY={1,9};
		int[] afterXY={2,8};
		Unit target = Unit.RMA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red MA move to diagonal line first in castle.
	 * Input: putUnit RMA (4,8) -> (6,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(4,8) = RMA
	 */
	@Test
	public void testFailureMoveRMAToDiagonalLineFirstInCastle(){
		int[] beforeXY={4,8};
		int[] afterXY={6,7};
		Unit target = Unit.RMA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(7, 9, Unit.RMA, 6, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(6, 7, Unit.RMA, 4, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	//한 포~~  
	/**
	 * When Red PHO move over the other pho.
	 * Input: putUnit RPHO (1,7) -> (1,0) / (8,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,7) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOOverAnotherPHO(){
		int[] beforeXY={1,7};
		int[] afterXY1={1,0};
		int[] afterXY2={8,7};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 3, Unit.BJOL, 3, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY1[0], afterXY1[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red PHO move to capture a enomy pho.
	 * Input: putUnit RPHO (1,7) -> (1,2)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,7) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOToCaptureAEnomyPHO(){
		int[] beforeXY={1,7};
		int[] afterXY={1,2};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red PHO move to Direct.
	 * Input: putUnit RPHO (1,7) -> (1,5) / (2,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(1,7) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOToDirect(){
		int[] beforeXY={1,7};
		int[] afterXY={1,5};
		int[] afterXY2={2,7};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red PHO move over two pieces.
	 * Input: putUnit RPHO (7,7) -> (2,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(7,7) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOOverTwoPieces(){
		int[] beforeXY={7,7};
		int[] afterXY={4,7};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(7, 9, Unit.RMA, 6, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red PHO move to allies.
	 * Input: putUnit RPHO (7,7) -> (5,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(7,7) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOToAllies(){
		int[] beforeXY={7,7};
		int[] afterXY={5,7};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(7, 9, Unit.RMA, 6, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red PHO move to illegal diagonal direction around castle.
	 * Input1: putUnit RPHO (2,6) -> (4,8)
	 * Expected1:
	 * 		return FAILURE
	 * 		(2,6) = RPHO
	 * Input2: putUnit RPHO (4,8) -> (2,6)
	 * Expected2:
	 * 		return FAILURE
	 * 		(4,8) = RPHO
	 */
	@Test
	public void testFailureMoveRPHOToIllegalDiagonalDirection(){//////////////
		int[] beforeXY={2,6};
		int[] afterXY={4,8};
		int[] beforeXY2={4,8};
		int[] afterXY2={2,6};
		Unit target = Unit.RPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(7, 9, Unit.RMA, 6, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(7, 7, Unit.RPHO, 2, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(2, 7, Unit.RPHO, 2, 0);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 0, Unit.RPHO, 2, 6);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(4, 8, Unit.RJANG, 3, 7);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
		JangGi.putUnit(1, 9, Unit.RMA, 2, 7);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(3, 9, Unit.RSA, 3, 8);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(2, 6, Unit.RPHO, 2, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(2, 8, Unit.RPHO, 4, 8);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);		
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY2[0], beforeXY2[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY2[0], beforeXY2[1]));
	}

	//////한 차
	/**
	 * When Red CHA move over a piece.
	 * Input: putUnit RCHA (8,9) -> (8,3) / (4,9)
	 * Expected:
	 * 		return FAILURE
	 * 		(8,9) = RCHA
	 */
	@Test
	public void testFailureMoveRCHAOverAPiece(){
		int[] beforeXY={8,9};
		int[] afterXY={8,3};
		int[] afterXY2={4,9};
		Unit target = Unit.RCHA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red CHA move to illegal direction.
	 * Input: putUnit RCHA (8,9) -> (6,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(8,9) = RCHA
	 */
	@Test
	public void testFailureMoveRCHAToIllegalDirection(){
		int[] beforeXY={8,9};
		int[] afterXY={6,7};
		Unit target = Unit.RCHA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red CHA move to Allies.
	 * Input: putUnit RCHA (8,9) -> (7,9)
	 * Expected:
	 * 		return FAILURE
	 * 		(8,9) = RCHA
	 */
	@Test
	public void testFailureMoveRCHAToAllies(){
		int[] beforeXY={8,9};
		int[] afterXY={7,9};
		Unit target = Unit.RCHA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}

	/**
	 * When Red CHA move to no diagonal line in castle.
	 * Input: putUnit RCHA (5,8) -> (4,7)
	 * Expected:
	 * 		return FAILURE
	 * 		(5,7) = RCHA
	 */
	@Test
	public void testFailureMoveRCHAToDiagonalNoLine(){
		int[] beforeXY={5,8};
		int[] afterXY={4,7};
		Unit target = Unit.RCHA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(8, 9, Unit.RCHA, 8, 8);
		JangGi.putUnit(1, 3, Unit.BJOL, 0, 3);
		JangGi.putUnit(8, 8, Unit.RCHA, 5, 8);
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
}
