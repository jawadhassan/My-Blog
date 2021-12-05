/**
 * 
 */

/*$(document).ready(function() {
    $('#example').DataTable();


} );*/


$(document).ready(function() {
	
		
	const obj = {id:1, fullName: "John", email: "abc", enabled:false};
	
	var JSONVALUE = JSON.stringify(obj); 
	
	var token = $("meta[name='_csrf']").attr("content");
	
    $('#example').DataTable( {
         processing: true,
         serverSide : true,
         ajax : {
			 "headers": {"X-CSRF-TOKEN": token},	
			 "dataType" : 'json',
			 "contentType": "application/json", 
			 "type" : 'POST',
			 "url" : '/admin/check/1',
			 "data": function(d){
				     d.data = obj;
                	 return JSON.stringify(d);
            	} 	
			}
    } );
} );