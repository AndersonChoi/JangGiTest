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
	 * Expected: Show Board
	 */

	@Test
	public void testShowBoard(){
		KoreanChess JangGi = new KoreanChess();
		JangGi.showBoard();
		assertEquals(PutResult.SUCCESS, JangGi.putUnit(0, 3, Unit.BJOL, 1, 3));
		JangGi.showBoard();
	} 
	
	/**/
	@Test// 없는 말 움직이기
	public void testFailurePutInvalidUnit(){
		int[] beforeXY={0,2};
		int[] afterXY={0,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(Unit.NULL, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test// 레드 시작
	public void testFailureFirstTurnRed(){
		int[] beforeXY={0,6};
		int[] afterXY={1,6};
		Unit target = Unit.RJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test// 초 두번
	public void testFailurePutTwoTurnBlue(){
		int[] beforeXY={0,4};
		int[] afterXY={0,5};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 0, 4);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test// 한 두번
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
	/*
	@Test //밖으로~~
	public void testFailureMoveOut(){
		int[] beforeXY={0,3};
		int[] afterXY={-1,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}*/
	
	//장
	
	@Test //장 궁성 밖으로
	public void testFailureMoveJangOutOfCastle(){
		int[] beforeXY={5,1};
		int[] afterXY={6,1};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test //장 두칸 움직이기
	public void testFailureMoveJangToTwoSpace(){
		int[] beforeXY={5,1};
		int[] afterXY={3,1};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test //장 선 없는 대각선 움직이기********
	public void testFailureMoveJangToDiagonalNoLine(){
		int[] beforeXY={5,1};
		int[] afterXY={4,2};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test //장 이상한 경로
	public void testFailureMoveJangToIllegalPath(){
		int[] beforeXY={5,1};
		int[] afterXY={3,2};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(4, 1, Unit.BJANG, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test //장 우리기물위치로 이동
	public void testFailureMoveJangToAllies(){
		int[] beforeXY={4,1};
		int[] afterXY={3,0};
		Unit target = Unit.BJANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	//사

	@Test //사 궁성 밖으로
	public void testFailureMoveSaOutOfCastle(){
		int[] beforeXY={5,1};
		int[] afterXY={6,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	@Test //사 두칸 움직이기
	public void testFailureMoveSaToTwoSpace(){
		int[] beforeXY={5,1};
		int[] afterXY={3,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	@Test //사 선 없는 대각선 움직이기********
	public void testFailureMoveSaToDiagonalNoLine(){
		int[] beforeXY={5,1};
		int[] afterXY={4,2};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	@Test //사 이상한 경로
	public void testFailureMoveSaToIllegalPath(){
		int[] beforeXY={5,1};
		int[] afterXY={3,2};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(5, 0, Unit.BSA, 5, 1);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	@Test //사 우리기물위치로 이동
	public void testFailureMoveSaToAllies(){
		int[] beforeXY={5,0};
		int[] afterXY={4,1};
		Unit target = Unit.BSA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 

	/*
	@Test //장군 당했는데 다른거 움직이기
	public void testFailureMoveOtherOnJangGun(){
		int[] beforeXY={0,6};
		int[] afterXY={1,6};
		Unit target = Unit.RJOL;
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
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test //장군 당하는 위치로 이동
	public void testFailureMoveJangDangerPosition(){
		int[] beforeXY={5,8};
		int[] afterXY={4,8};
		Unit target = Unit.RJANG;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(2, 3, Unit.BJOL, 3, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 3, Unit.BJOL, 3, 4);
		JangGi.putUnit(1, 6, Unit.RJOL, 0, 6);
		JangGi.putUnit(3, 4, Unit.BJOL, 3, 5);
		JangGi.putUnit(0, 6, Unit.RJOL, 1, 6);
		JangGi.putUnit(3, 5, Unit.BJOL, 3, 6);
		JangGi.putUnit(4, 8, Unit.RJANG, 5, 8);
		JangGi.putUnit(3, 6, Unit.BJOL, 3, 7);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}*/ 
	
	/**
	 * Input: 쫄 한칸 움직이기(후방, 적 궁성 내 대각선 후방) 
	 * Expected: PutRsult.FAILURE
	 */
	//쫄
	
	@Test //쫄 뒤로
	public void testFailureMoveJolToTheBackSpace(){
		int[] beforeXY={0,3};
		int[] afterXY={0,2};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	@Test //쫄 궁성안에서 대각선 뒤로
	public void testFailureMoveJolToBackSpaceInCastle(){
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
	
	@Test //쫄 이상한데로
	public void testFailureMoveJolToIllegalSpaces(){
		int[] beforeXY={0,3};
		int[] afterXY={1,4};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test //울팀한테 이동
	public void testFailureMoveJolToAllies(){
		int[] beforeXY={1,3};
		int[] afterXY={2,3};
		Unit target = Unit.BJOL;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(8, 6, Unit.RJOL, 7, 6);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	} 
	
	////////상~!
	
	@Test//상 경로 막힌 곳 이동
	public void testFailureMoveSangToBlockedPath(){
		int[] beforeXY={1,0};
		int[] afterXY={4,2};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//상 도착지 아군
	public void testFailureMoveSangToAllies(){
		int[] beforeXY={6,0};
		int[] afterXY={4,3};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//상 이상하게 움직이기
	public void testFailureMoveSangToIllegalSpace(){
		int[] beforeXY={6,0};
		int[] afterXY={5,2};
		Unit target = Unit.BSANG;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//상 궁성에서 대각선 직선 직선
	public void testFailureMoveSangToDiagonalFirstInCastle(){
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
	
	//마!!
	
	@Test//마 경로 막힌 곳 이동
	public void testFailureMoveMaToBlockedPath(){
		int[] beforeXY={2,0};
		int[] afterXY={0,1};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//마 도착지 아군
	public void testFailureMoveMaToAllies(){
		int[] beforeXY={2,0};
		int[] afterXY={1,2};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//마 이상하게 움직이기
	public void testFailureMoveMaToIllegalSpace(){
		int[] beforeXY={2,0};
		int[] afterXY={1,1};
		Unit target = Unit.BMA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//마 궁성에서 대각선 직선
	public void testFailureMoveMaToDiagonalFirstInCastle(){
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
	
	///포~~!
	
	@Test//포 넘기
	public void testFailureMovePhoOverTheOtherPho(){
		int[] beforeXY={1,2};
		int[] afterXY={8,2};
		int[] afterXY2={1,9};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY2[0], afterXY2[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//포 먹기
	public void testFailureMovePhoToCaptureTheOtherPho(){
		int[] beforeXY={1,2};
		int[] afterXY={1,7};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		JangGi.putUnit(0, 3, Unit.BJOL, 1, 3);
		JangGi.putUnit(0, 6, Unit.RJOL, 0, 5);
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//포 암것도 안넘고 움직이기
	public void testFailureMovePhoToDirect(){
		int[] beforeXY={1,2};
		int[] afterXY={1,4};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//포 두개 넘기
	public void testFailureMovePhoOverTwoPiece(){
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
	
	@Test//포 아군 먹기
	public void testFailureMovePhoToAllies(){
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
	
	@Test//포 대각선 넘기
	public void testFailureMovePhoToDiagonal(){
		int[] beforeXY={7,2};
		int[] afterXY={5,4};
		Unit target = Unit.BPHO;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	//////차
	
	@Test//차 기물 넘어가기
	public void testFailureMoveChaToOverAPiece(){
		int[] beforeXY={0,0};
		int[] afterXY={0,6};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//차 기물 넘어가기
	public void testFailureMoveChaToIllegalSpace(){
		int[] beforeXY={0,0};
		int[] afterXY={2,2};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//차 기물 넘어가기
	public void testFailureMoveChaToAllies(){
		int[] beforeXY={0,0};
		int[] afterXY={1,0};
		Unit target = Unit.BCHA;
		KoreanChess JangGi = new KoreanChess();
		assertEquals(PutResult.FAILURE, JangGi.putUnit(beforeXY[0], beforeXY[1], target, afterXY[0], afterXY[1]));
		assertEquals(target, JangGi.getUnit(beforeXY[0], beforeXY[1]));
	}
	
	@Test//차 궁성 선없는 대각선
	public void testFailureMoveChaToDiagonalNoLine(){
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
}

/*
실패하는 경우

없는 말 움직이기.
한 턴에 두번 움직이기.
밖으로 나가기

쫄
뒤로가기/궁성 대각선 뒤로(한 칸)
대각선 및 갈 수 없는곳으로가기(두 칸 이상)
기물이 있는 곳으로 가기

상
경로에 기물이 있을 때
도착점에 기물이 있을 때
갈 수 없는 경로
궁성 안에서 대각선 직선 직선

마
경로에 기물이 있을 때
도착점에 기물이 있을 때
갈 수 없는 경로
궁성 안에서 대각선 직선

포
포를 넘기
포를 먹기
두개 이상 넘기
안 넘기

차
넘어가기
대각선 등 이상한데 가기

사
궁성 밖으로 나가기
두 칸 이상가기
아군 기물이 있는 곳으로 가기

장
궁성 밖으로 나가기
두 칸 이상가기
아군 기물이 있는 곳으로 가기
(상대방이 장군인 위치로 움직이기)
상대방이 장군일 때 다른 말 움직이기.
*/