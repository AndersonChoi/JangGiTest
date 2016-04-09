import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import KoreanChessGame.KoreanChess;
import KoreanChessGame.PutResult;
import KoreanChessGame.Unit;


/*
 * 1 - testValidMoveBCHA    ok
 * 2 - testValidMoveBSANG   ok
 * 3 - testValidMoveBMA    ok
 * 4 - testValidMoveBSA    ok
 * 5 - testValidMoveBJANG   ok
 * 6 - testValidMoveBPHO  					B is ok but.. R is on
 * 7 - testValidMoveBJOL    ok
 * 
 * 8 - testValidMoveRJOL     ok
 * 9 - testValidMoveRPHO                        no
 * 10 - testValidMoveRCHA     ok 
 * 11 - testValidMoveRMA        ok
 * 12 - testValidMoveRSANG     ok
 * 13 - testValidMoveRSA          ok
 * 14 - testValidMoveRJANG    ok
 * 
 */

public class WonYoungChoi_200924542 {

	KoreanChess testJangGi;

	@After
	public void tearDown() {
		testJangGi = null;
	}
	
	

	/* - testValidMoveBCHA
	 * 1 - testValidMoveBCHA_toSouth
	 * Input : putUnit BCHA (0,0) -> (0,1) 
	 * Expected: return SUCCESS 
	 * 												(0,0) = NONE
	 * 												(0,1) = BCHA
	 * 
	 * 2 - testValidMoveBCHA_toNorth
	 * Input : putUnit BCHA (0,0) -> (0,1) 
	 * Expected: return SUCCESS 
	 * 												(0,0) = NONE
	 * 												(0,1) = BCHA
	 * 
	 * 3 - testValidMoveBCHA_toEast
	 * Input : putUnit BCHA (0,1) -> (1,1) 
	 * Expected: return SUCCESS 
	 * 												(0,1) = NONE
	 * 												(1,1) = BCHA
	 * 
	 * 4 - testValidMoveBCHA_toWest
	 * Input : putUnit BCHA (1,1) -> (0,1) 
	 * Expected: return SUCCESS 
	 * 												(1,1) = NONE
	 * 												(0,1) = BCHA
	 */
	@Test
	public void testValidMoveBCHA() {
		// 1 - testValidMoveBCHA_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,0};
			int[] afterXY = {0,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBCHA_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,1};
			int[] afterXY = {0,0};
			testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}

		// 3 - testValidMoveBCHA_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,1};
			int[] afterXY = {1,1};
			testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}

		// 4 - testValidMoveBCHA_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,1};
			int[] afterXY = {0,1};
			testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
			testJangGi.putUnit(0, 1, Unit.BCHA, 1, 1);
			testJangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
	}


	/* - testValidMoveBSANG
	 * 1 - testValidMoveBSANG_toSouthSouthEast
	 * Input : putUnit BSANG (1,0) -> (3,3) 
	 * Expected: return SUCCESS 
	 * 												(1,0) = NONE
	 * 												(3,3) = BSANG
	 * 2 - testValidMoveBSANG_toSouthSouthWest
	 * Input : putUnit BSANG (6,0) -> (4,3) 
	 * Expected: return SUCCESS 
	 * 												(6,0) = NONE
	 * 												(4,3) = BSANG
	 *  3 - testValidMoveBSANG_toNorthNorthEast
	 * Input : putUnit BSANG (4,3) -> (6,0) 
	 * Expected: return SUCCESS 
	 * 												(4,3) = NONE
	 * 												(6,0) = BSANG
	 *  4 - testValidMoveBSANG_toNorthNorthWest
	 * Input : putUnit BSANG (3,3) -> (1,0) 
	 * Expected: return SUCCESS 
	 * 												(3,3) = NONE
	 * 												(1,0) = BSANG
	 *  5 - testValidMoveBSANG_toEastEastSouth
	 * Input : putUnit BSANG (4,3) -> (7,5) 
	 * Expected: return SUCCESS 
	 * 												(4,3) = NONE
	 * 												(7,5) = BSANG
	 *  6 - testValidMoveBSANG_toEastEastNorth
	 * Input : putUnit BSANG (4,3) -> (7,1) 
	 * Expected: return SUCCESS 
	 * 												(4,3) = NONE
	 * 												(7,1) = BSANG
	 *  7 - testValidMoveBSANG_toWestWestSouth
	 * Input : putUnit BSANG (4,3) -> (1,5) 
	 * Expected: return SUCCESS 
	 * 												(4,3) = NONE
	 * 												(1,5) = BSANG
	 *  8 - testValidMoveBSANG_toWestWestNorth
	 * Input : putUnit BSANG (4,3) -> (1,1) 
	 * Expected: return SUCCESS 
	 * 												(4,3) = NONE
	 * 												(1,1) = BSANG
	 *  
	 */
	@Test
	public void testValidMoveBSANG() {
		// 1 - testValidMoveBSANG_toSouthSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,0};
			int[] afterXY = {3,3};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBSANG_toSouthSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {6,0};
			int[] afterXY = {4,3};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveBSANG_toNorthNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,3};
			int[] afterXY = {6,0};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveBSANG_toNorthNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,3};
			int[] afterXY = {1,0};
			testJangGi.putUnit(1,0, Unit.BSANG, 3,3);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveBSANG_toEastEastSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,3};
			int[] afterXY = {7,5};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveBSANG_toEastEastNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,3};
			int[] afterXY = {7,1};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveBSANG_toWestWestSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,3};
			int[] afterXY = {1,5};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveBSANG_toWestWestNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,3};
			int[] afterXY = {1,1};
			testJangGi.putUnit(4,3, Unit.BJOL, 4,4);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}

	/* - testValidMoveBMA
	 * 1 - testValidMoveBMA_toSouthSouthEast
	 * Input : putUnit BMA (2,0) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,2) = BMA
	 * 2 - testValidMoveBMA_toSouthSouthWest
	 * Input : putUnit BMA (3,2) -> (2,4) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(2,4) = BMA
	 *  3 - testValidMoveBMA_toNorthNorthEast
	 * Input : putUnit BMA (3,2) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(4,0) = BMA
	 *  4 - testValidMoveBMA_toNorthNorthWest
	 * Input : putUnit BMA (3,2) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(3,0) = BMA
	 *  5 - testValidMoveBMA_toEastEastSouth
	 * Input : putUnit BMA (3,2) -> (5,3) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(5,3) = BMA
	 *  6 - testValidMoveBMA_toEastEastNorth
	 * Input : putUnit BMA (3,2) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(5,1) = BMA
	 *  7 - testValidMoveBMA_toWestWestSouth
	 * Input : putUnit BMA (3,2) -> (1,3) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(1,3) = BMA
	 *  8 - testValidMoveBMA_toWestWestNorth
	 * Input : putUnit BMA (3,2) -> (1,1) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(1,1) = BMA
	 *  
	 */
	@Test
	public void testValidMoveBMA() {
		// 1 - testValidMovBMA_toSouthSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,0};
			int[] afterXY = {3,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBMA_toSouthSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {2,4};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveBMA_toNorthNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {4,0};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveBMA_toNorthNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {2,0};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveBMA_toEastEastSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {5,3};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveBMA_toEastEastNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {5,1};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveBMA_toWestWestSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {1,3};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveBMA_toWestWestNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {1,1};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}
	
	
	
	/* - testValidMoveBSA
	 * 1 - testValidMoveBSA_toEast
	 * Input : putUnit BSA (3,0) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(4,0) = BSA
	 *  2 - testValidMoveBSA_toSouth
	 * Input : putUnit BSA (3,0) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(3,1) = BSA
	 *  3 - testValidMoveBSA_toNorth
	 * Input : putUnit BSA (3,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(3,1) = NONE
	 * 												(3,0) = BSA
	 *  4 - testValidMoveBSA_toWest
	 * Input : putUnit BSA (5,0) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(5,0) = NONE
	 * 												(4,0) = BSA
	 *  5 - testValidMoveBSA_toDiagonalSouthEast
	 * Input : putUnit BSA (3,0) -> (4,1) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(4,1) = BSA
	 *  6 - testValidMoveBSA_toDiagonalSouthWest
	 * Input : putUnit BSA (5,0) -> (4,1) 
	 * Expected: return SUCCESS 
	 * 												(5,0) = NONE
	 * 												(4,1) = BSA
	 *  7 - testValidMoveBSA_toDiagonalNorthWest
	 * Input : putUnit BSA (4,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,0) = BSA
	 *  8 - testValidMoveBSA_toDiagonalNorthEast
	 * Input : putUnit BSA (4,1) -> (5,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,0) = BSA
	 */
	@Test
	public void testValidMoveBSA() {
		// 1 - testValidMoveBSA_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,0};
			int[] afterXY = {4,0};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBSA_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,0};
			int[] afterXY = {3,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveBSA_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,1};
			int[] afterXY = {3,0};
			testJangGi.putUnit(3, 0, Unit.BSA, 3, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveBSA_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {5,0};
			int[] afterXY = {4,0};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveBSA_toDiagonalSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,0};
			int[] afterXY = {4,1};
			testJangGi.putUnit(4,1, Unit.BJANG, 4,2);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveBSA_toDiagonalSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {5,0};
			int[] afterXY = {4,1};
			testJangGi.putUnit(4,1, Unit.BJANG, 4,2);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveBSA_toDiagonalNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,0};
			testJangGi.putUnit(4,1, Unit.BJANG, 4,2);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1,6);
			testJangGi.putUnit(3,0, Unit.BSA, 4,1);
			testJangGi.putUnit(1, 6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveBSA_toDiagonalNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,0};
			testJangGi.putUnit(4,1, Unit.BJANG, 4,2);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1,6);
			testJangGi.putUnit(5,0, Unit.BSA, 4,1);
			testJangGi.putUnit(1, 6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
	}
	
	
	
	
	
	/* - testValidMoveBJANG
	 * 1 - testValidMoveBJANG_toNorth
	 * Input : putUnit BJANG (4,1) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,0) = BJANG
	 *  2 - testValidMoveBJANG_toWest
	 * Input : putUnit BJANG (4,1) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,1) = BJANG
	 *  3 - testValidMoveBJANG_toEast
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 *  4 - testValidMoveBJANG_toDiagonalSouthEast
	 * Input : putUnit BJANG (4,1) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,2) = BJANG
	 *  5 - testValidMoveBJANG_toSouth
	 * Input : putUnit BJANG (4,1) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,2) = BJANG
	 *  6 - testValidMoveBJANG_toDiagonalSouthWest
	 * Input : putUnit BJANG (4,1) -> (5,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,2) = BJANG
	 *  7 - testValidMoveBJANG_toDiagonalNorthWest
	 * Input : putUnit BJANG (4,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,0) = BJANG
	 *  8 - testValidMoveBJANG_toDiagonalNorthEast
	 * Input : putUnit BJANG (4,1) -> (5,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,0) = BJANG
	 */
	@Test
	public void testValidMoveBJANG() {
		// 1 - testValidMoveBJANG_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {4,0};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBJANG_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveBJANG_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveBJANG_toDiagonalSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveBJANG_toSouth
		{
			testJangGi = new KoreanChess();
				int[] beforeXY = {4,1};
				int[] afterXY = {4,2};
				PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
				assertEquals(PutResult.SUCCESS, result);
				assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
				assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveBJANG_toDiagonalSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 7 - testValidMoveBJANG_toDiagonalNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,0};
			testJangGi.putUnit(3,0, Unit.BSA, 3,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveBJANG_toDiagonalNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,0};
			testJangGi.putUnit(5,0, Unit.BSA, 5,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}
	

	/* - testValidMoveBPHO
	 * 1 - testValidOverBMA_BPHO
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * 2 - testValidOverBJOL_BPHO
	 * Input : putUnit BPHO (1,2) -> (1,4) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,4) = BPHO
	 * 3 - testValidOverBJANG_BPHO
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * 4 - testValidOverBSA_BPHO
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * 5 - testValidOverBSANG_BPHO
	 * Input : putUnit BPHO (4,2) -> (4,4)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(4,4) = BPHO
	 * 6 - testValidOverBCHA_BPHO
	 * Input : putUnit BPHO (4,2) -> (0,2)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(0,2) = BPHO
	 * 7 - testValidCrossOverBSA_BPHO
	 * Input : putUnit BPHO (5,2) -> (3,0)
	 * Expected: return SUCCESS 
	 * 												(5,2) = NONE
	 * 												(3,0) = BPHO
	 * 8 - testValidOverRJOL_BPHO
	 * Input : putUnit BPHO (1,2) -> (1,7)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,7) = BPHO
	 * 9 - testValidOverRCHA_BPHO
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 * 10 - testValidOverRMA_BPHO
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 * 11 - testValidOverRSANG_BPHO
	 * Input : putUnit BPHO () -> ()
	 * Expected: return SUCCESS 
	 * 												() = NONE
	 * 												() = BPHO
	 * 12 - testValidOverRSA_BPHO
	 * Input : putUnit BPHO () -> ()
	 * Expected: return SUCCESS 
	 * 												() = NONE
	 * 												() = BPHO
	 * 13 - testValidOverRJANG_BPHO
	 * Input : putUnit BPHO () -> ()
	 * Expected: return SUCCESS 
	 * 												() = NONE
	 * 												() = BPHO
	 * 14 - testValidCrossOverRSA_BPHO
	 * Input : putUnit BPHO () -> ()
	 * Expected: return SUCCESS 
	 * 												() = NONE
	 * 												() = BPHO
	 * 
	 * 
	 */
	@Test
	public void testValidMoveBPHO() {
		// 1 - testValidOverBMA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {4,2};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidOverBJOL_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {1,4};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidOverBJANG_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {4,2};
			testJangGi.putUnit(4,1, Unit.BJANG, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidOverBSA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {4,2};
			testJangGi.putUnit(3,0, Unit.BSA, 3,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(3,1, Unit.BSA, 3,2);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidOverBSANG_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,2};
			int[] afterXY = {4,4};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(4,3, Unit.BJOL, 3,3);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			testJangGi.putUnit(6,0, Unit.BSANG, 4,3);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(1,2, Unit.BPHO, 4,2);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 -  testValidOverBCHA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,2};
			int[] afterXY = {0,2};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(0,0, Unit.BCHA, 0,2);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			testJangGi.putUnit(1,2, Unit.BPHO, 4,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(0,2, Unit.BCHA, 1,2);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			testJangGi.putUnit(3,2, Unit.BMA, 2,0);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidCrossOverBSA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {5,2};
			int[] afterXY = {3,0};
			testJangGi.putUnit(4,1, Unit.BJANG, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(1,2, Unit.BPHO, 5,2);
			testJangGi.putUnit(1,6, Unit.RJOL, 0,6);
			testJangGi.putUnit(3,0, Unit.BSA, 4,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidOverRJOL_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {1,7};
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(0,1, Unit.BCHA, 0,0);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(1,7, Unit.RPHO, 3,7);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 9 - testValidOverRCHA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {1,5};
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(0,1, Unit.BCHA, 0,0);
			testJangGi.putUnit(0,9, Unit.RCHA, 0,4);
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(0,4, Unit.RCHA, 1,4);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 10 - testValidOverRMA_BPHO
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {1,5};
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(0,1, Unit.BCHA, 0,0);
			testJangGi.putUnit(0,9, Unit.RCHA, 0,4);
			testJangGi.putUnit(0,0, Unit.BCHA, 0,1);
			testJangGi.putUnit(0,4, Unit.RCHA, 1,4);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}
	
	/* - testValidMoveBJOL
	 * 1 - testValidMoveBJOL_toWest
	 * Input : putUnit BJOL (2,3) -> (1,3) 
	 * Expected: return SUCCESS 
	 * 												(2,3) = NONE
	 * 												(1,3) = BJOL
	 * 2 - testValidMoveBJOL_toSouth
	 * Input : putUnit BJOL (2,3) -> (2,4) 
	 * Expected: return SUCCESS 
	 * 												(2,3) = NONE
	 * 												(2,4) = BJOL
	 * 3 - testValidMoveBJOL_toEast
	 * Input : putUnit BJOL (2,3) -> (3,3) 
	 * Expected: return SUCCESS 
	 * 												(2,3) = NONE
	 * 												(3,3) = BJOL
	 * 	
	 */
	@Test
	public void testValidMoveBJOL() {
		// 1 - testValidMoveBJOL_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,3};
			int[] afterXY = {1,3};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveBJOL_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,3};
			int[] afterXY = {2,4};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveBJOL_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,3};
			int[] afterXY = {3,3};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
	}

	/* - testValidMoveRJOL
	 * 1 - testValidMoveRJOL_toWest
	 * Input : putUnit RJOL (2,6) -> (1,6) 
	 * Expected: return SUCCESS 
	 * 												(2,6) = NONE
	 * 												(1,6) = RJOL
	 * 2 - testValidMoveRJOL_toNorth
	 * Input : putUnit RJOL (2,6) -> (2,5) 
	 * Expected: return SUCCESS 
	 * 												(2,6) = NONE
	 * 												(2,5) = RJOL
	 * 3 - testValidMoveRJOL_toEast
	 * Input : putUnit RJOL (2,6) -> (3,6) 
	 * Expected: return SUCCESS 
	 * 												(2,6) = NONE
	 * 												(3,6) = RJOL
	 * 	
	 */
	@Test
	public void testValidMoveRJOL() {
		// 1 - testValidMoveRJOL_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,6};
			int[] afterXY = {1,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveRJOL_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,6};
			int[] afterXY = {2,5};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveRJOL_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,6};
			int[] afterXY = {3,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJOL, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
	}
	

	/* - testValidMoveRPHO
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRPHO() {
		
	}
	
	

	/* - testValidMoveRCHA
	 * 1 - testValidMoveRCHA_toNorth
	 * Input : putUnit RCHA (0,9) -> (0,8) 
	 * Expected: return SUCCESS 
	 * 												(0,9) = NONE
	 * 												(0,8) = RCHA
	 * 
	 * 2 - testValidMoveRCHA_toSouth
	 * Input : putUnit RCHA (0,8) -> (0,9) 
	 * Expected: return SUCCESS 
	 * 												(0,8) = NONE
	 * 												(0,9) = RCHA
	 * 
	 * 
	 * 3 - testValidMoveRCHA_toEast
	 * Input : putUnit RCHA (0,8) -> (1,8) 
	 * Expected: return SUCCESS 
	 * 												(0,8) = NONE
	 * 												(1,8) = RCHA
	 * 
	 * 4 - testValidMoveRCHA_toWest
	 * Input : putUnit RCHA (1,8) -> (0,8) 
	 * Expected: return SUCCESS 
	 * 												(1,8) = NONE
	 * 												(0,8) = RCHA
	 */
	@Test
	public void testValidMoveRCHA() {
		// 1 - testValidMoveRCHA_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,9};
			int[] afterXY = {0,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveRCHA_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,8};
			int[] afterXY = {0,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,9, Unit.RCHA, 0,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveRCHA_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,8};
			int[] afterXY = {1,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,9, Unit.RCHA, 0,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveRCHA_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,8};
			int[] afterXY = {0,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,9, Unit.RCHA, 0,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(0,8, Unit.RCHA, 1,8);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}



	/* - testValidMoveRMA
	 * 1 - testValidMoveRMA_toNorthNorthEast
	 * Input : putUnit RMA (1,9) -> (2,7) 
	 * Expected: return SUCCESS 
	 * 												(1,9) = NONE
	 * 												(2,7) = RMA
	 * 2 - testValidMoveRMA_toNorthNorthWest
	 * Input : putUnit RMA (1,9) -> (0,7) 
	 * Expected: return SUCCESS 
	 * 												(1,9) = NONE
	 * 												(0,7) = RMA
	 *  3 - testValidMoveRMA_toSouthSouthWest
	 * Input : putUnit RMA (2,7) -> (1,9) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(1,9) = RMA
	 *  4 - testValidMoveRMA_toSouthSouthEast
	 * Input : putUnit RMA (2,7) -> (3,9) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(3,9) = RMA
	 *  5 - testValidMoveRMA_toEastEastNorth
	 * Input : putUnit RMA (2,7) -> (4,6) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(4,6) = RMA
	 *  6 - testValidMoveRMA_toEastEastSouth
	 * Input : putUnit RMA (2,7) -> (4,8) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(4,8) = RMA
	 *  7 - testValidMoveRMA_toWestWestNorth
	 * Input : putUnit RMA (2,7) -> (0,6) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(0,6) = RMA
	 *  8 - testValidMoveRMA_toWestWestSouth
	 * Input : putUnit RMA (2,7) -> (0,8) 
	 * Expected: return SUCCESS 
	 * 												(2,7) = NONE
	 * 												(0,8) = RMA
	 *  
	 */
	@Test
	public void testValidMoveRMA() {
		// 1 - testValidMoveRMA_toNorthNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,9};
			int[] afterXY = {2,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveRMA_toNorthNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,9};
			int[] afterXY = {0,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveRMA_toSouthSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {1,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveRMA_toSouthSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {3,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(3,9, Unit.RSA, 4,9);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveRMA_toEastEastNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {4,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveRMA_toEastEastSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {4,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(4,8, Unit.RJANG, 4,9);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveRMA_toWestWestNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {0,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(1,7, Unit.RPHO, 4,7);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 8 - testValidMoveRMA_toWestWestSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,7};
			int[] afterXY = {0,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(1,9, Unit.RMA, 2,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(1,7, Unit.RPHO, 4,7);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		
	}
	

	/* - testValidMoveRSANG
	 * 1 - testValidMoveRSANG_toSouthSouthEast
	 * Input : putUnit RSANG (4,6) -> (6,9) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(6,9) = RSANG
	 * 2 - testValidMoveRSANG_toSouthSouthWest
	 * Input : putUnit RSANG (4,6) -> (2,9) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(2,9) = RSANG
	 *  3 - testValidMoveRSANG_toNorthNorthEast
	 * Input : putUnit RSANG (2,9) -> (4,6) 
	 * Expected: return SUCCESS 
	 * 												(2,9) = NONE
	 * 												(4,6) = RSANG
	 *  4 - testValidMoveRSANG_toNorthNorthWest
	 * Input : putUnit RSANG (6,9) -> (4,6) 
	 * Expected: return SUCCESS 
	 * 												(6,9) = NONE
	 * 												(4,6) = RSANG
	 *  5 - testValidMoveRSANG_toEastEastSouth
	 * Input : putUnit RSANG (4,6) -> (7,8) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(7,8) = RSANG
	 *  6 - testValidMoveRSANG_toEastEastNorth
	 * Input : putUnit RSANG (4,6) -> (7,4) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(7,4) = RSANG
	 *  7 - testValidMoveRSANG_toWestWestSouth
	 * Input : putUnit RSANG (4,6) -> (1,8) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(1,8) = RSANG
	 *  8 - testValidMoveRSANG_toWestWestNorth
	 * Input : putUnit RSANG (4,6) -> (1,4) 
	 * Expected: return SUCCESS 
	 * 												(4,6) = NONE
	 * 												(1,4) = RSANG
	 *  
	 */
	@Test
	public void testValidMoveRSANG() {
		// 1 - testValidMoveRSANG_toSouthSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {6,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(6,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 2 - testValidMoveRSANG_toSouthSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {2,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(2,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 3 - testValidMoveRSANG_toNorthNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,9};
			int[] afterXY = {4,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 4 - testValidMoveRSANG_toNorthNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {6,9};
			int[] afterXY = {4,6};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 5 - testValidMoveRSANG_toEastEastSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {7,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(2,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 6 - testValidMoveRSANG_toEastEastNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {7,4};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(2,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 7 - testValidMoveRSANG_toWestWestSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {1,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(2,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
		// 8 - testValidMoveRSANG_toWestWestNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,6};
			int[] afterXY = {1,4};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,6, Unit.RJOL, 4,5);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(2,9, Unit.RSANG, 4,6);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}		
	}
	
	

	

	/* - testValidMoveRSA
	 * 1 - testValidMoveRSA_toEast
	 * Input : putUnit RSA (3,9) -> (4,9) 
	 * Expected: return SUCCESS 
	 * 												(3,9) = NONE
	 * 												(4,9) = RSA
	 *  2 - testValidMoveRSA_toSouth
	 * Input : putUnit RSA (3,8) -> (3,9) 
	 * Expected: return SUCCESS 
	 * 												(3,8) = NONE
	 * 												(3,9) = RSA
	 *  3 - testValidMoveRSA_toNorth
	 * Input : putUnit RSA (3,9) -> (3,8) 
	 * Expected: return SUCCESS 
	 * 												(3,9) = NONE
	 * 												(3,8) = RSA
	 *  4 - testValidMoveRSA_toWest
	 * Input : putUnit RSA (5,9) -> (4,9) 
	 * Expected: return SUCCESS 
	 * Expected: return SUCCESS 
	 * 												(5,9) = NONE
	 * 												(4,9) = RSA
	 *  5 - testValidMoveRSA_toDiagonalSouthEast
	 * Input : putUnit RSA (4,8) -> (5,9) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(5,9) = RSA
	 *  6 - testValidMoveRSA_toDiagonalSouthWest
	 * Input : putUnit RSA (4,8) -> (3,9) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(3,9) = RSA
	 *  7 - testValidMoveRSA_toDiagonalNorthWest
	 * Input : putUnit RSA (4,8) -> (3,7) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(3,7) = RSA
	 *  8 - testValidMoveRSA_toDiagonalNorthEast
	 * Input : putUnit RSA (4,8) -> (5,7) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(5,7) = RSA
	 */
	@Test
	public void testValidMoveRSA() {
		// 1 - testValidMoveRSA_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,9};
			int[] afterXY = {4,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveRSA_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,8};
			int[] afterXY = {3,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(3,9, Unit.RSA, 3,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveRSA_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,9};
			int[] afterXY = {3,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveRSA_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {5,9};
			int[] afterXY = {4,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveRSA_toDiagonalSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {5,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,8, Unit.RJANG, 4,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(5,9, Unit.RSA, 4,8);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveRSA_toDiagonalSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {3,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,8, Unit.RJANG, 4,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(3,9, Unit.RSA, 4,8);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveRSA_toDiagonalNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {3,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,8, Unit.RJANG, 4,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(3,9, Unit.RSA, 4,8);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveRSA_toDiagonalNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {5,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(4,8, Unit.RJANG, 4,7);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			testJangGi.putUnit(3,9, Unit.RSA, 4,8);
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
	}
	

	
	
	/* - testValidMoveRJANG
	 * 1 - testValidMoveRJANG_toNorth
	 * Input : putUnit RJANG (4,8) -> (4,7) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(4,7) = RJANG
	 *  2 - testValidMoveRJANG_toWest
	 * Input : putUnit RJANG (4,8) -> (3,8) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(3,8) = RJANG
	 *  3 - testValidMoveRJANG_toEast
	 * Input : putUnit RJANG (4,8) -> (5,8) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(5,8) = RJANG
	 *  4 - testValidMoveRJANG_toDiagonalSouthEast
	 * Input : putUnit RJANG (4,8) -> (5,9) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(5,9) = RJANG
	 *  5 - testValidMoveRJANG_toSouth
	 * Input : putUnit RJANG (4,8) -> (4,9) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(4,9) = RJANG
	 *  6 - testValidMoveRJANG_toDiagonalSouthWest
	 * Input : putUnit RJANG (4,8) -> (3,9) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(3,9) = RJANG
	 *  7 - testValidMoveRJANG_toDiagonalNorthWest
	 * Input : putUnit RJANG (4,8) -> (3,7) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(3,7) = RJANG
	 *  8 - testValidMoveRJANG_toDiagonalNorthEast
	 * Input : putUnit RJANG (4,8) -> (5,7) 
	 * Expected: return SUCCESS 
	 * 												(4,8) = NONE
	 * 												(5,7) = RJANG
	 */
	@Test
	public void testValidMoveRJANG() {
		// 1 - testValidMoveRJANG_toNorth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {4,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 2 - testValidMoveRJANG_toWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {3,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 3 - testValidMoveRJANG_toEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {5,8};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 4 - testValidMoveRJANG_toDiagonalSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {4,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(5,9, Unit.RSA, 5,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 5 - testValidMoveRJANG_toSouth
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {4,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 6 - testValidMoveRJANG_toDiagonalSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {3,9};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(3,9, Unit.RSA, 3,8);
			testJangGi.putUnit(1,3, Unit.BJOL, 0,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 7 - testValidMoveRJANG_toDiagonalNorthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {3,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		// 8 - testValidMoveRJANG_toDiagonalNorthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,8};
			int[] afterXY = {5,7};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.RJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.RJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
			assertEquals(Unit.NULL, testJangGi.getUnit(beforeXY[0], beforeXY[1]));
		}
		
	}

	
	

}
