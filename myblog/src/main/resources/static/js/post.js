$(document).ready(
			 function(){
				$("#saveForm").click(function(event){
					console.log('Check');
					var $this = $(this);
					BtnSaving($this);
					ajaxPost($this);
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
	    	console.log('Success' + JSON.stringify(result));
	    	 CKEDITOR.instances.posteditor.updateElement();
	    	 CKEDITOR.instances.posteditor.setData('');
	    	 CKEDITOR.instances.posteditor.setData(''+result);
	    },
	    error : function(e){
	    	console.log("Error", e);
	    }
	    
	});
	
	
}

function editPost(elem){
    //var formData = CKEDITOR.instances.content.getData();

    var data = CKEDITOR.instances.editor.getData();
    console.log('Check'+data);

    $.ajax({
        type : "POST",
        contentType : "text/html",
        data:data,
        dataType : 'text',
        url: "/admin/editpost",
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
})
