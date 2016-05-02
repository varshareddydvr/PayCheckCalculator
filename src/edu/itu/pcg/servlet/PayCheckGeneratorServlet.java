package edu.itu.pcg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.itu.pcg.model.PayCheckRequest;
import edu.itu.pcg.model.PayCheckResponse;
import edu.itu.pcg.service.PayCheckGeneratorService;
import edu.itu.pcg.util.ConnectionUtil;

/**
 * Servlet implementation class PayCheckGeneratorServlet
 */
public class PayCheckGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayCheckGeneratorServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	try {
			ConnectionUtil.getConnection();
			System.out.println("DB connection obtained!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	ConnectionUtil.closeConnection();
    	System.out.println("DB connection closed!");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        
        // TODO - validate http request
        PayCheckRequest paycheckReq = new PayCheckRequest(request);
        System.out.println("Paycheck Request: "+paycheckReq);
         
        PayCheckGeneratorService service = new PayCheckGeneratorService();
        PayCheckResponse paycheckResp = service.generatePayCheck(paycheckReq);
        System.out.println("Paycheck Response: "+paycheckResp);
        
    	Date currentDate = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	String setDate = dateFormat.format(currentDate);
    	request.setAttribute("date", setDate);
    	System.out.println("the date is: "+setDate);
        
    	DecimalFormat df = new DecimalFormat("#.##");
    	
        request.setAttribute("state", paycheckReq.getState());
        request.setAttribute("grossPay", paycheckReq.getAnnualGrossPay());
        request.setAttribute("grossPayType", paycheckReq.getGrossPayType());
        request.setAttribute("payFreq", paycheckReq.getPayFrequency());
        request.setAttribute("filingStatus", paycheckReq.getFilingStatus());
        request.setAttribute("paycheck_grosspay", Double.valueOf(df.format(paycheckResp.getGrossPay())));
        request.setAttribute("paycheck_netpay", Double.valueOf(df.format(paycheckResp.getNetPay())));
        request.setAttribute("paycheck_fedTax", Double.valueOf(df.format(paycheckResp.getFederalTax())));
        request.setAttribute("paycheck_stateTax", Double.valueOf(df.format(paycheckResp.getStateTax())));
        request.setAttribute("paycheck_medicareTax", Double.valueOf(df.format(paycheckResp.getMedicareTax())));
        request.setAttribute("paycheck_socialSecTax", Double.valueOf(df.format(paycheckResp.getSocialSecurityTax())));
        request.setAttribute("paycheck_sdisuiTax", Double.valueOf(df.format(paycheckResp.getSdisuiTax())));
               
        RequestDispatcher rd = request.getRequestDispatcher("payCheck.jsp");    
		rd.forward(request,response);		   
	}

}
