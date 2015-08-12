<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>A Game of GravaHal</title>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
		<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
		<script src="resources/js/main.js" type="text/javascript"></script>
	</head>
	
	<body>
		<h1>
			Grava Hal
		</h1>
		
		<c:set var="imgPit" value="resources/img/pit.png" />
		<c:set var="imgStone" value="resources/img/stone.png" />
		
		<div id="gameBoard">
			<h3 align="center"> Player 1 </h3>
	        <table>
	           <tr id="row0">
	              <td>&nbsp</td>
	              <td>${lastState.getBoard().get(5).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(4).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(3).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(2).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(1).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(0).getStoneCount() }</td>
	              <td>&nbsp</td>
	          </tr>
	          <tr id="row1">
	              <td rowspan="2"> <img id = "7" class="gravahal" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img class="images" id = "6" src = <c:out value="${imgPit }" /> /> </td>
	              <td> <img id = "5" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "4" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "3" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "2" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "1" src = <c:out value="${imgPit }" /> /> </td>
	              <td rowspan="2"> <img id = "14" class="gravahal" src = <c:out value="${imgPit }" /> /> </td>
	          </tr>
	          <tr id="row2">
	              <td><img id = "8" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "9" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "10" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "11" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "12" src = <c:out value="${imgPit }" /> /> </td>
	              <td><img id = "13" src = <c:out value="${imgPit }" /> /> </td>
	          </tr>
	         <tr id="row3">
	              <td>${lastState.getBoard().get(6).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(7).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(8).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(9).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(10).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(11).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(12).getStoneCount() }</td>
	              <td>${lastState.getBoard().get(13).getStoneCount() }</td>
	          </tr>
	       </table>
	       <h3 align="center"> Player 2 </h3>
	       <h2> Message:</h2>
	       ${lastState.getCurrentMessage() }
       </div>
	</body>
</html>
