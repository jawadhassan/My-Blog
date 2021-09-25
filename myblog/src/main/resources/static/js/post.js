$(document).ready(
			 function(){
				 
				 var $editId;
				 var $deleteId;
				 
				 $('#editPost').on('show.bs.modal', function(e){
						$editId =  $(e.relatedTarget).attr('id');
					}); 
		
				 
				/*$("#saveForm").click(function(event){
					console.log('Saving Post...');
					var $value = $("#postTitle").val();
					var $text_data = CKEDITOR.instances.editor.getData();
					var $data = {
							title : $value,
							content : $text_data
					};
					console.log('Saving Post...'+ JSON.stringify($data));
					var $this = $(this);
					BtnSaving($this);
					ajaxPost($this,JSON.stringify($data));
				})*/
				
				$("#editForm").click(function(event){
					console.log('Saving Changes...');
					var $this = $(this);
					BtnSaving($this);
					ajaxPatch($this, $editId);
				
				})
				
				$('#confirmDelete').on('show.bs.modal', function(e){
					$deleteId =  $(e.relatedTarget).attr('id');
				})
				
				
				$("#deletepost").click(function(event){
					console.log('Deleting Post...');
					var $this = $(this);
					BtnDeleting($this);
					deletePost($this,$deleteId);
				
				})
			});


function ajaxPost(elem, data){	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

//    var data = CKEDITOR.instances.editor.getData();
    $.ajax({
        type : "POST",
        data:data,
        dataType: 'json',
        contentType: 'application/json',
        url: "/admin/savepost",
        success : function(result){
            console.log('Success: '+ result);
            $(elem).html(
                        `<span class="glyphicon glyphicon-align-left" role="status" aria-hidden="true"></span> Saved`	
            );
        },
        error : function(e){
            console.log("Error: "+ e);
            BtnReset(elem);
        }
    });
    
    
}


function ajaxPatch(elem, id){
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
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
            console.log('Success: ' + result);
            $(elem).html(
                        `<span class="glyphicon glyphicon-align-left" role="status" aria-hidden="true"></span> Saved`	
            );
        },
        error : function(e){
            console.log("Error: "+ e);
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
	    	console.log('Success: ' + JSON.stringify(result));
	    	 CKEDITOR.instances.posteditor.updateElement();
	    	 CKEDITOR.instances.posteditor.setData(''+$result.content);
	    },
	    error : function(e){
	    	console.log("Error: ", e);
	    }
	    
	});
	
	
}



function deletePost(elem,id){
	var $id = id;
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
	$.ajax({
		type : "DELETE",
		url : "/admin/deletepost/"+ $id + "/",
		dataType : 'json',
		success : function(result){
			console.log('Success: ' + JSON.stringify(result));
			 $(elem).html(
                     `<span class="glyphicon glyphicon-align-left" role="status" aria-hidden="true"></span> Deleted`	
			 );
		},
		error : function(e){
			console.log("Error:", e);
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
}


function BtnDeleting(elem){
    $(elem).attr("data-original-text", $(elem).html());
    $(elem).prop("disabled", true);
    $(elem).html(
             `<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Deleting...`	
    );
}



var quill = new Quill('#editor', {
	modules: {
    toolbar: [
      ['bold', 'italic'],
      ['link', 'blockquote', 'code-block', 'image'],
      [{ list: 'ordered' }, { list: 'bullet' }]
    ]
  },
    theme: 'snow'
});


var form = document.querySelector('form');
form.onsubmit = function() {
  // Populate hidden form on submit
  var about = document.querySelector('input[name=about]');
  about.value = JSON.stringify(quill.getContents());
  
  console.log("Submitted", $(form).serialize(), $(form).serializeArray());
  
  // No back end to actually submit to!
  alert('Open the console to see the submit data!')
  return false;
};



/*$('#createPost').on('hidden.bs.modal', function () {
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
*/