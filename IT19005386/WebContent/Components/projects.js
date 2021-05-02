$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
{
$("#alertSuccess").hide();
}
$("#alertError").hide();
});
// SAVE ============================================



$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
{
$("#alertError").text(status);
$("#alertError").show();
return;
}
// If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
$.ajax(
{
url : "ProjectsAPI",
type : type,
data : $("#formItem").serialize(),
dataType : "text",
complete : function(response, status)
{
onItemSaveComplete(response.responseText, status);
}
});
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
$("#hidItemIDSave").val($(this).data("itemid"));

$("#ProjectName").val($(this).closest("tr").find('td:eq(0)').text());
$("#ProjectType").val($(this).closest("tr").find('td:eq(1)').text());
$("#UserID").val($(this).closest("tr").find('td:eq(2)').text());
$("#sdate").val($(this).closest("tr").find('td:eq(3)').text());
$("#edate").val($(this).closest("tr").find('td:eq(4)').text());
$("#status").val($(this).closest("tr").find('td:eq(5)').text());
$("#investStatus").val($(this).closest("tr").find('td:eq(6)').text());
$("#InvestmentAmount").val($(this).closest("tr").find('td:eq(7)').text());
$("#ProposedEquity").val($(this).closest("tr").find('td:eq(8)').text());
$("#ProjectTimeline").val($(this).closest("tr").find('td:eq(9)').text());



});



function onItemSaveComplete(response, status)
{
if (status == "success")
{
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success")
{
$("#alertSuccess").text("Successfully saved.");
$("#alertSuccess").show();
$("#divItemsGrid").html(resultSet.data);
} else if (resultSet.status.trim() == "error")
{
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error")
{
$("#alertError").text("Error while saving.");
$("#alertError").show();
} else
{
$("#alertError").text("Unknown error while saving..");
$("#alertError").show();
}
$("#hidItemIDSave").val("");
$("#formItem")[0].reset();
}

$(document).on("click", ".btnRemove", function(event)
{
$.ajax(
{
url : "ProjectsAPI",
type : "DELETE",
data : "ProjectID=" + $(this).data("itemid"),
dataType : "text",
complete : function(response, status)
{
onItemDeleteComplete(response.responseText, status);
}
});
});

function onItemDeleteComplete(response, status)
{
if (status == "success")
{
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success")
{
$("#alertSuccess").text("Successfully deleted.");
$("#alertSuccess").show();
$("#divItemsGrid").html(resultSet.data);
} else if (resultSet.status.trim() == "error")
{
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error")
{
$("#alertError").text("Error while deleting.");
$("#alertError").show();
} else
{
$("#alertError").text("Unknown error while deleting..");
$("#alertError").show();
}
}

// CLIENT-MODEL================================================================
function validateItemForm()
{
	// name
	if ($("#ProjectName").val().trim() == "")
	{
			return "Insert project name.";
	}
	// type
	if ($("#ProjectType").val().trim() == "")
	{
			return "Insert project type.";
	}
	// userid -------------------------------
	if ($("#UserID").val().trim() == "")
	{
			return "Insert user id.";
	}
	// is numerical value
	var userID = $("#UserID").val().trim();
	if (!$.isNumeric(userID))
	{
	return "Insert a numerical value for userID.";
	}
	// sdate
	if ($("#sdate").val().trim() == "")
	{
			return "Insert start date.";
	}
	// edate
	if ($("#edate").val().trim() == "")
	{
			return "Insert end date.";
	}
	
	//validate date
	var sdate=$("#sdate").val();
	sdate=new Date(sdate).getTime();
	
	var edate=$("#edate").val();
	edate=new Date(edate).getTime();
	
	if(edate<sdate)
	{
		return "Invalid dates..end date should be greater than start date";
	}
	
	
	//  -------------------------------
	if ($("#status").val().trim() == "")
	{
			return "Insert status.";
	}// investment status
	if ($("#investStatus").val().trim() == "")
	{
			return "Insert investment status.";
	}
	// investment amount
	if ($("#InvestmentAmount").val().trim() == "")
	{
			return "Insert investment amount.";
	}
	
	// is numerical value
	var investamount = $("#InvestmentAmount").val().trim();
	if (!$.isNumeric(investamount))
	{
	return "Insert a numerical value for invest amount.";
	}
	// convert to decimal price
	$("#InvestmentAmount").val(parseFloat(investamount).toFixed(2));
	
	
	// proposed equity -------------------------------
	if ($("#ProposedEquity").val().trim() == "")
	{
			return "Insert proposed equity.";
	}
	// is numerical value
	var proposedequiity = $("#ProposedEquity").val().trim();
	if (!$.isNumeric(proposedequiity))
	{
	return "Insert a numerical value for ProposedEquity.";
	}
	// convert to decimal price
	$("#InvestmentAmount").val(parseFloat(proposedequiity).toFixed(2));
	
	
	
	
	//project timeline
	if ($("#ProjectTimeline").val().trim() == "")
	{
			return "Insert project timeline.";
	}
			return true;
}