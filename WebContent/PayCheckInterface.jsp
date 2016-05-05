<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay check calculator</title>
</head>
<body>
	<form id="pay_submit_form" action="PayCheckGeneratorServlet"
		method="post">
		<div style="width: 600px; border-style: solid; border-width: 1px;"
			align="center">
			<table align="center" style="width: 600px;">
				<tr align="center" bgcolor="#d4ffaa">
					<td colspan="3">Select Calculation State</td>
				</tr>
				<tr>
					<td>State</td>
					<td><select style="width: 240px;" id="state" name="state">
							<option value="Alabama">Alabama</option>
							<option value="Alaska">Alaska</option>
							<option value="Arizona">Arizona</option>
							<option value="Arkansas">Arkansas</option>
							<option value="California">California</option>
							<option value="Colorado">Colorado</option>
							<option value="Connecticut">Connecticut</option>
							<option value="Delaware">Delaware</option>
							<option value="District Of Columbia">District Of Columbia</option>
							<option value="Florida">Florida</option>
							<option value="Georgia">Georgia</option>
							<option value="Hawaii">Hawaii</option>
							<option value="Idaho">Idaho</option>
							<option value="Illinois">Illinois</option>
							<option value="Indiana">Indiana</option>
							<option value="Iowa">Iowa</option>
							<option value="Kansas">Kansas</option>
							<option value="Kentucky">Kentucky</option>
							<option value="Louisiana">Louisiana</option>
							<option value="Maine">Maine</option>
							<option value="Marryland">Maryland</option>
							<option value="Massachusetts">Massachusetts</option>
							<option value="Michigan">Michigan</option>
							<option value="Minnesota">Minnesota</option>
							<option value="Mississippi">Mississippi</option>
							<option value="Missouri">Missouri</option>
							<option value="Montana">Montana</option>
							<option value="Nebraska">Nebraska</option>
							<option value="Nevada">Nevada</option>
							<option value="New Hampshire">New Hampshire</option>
							<option value="New Jersey">New Jersey</option>
							<option value="New Mexico">New Mexico</option>
							<option value="New York">New York</option>
							<option value="North Carolina">North Carolina</option>
							<option value="North Dakota">North Dakota</option>
							<option value="Ohio">Ohio</option>
							<option value="Olahoma">Oklahoma</option>
							<option value="Oregon">Oregon</option>
							<option value="Pennsylvania">Pennsylvania</option>
							<option value="Rhode Island">Rhode Island</option>
							<option value="South Carolina">South Carolina</option>
							<option value="South Dakota">South Dakota</option>
							<option value="Tennessee">Tennessee</option>
							<option value="Texas">Texas</option>
							<option value="Utah">Utah</option>
							<option value="Vermont">Vermont</option>
							<option value="Virginia">Virginia</option>
							<option value="Washington">Washington</option>
							<option value="West Virginia">West Virginia</option>
							<option value="Wisconsin">Wisconsin</option>
							<option value="Wyoming">Wyoming</option>
							<option value="American Samoa">American Samoa</option>
							<option value="Guam">Guam</option>
							<option value="Northern Mariana Islands">Northern Mariana Islands</option>
							<option value="Puerto Rico">Puerto Rico</option>
							<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
							<option value="Virgin Islands">Virgin Islands</option>
					</select></td>
				</tr>
			</table>
			<hr>
			<table align="center" style="width: 600px;">
				<tr align="center" bgcolor="#d4ffaa">
					<td colspan="3">General Information</td>
				</tr>
				<tr>
					<td>Annual Gross Pay</td>
					<td><input type="text" id="annual_Gross_Pay"
						name="annual_Gross_Pay" style="width: 235px;"></td>
				</tr>
				<tr>
					<td>Pay Frequency</td>
					<td><select style="width: 240px;" id="pay_frequency"
						name="pay_frequency">
							<option value="Daily">Daily</option>
							<option value="Weekly">Weekly</option>
							<option value="Bi-Weekly">Bi-Weekly</option>
							<option value="Semi-Monthly">Semi-Monthly</option>
							<option value="Monthly">Monthly</option>
							<option value="Quarterly">Quarterly</option>
							<option value="Semi-Annually">Semi-Annually</option>
							<option value="Annually" selected="Selected">Annually</option>
					</select></td>
				</tr>
				<tr>
					<td>Federal Filing Status</td>
					<td><select style="width: 240px;" id="filing_status"
						name="filing_status">
							<option selected="Selected" value="Single">Single</option>
							<option value="Joint">Married</option>
					</select></td>
				</tr>
				<tr>
					<td># of Federal Allowances</td>
					<td><input type="text" style="width: 235px;"
						name="no_of_federal_allowances" id="no_of_federal_allowances"></td>
				</tr>
				<tr>
					<td>Additional Federal Withholding</td>
					<td><input type="text" style="width: 235px;"
						name="addnl_federal_withholding" id="addnl_federal_withholding"></td>
				</tr>

				<tr>
					<td>I'am Exempt From</td>
					<td>
						<input type="checkbox" name="tax_exempt" value="Federal">Federal Tax 
						<input type="checkbox" name="tax_exempt" value="FICA">FICA
						<input type="checkbox" name="tax_exempt" value="Medicare">Medicare
					</td>
				</tr>
			</table>
			<hr>
			<table align="center" style="width: 600px;">
				<tr align="center" bgcolor="#d4ffaa">
					<td colspan="3">State and Local Information</td>
				</tr>
				<tr>
					<td>Additional State Withholding</td>
					<td><input type="text" style="width: 235px;"></td>
				</tr>

				<tr>
					<td>Exempt State</td>
					<td><input type="radio" name="exempt_state" value="yes">Yes
						<input type="radio" name="exempt_state" value="no">No
				</tr>
			</table>

		</div>
		<div style="width: 600px" align="center">
			<table align="center" style="width: 600px;">
				<tr align="center" colspan="3">
					<td><button style="background-color: #d4ffaa">Calculate</button>
						<button style="background-color: #d4ffaa" type="reset">Clear</button>

					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>