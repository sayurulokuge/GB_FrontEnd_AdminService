$(document).on("click", "#btnSignUp","#btnUpdate", function(event){ 

	// Clear alerts---------------------
	$("#alertSuccess").text(""); 
	$("#alertSuccess").hide(); 
	$("#alertError").text(""); 
	$("#alertError").hide(); 

	// Form validation-------------------
	var status = validateItemForm(); 
	
	if (status != true) { 
 
		$("#alertError").text(status); 
		$("#alertError").show(); 
		
	return; 
	}
	
	// If valid------------------------
	var type = ($("#hidInnovatorID").val() == "") ? "POST" : "PUT"; 
	
	$.ajax( 
			{ 
				url : "AdminAPI", 
				type : type, 
				data : $("#Innovator").serialize(), 
				dataType : "text", 
				complete : function(response, status) 
				
				{ 
					onItemSaveComplete(response.responseText, status); 
				} 
			}); 
});

function onItemSaveComplete(response, status) { 

	if (status == "success") { 
		var resultSet = JSON.parse(response); 
 
		if (resultSet.status.trim() == "success") { 
			
			$("#alertSuccess").text("Successfully saved."); 
			$("#alertSuccess").show(); 
			$("#divItemsGrid").html(resultSet.data); 
 
		} else if (resultSet.status.trim() == "error") { 
 
			$("#alertError").text(resultSet.data); 
			$("#alertError").show(); 
		}
		
	} else if (status == "error") { 
 
		$("#alertError").text("Error while saving."); 
		$("#alertError").show(); 
 
	} else { 
		$("#alertError").text("Unknown error while saving.."); 
		$("#alertError").show(); 
	} 
	 
	$("#hidInnovatorID").val(""); 
	$("#Innovator")[0].reset(); 
}

$(document).on("click", ".btnUpdate", function(event) { 
		
	$("#hidInnovatorID").val($(this).data("innID")); 
	$("#editFname").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#editFName").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#editEmail").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("#editPW").val($(this).closest("tr").find('td:eq(3)').text()); 
});

$(document).on("click", ".btnRemove", function(event) { 
		 
	$.ajax( { 
		 
		url : "AdminAPI", 
		type : "DELETE", 
		data : "innID=" + $(this).data("innID"),
		dataType : "text", 
		complete : function(response, status) 
		 
		{ 
			onItemDeleteComplete(response.responseText, status); 
		} 
	}); 
});

function onItemDeleteComplete(response, status) { 

	if (status == "success") { 
		
		var resultSet = JSON.parse(response); 
 
		if (resultSet.status.trim() == "success") { 
 
			$("#alertSuccess").text("Successfully deleted."); 
			$("#alertSuccess").show(); 
			$("#divItemsGrid").html(resultSet.data); 
 
		} else if (resultSet.status.trim() == "error") { 
 
			$("#alertError").text(resultSet.data); 
			$("#alertError").show(); 
		} 
	
	} else if (status == "error") { 
 
		$("#alertError").text("Error while deleting."); 
		$("#alertError").show(); 
	
	} else { 
		
		$("#alertError").text("Unknown error while deleting.."); 
		$("#alertError").show(); 
	} 
}
