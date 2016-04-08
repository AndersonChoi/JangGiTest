import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import KoreanChessGame.KoreanChess;
import KoreanChessGame.PutResult;
import KoreanChessGame.Unit;

public class WonYoungChoi_200924542 {

	KoreanChess testJangGi;
	// 나는 먼저 success 부터한다 success는 성공한거 캡쳐도아니고 fail도 아니고 잘이동햇는지에 대한 정보를 담는다.

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
	 * - 1
	 * Input : putUnit BSANG (2,0) -> (3,3) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,3) = BSANG
	 */
	@Test
	public void testValidMoveBSANG() {
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,0};
			int[] afterXY = {3,3};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
	}

	/* - testValidMoveBMA
	 * 1 - testValidMoveMA_toSouthSouthEast
	 * Input : putUnit BMA (2,0) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,2) = BMA
	 * 2 - testValidMoveMA_toSouthSouthWest
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
	 *  6 - testValidMoveBMA_toEastEastNorth
	 *  7 - testValidMoveBMA_toWestWestSouth
	 *  8 - testValidMoveBMA_toWestWestNorth
	 *  
	 */
	@Test
	public void testValidMoveBMA() {
		// 1 - testValidMoveMA_toSouthSouthEast
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,0};
			int[] afterXY = {3,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - testValidMoveMA_toSouthSouthWest
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,2};
			int[] afterXY = {2,4};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
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
		}
		
	}
	
	
	
	/* - testValidMoveBSA
	 * - 1
	 * Input : putUnit BSA (3,0) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(4,0) = BSA
	 *  - 2 
	 * Input : putUnit BSA (3,0) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(3,1) = BSA
	 *  
	 *  
	 */
	@Test
	public void testValidMoveBSA() {
		// 1 - putUnit BSA (3,0) -> (4,0) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,0};
			int[] afterXY = {4,0};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - putUnit BSA (3,0) -> (3,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {3,0};
			int[] afterXY = {3,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
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
	 *  7 - testValidMoveBJANG_toWest
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 *  8 - testValidMoveBJANG_toDiagonalNorthWest
	 * Input : putUnit BJANG (4,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,0) = BJANG
	 *  9 - testValidMoveBJANG_toDiagonalNorthEast
	 * Input : putUnit BJANG (4,1) -> (5,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,0) = BJANG
	 */
	@Test
	public void testValidMoveBJANG() {
		// 1 - putUnit BJANG (4,1) -> (4,0) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {4,0};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - putUnit BJANG (4,1) -> (3,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 3 - putUnit BJANG (4,1) -> (5,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 4 - putUnit BJANG (4,1) -> (3,2) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 5 - putUnit BJANG (4,1) -> (4,2) 
		{
			testJangGi = new KoreanChess();
				int[] beforeXY = {4,1};
				int[] afterXY = {4,2};
				PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
				assertEquals(PutResult.SUCCESS, result);
				assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 6 - putUnit BJANG (4,1) -> (5,2)
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 7 - putUnit BJANG (4,1) -> (5,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 8 - putUnit BJANG (4,1) -> (3,0) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {3,0};
			testJangGi.putUnit(3,0, Unit.BSA, 3,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 9 - putUnit BJANG (4,1) -> (5,0) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {4,1};
			int[] afterXY = {5,0};
			testJangGi.putUnit(5,0, Unit.BSA, 5,1);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		
	}
	

	/* - testValidMoveBPHO
	 * - 1(testValidOverBMA_BPHO)
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * - 2(testValidOverBJOL_BPHO)
	 * Input : putUnit BPHO (1,2) -> (1,4) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,4) = BPHO
	 * - 3(testValidOverBJANG_BPHO)
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * - 4(testValidOverBSA_BPHO)
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 * - 5(testValidOverBSANG_BPHO)
	 * Input : putUnit BPHO (4,2) -> (4,4)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(4,4) = BPHO
	 * - 6(testValidOverBCHA_BPHO)
	 * Input : putUnit BPHO (4,2) -> (0,2)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(0,2) = BPHO
	 * - 7(testValidCrossOverBSA_BPHO)
	 * Input : putUnit BPHO (5,2) -> (3,0)
	 * Expected: return SUCCESS 
	 * 												(5,2) = NONE
	 * 												(3,0) = BPHO
	 * - 8(testValidOverRJOL_BPHO)
	 * Input : putUnit BPHO (1,2) -> (1,7)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,7) = BPHO
	 * - 9(testValidOverRCHA_BPHO)
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 * - 10(testValidOverRMA_BPHO)
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 * 
	 * 
	 */
	@Test
	public void testValidMoveBPHO() {
		// 1 - putUnit BPHO (1,2) -> (4,2) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {4,2};
			testJangGi.putUnit(2,0, Unit.BMA, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - putUnit BPHO (1,2) -> (1,4) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {1,4};
			testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 3 - putUnit BPHO (1,2) -> (4,2) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {1,2};
			int[] afterXY = {4,2};
			testJangGi.putUnit(4,1, Unit.BJANG, 3,2);
			testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 4 - Input : putUnit BPHO (1,2) -> (4,2) 
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
		}
		// 5 - Input : putUnit BPHO (4,2) -> (4,4)
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
		}
		// 6 - putUnit BPHO (4,2) -> (0,2)
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
		}
		// 7 - putUnit BPHO (5,2) -> (3,0)
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
		}
		// 8 - putUnit BPHO (1,2) -> (1,7)
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
		}
		// 9 - putUnit BPHO (1,2) -> (1,5)
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
		}
		// 10 - putUnit BPHO (1,2) -> (1,5)
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
		}
		
	}
	
	/* - testValidMoveBJOL
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveBJOL() {
		
	}
	

	/* - testValidMoveRJOL
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRJOL() {
		
	}
	

	/* - testValidMoveRPHO
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRPHO() {
		
	}
	
	

	/* - testValidMoveRCHA
	 * - 1(testValidMoveRCHA_toNorth)
	 * Input : putUnit RCHA (0,9) -> (0,8) 
	 * Expected: return SUCCESS 
	 * 												(0,9) = NONE
	 * 												(0,8) = RCHA
	 * 
	 * - 2(testValidMoveRCHA_toSouth)
	 * Input : putUnit RCHA (0,8) -> (0,9) 
	 * Expected: return SUCCESS 
	 * 												(0,8) = NONE
	 * 												(0,9) = RCHA
	 * 
	 * 
	 * - 3(testValidMoveRCHA_toEast)
	 * Input : putUnit RCHA (0,8) -> (1,8) 
	 * Expected: return SUCCESS 
	 * 												(0,8) = NONE
	 * 												(1,8) = RCHA
	 * 
	 * - 4(testValidMoveRCHA_toWest)
	 * Input : putUnit RCHA (1,8) -> (0,8) 
	 * Expected: return SUCCESS 
	 * 												(1,8) = NONE
	 * 												(0,8) = RCHA
	 */
	@Test
	public void testValidMoveRCHA() {
		// 1 - putUnit RCHA (0,9) -> (0,8) 
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
		// 2 - putUnit RCHA (0,8) -> (0,9) 
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
		// 3 - putUnit RCHA (0,8) -> (1,8) 
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
		// 4 - putUnit RCHA (1,8) -> (0,8) 
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
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRMA() {
		
	}
	


	/* - testValidMoveRSANG
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRSANG() {
		
	}


	/* - testValidMoveRSA
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRSA() {
		
	}


	/* - testValidMoveRJANG
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRJANG() {
		
	}
	
	
	

}
