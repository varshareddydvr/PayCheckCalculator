<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay check</title>
</head>
<body>
	<form id="pay_submit_form" action="PayCheckGeneratorServlet"
		method="post">
		<div style="width: 600px; border-style: solid; border-width: 1px;"
			align="center">
			<table align="center" style="width: 600px;">
				<tr align="center" bgcolor="#d4ffaa">
					<td colspan="3">Your Pay Check</td>
				</tr>
				<tr>
					<td>Check Date</td>
					<td><label value="<%=request.getAttribute("date")%>"><%=request.getAttribute("date")%></label></td>
				</tr>
				<tr>
					<td>State</td>
					<td><label><%=request.getAttribute("state")%></label></td>
				</tr>
				<tr>
					<td>Gross Pay</td>
					<td><label><%=request.getAttribute("paycheck_grosspay")%></label></td>
				</tr>
				<tr>
					<td>Net Pay</td>

					<td><label><%=request.getAttribute("paycheck_netpay")%></label>
					</td>
				</tr>
				<tr>
					<td>Pay Frequency</td>
					<td><label><%=request.getAttribute("payFreq")%></label></td>
				</tr>
				<tr>
					<td>Federal Filing Status</td>
					<td><label><%=request.getAttribute("filingStatus")%></label>
					</td>
				</tr>
			</table>
			<hr>
			<table align="center" style="width: 600px;">
				<tr align="center" bgcolor="#d4ffaa">
					<td colspan="3">Your Deductions</td>
				</tr>
				<tr>
					<td>Federal Tax</td>
					<td><label><%=request.getAttribute("paycheck_fedTax")%></label></td>
				</tr>
				<tr>
					<td>State Tax</td>
					<td><label><%=request.getAttribute("paycheck_stateTax")%></label></td>
				</tr>
				<tr>
					<td>Social Security Tax</td>
					<td><label><%=request.getAttribute("paycheck_socialSecTax")%></label></td>
				</tr>
				<tr>
					<td>MediCare Tax</td>
					<td><label><%=request.getAttribute("paycheck_medicareTax")%></label></td>
				</tr>
				<tr>
					<td>SDI/SUI Tax</td>
					<td><label><%=request.getAttribute("paycheck_sdisuiTax") %></label></td>
				</tr>
			</table>
		</div>
		<div style="width: 600px" align="center">
			<table align="center" style="width: 600px;">
				<tr align="center" colspan="3">
					<td><button style="background-color: #d4ffaa" onclick="history.back()">Back</button></td>
				</tr>
			</table>
		</div>	
	</form>
</body>
</html>