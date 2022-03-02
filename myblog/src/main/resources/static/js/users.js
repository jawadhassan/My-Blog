/**
 * 
 */

/*$(document).ready(function() {
    $('#example').DataTable();


} );*/


$(document).ready(function(){
	$('#example').dataTable().fnDestroy();
	 $('#example').DataTable( {
		 dom: 'Bfrtip'
    } );
})

$('#add_new').click(function(){
//	check();
})

function check() {
	
		
	const obj = {id:1, fullName: "John", email: "abc", enabled:false};
	
	var JSONVALUE = JSON.stringify(obj); 
	
	var token = $("meta[name='_csrf']").attr("content");
	
    $('#example').DataTable( {
         processing: true,
         serverSide : true,
		 dom: 'Bfrtip',
		 buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
         ],
         ajax : {
			 "headers": {"X-CSRF-TOKEN": token},	
			 "dataType" : 'json',
			 "contentType": "application/x-www-form-urlencoded", 
			 "type" : 'POST',
			 "url" : '/admin/check/1',
			 "data": {
				  id : 2,
				  fullname  : "James"
            	} 	
			}
    } );
}