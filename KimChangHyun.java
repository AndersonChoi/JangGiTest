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
	@Test
	public void BSANG_CaptureTest(){			//RSA is just repeating useless movement
		int[] myXY = {6, 0};			//Set the moving BSANG
		janggi.putUnit(4, 3, Unit.BJOL, 3, 3);			//Open the BSANG's way
		janggi.putUnit(8, 6, Unit.RJOL, 7, 6);			//To move RPHO
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] + 3);
		janggi.putUnit(7, 7, Unit.RPHO, 7, 5);			//Open the BSANG's way
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] + 3);			//Capture RJOL
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] + 2, myXY[1] = myXY[1] + 3);			//Capture RCHA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 8, Unit.RSA, 5, 9);
		
		janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] - 3);
		janggi.putUnit(3, 9, Unit.RSA, 4, 9);			//Set the RSA captured by BSANG
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 2, myXY[1] = myXY[1] + 3);			//Capture RSA
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 9, Unit.RSA, 5, 8);
		
		result = janggi.putUnit(myXY[0], myXY[1], Unit.BSANG, myXY[0] = myXY[0] - 3, myXY[1] = myXY[1] - 2);			//Capture RPHO
		assertEquals(PutResult.CAPTURE, result);
		janggi.putUnit(5, 8, Unit.RSA, 5, 9);
		
	}
}
