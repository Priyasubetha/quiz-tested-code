package servlet.service;

public class intConvertionService {

	public int[] convertToInt(String questionNumber,String numberOfQuestions) {
		int inputedDatas[] = new int[2];
		int numStart,numTotal;
		if(questionNumber!=null && numberOfQuestions!=null) {
			if(questionNumber.matches("\\d+") && numberOfQuestions.matches("\\d+")){
				numStart=Integer.parseInt(questionNumber);
				
				numTotal = Integer.parseInt(numberOfQuestions);
				inputedDatas[0]=numStart;
				inputedDatas[1]=numTotal;
			}
		}
		return inputedDatas;
	}
}
