$(function(){    
	var handleDataTableButtons = function() {
	    if ($("#students_datatable").length) {
	      $("#students_datatable").DataTable({
	        dom: "Bfrtip",
	        buttons: [
	          {
	            extend: "copy",
	            className: "btn-sm"
	          },
	          {
	            extend: "csv",
	            className: "btn-sm"
	          },
	          {
	            extend: "excel",
	            className: "btn-sm"
	          },
	          {
	            extend: "pdfHtml5",
	            className: "btn-sm"
	          },
	          {
	            extend: "print",
	            className: "btn-sm"
	          },
	        ],
	        responsive: true
	      });
	    }
	  };
	  
	  TableManageButtons = function() {
	    "use strict";
	    return {
	      init: function() {
	        handleDataTableButtons();
	      }
	    };
	  }();
	
	  TableManageButtons.init();
	  
	  $("#students_datatable tbody tr td .btn-group button").focusout(function(){
		  $(this).attr({"aria-expanded": "false"});
		  $(this).parent().removeClass("open");
	  });
});
