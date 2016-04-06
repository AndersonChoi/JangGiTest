import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import KoreanChessGame.KoreanChess;
import KoreanChessGame.PutResult;
import KoreanChessGame.Unit;

public class WonYoungChoi_200924542 {

	KoreanChess testJangGi = new KoreanChess();
	// 나는 먼저 success 부터한다 success는 성공한거 캡쳐도아니고 fail도 아니고 잘이동햇는지에 대한 정보를 담는다.

	@Before
	public void setUp() {
		testJangGi = new KoreanChess();
	}

	@After
	public void tearDown() {
		testJangGi = null;
	}

	/*
	 * Input : putUnit BCHA (0,0) -> (0,1) 
	 * Expected: return SUCCESS 
	 * 												(0,0) = NONE
	 * 												(0,1) = BCHA
	 */
	@Test
	public void testValidFirstPutBCHA() {
		PutResult result = testJangGi.putUnit(0, 0, Unit.BCHA, 0, 1);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BCHA, testJangGi.getUnit(0, 1));
		assertEquals(Unit.NULL, testJangGi.getUnit(0, 0));
	}

	/*
	 * Input : putUnit BSANG (2,0) -> (3,3) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,3) = BSANG
	 */
	@Test
	public void testValidFirstPutBSANG() {
		int[] beforeXY = {1,0};
		int[] afterXY = {3,3};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BSANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BMA (2,0) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(2,0) = NONE
	 * 												(3,2) = BMA
	 */
	@Test
	public void testValidFirstPutBMA_01() {
		int[] beforeXY = {2,0};
		int[] afterXY = {3,2};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	

	/*
	 * Input : putUnit BMA (3,2) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,2) = NONE
	 * 												(4,0) = BMA
	 */
	@Test
	public void testValidFirstPutBMA_02() {
		int[] beforeXY = {3,2};
		int[] afterXY = {4,0};
		testJangGi.putUnit(2,0, Unit.BMA, 3,2);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BMA, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BMA, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BSA (3,0) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(4,0) = BSA
	 */
	@Test
	public void testValidFirstPutBSA_01() {
		int[] beforeXY = {3,0};
		int[] afterXY = {4,0};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BSA (3,0) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(3,0) = NONE
	 * 												(3,1) = BSA
	 */
	@Test
	public void testValidFirstPutBSA_02() {
		int[] beforeXY = {3,0};
		int[] afterXY = {3,1};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BSA, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BSA, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	


	/*
	 * Input : putUnit BJANG (4,1) -> (4,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,0) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_01() {
		int[] beforeXY = {4,1};
		int[] afterXY = {4,0};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	
	

	/*
	 * Input : putUnit BJANG (4,1) -> (3,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,1) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_02() {
		int[] beforeXY = {4,1};
		int[] afterXY = {3,1};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	


	/*
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_03() {
		int[] beforeXY = {4,1};
		int[] afterXY = {5,1};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	

	/*
	 * Input : putUnit BJANG (4,1) -> (3,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,2) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_04() {
		int[] beforeXY = {4,1};
		int[] afterXY = {3,2};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BJANG (4,1) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(4,2) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_05() {
		int[] beforeXY = {4,1};
		int[] afterXY = {4,2};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BJANG (4,1) -> (5,2) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,2) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_06() {
		int[] beforeXY = {4,1};
		int[] afterXY = {5,2};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}


	/*
	 * Input : putUnit BJANG (4,1) -> (5,1) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,1) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_07() {
		int[] beforeXY = {4,1};
		int[] afterXY = {5,1};
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BJANG (4,1) -> (3,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(3,0) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_08() {
		int[] beforeXY = {4,1};
		int[] afterXY = {3,0};
		testJangGi.putUnit(3,0, Unit.BSA, 3,1);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BJANG (4,1) -> (5,0) 
	 * Expected: return SUCCESS 
	 * 												(4,1) = NONE
	 * 												(5,0) = BJANG
	 */
	@Test
	public void testValidFirstPutBJANG_09() {
		int[] beforeXY = {4,1};
		int[] afterXY = {5,0};
		testJangGi.putUnit(5,0, Unit.BSA, 5,1);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BJANG, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BJANG, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	
	
	
	
	/*
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_01() {
		int[] beforeXY = {1,2};
		int[] afterXY = {4,2};
		testJangGi.putUnit(2,0, Unit.BMA, 3,2);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}
	


	/*
	 * Input : putUnit BPHO (1,2) -> (1,4) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,4) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_02() {
		int[] beforeXY = {1,2};
		int[] afterXY = {1,4};
		testJangGi.putUnit(0,3, Unit.BJOL, 1,3);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_03() {
		int[] beforeXY = {1,2};
		int[] afterXY = {4,2};
		testJangGi.putUnit(4,1, Unit.BJANG, 3,2);
		testJangGi.putUnit(0,6, Unit.RJOL, 1,6);
		PutResult result = testJangGi.putUnit(beforeXY[0], beforeXY[1], Unit.BPHO, afterXY[0], afterXY[1]);
		assertEquals(PutResult.SUCCESS, result);
		assertEquals(Unit.BPHO, testJangGi.getUnit(afterXY[0], afterXY[1]));
	}

	/*
	 * Input : putUnit BPHO (1,2) -> (4,2) 
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(4,2) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_04() {
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

	/*
	 * Input : putUnit BPHO (4,2) -> (4,4)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(4,4) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_05() {
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
	
	

	/*
	 * Input : putUnit BPHO (4,2) -> (0,2)
	 * Expected: return SUCCESS 
	 * 												(4,2) = NONE
	 * 												(0,2) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_06() {
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
	
	

	/*
	 * Input : putUnit BPHO (5,2) -> (3,0)
	 * Expected: return SUCCESS 
	 * 												(5,2) = NONE
	 * 												(3,0) = BPHO
	 */
	@Test
	public void testValidFirstPutBPHO_07() {
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
	


	/*
	 * Input : putUnit BPHO (1,2) -> (1,7)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,7) = BPHO
	 */
	@Test
	public void testValidOverRJOL_BPHO() {
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
	

	/*
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 */
	@Test
	public void testValidOverRCHA_BPHO() {
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
	

	/*
	 * Input : putUnit BPHO (1,2) -> (1,5)
	 * Expected: return SUCCESS 
	 * 												(1,2) = NONE
	 * 												(1,5) = BPHO
	 */
	@Test
	public void testValidOverRMA_BPHO() {
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
