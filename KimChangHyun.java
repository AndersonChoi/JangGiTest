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
	
	/*
	 * BJOL captures all kinds of objects
	 */
	@Test
	public void BJOL_CaptureTest() {			//RSA is just repeating useless movement
		int[] myXY = {0, 3};			//Set the moving BJOL
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);			//Capture RJOL
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);			//Capture RCHA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, ++myXY[0], myXY[1]);			//Capture RMA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, ++myXY[0], myXY[1]);			//Capture RSANG
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 3, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, ++myXY[0], myXY[1]);			//Capture RSA
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		myXY[0] = 2; myXY[1] = 3; 		//Set the new moving BJOL
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, --myXY[0], myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);			//Capture RPHO
		assertEquals(PutResult.CAPTURE,result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		
		myXY[0] = 4; myXY[1] = 3;		//Set the new moving BJOL
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, --myXY[0], myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, myXY[0], ++myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BJOL, ++myXY[0], ++myXY[1]);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER,result);
	}

	/*
	 * RJOL captures all kinds of objects
	 */
	@Test
	public void RJOL_CaptureTest() {			//BSA is just repeating useless movement
		int[] myXY = {8, 6};			//Set the moving RJOL
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 0, Unit.BSA, 4, 0);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, --myXY[0], myXY[1]);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 5, 0);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, --myXY[0], myXY[1]);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, --myXY[0], myXY[1]);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		myXY[0] = 6; myXY[1] = 6;			//Set the new moving RJOL
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, ++myXY[0], myXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		
		myXY[0] = 4; myXY[1] = 6;			//Set the new moving RJOL
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, ++myXY[0], myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, myXY[0], --myXY[1]);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RJOL, --myXY[0], --myXY[1]);			//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}
	
	/*
	 * BCHA captures all kinds of objects
	 */
	@Test
	public void BCHA_CaptureTest(){			//RSA is just repeating useless movement
		int[] myXY = {0, 0};			//Set the moving BCHA
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);	//Open the BCHA's way
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, myXY[0], myXY[1] = myXY[1] + 6);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, myXY[0], myXY[1] = myXY[1] + 3);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, ++myXY[0], myXY[1]);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, myXY[0], myXY[1] = myXY[1] - 2);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, ++myXY[0], myXY[1]);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, ++myXY[0], myXY[1]);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BCHA, ++myXY[0], --myXY[1]);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}

	/*
	 * RCHA captures all kinds of objects
	 */
	@Test
	public void RCHA_CaptureTest(){			//BSA is just repeating useless movement
		int[] myXY = {8, 9};			//Set the moving RCHA
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);	//Open the RCHA's way
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, myXY[0], myXY[1] = myXY[1] - 6);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, myXY[0], myXY[1] = myXY[1] - 3);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, --myXY[0], myXY[1]);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, myXY[0], myXY[1] = myXY[1] + 2);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, --myXY[0], myXY[1]);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, --myXY[0], myXY[1]);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RCHA, --myXY[0], ++myXY[1]);			//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}
	
	/*
	 * BMA captures all kinds of objects
	 */
	@Test
	public void BMA_CaptureTest(){			//RSA is just repeating useless movement
		int[] myXY = {2, 0};			//Set the moving BMA
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, --myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, --myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, myXY[0] = myXY[0] - 2, ++myXY[1]);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] - 2);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] + 2);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, --myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);
		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, myXY[0] = myXY[0] + 2, ++myXY[1]);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, myXY[0] = myXY[0] - 2, ++myXY[1]);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] + 2);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, --myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, --myXY[0], myXY[1] = myXY[1] + 2);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 9, Unit.RSA, 5, 9);

		janggi.putUnit(myXY[0], myXY[1], Unit.BMA, ++myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(5, 9, Unit.RSA, 4, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BMA, myXY[0] + 2, ++myXY[1]);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}
	
	/*
	 * RMA captures all kinds of objects
	 */
	@Test
	public void RMA_CaptureTest(){			//BSA is just repeating useless movement
		int[] myXY = {7, 9};			//Set the Moving RMA
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(6, 6, Unit.RJOL, 7, 6);	//Open the RMA's way
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] - 2);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, ++myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, myXY[0] = myXY[0] + 2, --myXY[1]);			//Capture BMA
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] - 2);			//Capture BSA
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, ++myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, myXY[0] = myXY[0] - 2, ++myXY[1]);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, ++myXY[0], myXY[1] = myXY[1] - 2);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, myXY[0] = myXY[0] + 2, ++myXY[1]);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, ++myXY[0], myXY[1] = myXY[1] - 2);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] + 2);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, --myXY[0], myXY[1] = myXY[1] - 2);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 0, Unit.BSA, 3, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RMA, myXY[0] - 2, ++myXY[1]);			//Capture BJANG 'GAME OVER'
		assertEquals(PutResult.GAMEOVER, result);
	}
	
	/*
	 * BSANG captures all kinds of objects
	 */
	@Test
	public void BSANG_CaptureTest(){			//RSA is just repeating useless movement
		int[] myXY = {6, 0};			//Set the moving BSANG
		janggi.putUnit(4, 3, Unit.BJOL, 3, 3);			//Open the BSANG's way
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);			//To move RPHO
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] + 3);
		janggi.putUnit(7, 7, Unit.RPHO, 7, 5);			//Open the BSANG's way
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] + 3);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 6, Unit.RJOL, 5, 6);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] + 3);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);			//Set the RMA captured by BSANG
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] - 3);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);			//Set the RSA captured by BSANG
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] + 3);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(2, 7, Unit.RMA, 4, 6);			//Set the RMA captured by BSANG
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] - 2);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] + 2);
		janggi.putUnit(4, 6, Unit.RMA, 3, 8);			//Set the RMA captured by BSANG
		janggi.putUnit(5, 0, Unit.BSA, 5, 1);
		janggi.putUnit(3, 8, Unit.RMA, 1, 7);			//Set the RMA captured by BSANG
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] - 2);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 8, Unit.RSA, 5, 9);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] - 3);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] + 3);
		janggi.putUnit(5, 8, Unit.RSA, 5, 9);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] + 2);			//Capture RSANG
		janggi.showBoard();
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 8, Unit.RJANG, 5, 7);			//Set the RJANG captured by BSANG
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] - 2);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}

	/*
	 * RSANG captures all kinds of objects
	 */
	@Test
	public void RSANG_CaptureTest(){			//BSA is just repeating useless movement
		int[] myXY = {2, 9};			//Set the moving BSANG
		janggi.putUnit(8, 3, Unit.BJOL, 7, 3);			//To move BPHO
		janggi.putUnit(4, 6, Unit.RJOL, 3, 6);
		janggi.putUnit(7, 2, Unit.BPHO, 7, 4);
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] - 3);
		janggi.putUnit(5, 0, Unit.BSA, 5, 1);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] - 3);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 1, Unit.BSA, 5, 0);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] - 3);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);			//Set the BSA captured by RSANG
	
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] + 3);
		janggi.putUnit(7, 4, Unit.BPHO, 7, 2);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] - 3);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 0, Unit.BSA, 5, 1);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] + 2);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 1, Unit.BSA, 5, 0);
		
		myXY[0] = 6; myXY[1] = 9;			//Set the new moving RSANG
		
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] - 3);
		janggi.putUnit(5, 0, Unit.BSA, 5, 1);
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] - 2);
		janggi.putUnit(5, 1, Unit.BSA, 5, 0);
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] - 2);
		janggi.putUnit(5, 0, Unit.BSA, 5, 1);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] - 2);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(2, 0, Unit.BMA, 3, 2);			//Open the RSANG's way

	
		janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] + 2);
		janggi.putUnit(5, 1, Unit.BSA, 5, 0);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] - 2);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 1, Unit.BJANG, 4, 0);			//Set the BJANG captured by RSANG

		myXY[0] = 1; myXY[1] = 2;			//Set the before moved RSANG
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RSANG, myXY[0] = myXY[0] + 3, myXY[1] = myXY[1] - 2);			//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
		janggi.showBoard();
	}

	/*
	 * BPHO captures all kinds of objects
	 */
	@Test
	public void BPHO_CaptureTest(){			//RJOL is just repeating useless movement
		int[] myXY = {1, 2};			//Set the moving BPHO
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);			//To make BPHO can jump
		janggi.putUnit(0, 6, Unit.RJOL, 1, 6);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0], myXY[1] = myXY[1] + 4);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);			//To step aside the RPHO
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0], myXY[1] = myXY[1] - 4);
		janggi.putUnit(1, 7, Unit.RPHO, 4, 7);			//Step aside the RPHO
		janggi.putUnit(3, 0, Unit.BSA, 4, 0);
		janggi.putUnit(2, 7, Unit.RMA, 1, 9);			//Set the RMA captured by BPHO
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0], myXY[1] = myXY[1] + 7);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0] = myXY[0] + 2, myXY[1]);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0] = myXY[0] + 3, myXY[1]);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0] = myXY[0] + 2, myXY[1]);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 8, Unit.RJANG, 5, 9);			//Set the RJANG captured by BPHO

		result = janggi.putUnit(myXY[0], myXY[1], Unit.BPHO, myXY[0] = myXY[0] - 3, myXY[1]);			//Capture RJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}

	/*
	 * RPHO captures all kinds of objects
	 */
	@Test
	public void RPHO_CaptureTest(){			//BJOL is just repeating useless movement
		int[] myXY = {7, 7};			//Set the moving RPHO
		janggi.putUnit(8, 3, Unit.BJOL, 7, 3);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);			//To make RPHO can jump
		janggi.putUnit(7, 0, Unit.BMA, 6, 2);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0], myXY[1] = myXY[1] - 4);			//Capture BJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(7, 2, Unit.BPHO, 4, 2);

		janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0], myXY[1] = myXY[1] + 4);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0], myXY[1] = myXY[1] - 7);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0] = myXY[0] - 2, myXY[1]);			//Capture BSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0] = myXY[0] - 3, myXY[1]);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 0, Unit.BSANG, 3, 3);			//To Set the BCHA captured by RPHO
		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0] = myXY[0] + 4, myXY[1]);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0] = myXY[0] - 6, myXY[1]);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 1, Unit.BJANG, 4, 0);			//Set the BJANG captured by RPHO

		result = janggi.putUnit(myXY[0], myXY[1], Unit.RPHO, myXY[0] = myXY[0] + 4, myXY[1]);			//Capture BJANG 'GAMEOVER'
		assertEquals(PutResult.GAMEOVER, result);
	}

	/*
	 * BSA captures all kinds of objects without RJANG and RSA
	 */
	@Test
	public void BSA_CaptureTest(){			//BJOL is just repeating useless movement
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);			//Open The RCHA's way
		janggi.putUnit(0, 6, Unit.RJOL, 1, 6);			//Open The RCHA's way
		janggi.putUnit(2, 0, Unit.BMA, 3, 2);			//To make BPHO can jump
		janggi.putUnit(0, 9, Unit.RCHA, 0, 1);
		janggi.putUnit(1, 2, Unit.BPHO, 4, 2);			//To make RPHO can jump
		janggi.putUnit(0, 1, Unit.RCHA, 3, 1);
		result = janggi.putUnit(3, 0, Unit.BSA, 3, 1);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 6, Unit.RJOL, 5, 6);			//Open The RSANG's way

		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);			//To make RPHO can jump
		janggi.putUnit(1, 7, Unit.RPHO, 1, 1);
		janggi.putUnit(3, 1, Unit.BSA, 3, 0);			//Back to original position
		janggi.putUnit(1, 1, Unit.RPHO, 5, 1);
		result = janggi.putUnit(5, 0, Unit.BSA, 5, 1);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(2, 9, Unit.RSANG, 4, 6);

		janggi.putUnit(5, 1, Unit.BSA, 5, 0);			//Back to original position
		janggi.putUnit(4, 6, Unit.RSANG, 6, 3);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(6, 3, Unit.RSANG, 4, 0);
		result = janggi.putUnit(3, 0, Unit.BSA, 4, 0);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);

		janggi.putUnit(5, 0, Unit.BSA, 5, 1);
		janggi.putUnit(2, 7, Unit.RMA, 4, 6);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(2, 7, Unit.RMA, 4, 6);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(4, 6, Unit.RMA, 5, 4);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(5, 4, Unit.RMA, 7, 3);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(7, 3, Unit.RMA, 5, 2);
		result = janggi.putUnit(5, 1, Unit.BSA, 5, 2);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 6, Unit.RJOL, 5, 5);
		
		janggi.putUnit(5, 2, Unit.BSA, 5, 1);
		janggi.putUnit(5, 5, Unit.RJOL, 5, 4);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(5, 4, Unit.RJOL, 5, 3);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(5, 3, Unit.RJOL, 5, 2);
		result = janggi.putUnit(5, 1, Unit.BSA, 5, 2);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
	}

	/*
	 * RSA captures all kinds of objects without BJANG and BSA
	 */
	@Test
	public void RSA_CaptureTest(){			//RJOL is just repeating useless movement
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);			//Open The BCHA's way
		janggi.putUnit(0, 6, Unit.RJOL, 1, 6);			//Open The BCHA's way
		janggi.putUnit(0, 0, Unit.BCHA, 0, 8);
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);			//To make RPHO can jump
		janggi.putUnit(0, 8, Unit.BCHA, 3, 8);
		result = janggi.putUnit(3, 9, Unit.RSA, 3, 8);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);			//To make BPHO can jump

		janggi.putUnit(1, 7, Unit.RPHO, 4, 7);			//To make BPHO can jump
		janggi.putUnit(1, 2, Unit.BPHO, 1, 8);
		janggi.putUnit(3, 8, Unit.RSA, 3, 9);			//Back to original position
		janggi.putUnit(1, 8, Unit.BPHO, 5, 8);
		result = janggi.putUnit(5, 9, Unit.RSA, 5, 8);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 3, Unit.BJOL, 5, 3);			//Open the BSANG's way

		janggi.putUnit(5, 8, Unit.RSA, 5, 9);			//Back to original position
		janggi.putUnit(6, 0, Unit.BSANG, 4, 3);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(4, 3, Unit.BSANG, 6, 6);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(6, 6, Unit.BSANG, 4, 9);
		result = janggi.putUnit(3, 9, Unit.RSA, 4, 9);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(7, 0, Unit.BMA, 6, 2);

		janggi.putUnit(4, 6, Unit.RJOL, 5, 6);			//Open the BMA's way
		janggi.putUnit(6, 2, Unit.BMA, 4, 3);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(4, 3, Unit.BMA, 2, 4);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(2, 4, Unit.BMA, 3, 6);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);
		janggi.putUnit(3, 6, Unit.BMA, 5, 7);
		result = janggi.putUnit(5, 8, Unit.RSA, 5, 7);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 3, Unit.BJOL, 5, 4);

		janggi.putUnit(5, 7, Unit.RSA, 5, 8);			//Back to before position
		janggi.putUnit(5, 4, Unit.BJOL, 5, 5);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(5, 5, Unit.BJOL, 5, 6);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(5, 6, Unit.BJOL, 5, 7);
		result = janggi.putUnit(5, 8, Unit.RSA, 5, 7);			//Capture BJOL
		janggi.showBoard();
		assertEquals(PutResult.CAPTURE, result);
	}

	/*
	 * BJANG captures all kinds of objects without RJANG and RSA
	 */
	@Test
	public void BJANG_CaptureTest(){			//BJOL is just repeating useless movement
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);			//Open The RCHA's way
		janggi.putUnit(0, 6, Unit.RJOL, 1, 6);			//Open The RCHA's way
		janggi.putUnit(2, 0, Unit.BMA, 3, 2);			//To make BPHO can jump
		janggi.putUnit(0, 9, Unit.RCHA, 0, 1);
		janggi.putUnit(1, 2, Unit.BPHO, 4, 2);			//To make RPHO can jump
		janggi.putUnit(0, 1, Unit.RCHA, 3, 1);
		result = janggi.putUnit(4, 1, Unit.BJANG, 3, 1);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 6, Unit.RJOL, 5, 6);			//Open The RSANG's way

		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);			//To make RPHO can jump
		janggi.putUnit(1, 7, Unit.RPHO, 1, 1);
		janggi.putUnit(3, 1, Unit.BJANG, 4, 1);			//Back to original position
		janggi.putUnit(1, 1, Unit.RPHO, 5, 1);
		result = janggi.putUnit(4, 1, Unit.BJANG, 5, 1);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(2, 9, Unit.RSANG, 4, 6);

		janggi.putUnit(5, 1, Unit.BJANG, 4, 1);			//Back to original position
		janggi.putUnit(4, 6, Unit.RSANG, 6, 3);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(6, 3, Unit.RSANG, 4, 0);
		result = janggi.putUnit(4, 1, Unit.BJANG, 4, 0);			//Capture RSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);

		janggi.putUnit(4, 0, Unit.BJANG, 4, 1);			//Back to original position
		janggi.putUnit(2, 7, Unit.RMA, 4, 6);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(2, 7, Unit.RMA, 4, 6);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(4, 6, Unit.RMA, 5, 4);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(5, 4, Unit.RMA, 7, 3);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(7, 3, Unit.RMA, 5, 2);
		result = janggi.putUnit(4, 1, Unit.BJANG, 5, 2);			//Capture RMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 6, Unit.RJOL, 5, 5);
		
		janggi.putUnit(5, 2, Unit.BJANG, 4, 1);			//Back to original position
		janggi.putUnit(5, 5, Unit.RJOL, 5, 4);
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);
		janggi.putUnit(5, 4, Unit.RJOL, 5, 3);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);
		janggi.putUnit(5, 3, Unit.RJOL, 5, 2);
		result = janggi.putUnit(4, 1, Unit.BJANG, 5, 2);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
	}

	/*
	 * RJANG captures all kinds of objects without BJANG and BSA
	 */
	@Test
	public void RJANG_CaptureTest(){			//RJOL is just repeating useless movement
		janggi.putUnit(0, 3, Unit.BJOL, 1, 3);			//Open The BCHA's way
		janggi.putUnit(0, 6, Unit.RJOL, 1, 6);			//Open The BCHA's way
		janggi.putUnit(0, 0, Unit.BCHA, 0, 8);
		janggi.putUnit(1, 9, Unit.RMA, 2, 7);			//To make RPHO can jump
		janggi.putUnit(0, 8, Unit.BCHA, 3, 8);
		result = janggi.putUnit(4, 8, Unit.RJANG, 3, 8);			//Capture BCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(1, 3, Unit.BJOL, 0, 3);			//To make BPHO can jump

		janggi.putUnit(1, 7, Unit.RPHO, 4, 7);			//To make BPHO can jump
		janggi.putUnit(1, 2, Unit.BPHO, 1, 8);
		janggi.putUnit(3, 8, Unit.RJANG, 4, 8);			//Back to original position
		janggi.putUnit(1, 8, Unit.BPHO, 5, 8);
		result = janggi.putUnit(4, 8, Unit.RJANG, 5, 8);			//Capture BPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(4, 3, Unit.BJOL, 5, 3);			//Open the BSANG's way

		janggi.putUnit(5, 8, Unit.RJANG, 4, 8);			//Back to original position
		janggi.putUnit(6, 0, Unit.BSANG, 4, 3);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(4, 3, Unit.BSANG, 6, 6);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(6, 6, Unit.BSANG, 4, 9);
		result = janggi.putUnit(4, 8, Unit.RJANG, 4, 9);			//Capture BSANG
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(7, 0, Unit.BMA, 6, 2);

		janggi.putUnit(4, 6, Unit.RJOL, 5, 6);			//Open the BMA's way
		janggi.putUnit(6, 2, Unit.BMA, 4, 3);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(4, 3, Unit.BMA, 2, 4);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(2, 4, Unit.BMA, 3, 6);
		janggi.putUnit(4, 9, Unit.RJANG, 4, 8);			//Back to original position
		janggi.putUnit(3, 6, Unit.BMA, 5, 7);
		result = janggi.putUnit(4, 8, Unit.RJANG, 5, 7);			//Capture BMA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 3, Unit.BJOL, 5, 4);

		janggi.putUnit(5, 7, Unit.RJANG, 4, 8);			//Back to before position
		janggi.putUnit(5, 4, Unit.BJOL, 5, 5);
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);
		janggi.putUnit(5, 5, Unit.BJOL, 5, 6);
		janggi.putUnit(7, 6, Unit.RJOL, 8, 6);
		janggi.putUnit(5, 6, Unit.BJOL, 5, 7);
		result = janggi.putUnit(4, 8, Unit.RJANG, 5, 7);			//Capture BJOL
		janggi.showBoard();
		assertEquals(PutResult.CAPTURE, result);
	}
}
