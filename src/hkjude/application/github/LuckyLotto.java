package hkjude.application.github;

import java.util.Arrays;
import java.util.Random;

public class LuckyLotto {
	private Random random = new Random();

	protected String performLotto(int luckyNumber){
		if(luckyNumber > 10){
			return "LuckyNumber Range is 0~10";
		}
		int[] getNumbers = null;
		String rValue = "Generate Lotto Number\n";
		for(int i=0;i<3;i++){//3게임 번호 생성.
			for(int j=0;j<11;j++){//로또번호 생성하다가 luckyNumber 와 맞는것만 가져온다.
				getNumbers = null;
				getNumbers = generate6Number();
				if(luckyNumber == j){
					rValue += getNumbers[0]+", "+getNumbers[1]+", "+getNumbers[2]+", "+getNumbers[3]+", "+getNumbers[4]+", "+getNumbers[5]+"\n";
				}
			}
		}
		
		return rValue;
	}
	
	private int[] generate6Number(){
		int[] storeNumber = new int[6];//임의로 생성한 번호들을 저장할 배열
		int buff = 0;
		boolean isCorrect = false;
		for(int i=0;i<6;i++){
			buff = random.nextInt(45)+1;
			if(i > 0){
				isCorrect = false;
				for(int j=0;j<i+1;j++){
					if(buff == storeNumber[j]){//중복 값 체크.
						isCorrect = true;
						i--;
						break;
					}
				}
				
				if(!isCorrect){
					storeNumber[i] = buff;
				}
			}else{
				storeNumber[i] = buff;
			}
		}
		
		Arrays.sort(storeNumber);
		return storeNumber;
	}
	
}
