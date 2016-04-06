package testOracle;
import static org.junit.Assert.*;

import org.junit.*;

import KoreanChessGame.*;

public class KimChangHyun_201124435 {
	KoreanChess janggi;
	PutResult result;
	
	@Before
	public void setUp() throws Exception {
		janggi = new KoreanChess();
	}

	@After
	public void tearDown() throws Exception {
		janggi = null;
	}
	
	@Test
	public void BJOL_CaptureTest() {
		int[] beforeXY = {0, 3};
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);			//Capture RJOL
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);			//Capture RCHA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, ++beforeXY[0], beforeXY[1]);			//Capture RMA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, ++beforeXY[0], beforeXY[1]);			//Capture RSANG
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, ++beforeXY[0], beforeXY[1]);			//Capture RSA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		beforeXY[0] = 2; beforeXY[1] = 3; 
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, --beforeXY[0], beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);			//Capture RPO
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		
		beforeXY[0] = 4; beforeXY[1] = 3;
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, --beforeXY[0], beforeXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, beforeXY[0], ++beforeXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BJOL, ++beforeXY[0], ++beforeXY[1]);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER,result);
	}

	@Test
	public void RJOL_CaptureTest() {
		int[] beforeXY = {8, 6};
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, --beforeXY[0], beforeXY[1]);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, --beforeXY[0], beforeXY[1]);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, --beforeXY[0], beforeXY[1]);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		beforeXY[0] = 6; beforeXY[1] = 6;
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, ++beforeXY[0], beforeXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);			//Capture BPO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		
		beforeXY[0] = 4; beforeXY[1] = 6;
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, ++beforeXY[0], beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, beforeXY[0], --beforeXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RJOL, --beforeXY[0], --beforeXY[1]);			//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}
	
	@Test
	public void BCHA_CaptureTest(){
		int[] beforeXY = {0, 0};
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0], beforeXY[1] = beforeXY[1] + 6);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0], beforeXY[1] = beforeXY[1] + 3);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0] = beforeXY[0] + 1, beforeXY[1]);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0], beforeXY[1] = beforeXY[1] - 2);			//Capture RPO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0], beforeXY[1] = beforeXY[1] + 2);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0] = beforeXY[0] + 1, beforeXY[1]);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0] = beforeXY[0] + 1, beforeXY[1]);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.BCHA, beforeXY[0] + 1, beforeXY[1] - 1);						//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}

	@Test
	public void RCHA_CaptureTest(){
		int[] beforeXY = {8, 9};
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0], beforeXY[1] = beforeXY[1] - 6);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0], beforeXY[1] = beforeXY[1] - 3);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0] = beforeXY[0] - 1, beforeXY[1]);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0], beforeXY[1] = beforeXY[1] + 2);			//Capture BPO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0], beforeXY[1] = beforeXY[1] - 2);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0] = beforeXY[0] - 1, beforeXY[1]);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		
		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0] = beforeXY[0] - 1, beforeXY[1]);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(beforeXY[0], beforeXY[1], Unit.RCHA, beforeXY[0] - 1, beforeXY[1] +1 );						//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
		
		janggi.showBoard();
	}
}
