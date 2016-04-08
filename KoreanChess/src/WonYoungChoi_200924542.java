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
	 * - 1(testValidMoveCHA_toSouth)
	 * Input : putUnit BCHA (0,0) -> (0,1) 
	 * Expected: return SUCCESS 
	 * 												(0,0) = NONE
	 * 												(0,1) = BCHA
	 * 
	 * - 2(testValidMoveCHA_toNorth)
	 * 
	 * - 3(testValidMoveCHA_toEast)
	 * 
	 * - 4(testValidMoveCHA_toWest)
	 * 
	 */
	@Test
	public void testValidMoveBCHA() {
		// 1 - putUnit BCHA (0,0) -> (0,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,0};
			int[] afterXY = {0,1};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - putUnit BCHA (0,1) -> (0,0) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,1};
			int[] afterXY = {0,0};
			testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}

		// 3 - putUnit BCHA (0,1) -> (1,1) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {0,1};
			int[] afterXY = {1,1};
			testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
			testJangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BCHA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}

		// 4 - putUnit BCHA (1,1) -> (0,1) 
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
	 * - 1
	 * Input : putUnit BMA (2,0) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,2) = BMA
	 * 
	 *  - 2 
	 * Input : putUnit BMA (3,2) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(4,0) = BMA
	 *  
	 */
	@Test
	public void testValidMoveBMA() {
		// 1 - putUnit BMA (2,0) -> (3,2) 
		{
			testJangGi = new KoreanChess();
			int[] beforeXY = {2,0};
			int[] afterXY = {3,2};
			PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
			assertEquals(PutResult.SUCCESS, result);
			assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
		}
		// 2 - putUnit BMA (3,2) -> (4,0) 
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
	 * - 1
	 * Input : putUnit BJANG (4,1) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,0) = BJANG
	 *  - 2
	 * Input : putUnit BJANG (4,1) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,1) = BJANG
	 *  - 3
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 *  - 4
	 * Input : putUnit BJANG (4,1) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,2) = BJANG
	 *  - 5
	 * Input : putUnit BJANG (4,1) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,2) = BJANG
	 *  - 6
	 * Input : putUnit BJANG (4,1) -> (5,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,2) = BJANG
	 *  - 7
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 *  - 8
	 * Input : putUnit BJANG (4,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,0) = BJANG
	 *  - 9
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
	 * - 1
	 * 
	 */
	@Test
	public void testValidMoveRCHA() {
		
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
