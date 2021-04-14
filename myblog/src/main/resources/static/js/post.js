$(document).ready(
			 function(){
				 
				 var $editId;
				 
				 $('#editPost').on('show.bs.modal', function(e){
						$editId =  $(e.relatedTarget).attr('id');
						//ajaxPatch($this, $editId);
					}); 
				 
				$("#saveForm").click(function(event){
					console.log('Check');
					var $this = $(this);
					BtnSaving($this);
					ajaxPost($this);
				})
				
				$("#editForm").click(function(event){
					console.log('Check');
					var $this = $(this);
					BtnSaving($this);
						//var $editId =  $(e.relatedTarget).attr('id');
						ajaxPatch($this, $editId);
				
				})
			});


function ajaxPost(elem){
    //var formData = CKEDITOR.instances.content.getData();

    var data = CKEDITOR.instances.editor.getData();
    $.ajax({
        type : "POST",
        contentType : "text/html",
        data:data,
        dataType : 'text',
        url: "/admin/savepost",
        success : function(result){
            console.log('Success');
            $(elem).html(
                        `<span class="glyphicon glyphicon-align-left" role="status" aria-hidden="true"></span> Saved`	
            );
            //CKEDITOR.instances.editor.updateElement();
            //BtnReset(elem);
        },
        error : function(e){
            console.log("Error:"+ e);
            BtnReset(elem);
        }
    });
    
    
}


function ajaxPatch(elem, id){
    //var formData = CKEDITOR.instances.content.getData();
	var $id = id;
    var data = CKEDITOR.instances.posteditor.getData();
    var postData = new Array();
    $.ajax({
        type : "PATCH",
        contentType : "text/html",
        data:data,
        dataType : 'text',
        url: "/admin/editpost/"+ $id + "/" ,
        success : function(result){
            console.log('Success');
            $(elem).html(
                        `<span class="glyphicon glyphicon-align-left" role="status" aria-hidden="true"></span> Saved`	
            );
            //CKEDITOR.instances.editor.updateElement();
            //BtnReset(elem);
        },
        error : function(e){
            console.log("Error:"+ e);
            BtnReset(elem);
        }
    });
    
    
}

function fetchPost(id){
	
	var $id = id;
	$.ajax({
		type: "GET",
	    url : "/admin/fetchpost",
	    data : {
	    	id : $id
	    },
	    dataType : 'json',
	    success : function(result){
	    	$result = result;
	    	console.log('Success' + JSON.stringify(result));
	    	 CKEDITOR.instances.posteditor.updateElement();
//	    	 CKEDITOR.instances.posteditor.setData('');
	    	 CKEDITOR.instances.posteditor.setData(''+$result.content);
	    },
	    error : function(e){
	    	console.log("Error", e);
	    }
	    
	});
	
	
}


function BtnSaving(elem){
    $(elem).attr("data-original-text", $(elem).html());
    $(elem).prop("disabled", true);
    $(elem).html(
             `<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Saving...`	
    );
}


function BtnReset(elem){
    $(elem).prop("disabled", false);
    $(elem).html($(elem).attr("data-original-text"));
    //$('#createPost').modal('hide');
}


$('#createPost').on('hidden.bs.modal', function () {
    CKEDITOR.instances.editor.updateElement();
    CKEDITOR.instances.editor.setData('');
    var $this = $("#saveForm");
    BtnReset($this);
});

$('#editPost').on('show.bs.modal', function(e){
	var $editId =  $(e.relatedTarget).attr('id');
	fetchPost($editId);
	 var $this = $("#editForm");
	 BtnReset($this);
})
