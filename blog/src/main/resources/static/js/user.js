let index = {
	init:function(){
		btnSave = document.querySelector("#btn-save");
		btnSave.addEventListener("click",()=>{
			this.save();
		});
	},
	
	save:function(){
		let data={
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val()
		}
	}
}

index.init();