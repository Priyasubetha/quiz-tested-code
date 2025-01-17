package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Bean;
import servlet.model.subBean;
import servlet.service.intConvertionService;


@WebServlet("/directTo")
public class directTo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Bean b=new Bean();
		boolean flag=false;
		HttpSession session=request.getSession();
		Map<Integer,ArrayList<String>> map=new HashMap<>();
		ArrayList<String> list=new ArrayList<>();
		
		int currentQuestionNumber,totalNumberOfQuestion;
		
		String input1 = request.getParameter("input1");
		String input2 = request.getParameter("input2");
		
		String questionNumberStr=(String)session.getAttribute("questionNumber");
		String totalQuestionsStr = (String)session.getAttribute("totalNumbersOfQuestions");
		
		intConvertionService converttoint = new intConvertionService();
		int intConvertion[]=converttoint.convertToInt(questionNumberStr,totalQuestionsStr);
		currentQuestionNumber=intConvertion[0];
		totalNumberOfQuestion=intConvertion[1];
		
		String allInputs[]=new String[2];
		allInputs[0]=input1;
		allInputs[1]=input2;
		
		if(currentQuestionNumber<=totalNumberOfQuestion) {
			if(currentQuestionNumber<totalNumberOfQuestion) {
				
			for(int i=0;i<2;i++) {
				session.setAttribute("questionData"+questionNumberStr+""+i+"",allInputs[i] );
			}
				
				
			currentQuestionNumber = currentQuestionNumber+1;
			session.setAttribute("questionNumber", Integer.toString(currentQuestionNumber));
			RequestDispatcher dispatch = request.getRequestDispatcher("inputJsp.jsp");
			dispatch.forward(request, response);
			}
			else if(currentQuestionNumber==totalNumberOfQuestion){
				for(int i=0;i<2;i++) {
					session.setAttribute("questionData"+questionNumberStr+""+i+"",allInputs[i] );
				}
				System.out.println("ended");
			
				for(int i=1;i<=totalNumberOfQuestion;i++) {
					map.put(i,new ArrayList<String>());
					for(int j=0;j<2;j++) {
						String getData = (String)session.getAttribute("questionData"+i+""+j+"");
						
						map.get(i).add(getData);
					}					
		
					flag=true;
				}
			}
		}

		if(flag) {
			for(Map.Entry<Integer, ArrayList<String>> valuePair : map.entrySet()) {
				//int key=valuePair.getKey();
				list=valuePair.getValue();
				System.out.print(valuePair.getKey()+" - ");
				for(String view : list) {
					System.out.println(view);
				}
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
